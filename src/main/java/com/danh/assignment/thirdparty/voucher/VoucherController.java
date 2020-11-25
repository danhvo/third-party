package com.danh.assignment.thirdparty.voucher;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danh.assignment.thirdparty.dto.ResponseDTO;
import com.danh.assignment.thirdparty.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
public class VoucherController {
	private Random random = new Random();
	
	@GetMapping(produces = { "application/json" }, path = "code")
	public ResponseDTO<Object> getVoucherCode(@RequestParam(value = "slow", required = true) boolean slow)
			throws InterruptedException {
		log.info("Start getting Voucher Code!");
		boolean notFound = random.nextBoolean();
		if (notFound) {
			throw new NotFoundException("Voucher Code not found!");
		}

		if (slow) {
			Thread.sleep(31000L);
		}
		Map<String, String> result = new HashMap<>();
		result.put("code", "123456");
		return ResponseDTO.builder().data(result).code("200").status("Success").build();
	}
}
