package com.demo.common.conifg;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.demo.common.filter.OptionsRequestFilter;

@Configurable
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
public class WebSecurityConfig{
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//        .antMatchers("/yejiu/**").permitAll()  // 所有login请求无需验证
//		//        .antMatchers("/login/**").hasAnyRole() ;
//		        .anyRequest().authenticated();  // 其余请求都需要过滤
//		
//		http.formLogin()
//		        .loginPage("/login"); // 设置跳转登录页面
//		
//		http.csrf().disable();  // CRSF禁用，因为不使用session 可以预防CRSF攻击
//		
//		http.sessionManagement().disable(); // 禁用session
//		
//		http.cors(); // 支持跨域
//		
//		// 添加header设置，支持跨域和ajax请求
//		http.headers().addHeaderWriter(new StaticHeadersWriter(Arrays.asList(
//		        new Header("Access-control-Allow-Origin","*"),
//		        new Header("Access-Control-Expose-Headers","Authorization"))));
//		// 添加header设置，支持跨域和ajax请求
//		http.addFilterAfter(new OptionsRequestFilter(), CorsFilter.class);
//	}
//	
//	@Bean
//    public BCryptPasswordEncoder bcryptPasswordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    /**
//     *  跨域支持
//     * @return CorsConfigurationSource
//     */
//    @Bean
//    protected CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("GET","POST","HEAD", "OPTION"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.addExposedHeader("Authorization");
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
	

}
