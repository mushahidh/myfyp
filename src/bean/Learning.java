package bean;
import java.io.*;
public class Learning implements Serializable{

	private static final long serialVersionUID = 1L;
	private int field_id;
	private float total_average;
	private float counter_average;
	private int counter;
	private int total_rating;
	private int total_user_rating;
	private int total_counter_rating;
	private int user_counter_rating;
	private int total_counter;
	
	//<========================Getter and Setter Goes here========================>
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getTotal_rating() {
		return total_rating;
	}
	public void setTotal_rating(int total_rating) {
		this.total_rating = total_rating;
	}
	public int getTotal_user_rating() {
		return total_user_rating;
	}
	public void setTotal_user_rating(int total_user_rating) {
		this.total_user_rating = total_user_rating;
	}
	public int getTotal_counter_rating() {
		return total_counter_rating;
	}
	public void setTotal_counter_rating(int total_counter_rating) {
		this.total_counter_rating = total_counter_rating;
	}
	public int getUser_counter_rating() {
		return user_counter_rating;
	}
	public void setUser_counter_rating(int user_counter_rating) {
		this.user_counter_rating = user_counter_rating;
	}
	public float getTotal_average() {
		return total_average;
	}
	public void setTotal_average(float total_average) {
		this.total_average = total_average;
	}
	public float getCounter_average() {
		return counter_average;
	}
	public void setCounter_average(float counter_average) {
		this.counter_average = counter_average;
	}
	public int getTotal_counter() {
		return total_counter;
	}
	public void setTotal_counter(int total_counter) {
		this.total_counter = total_counter;
	}
	


	//<========================End Getter and Setters=============================>
	
}
