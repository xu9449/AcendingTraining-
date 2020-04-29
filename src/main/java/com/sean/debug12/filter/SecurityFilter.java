package com.sean.debug12.filter;

import com.sean.debug12.model.Adopter;
import com.sean.debug12.service.AdopterService;
import com.sean.debug12.service.JWTService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebFilter(filterName= "securityFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST})
public class SecurityFilter implements Filter {

    @Autowired
    private AdopterService adopterService;

    @Autowired
    private JWTService jwtService;

    private static final Set<String> IGNORED_PATH = new HashSet<>(Arrays.asList("/auth"));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        int statusCode = authorization(req);
        if (statusCode == HttpServletResponse.SC_ACCEPTED) chain.doFilter(request, response);
        else ((HttpServletResponse)response).sendError(statusCode);
    }

    private int authorization(HttpServletRequest req) {
        int statusCode = HttpServletResponse.SC_UNAUTHORIZED;
        String uri = req.getRequestURI();
        if (IGNORED_PATH.contains(uri)) return HttpServletResponse.SC_ACCEPTED;
        String verb = req.getMethod();

        try{
            String token = req.getHeader("Authorization").replaceAll("^(.*?)", "");

            Claims claims = jwtService.decryptJWTToken(token);

            if (claims.getId() != null) {
                Adopter adopter = adopterService.getAdopterEagerBy(Long.valueOf(claims.getId()));
                if (adopter != null) statusCode = HttpServletResponse.SC_ACCEPTED;
            }

            String allowedResources = "/";
            switch(verb) {
                case "GET"    : allowedResources = (String)claims.get("allowedReadResources");   break;
                case "POST"   : allowedResources = (String)claims.get("allowedCreateResources"); break;
                case "PUT"    : allowedResources = (String)claims.get("allowedUpdateResources"); break;
                case "DELETE" : allowedResources = (String)claims.get("allowedDeleteResources"); break;
            }
            // /employees/id 200 "allowedReadResources": "/employees,/ems,/acnts,/accounts",
            // /paystubs/id  403 "allowedReadResources": "/employees,/ems,/acnts,/accounts",
            for (String s : allowedResources.split(",")) {
                if(s.trim().isEmpty())
                    break;
                if (uri.trim().toLowerCase().startsWith(s.trim().toLowerCase())) {
                    statusCode = HttpServletResponse.SC_ACCEPTED;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusCode;
    }

}

