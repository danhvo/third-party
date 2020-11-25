package com.danh.assignment.thirdparty.sim;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SimRepository extends CrudRepository<Sim, Long> {
	List<Sim> findByCompanyNameAndNumber(String companyName, String number);
}
