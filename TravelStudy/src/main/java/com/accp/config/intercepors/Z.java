package com.accp.config.intercepors;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.accp.domain.Employee;
import com.accp.domain.Plate;
import com.accp.qyj.service.PlateService;
import com.accp.qyj.service.RoleplateService;
import com.accp.qyj.service.impl.PlateServiceImpl;

@Component
public class Z  implements HandlerInterceptor  {
	
	@Autowired
	PlateServiceImpl service;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Map<String,Plate> map=(Map<String,Plate>)request.getSession().getAttribute("plate");		
		if(map==null) {
			Employee u = (Employee)request.getSession().getAttribute("user");
			if(u!=null) {
				map = service.queryPlateByUserId(u.getId());
			}else {
				return false;
			}
		}
		String uri =request.getRequestURI();
		System.out.println(uri);
//		uri =uri.replaceAll(request.getContextPath()+"/", "");
		Object obj =map.get(uri);
		if(obj!=null) {
			return true;
		}else {	
			
			return false;
		}
		
	}
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
}
