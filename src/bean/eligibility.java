package bean;
import java.io.*;

public class eligibility implements Serializable{

	private static final long serialVersionUID = 1L;
	private int field_id;
	private int required_idd;
	private int[] required_id;
	public int getField_id() {
		return field_id;
	}
	//<========================Getter and Setter Goes here========================>
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int getRequired_idd() {
		return required_idd;
	}
	public void setRequired_idd(int required_idd) {
		this.required_idd = required_idd;
	}
	public int[] getRequired_id() {
		return required_id;
	}
	public void setRequired_id(int[] required_id) {
		this.required_id = required_id;
	}

	//<========================End Getter and Setters=============================>
	}
