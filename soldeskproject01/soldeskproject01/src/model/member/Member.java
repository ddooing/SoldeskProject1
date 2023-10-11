package model.member;

import java.io.Serializable;
import java.util.ArrayList;


public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	public static String tokeniD;
	public static String getTokeniD() {
		return tokeniD;
	}

	public static void setTokeniD(String tokeniD) {
		Member.tokeniD = tokeniD;
	}

	private String id;
	private String pw;
	private String name;
	private String tel;
	
	public Member() {

	}

	public ArrayList<ArtReserInfo> getTiketList(){ // id인 예매 정보 리스트 
		
		ArrayList<ArtReserInfo> tikeList;
				
		ArtReserInfoList a = new ArtReserInfoList();
		tikeList=a.getIdReserList(); // ArtReserInfoList 에서 id 의 예매 정보리스트 가져옴
         
		 return tikeList;
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