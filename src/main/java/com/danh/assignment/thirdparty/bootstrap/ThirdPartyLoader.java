package com.danh.assignment.thirdparty.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.danh.assignment.thirdparty.voucher.Voucher;
import com.danh.assignment.thirdparty.voucher.VoucherRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ThirdPartyLoader implements CommandLineRunner {

	@Autowired
    private VoucherRepository repository;

    @Override
    public void run(String... args) {

        log.info("Loading data...");

        repository.save(new Voucher("Mobifone", "1234"));
        repository.save(new Voucher("Viettel", "4567"));
        repository.save(new Voucher("Vinaphone", "6789"));

        System.out.println("\nfindAll()");
        repository.findAll().forEach(x -> System.out.println(x));

        System.out.println("\nfindById(1L)");
        repository.findById(1l).ifPresent(x -> System.out.println(x));

        System.out.println("\nfindByName('Vinaphone')");
        repository.findByName("Vinaphone").forEach(x -> System.out.println(x));

    }

}
