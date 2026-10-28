package com.hospital.dailyreport.patient;

public class PatientCount {
	private String type;
	private int count;

	public PatientCount(String type, int count) {
		this.type = type;
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public int getCount() {
		return count;
	}
}


