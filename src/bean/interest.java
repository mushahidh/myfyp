package bean;
import java.io.*;

public class interest implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int field_id;
	private int realistic;
	private int social;
	private int artistic;
	private int investigative;
	private int enterprising;
	private int conventional;
	//<========================Getter and Setter Goes here========================>
	public int getField_id() {
		return field_id;
	}
	public void setField_id(int field_id) {
		this.field_id = field_id;
	}
	public int getRealistic() {
		return realistic;
	}
	public void setRealistic(int realistic) {
		this.realistic = realistic;
	}
	public int getSocial() {
		return social;
	}
	public void setSocial(int social) {
		this.social = social;
	}
	public int getArtistic() {
		return artistic;
	}
	public void setArtistic(int artistic) {
		this.artistic = artistic;
	}
	public int getInvestigative() {
		return investigative;
	}
	public void setInvestigative(int investigative) {
		this.investigative = investigative;
	}
	public int getConventional() {
		return conventional;
	}
	public void setConventional(int conventional) {
		this.conventional = conventional;
	}
	public int getEnterprising() {
		return enterprising;
	}
	public void setEnterprising(int enterprising) {
		this.enterprising = enterprising;
	}

	//<========================End Getter and Setters=============================>
	
}
