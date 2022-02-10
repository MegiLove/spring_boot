package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class DeptLog {
	private int no;
	private String uri;
	private String ip;
	private Date time;
}
