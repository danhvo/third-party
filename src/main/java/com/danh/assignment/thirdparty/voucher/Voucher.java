package com.danh.assignment.thirdparty.voucher;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.danh.assignment.thirdparty.sim.Sim;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor 
@NoArgsConstructor 
@ToString
@Builder
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String code;
    private Long money;
    
    @ManyToOne
    @ToString.Exclude
    private Sim sim;

}
