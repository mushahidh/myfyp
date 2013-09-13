package bean;
import java.io.*;

public class group implements Serializable{

	private static final long serialVersionUID = 1L;
	private int group_id;
	private String group_name;
	private int group_standard;
	//<========================Getter and Setter Goes here========================>
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public int getGroup_standard() {
		return group_standard;
	}
	public void setGroup_standard(int group_standard) {
		this.group_standard = group_standard;
	}
	public int getGroup_id() {
		return group_id;
	}
	public void setGroup_id(int group_id) {
		this.group_id = group_id;
	}
	

	//<========================End Getter and Setters=============================>

	
}

