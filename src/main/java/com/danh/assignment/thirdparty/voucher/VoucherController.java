package com.danh.assignment.thirdparty.voucher;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danh.assignment.thirdparty.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
public class VoucherController {

	@Autowired
	private VoucherService voucherService;

	@GetMapping(produces = { "application/json" }, path = "vouchers")
	public ResponseDTO<Object> getVouchers() {
		log.info("Start getting Vouchers!");
		Map<String, List<Voucher>> result = new HashMap<>();
		result.put("vouchers", voucherService.getVouchers());
		return ResponseDTO.builder().data(result).code("200").status("Success").build();
	}
	
	@GetMapping(produces = { "application/json" }, path = "vouchers/codes")
	public ResponseDTO<Object> getVoucherCodes() {
		log.info("Start getting Voucher Codes!");
		Map<String, List<String>> result = new HashMap<>();
		result.put("codes", voucherService.getVoucherCodes());
		return ResponseDTO.builder().data(result).code("200").status("Success").build();
	}
	
	@GetMapping(produces = { "application/json" }, path = "code")
	public ResponseDTO<Object> getVoucherCode() {
		log.info("Start getting Voucher Code!");
		Map<String, String> result = new HashMap<>();
		result.put("code", "123456");
		return ResponseDTO.builder().data(result).code("200").status("Success").build();
	}
	
	/*@GetMapping(produces = { "application/json" }, path = "vouchers/{name}")
	public ResponseDTO<Object> getVouchersByName(@PathVariable String name) {
		log.info("Start getting Vouchers by name!");
		List<Voucher> vouchers = voucherService.getVouchersByName(name);
		if (CollectionUtils.isEmpty(vouchers)) {
			throw new NotFoundException();
		}
		Map<String, List<Voucher>> result = new HashMap<>();
		result.put("vouchers", vouchers);
		return ResponseDTO.builder().data(result).code("200").status("Success").build();
	}*/
}
