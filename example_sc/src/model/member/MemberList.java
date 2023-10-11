package model.member;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberList {

	private ArrayList<Member> memberList;
	
	public MemberList() {
		memberList = new ArrayList<Member>();
	}
	
	public void addMember(Member member) {
		memberList.add(member);
	}
	
	public String loginMember(String id) {
		
		Iterator<Member> ir = memberList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return member.getPw();
			}
		}
		return "";

	}
	
	public String joinMember(String id) {
		
		Iterator<Member> ir = memberList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return "존재하는 아이디입니다.";
			}
		}
		return "";

	}
	
	public String infoName(String id) {
		
		Iterator<Member> ir = memberList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return member.getName();
			}
		}
		return "";		
	}
	
	public String infoTel(String id) {
		
		Iterator<Member> ir = memberList.iterator();
		while(ir.hasNext()) {
			Member member = ir.next();
			String tempId = member.getId();
			if(tempId.equals(id)) {
				return member.getTel();
			}
		}
		return "";		
	}

	
	public void showAllMember() {
		for(Member member:memberList) {
			System.out.println(member);
		}
		System.out.println("-----------------------------------");
	}
}

