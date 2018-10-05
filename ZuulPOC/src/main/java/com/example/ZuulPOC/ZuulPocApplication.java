package com.example.ZuulPOC;

import com.example.ZuulPOC.filter.AccessControlFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RestController
public class ZuulPocApplication {

    @Autowired
    RouteLocator routeLocator;

    @RequestMapping("/routes")
    public String routes(){
        for(Route route : routeLocator.getRoutes()) {

            System.out.println("++++++++++++++++++ " + route.getFullPath());
        }
        return "See The Console For Routes";
    }

	public static void main(String[] args) {
		SpringApplication.run(ZuulPocApplication.class, args);
	}


	@Bean
    public AccessControlFilter accessControlFilter(){
        return new AccessControlFilter();
    }
}
