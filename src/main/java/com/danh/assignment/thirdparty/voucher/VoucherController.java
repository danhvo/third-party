package com.danh.assignment.thirdparty.voucher;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.danh.assignment.thirdparty.dto.ResponseDTO;
import com.danh.assignment.thirdparty.dto.VoucherDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/api/v1/")
@RestController
public class VoucherController {
	private Random random = new Random();

	@GetMapping(produces = { "application/json" }, path = "code")
	public ResponseDTO<VoucherDTO> getVoucherCode(@RequestParam(value = "slow", required = true) boolean slow,
			@RequestParam(value = "error", required = true) boolean error) throws InterruptedException {
		log.info("Start getting Voucher Code!");
		if (error) {
			throw new RuntimeException(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());
		}
		VoucherDTO voucherDTO = VoucherDTO.builder().build();
		boolean found = random.nextBoolean();
		String message = "Not Found!";
		if (found) {
			voucherDTO.setCode(String.valueOf(ThreadLocalRandom.current().nextLong(10000)));
			message = "Found!";
		}

		if (slow) {
			Thread.sleep(3000L);
		}
		log.info("End getting Voucher Code!");

		return new ResponseDTO<VoucherDTO>("Success", HttpStatus.OK.value(), voucherDTO, message);
	}
}
