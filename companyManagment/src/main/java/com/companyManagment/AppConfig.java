package com.companyManagment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
//import org.springframework.hateoas.client.LinkDiscoverer;
//import org.springframework.hateoas.client.LinkDiscoverers;
//import org.springframework.hateoas.config.EnableHypermediaSupport;
//import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;

import com.companyManagment.repository.IEmployeeRepository;
import com.companyManagment.repository.IEmployeeRepositoryImpl;
import com.companyManagment.service.IEmployeeService;
import com.companyManagment.service.IEmployeeServiceImpl;
import com.companyManagment.web.EmployeeController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
public class AppConfig {
    
	
	
}

