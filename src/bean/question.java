package bean;
import java.io.*;

public class question implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int question_id;
	private String question;
	private String type;
	
	//<========================Getter and Setter Goes here========================>
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}



	//<========================End Getter and Setters=============================>
}
