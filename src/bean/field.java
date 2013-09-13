package bean;
import java.io.*;

public class field implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int field_id;
	private String field_name;
	private String field_desc;
	private int field_standard;
	//<========================Getter and Setter Goes here========================>
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getField_desc() {
		return field_desc;
	}
	public void setField_desc(String field_desc) {
		this.field_desc = field_desc;
	}
	
	public int getField_standard() {
		return field_standard;
	}
	public void setField_standard(int field_standard) {
		this.field_standard = field_standard;
	}

	//<========================End Getter and Setters=============================>

	
}
