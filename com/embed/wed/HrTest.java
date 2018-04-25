package com.hand.wed;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class HrTest {

	public static void main(String[] args) {
		Gson gson = new Gson();
		
		HrRecord hr1 = new HrRecord();
		hr1.setAttribute1("a");
		hr1.setAttribute2("b");
		hr1.setAttribute3("c");
		hr1.setAttribute4("d");
		hr1.setAttribute5("e");
		
		HrRecord hr2 = new HrRecord();
		hr2.setAttribute1("e");
		hr2.setAttribute2("f");
		hr2.setAttribute3("g");
		hr2.setAttribute4("h");
		hr2.setAttribute5("i");
		
		List<HrRecord> hrRecords = new ArrayList<HrRecord>();
		hrRecords.add(hr1);
		hrRecords.add(hr2);
		
		HrData hd1 = new HrData();
		hd1.setPeriod_name("201804");
		hd1.setAccount("ABCD");
		hd1.setBg_code("99900");
		hd1.setBg_name("BG");
		hd1.setCoa_code("999000");
		hd1.setCost_type("COPS");
		hd1.setRatio(2.33);
		hd1.setHrRecords(hrRecords);
		
		HrData hd2 = new HrData();
		hd2.setPeriod_name("201804");
		hd2.setAccount("ABCD");
		hd2.setBg_code("99800");
		hd2.setBg_name("BG");
		hd2.setCoa_code("033000");
		hd2.setCost_type("SM");
		hd2.setRatio(2.33);
		hd2.setHrRecords(hrRecords);
		
		List<HrData> list = new ArrayList<HrData>();
		list.add(hd1);
		list.add(hd2);
		
		System.out.println(list);
		String str = gson.toJson(list);
		System.out.println(str);
		
	}

}
