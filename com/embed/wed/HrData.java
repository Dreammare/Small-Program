package com.hand.wed;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HrData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String period_name;
	private String account;
	private String bg_code;
	private String bg_name;
	private String coa_code;
	private String cost_type;
	private Double ratio;
	
	private List<HrRecord> hrRecords = new ArrayList<HrRecord>();
	
	private HrRecord hrRecord;
	
	public String getPeriod_name() {
		return period_name;
	}
	public void setPeriod_name(String period_name) {
		this.period_name = period_name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBg_code() {
		return bg_code;
	}
	public void setBg_code(String bg_code) {
		this.bg_code = bg_code;
	}
	public String getBg_name() {
		return bg_name;
	}
	public void setBg_name(String bg_name) {
		this.bg_name = bg_name;
	}
	public String getCoa_code() {
		return coa_code;
	}
	public void setCoa_code(String coa_code) {
		this.coa_code = coa_code;
	}
	public String getCost_type() {
		return cost_type;
	}
	public void setCost_type(String cost_type) {
		this.cost_type = cost_type;
	}
	public Double getRatio() {
		return ratio;
	}
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}
	public List<HrRecord> getHrRecords() {
		return hrRecords;
	}
	public void setHrRecords(List<HrRecord> hrRecords) {
		this.hrRecords = hrRecords;
	}
	public HrRecord getHrRecord() {
		return hrRecord;
	}
	public void setHrRecord(HrRecord hrRecord) {
		this.hrRecord = hrRecord;
	}
	
}
