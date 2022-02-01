package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ExceptionLog {
	private int no;
	private String msg;
	private String uri;
	private Date time;
}
