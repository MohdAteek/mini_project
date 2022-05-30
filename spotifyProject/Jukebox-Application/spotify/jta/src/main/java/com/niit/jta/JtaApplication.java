package com.niit.jta;

import com.niit.jta.filter.JwtFilter;
import io.jsonwebtoken.Jwt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@SpringBootApplication
public class JtaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JtaApplication.class, args);
	}

	public FilterRegistrationBean jwtfilter(){

		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new JwtFilter());
		filterRegistrationBean.addUrlPatterns("/userservice/getalluser/*");

		return filterRegistrationBean;
	}
}
