package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import artDB.ArtGalleryList;

import java.util.Calendar;
import java.util.Date;

public class ListPanel extends JPanel {

	private ArtGalleryList artGalleryList; // 전시회 정보 리스트 
		
	public ListPanel() {
		// 패널의 위치와 크기 설정
	    setBounds(19, 123, 362, 500);
	    // 패널의 배경색을 핑크색으로 설정
	    setBackground(Color.pink);
	    


	 // 현재 날짜를 구함
        Calendar currentDate = Calendar.getInstance();
        Date now = currentDate.getTime();
        System.out.println(now);
        
        // Home 처음 보이는 전시회 리스트 -> 최신순 
        	// 후에 수정하기 아래 코드는 리스트 차례대로 부른거
        artGalleryList = new ArtGalleryList();
        
        
        // 현재 날짜 기준 곧 종료 
        //artGalleryList.soonEnd(now);
        
   
	}
}
