package com.cn.jhsoft.usedcar.modules.pm.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;

import com.cn.jhsoft.usedcar.common.utils.ExcelPOIUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cn.jhsoft.usedcar.modules.pm.entity.DrpEntity;
import com.cn.jhsoft.usedcar.modules.pm.service.DrpService;
import com.cn.jhsoft.usedcar.common.utils.PageUtils;
import com.cn.jhsoft.usedcar.common.utils.Query;
import com.cn.jhsoft.usedcar.common.utils.R;
import com.cn.jhsoft.usedcar.common.validator.ValidatorUtils;
import com.cn.jhsoft.usedcar.common.validator.group.AddGroup;
import com.cn.jhsoft.usedcar.common.validator.group.UpdateGroup;
import com.cn.jhsoft.usedcar.modules.sys.controller.AbstractController;
import com.cn.jhsoft.usedcar.common.utils.DateUtils;
import com.cn.jhsoft.usedcar.common.utils.IPUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 进销存
 * 
 * @author chenyi9
 * @email hn1987@126.com
 * @date 2018-12-26 19:28:57
 */
@RestController
@RequestMapping("/pm/drp")
public class DrpController extends AbstractController {
	@Autowired
	private DrpService drpService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("pm:drp:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DrpEntity> drpList = drpService.queryList(query);
		int total = drpService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(drpList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("pm:drp:info")
	public R info(@PathVariable("id") Long id){
		DrpEntity drp = drpService.queryObject(id);
		
		return R.ok().put("drp", drp);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("pm:drp:save")
	public R save(@RequestBody DrpEntity drp){
        ValidatorUtils.validateEntity(drp, AddGroup.class);
		drp.setCreateDate(DateUtils.getTodayDate());
		drp.setCreateDatetime(DateUtils.getTodayDateYMDHMS());
		drpService.save(drp);
		
		return R.ok();
	}

	/**
	 * 上传
	 */
	@RequestMapping("/upload")
	@RequiresPermissions("pm:drp:save")
	public R save(@RequestParam("file") MultipartFile file, HttpServletRequest request){
		//String dealerId = request.getParameter("dealerId").toString();
		try {
			// startRowNum是从0开始，1代表忽略第0行。
			List<String[]> lists = ExcelPOIUtils.readExcel(file, 1);

			// 先删除所有数据
			drpService.deleteAll();

			// 忽略第一行 头，i从1开始
			for(int i = 1;i<lists.size();i++){

				String[] datas = lists.get(i);
				if (datas[0] == null || datas[0].equals("")){
					continue;
				}
				if (datas[1] == null || datas[1].equals("")){
					continue;
				}

				int num = 0;
				DrpEntity entity = new DrpEntity();

				entity.setNum(Long.valueOf(datas[num++]));
				entity.setRkdh(datas[num++]);
				entity.setBrand(datas[num++]);
				entity.setArctic(datas[num++]);
				entity.setCarModel(datas[num++]);
				entity.setColor(datas[num++]);
				entity.setMileage(datas[num++]);
				entity.setFirstDate(datas[num++]);

				entity.setDisplacement(datas[num++]);
				entity.setGearbox(datas[num++]);
				entity.setVin(datas[num++]);
				entity.setRemark(datas[num++]);
				entity.setBuyType(datas[num++]);
				entity.setBuyClientRef(datas[num++]);
				entity.setBuyCompany(datas[num++]);
				entity.setBuyReferrer(datas[num++]);
				entity.setBuyReferrerDuty(datas[num++]);
				entity.setBuyer(datas[num++]);

				entity.setRawCarOwner(datas[num++]);
				entity.setRawPhone(datas[num++]);
				entity.setPermuteArctic(datas[num++]);
				entity.setBuyDate(datas[num++]);
				entity.setBuyPrice(datas[num++]);
				entity.setBuyTransferFee(datas[num++]);
				entity.setBuyOtherFee(datas[num++]);
				entity.setBep(datas[num++]);
				entity.setSlNum(datas[num++]);
				entity.setSellDate(datas[num++]);

				entity.setIsAuth(datas[num++]);
				entity.setServicingCosts(datas[num++]);
				entity.setUpkeep(datas[num++]);
				entity.setCheckFee(datas[num++]);
				entity.setSali(datas[num++]);
				entity.setStoreTime(datas[num++]);
				entity.setIsExceed(datas[num++]);
				entity.setMinPrice(datas[num++]);
				entity.setSellPrice(datas[num++]);
				entity.setSellType(datas[num++]);

				entity.setSellClientRef(datas[num++]);
				entity.setSellReferrer(datas[num++]);
				entity.setSellReferrerDuty(datas[num++]);
				entity.setSeller(datas[num++]);
				entity.setNewCarOwner(datas[num++]);
				entity.setNewPhone(datas[num++]);
				entity.setChannel(datas[num++]);
				entity.setSellDateFinal(datas[num++]);
				entity.setSellPriceFinal(datas[num++]);
				entity.setPaymentType(datas[num++]);

				entity.setPaymentFirstMoney(datas[num++]);
				entity.setPaymentLoanMoney(datas[num++]);
				entity.setTransferFee(datas[num++]);
				entity.setSellOtherFee(datas[num++]);
				entity.setRbr(datas[num++]);
				entity.setFhc(datas[num++]);
				entity.setProfitInsurance(datas[num++]);
				entity.setProfitDecorative(datas[num++]);
				entity.setFormalitieCharge(datas[num++]);
				entity.setRebate(datas[num++]);

				entity.setOther(datas[num++]);
				entity.setMaori(datas[num++]);
				entity.setMaoriRate(datas[num++]);
				entity.setDirectCost(datas[num++]);
				entity.setMaori2(datas[num++]);
				entity.setMaoriRate2(datas[num++]);
				entity.setOtherEarnings(datas[num++]);
				entity.setRebate2(datas[num++]);
				entity.setSynthesisMaori(datas[num++]);
				entity.setBuyYear(datas[num++]);

				entity.setBuyMonth(datas[num++]);
				entity.setSellYear(datas[num++]);
				entity.setSellMonth(datas[num++]);
				entity.setBuyWay(datas[num++]);
				entity.setSellWay(datas[num++]);
				entity.setSellWay2(datas[num++]);
				entity.setCarAge(datas[num++]);
				entity.setCarAgeLeavel(datas[num++]);
				entity.setBuyPriceLeavel(datas[num++]);
				entity.setIsStore(datas[num++]);


				entity.setCreateDate(DateUtils.getTodayDate());
				entity.setCreateDatetime(DateUtils.getTodayDateYMDHMS());

				drpService.save(entity);

			}
		} catch (IOException e) {
			return R.error(e.getMessage());
		}

		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("pm:drp:update")
	public R update(@RequestBody DrpEntity drp){
        ValidatorUtils.validateEntity(drp, UpdateGroup.class);
		drpService.update(drp);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("pm:drp:delete")
	public R delete(@RequestBody Long[] ids){
		drpService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
