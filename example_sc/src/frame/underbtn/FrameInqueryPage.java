package frame.underbtn;

import javax.swing.*;

import artDB.ArtGalleryInfo;
import frame.base.FrameBase;
import frame.reserve.FrameReserve;
import model.member.ArtReserInfo;
import model.member.ArtReserInfoList;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrameInqueryPage extends JPanel {
	private ArtReserInfo reservation;

	 public FrameInqueryPage(ArtReserInfo reservation) {
		 this.reservation = reservation;
		 setLayout(null);
	        setSize(400, 700);
	        
		 ArtGalleryInfo artInfo = this.reservation.getA();
		 
		 ImageIcon originalIcon9 = new ImageIcon(artInfo.getImageURL());
	        Image originalImage9 = originalIcon9.getImage();
	        Image scaledImage9 = originalImage9.getScaledInstance(360, 280, Image.SCALE_SMOOTH);
	        ImageIcon posterImage1 = new ImageIcon(scaledImage9);
			JLabel fImage=new JLabel(posterImage1);
	        fImage.setSize(360,280);
	        fImage.setLocation(20,70);
	        add(fImage);
	        
	        // dateStart 포맷팅
	        Date dateStart = artInfo.getDateStart();
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        String formattedDateStart = dateFormat.format(dateStart);

	        // dateEnd 포맷팅
	        Date dateEnd = artInfo.getDateEnd();
	        String formattedDateEnd = dateFormat.format(dateEnd);
			
	        JLabel title = new JLabel("<HTML><body>" +artInfo.getArtName() + "</body></HTML>");
	        
	        JLabel placendate = new JLabel("<HTML><body>"+
	        "전시관 :" +artInfo.getPlace() + "<br>"+
	        "예매 날짜 : "  +reservation.getReserveDate() +"<br>" + 
			"예매 관람 시간 : " + reservation.getReseveTime() +"<br>" +
	        "티켓 개수 : "+reservation.getReserverInt()+"<br>" + 
			"총 입장료 : " + reservation.getTotalfee() + "<br>" 
			 
			+"</body></HTML>");

			
	        
			title.setSize(400,30);
			title.setLocation(30, 360);
			title.setBackground(new Color(255, 255, 255));
			title.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));
			
			placendate.setSize(400,180);
			placendate.setLocation(30, 410);
			placendate.setBackground(new Color(255, 255, 255));
			placendate.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

			// 구분선 추가
			JSeparator separator1 = new JSeparator();
			separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
			separator1.setForeground(Color.BLACK); 
			add(separator1);
		
			add(title);
			add(placendate);

	        
	     // "길찾기" 버튼 생성
	      		ImageIcon originalIcon1 = new ImageIcon("./src/img/길찾기.png");
	              Image originalImage1 = originalIcon1.getImage();
	              Image scaledImage1 = originalImage1.getScaledInstance(70, 30, Image.SCALE_SMOOTH);
	              ImageIcon mapgobtn = new ImageIcon(scaledImage1);
	              JButton mapgobtn1 = new JButton(mapgobtn);
	              
	              mapgobtn1.setBounds(295, 450, 70, 30);
	              mapgobtn1.setBorderPainted(false); // 버튼 외각선 지우기
	              mapgobtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
	              mapgobtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
	              add(mapgobtn1);
	              
	              

	              // 호버 시에 표시할 이미지 설정
	              ImageIcon hoverIcon2 = new ImageIcon("./src/img/길찾기hover.png");
	              Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH);
	              mapgobtn1.setRolloverIcon(new ImageIcon(scaledHoverImage2));
	     		
	     		
	     		mapgobtn1.addActionListener(new ActionListener() {
	     			
	     			@Override
	     			public void actionPerformed(ActionEvent e) {
	     				try {
	     		            // 크롬 브라우저 열기
	     					String URL = artInfo.getPlaceURL();
	     		            Desktop.getDesktop().browse(new URI(URL));
	     		        } catch (IOException | URISyntaxException ex) {
	     		            ex.printStackTrace(); // 예외 처리
	     		        }
	     				
	     			}
	     		});
	        

	     		
	     		ImageIcon originalIcon10 = new ImageIcon("./src/img/뒤로가기.png");
	            Image originalImage10 = originalIcon10.getImage();
	            Image scaledImage10 = originalImage10.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
	            ImageIcon posterImage10 = new ImageIcon(scaledImage10);
	            JButton back = new JButton(posterImage10);
	    		back.setSize(50,40);
	    		back.setLocation(30,30);
	    		back.setBorderPainted(false);
	    		back.setContentAreaFilled(false);
	    		back.setFocusPainted(false);
	    		
	    		add(back);
	    		
	    		back.addActionListener(new ActionListener() {
	    	        @Override
	    	        public void actionPerformed(ActionEvent e) {
	    	            
	    	        
	    	            // 현재 창을 닫습니다.
	    	            Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());
	    	            if (window1 != null) {
	    	                window1.dispose();
	    	            }
	    	        }
	    	    });
    }

}
