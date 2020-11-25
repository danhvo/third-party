package com.danh.assignment.thirdparty.bootstrap;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThirdPartyLoader implements CommandLineRunner {

    @Override
    public void run(String... args) {
    	InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            log.info("Your current IP address : " + ip);
            log.info("Your current Hostname : " + hostname);
 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
