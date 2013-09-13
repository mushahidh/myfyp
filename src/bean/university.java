package bean;
import java.io.*;

public class university implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int uni_id;
	private String uni_name;
	private String uni_location;
	private String uni_address;
	private String uni_website;
	private String uni_desc;
	private double uni_longitude;
	private double uni_latitude;
	//<========================Getter and Setter Goes here========================>
	public int getUni_id() {
		return uni_id;
	}
	public void setUni_id(int uni_id) {
		this.uni_id = uni_id;
	}
	public String getUni_name() {
		return uni_name;
	}
	public void setUni_name(String uni_name) {
		this.uni_name = uni_name;
	}
	public String getUni_location() {
		return uni_location;
	}
	public void setUni_location(String uni_location) {
		this.uni_location = uni_location;
	}
	public String getUni_address() {
		return uni_address;
	}
	public void setUni_address(String uni_address) {
		this.uni_address = uni_address;
	}
	public String getUni_website() {
		return uni_website;
	}
	public void setUni_website(String uni_website) {
		this.uni_website = uni_website;
	}
	public String getUni_desc() {
		return uni_desc;
	}
	public void setUni_desc(String uni_desc) {
		this.uni_desc = uni_desc;
	}
	public double getUni_longitude() {
		return uni_longitude;
	}
	public void setUni_longitude(double uni_longitude) {
		this.uni_longitude = uni_longitude;
	}
	public double getUni_latitude() {
		return uni_latitude;
	}
	public void setUni_latitude(double uni_latitude) {
		this.uni_latitude = uni_latitude;
	}



	//<========================End Getter and Setters=============================>
}
