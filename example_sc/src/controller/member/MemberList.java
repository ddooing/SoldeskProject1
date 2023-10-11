package controller.member;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import model.member.Member;

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
	
	public String infoName(String id) throws UnsupportedEncodingException {
		
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
	
	public String findID(String inputName, String inputTel) {
        Iterator<Member> iterator = memberList.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getName().equals(inputName)) {
            	if(member.getTel().equals(inputTel)) {
            		return member.getId();
            	} 
            } 
        }
        return null; 
   }
	
   public String findPW(String inputID, String inputTel, String inputName) {
        Iterator<Member> iterator = memberList.iterator();
        while (iterator.hasNext()) {
            Member member = iterator.next();
            if (member.getId().equals(inputID) && member.getTel().equals(inputTel) && member.getName().equals(inputName)) {
                return member.getPw();
            }
        }
        return null; 
   }
}
