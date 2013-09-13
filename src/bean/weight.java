package bean;
import java.io.*;

public class weight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int field_id;
	private int weight;
	//<========================Getter and Setter Goes here========================>
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	//<========================End Getter and Setters=============================>
}
