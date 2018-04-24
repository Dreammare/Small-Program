package com.tencent.model;

import java.io.Serializable;

public class HrData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String period_name;
	private String account;
	private String bg_code;
	private String bg_name;
	private String coa_code;
	private String cost_type;
	private Double ratio;
	
	private String attribute1;
	private String attribute2;
	private String attribute3;
	private String attribute4;
	private String attribute5;
	public String getPeriod_name() {
		return period_name;
	}
	public String getAccount() {
		return account;
	}
	public String getBg_code() {
		return bg_code;
	}
	public String getBg_name() {
		return bg_name;
	}
	public String getCoa_code() {
		return coa_code;
	}
	public String getCost_type() {
		return cost_type;
	}
	public Double getRatio() {
		return ratio;
	}
	public String getAttribute1() {
		return attribute1;
	}
	public String getAttribute2() {
		return attribute2;
	}
	public String getAttribute3() {
		return attribute3;
	}
	public String getAttribute4() {
		return attribute4;
	}
	public String getAttribute5() {
		return attribute5;
	}
	public void setPeriod_name(String period_name) {
		this.period_name = period_name;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setBg_code(String bg_code) {
		this.bg_code = bg_code;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public void setCoa_code(String coa_code) {
		this.coa_code = coa_code;
	}
	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}
	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}
	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}
	public void setAttribute4(String attribute4) {
		this.attribute4 = attribute4;
	}
	public void setAttribute5(String attribute5) {
		this.attribute5 = attribute5;
	}
	@Override
	public String toString() {
		return "HrData [period_name=" + period_name + ", account=" + account
				+ ", bg_code=" + bg_code + ", bg_name=" + bg_name
				+ ", coa_code=" + coa_code + ", cost_type=" + cost_type
				+ ", ratio=" + ratio + ", attribute1=" + attribute1
				+ ", attribute2=" + attribute2 + ", attribute3=" + attribute3
				+ ", attribute4=" + attribute4 + ", attribute5=" + attribute5
				+ "]";
	}

}
