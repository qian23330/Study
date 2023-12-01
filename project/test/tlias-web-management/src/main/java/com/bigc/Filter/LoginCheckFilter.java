package com.bigc.Filter;

import com.alibaba.fastjson.JSONObject;
import com.bigc.pojo.Result;
import com.bigc.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // 1.获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url:{}", url);

        // 2.判断请求url中是否包含login，如果包含，说明是登录操作，放行
        if (url.contains("login")) {
            log.info("登录操作，放行...");
            chain.doFilter(request, response);
            return;
        }

        // 3.获取请求头部的令牌(token)
        String jwt = req.getHeader("token");

        // 4.判断token是否存在，如果不存在，返回错误结果(未登录)
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动转换 对象--json  阿里巴巴fastJSON工具包
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 5.解析token，如果解析失败，返回错误结果(未登录)
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // jwt 解析失败
            e.printStackTrace();
            log.info("解析token失败，返回未登录的错误信息");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        // 6.放行
        log.info("token合法，放行");
        chain.doFilter(request, response);
    }
}
