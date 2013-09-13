package bean;
import java.io.*;

public class includes implements Serializable{

	private static final long serialVersionUID = 1L;
	private int field_id;
	
	private int[] course_id;
	private int course_idd;
	//<========================Getter and Setter Goes here========================>
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int[] getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int[] course_id) {
		this.course_id = course_id;
	}
	public int getCourse_idd() {
		return course_idd;
	}
	public void setCourse_idd(int course_idd) {
		this.course_idd = course_idd;
	}
	
	

	//<========================End Getter and Setters=============================>

	
}
