package bean;
import java.io.*;

public class groupIncludes implements Serializable{

	private static final long serialVersionUID = 1L;
	private int group_id;
	private int[] field_id;
	private int field_idd;
	
	//<========================Getter and Setter Goes here========================>
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	public int[] getField_id() {
		return field_id;
	}
	public void setField_id(int[] field_id) {
		this.field_id = field_id;
	}
	public int getField_idd() {
		return field_idd;
	}
	public void setField_idd(int field_idd) {
		this.field_idd = field_idd;
	}

	//<========================End Getter and Setters=============================>
}
