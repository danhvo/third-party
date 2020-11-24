package com.danh.assignment.thirdparty.voucher;

import java.util.List;

public interface VoucherService {
	List<Voucher> getVouchers();
	List<String> getVoucherCodes();
}
