package com.javatechie.spring.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class SpringMobileApplication {

	
	@GetMapping("/")
	public String greeting(Device device) {
		String deviceType = "";
		String platform = "";
		if (device.isMobile()) {
			deviceType = "mobile";
		} else if (device.isTablet()) {
			deviceType = "tablet";
		} else if (device.isNormal()) {
			deviceType = "browser";
		}

		platform = device.getDevicePlatform().name();

		if (platform.equalsIgnoreCase("UNKNOWN")) {
			platform = "browser";
		}

		return "index";

	}

	public static void main(String[] args) {
		SpringApplication.run(SpringMobileApplication.class, args);
	}
}
