package com.danh.assignment.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danh.assignment.thirdparty.utils.HostInforUtils;

@SpringBootApplication
@RequestMapping("/infor/")
@RestController
public class ThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApplication.class, args);
	}
	
	@GetMapping(produces = { "application/json" }, path = "host")
	public String returnHostInfor() {
        return HostInforUtils.HOST_INFOR;
	}

}
