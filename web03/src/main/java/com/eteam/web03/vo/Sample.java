package com.eteam.web03.vo;

public class Sample {
	private int sampleId; 		// sample.sample_id
	private String sampleName;	// sample.sample_name
	
	public int getSampleId() {
		return sampleId;
	}

	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}

	public String getSampleName() {
		return sampleName;
	}

	public void setSampleName(String sampleName) {
		this.sampleName = sampleName;
	}

	@Override
	public String toString() {
		return "sample [sampleId=" + sampleId + ", sampleName=" + sampleName + "]";
	}
}
