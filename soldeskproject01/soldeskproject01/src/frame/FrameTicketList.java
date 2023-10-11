package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.member.ArtReserInfo;
import model.member.ArtReserInfoList;

public class FrameTicketList extends JPanel {
	 public FrameTicketList()
	    {
	        // JPanel 구조 설정
	        setBackground(Color.white);
	        setLayout(null);
	        setSize(400, 700);
	        
	        String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로

	        ImageIcon menuLine = new ImageIcon("./src/line3.png");

	        
	        try {
	            // TTF 파일을 읽어서 Font 객체 생성
	            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));


	            
		        JLabel menuline = new JLabel(menuLine); // 메뉴선
		        JLabel text = new JLabel("티켓 "); 
	
		        text.setSize(200,50);
		        text.setLocation(40, 40);
		        // 원하는 폰트 스타일과 크기로 설정
		        customFont = customFont.deriveFont(Font.PLAIN, 30); // 크기 24, 평범한 스타일로 설정
		        text.setFont(customFont);
	
		        menuline.setSize(380, 5);
		        menuline.setLocation(10, text.getY() + text.getHeight());
	
		        add(text);
		        add(menuline);
		        
	            // ArtReserInfoList를 사용하여 예약 정보를 받아옵니다.
	            ArtReserInfoList artReserInfoList = new ArtReserInfoList();
	            List<ArtReserInfo> reservationList = artReserInfoList.getArtReserInfoList();
		            
	         // 예약 정보를 반복하며 티켓 목록을 생성하는 코드
	            int y = menuline.getY() + menuline.getHeight() + 20; // 시작 위치 설정

	            for (ArtReserInfo reservation : reservationList) {
	                if (reservation != null && reservation.getA() != null) { 
	                    JLabel ticketInfo = new JLabel();
	                    ticketInfo.setSize(350, 40);
	                    ticketInfo.setLocation(30, y);

	                    String ticketText = "예약 번호: " + reservation.getId() + ", 예술 작품: " + reservation.getA().getArtName();
	                    ticketInfo.setText(ticketText);

	                    add(ticketInfo);

	                    y += ticketInfo.getHeight() + 10; 
	                }
	            }
		        
	        } catch (IOException | FontFormatException e) {
	            e.printStackTrace();
	        }
	        
	        
	        
	        JButton back = new JButton();
			back.setSize(50,40);
			back.setLocation(30,640);
			back.setBorderPainted(false);
			back.setContentAreaFilled(false);
			back.setFocusPainted(false);
			add(back);
			
			back.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
	                if (window1 != null) {
	                    window1.dispose(); 
	                }
					FrameBase.getInstance(new Home());
					
				}
			});
	    }
}
