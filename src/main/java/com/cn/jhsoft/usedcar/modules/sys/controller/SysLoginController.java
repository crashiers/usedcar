package com.cn.jhsoft.usedcar.modules.sys.controller;

import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.ShiroUtils;
import com.cn.jhsoft.usedcar.modules.sys.service.SysUserService;
import com.cn.jhsoft.usedcar.modules.sys.service.SysUserTokenService;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.modules.sys.entity.SysUserEntity;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * 登录相关
 * 
 * @author jhsoft
 * @email hn1987@126.com
 * @date 2016年11月10日 下午1:15:31
 */
@RestController
public class SysLoginController {
	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserTokenService sysUserTokenService;

	@RequestMapping("captcha.jpg")
	public void captcha(HttpServletResponse response)throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");

		//生成文字验证码
		String text = producer.createText();
		//生成图片验证码
		BufferedImage image = producer.createImage(text);
		//保存到shiro session
		ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IOUtils.closeQuietly(out);
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/sys/login", method = RequestMethod.POST)
	public Map<String, Object> login(String username, String password, String captcha)throws IOException {
		String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
		if(!captcha.equalsIgnoreCase(kaptcha)){
			return R.error("验证码不正确");
		}

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(username);

		//账号不存在、密码错误
		if(user == null || !user.getPassword().equals(new Sha256Hash(password, user.getSalt()).toHex())) {
			return R.error("账号或密码不正确");
		}

		//账号锁定
		if(user.getStatus() == 0){
			return R.error("账号已被锁定,请联系管理员");
		}

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(user.getUserId());
		return r;
	}

	/**
	 * 注册
	 */
	@RequestMapping(value = "/sys/reg", method = RequestMethod.POST)
	public Map<String, Object> reg(String password,
								   String email,
								   String mobile,
								   String relname,
								   String province,
								   String city,
								   String district,
								   String address,
								   String company,
								   String tel)throws IOException {

		//用户信息
		SysUserEntity user = sysUserService.queryByUserName(email);
		if (user != null) {
			if (user.getEmail().equals(email)) {
				return R.error("邮箱已存在，请重新填写！");
			}
			if (user.getMobile().equals(mobile)) {
				return R.error("手机号已存在，请重新填写！");
			}
			user = sysUserService.queryByUserName(mobile);
			if (user.getEmail().equals(email)) {
				return R.error("邮箱已存在，请重新填写！");
			}
			if (user.getMobile().equals(mobile)) {
				return R.error("手机号已存在，请重新填写！");
			}
		}

		SysUserEntity newUser = new SysUserEntity();
		newUser.setUsername(email);
		newUser.setEmail(email);
		newUser.setMobile(mobile);
		newUser.setRelname(relname);
		newUser.setProvince(province);
		newUser.setCity(city);
		newUser.setDistrict(district);
		newUser.setAddress(address);
		newUser.setCompany(company);
		newUser.setTel(tel);
		newUser.setPassword(password);
		newUser.setCreateDate(DateUtils.getTodayDate());
		newUser.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		newUser.setStatus(SysUserEntity.STATUS_BLOCK);
		newUser.setUserType("客户");
		newUser.setUsedNum(10);
		sysUserService.save(newUser);

		//生成token，并保存到数据库
		R r = sysUserTokenService.createToken(newUser.getUserId());
		return r;
	}
	
}
