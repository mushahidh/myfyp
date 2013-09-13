package bean;

import java.io.Serializable;

public class offers implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private int field_idd;
	private int uni_id;
	private int duration;
	private int hssc_criteria;
	private int ssc_criteria;
	private int[] field_id;
	//<========================Getter and Setter Goes here========================>
	public int getUni_id() {
		return uni_id;
	}
	public void setUni_id(int uni_id) {
		this.uni_id = uni_id;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getHssc_criteria() {
		return hssc_criteria;
	}
	public void setHssc_criteria(int hssc_criteria) {
		this.hssc_criteria = hssc_criteria;
	}
	public int getSsc_criteria() {
		return ssc_criteria;
	}
	public void setSsc_criteria(int ssc_criteria) {
		this.ssc_criteria = ssc_criteria;
	}
	public int getField_idd() {
		return field_idd;
	}
	public void setField_idd(int field_idd) {
		this.field_idd = field_idd;
	}
	public int[] getField_id() {
		return field_id;
	}
	public void setField_id(int[] field_id) {
		this.field_id = field_id;
	}

	//<========================End Getter and Setters=============================>
}
