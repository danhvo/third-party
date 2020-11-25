package com.danh.assignment.thirdparty.sim;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.danh.assignment.thirdparty.voucher.Voucher;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
@Builder
public class Sim {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	private String number;
	private String name;
	
	@OneToMany(mappedBy = "sim", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
	@ToString.Exclude
	private List<Voucher> vouchers;
	
	public void setVoucher(Voucher voucher) {
		if (this.vouchers == null) {
			this.vouchers = new ArrayList<>();
		}
		this.vouchers.add(voucher);
	}
}
