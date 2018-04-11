package com.spring.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * com.hw.myp2c.common.filter
 * Administrator
 * 2017/10/18
 **/

public class RequestFilter implements Filter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // dn                                   ：域名
        //dn/p/TabId                      ：站点页面
        //dn/p/TabId/?StId=xxx     ：站点系统页面
        //
        String dn = request.getServerName();
        Map<String, Object> extraParams = new HashMap<String, Object>();
        extraParams.put("dn", dn);
        RequestParameterWrapper requestParameterWrapper = new RequestParameterWrapper(request);
        requestParameterWrapper.addParameters(extraParams);
        System.out.println(requestParameterWrapper.getParameter("dn"));
        filterChain.doFilter(requestParameterWrapper, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
