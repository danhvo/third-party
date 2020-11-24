package com.danh.assignment.thirdparty;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping("/infor/")
@RestController
public class ThirdPartyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdPartyApplication.class, args);
	}
	
	@GetMapping(produces = { "application/json" }, path = "host")
	public String returnHost() {
		InetAddress ip = null;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("Your current IP address : " + ip);
 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        
        return Objects.toString(ip);
	}

}
