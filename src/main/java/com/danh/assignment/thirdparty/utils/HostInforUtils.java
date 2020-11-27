package com.danh.assignment.thirdparty.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;

public class HostInforUtils {
	private HostInforUtils() {}
	public static final String HOST_INFOR = returnHostInfor();
	
	private static String returnHostInfor() {
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
