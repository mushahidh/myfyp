package bean;
import java.io.*;
import javax.servlet.http.Part;

public class user implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_screen_name;
	private String user_encrypted_password;
	private String user_email;
	private String user_DOB;
	private String user_first_name;
	private String user_last_name;
	private String user_city;
	private String user_gender;
	private String user_cell_number;
	private Part user_profile_picture;
	//<========================Getter and Setter Goes here========================>
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_screen_name() {
		return user_screen_name;
	}
	public void setUser_screen_name(String user_screen_name) {
		this.user_screen_name = user_screen_name;
	}
	public String getUser_encrypted_password() {
		return user_encrypted_password;
	}
	public void setUser_encrypted_password(String user_encrypted_password) {
		this.user_encrypted_password = user_encrypted_password;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_DOB() {
		return user_DOB;
	}
	public void setUser_DOB(String user_DOB) {
		this.user_DOB = user_DOB;
	}
	public String getUser_first_name() {
		return user_first_name;
	}
	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}
	public String getUser_last_name() {
		return user_last_name;
	}
	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}
	public String getUser_city() {
		return user_city;
	}
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	public String getUser_gender() {
		return user_gender;
	}
	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUser_cell_number() {
		return user_cell_number;
	}
	public void setUser_cell_number(String user_cell_number) {
		this.user_cell_number = user_cell_number;
	}
	public Part getUser_profile_picture() {
		return user_profile_picture;
	}
	public void setUser_profile_picture(Part user_profile_picture) {
		this.user_profile_picture = user_profile_picture;
	}


	//<========================End Getter and Setters=============================>
	
}
