package com.ajh.aijihui.vo;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseVO {
	private String code;
	
	private String desc;
	
	private String token;
	
	private Object data;
	
	public ResponseVO() {
	}

	public ResponseVO(Object data) {
		this("0000", "响应成功");
		this.data = data;
	}
	
	public ResponseVO(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public String getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void success(Object data){
		this.code="0000";
		this.desc="响应成功";
		this.data=data;
	}
	public void success(){
		this.code="0000";
		this.desc="响应成功";
		this.data="";
	}

	public static ResponseVO ok() {
		return new ResponseVO("0000", "响应成功");
	}

	public static ResponseVO ok(Object data) {
		return new ResponseVO(data);
	}

	public static ResponseVO error(Result result) {
		return error(result.getCode(), result.getDesc());
	}

	public static ResponseVO error(String code, String desc) {
		return new ResponseVO(code, desc);
	}
	

	
	public void fail(String code,String desc){
		this.code=code;
		this.desc=desc;
		this.data=null;
	}

	@Override
	public String toString() {
		return "ResponseVO [code=" + code + ", desc=" + desc + ", token=" + token + ", data=" + data + "]";
	}
	
}
