//package com.pwc.nic.rest;
//
//import com.pwc.nic.config.TenantContext;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//public class MultiTenantInterceptor extends HandlerInterceptorAdapter {
//
//	private static final String TENANT_HEADER_NAME = "customerId";
//
//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//		String tenantId = request.getHeader(TENANT_HEADER_NAME);
//		TenantContext.setTenantId(tenantId);
//		return true;
//	}
//
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		TenantContext.clear();
//	}
//}