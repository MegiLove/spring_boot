package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionLog {
	private int no;
	private String uri;
	private String ip;
	private String error_code;
	private Date time;
}
