package controller.member;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

import model.member.Member;

public class MemberController {

	static String filename = "회원명단.txt";
	static ArrayList<Member> memberList = new ArrayList<>();

	public ArrayList<Member> readFile(String filename) {

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), StandardCharsets.UTF_8));

			
				while(true) {
					String text = br.readLine(); // 텍스트 파일 내 데이터를 한 줄 씪 읽음
				
					// 텍스트 내 데이터가 없으면 끝내도록
					if (text == null) {
						break;
					}
					
					String[] strArray = text.split("/");	
					memberList.add(new Member(strArray[0], strArray[1], strArray[2], strArray[3]));
					System.out.println(strArray[0] + ", " + strArray[2]);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberList;
	}
}

