package com.demo.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


/**
 *  跨域支持 OPTIONS请求配置
 *
 *  对于ajax的跨域请求，浏览器在发送真实请求之前，会向服务端发送OPTIONS请求，
 *  看服务端是否支持。对于options请求我们只需要返回header，不
 *  需要再进其它的filter，所以加了一个OptionsRequestFilter，
 *  填充header后就直接返回：
 */
@Component
public class OptionsRequestFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if(request.getMethod().equals("OPTIONS")) {
            response.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,HEAD");
            response.setHeader("Access-Control-Allow-Headers", response.getHeader("Access-Control-Request-Headers"));
            return;
        }
        filterChain.doFilter(request, response);
		
	}

}
