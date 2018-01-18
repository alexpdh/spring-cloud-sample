package com.api.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 过滤器
 *
 * @author pengdh
 * @date 2018/01/18
 */
public class AccessFilter extends ZuulFilter {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		logger.info("send {} request to {}", request.getMethod(), request.getRequestURI().toString());
		Object accessToken = request.getParameter("accessToken");
		if (accessToken == null) {
			logger.warn("accessToken is empty");
			context.setSendZuulResponse(false);
			context.setResponseStatusCode(401);
			return null;
		}
		logger.info("accessToken is Ok");
		return null;
	}
}
