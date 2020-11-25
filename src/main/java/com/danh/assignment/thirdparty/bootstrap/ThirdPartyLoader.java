package com.danh.assignment.thirdparty.bootstrap;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.danh.assignment.thirdparty.sim.Sim;
import com.danh.assignment.thirdparty.sim.SimRepository;
import com.danh.assignment.thirdparty.voucher.Voucher;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThirdPartyLoader implements CommandLineRunner {

	@Autowired
    private SimRepository simRepository;

    @Override
    public void run(String... args) {
    	InetAddress ip;
        String hostname;
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
 
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        log.info("Loading data...");

        Sim viettel = Sim.builder().companyName("Viettel").name("C90").number("0389555555").build();
        viettel.setVoucher(Voucher.builder().code("1234").money(50000L).sim(viettel).build());
        simRepository.save(viettel);
        Sim mobifone = Sim.builder().companyName("Mobifone").name("4G").number("0935717171").build();
        mobifone.setVoucher(Voucher.builder().code("2345").money(100000L).sim(mobifone).build());
        simRepository.save(mobifone);
        Sim vinaphone = Sim.builder().companyName("Vinaphone").name("D500").number("0886008346").build();
        vinaphone.setVoucher(Voucher.builder().code("6789").money(200000L).sim(vinaphone).build());
        simRepository.save(vinaphone);
        
        System.out.println("\nfindAll()");
        simRepository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        simRepository.findById(1l).ifPresent(x -> System.out.println(x));
    }

}
