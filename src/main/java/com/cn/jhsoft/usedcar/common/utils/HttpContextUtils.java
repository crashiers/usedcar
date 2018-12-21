package com.cn.jhsoft.usedcar.common.utils;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class HttpContextUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获取当前项目域名
	 * @return
	 */
	public static String getHost(){
		HttpServletRequest request = getHttpServletRequest();
		String host = request.getScheme()+"://"+ request.getServerName();
		if (request.getServerPort() != 80) {
			host += ":" + request.getServerPort();
		}
		return host;
	}

	/**
	 * 获取当前页面名
	 * @return
	 */
	public static String getPageUrl(){
		HttpServletRequest request = getHttpServletRequest();

		String url = "";
		url = getHost() + request.getServletPath();
		if (request.getQueryString() != null){
			url += "?" + request.getQueryString();
		}
		return url;
	}
}
