package bean;
import java.io.*;

import javax.servlet.http.Part;

public class admin implements Serializable{

	private static final long serialVersionUID = 1L;
	private int user_id;
	private String user_screen_name;
	private String user_email;
	private String user_encrypted_password;
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
	public Part getUser_profile_picture() {
		return user_profile_picture;
	}
	public void setUser_profile_picture(Part user_profile_picture) {
		this.user_profile_picture = user_profile_picture;
	}

	//<========================End Getter and Setters=============================>
	
}
