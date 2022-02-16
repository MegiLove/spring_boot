package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class PaymentVO {
	private String imp_uid;
	private String merchant_uid;
	private int paid_amount;
	private int apply_num;
	private Date payment_date;
}
