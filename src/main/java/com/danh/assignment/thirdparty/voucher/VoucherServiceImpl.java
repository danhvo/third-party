package com.danh.assignment.thirdparty.voucher;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
	@Autowired
	private VoucherRepository repository;

	@Override
	public List<Voucher> getVouchers() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public List<String> getVoucherCodes() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).map(voucher -> voucher.getCode())
				.collect(Collectors.toList());
	}
}
