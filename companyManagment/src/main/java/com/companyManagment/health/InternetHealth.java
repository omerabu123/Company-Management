package com.companyManagment.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
@Component
@Endpoint(id = "myHealth")
public class InternetHealth implements HealthIndicator {

	@Override
	@ReadOperation
	public Health health() {
		if (checkInternet())
		return	Health.up().withDetail("Success" , "Active Internet connection").build();
		else 
		 return Health.up().withDetail("Failed", "InActive Internet connection").build();
		
	}

	public boolean checkInternet() {
		boolean flag = false;
		try {
			URL url = new URL("https://google.com");
			URLConnection connection = url.openConnection();
			connection.connect();
			flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

}
