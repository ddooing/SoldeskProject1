package model.member;

import java.io.Serializable;


public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String pw;
	private String name;
	private String tel;
	
	public static String tokeniD;

	public static String getTokenID() {
		return tokeniD;
	}

	public void setTokenID(String tokenID) {
		this.tokeniD = tokenID;
	}
	public Member() {

	}

	// 생성자
	public Member(String id, String pw, String name, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + pw + " " + name;
	}

}