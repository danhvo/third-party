package com.danh.assignment.thirdparty.voucher;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VoucherRepository extends CrudRepository<Voucher, Long> {

    List<Voucher> findByCode(String code);
    List<Voucher> findByName(String name);

}
