package com.sean.debug12.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

@WebFilter(filterName = "sessionFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SessionFilter implements Filter{
    private ArrayList<String> urlList;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        boolean allowedRequest = false;

        //if(urlList.contains(url)) {
            allowedRequest = true;
        //}

        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            if (null == session) {
                response.sendRedirect("index.jsp");
            }
        }

        chain.doFilter(req, res);
    }

    public void init(FilterConfig config) throws ServletException {
        String urls = " ";
        StringTokenizer token = new StringTokenizer(urls, ",");

        urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());
        }
    }
}
