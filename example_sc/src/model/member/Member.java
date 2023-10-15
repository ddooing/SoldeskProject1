package model.member;

import java.io.Serializable;
import java.util.ArrayList;


public class Member implements Serializable {

	private static final long serialVersionUID = 1L;
	public static String tokeniD;
	private String id;
	private String pw;
	private String name;
	private String tel;
	
	
	public Member() {

	}
	
	// 생성자
	public Member(String id, String pw, String name, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}
	

	public static String getTokenID() {
		return tokeniD;
	}

	public void setTokenID(String tokenID) {
		this.tokeniD = tokenID;
	}
	
	
	public ArrayList<ArtReserInfo> getTiketList(){ // id인 예매 정보 리스트 
		
		ArrayList<ArtReserInfo> tikeList;
				
		ArtReserInfoList a = new ArtReserInfoList();
		tikeList=a.getIdReserList(); // ArtReserInfoList 에서 id 의 예매 정보리스트 가져옴
         
		 return tikeList;
	}
	
	// 토큰 아이디 확인용 
	/*
	public void getTiketList(){
		ArtReserInfoList list = new ArtReserInfoList();
		list.showId();
		
	}*/


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
		return id + " " + pw + " " + name;
	}

}