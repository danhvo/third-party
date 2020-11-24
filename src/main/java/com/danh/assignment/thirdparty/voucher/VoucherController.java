package com.danh.assignment.thirdparty.voucher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	@GetMapping(produces = { "application/json" }, path = "vouchers")
	public List<Voucher> getVouchers() {
		log.info("Start getting Vouchers!");
		return voucherService.getVouchers();
	}
	
	@GetMapping(produces = { "application/json" }, path = "vouchers/codes")
	public List<String> getVoucherCodes() {
		log.info("Start getting Voucher Codes!");
		return voucherService.getVoucherCodes();
	}

}
