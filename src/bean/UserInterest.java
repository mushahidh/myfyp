package bean;
import java.io.*;

public class UserInterest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int user_id;
	private int realistic;
	private int investigative;
	private int artistic;
	private int social;
	private int enterprising;
	private int conventional;
	//<========================Getter and Setter Goes here========================>
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getRealistic() {
		return realistic;
	}
	public void setRealistic(int realistic) {
		this.realistic = realistic;
	}
	public int getInvestigative() {
		return investigative;
	}
	public void setInvestigative(int investigative) {
		this.investigative = investigative;
	}
	public int getArtistic() {
		return artistic;
	}
	public void setArtistic(int artistic) {
		this.artistic = artistic;
	}
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	public int getEnterprising() {
		return enterprising;
	}
	public void setEnterprising(int enterprising) {
		this.enterprising = enterprising;
	}
	public int getConventional() {
		return conventional;
	}
	public void setConventional(int conventional) {
		this.conventional = conventional;
	}


	//<========================End Getter and Setters=============================>
}
