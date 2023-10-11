package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import model.member.Member;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;


import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
//import controller.member.MemberToken;
//import model.member.Member;
import model.member.ArtReserInfo;
import model.member.ArtReserInfoList;

public class FramePosterClick extends JPanel {
	
	JPanel framehomePanel;
	private int ad;
	private ArtGalleryList artgallerylist;//전시회 정보 리스트
	private ArtGalleryInfo art;//제목이 artname인 객체 넣을 공간 
	private List<ArtGalleryInfo> posterInfoList;
	
	List<ArtReserInfo> reserInfoList;
	
	
	private String id ;
	
	public FramePosterClick(String id,String artname, String prepage) {
		
		setSize(400, 700); // homepanel 과 같은 사이즈 
        setLayout(null);
        setVisible(true);
        
		artgallerylist = new ArtGalleryList();
		this.id= id;

        // 전시회 정보 리스트에서 제목이 artname인 객체 찾아내기 
        for(int i=0; i<artgallerylist.getPosters().size();i++) {
        	if(artname.equals(artgallerylist.getPosters().get(i).getArtName())) {
        		//제목이 artname인 객체 art 에 넣기 
        		art= artgallerylist.getPosters().get(i);
        		posterInfoList = artgallerylist.getPosters();
        		//System.out.println(" 고른 객체 : "+art.getArtName());
        		makeArtInfo(art,i);
        		break;
        	}
        }
        
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
	            if ("Home".equals(prepage)) {
	                // Home()에서 넘어왔을 때의 동작
	                FrameBase.getInstance(new Home());
	            } else if ("FrameSearch_1".equals(prepage)) {
	                // FrameSearch_1에서 넘어왔을 때의 동작
	                FrameBase.getInstance(new FrameSearch_1());
	            } else if("FrameTicketList".equals(prepage)){
	            	 // FrameSearch_1에서 넘어왔을 때의 동작
	            	FrameBase.getInstance(new FrameTicketList(Member.tokeniD));
	            } else if("FrameHomePopularClick".equals(prepage)) {
	                // 다른 조건에 따른 동작 설정
	            	FrameBase.getInstance(new Home());
	            } else if("FrameSoonPage".equals(prepage)) {
	                // 다른 조건에 따른 동작 설정
	            	FrameBase.getInstance(new FrameSoonPage());
	            } else if("".equals(prepage)) {
	                // 다른 조건에 따른 동작 설정
	            	FrameBase.getInstance(new Home());
	            } else {
	            	FrameBase.getInstance(new Home());
	            }
	        
	            // 현재 창을 닫습니다.
	            Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());
	            if (window1 != null) {
	                window1.dispose();
	            }
	        }
	    });
        
        
	}

	public void makeArtInfo(ArtGalleryInfo artInfo,int i) {
		ImageIcon originalIcon9 = new ImageIcon(posterInfoList.get(i).getImageURL());
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
        
        JLabel placendate = new JLabel("<HTML><body>" +artInfo.getPlace() + "<br>" 
        + formattedDateStart + " ~ " + formattedDateEnd +"</body></HTML>");
        
		JLabel story = new JLabel("<HTML><body>" +
						"관람시간 : " + artInfo.getStarttime() + " ~ " + artInfo.getEndtime() + "<br>" + 
						"입장료 : " + artInfo.getFee() + "<br>" + 
						"주소 : " + artInfo.getPlace() + "</body></HTML>");
		
		// "예약" 버튼 생성
		ImageIcon originalIcon = new ImageIcon("./src/img/예매.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon reservebtn = new ImageIcon(scaledImage);
        JButton reservebtn1 = new JButton(reservebtn);
        
        reservebtn1.setBounds(300, 450, 60, 30);
        reservebtn1.setBorderPainted(false); // 버튼 외각선 지우기
        reservebtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        reservebtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
        add(reservebtn1);
        
		title.setSize(400,30);
		title.setLocation(30, 360);
		title.setBackground(new Color(255, 255, 255));
		title.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));
		
		placendate.setSize(400,60);
		placendate.setLocation(30, 410);
		placendate.setBackground(new Color(255, 255, 255));
		placendate.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		
		story.setSize(400, 70);
		story.setLocation(30, 500);
		story.setBackground(new Color(255, 255, 255));
		story.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		
		// 구분선 추가
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
		separator1.setForeground(Color.BLACK); 
		add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(20, 490, 360, 10); // 구분선의 위치와 크기 조정
		separator2.setForeground(Color.BLACK); 
		add(separator2);
		
		
		add(title);
		add(placendate);
		add(story);
		
		
		// 예매 시뮬레이션
        
		ArtReserInfoList a = new ArtReserInfoList();
        //a.show();
         reserInfoList =a.getArtReserInfoList();
         
        // 선택한 전시회 객체 넣기 
        ArtGalleryInfo selectArt = art;
        // 예매 시간 
        String reseveTime=" 13:00 - 12:00";
        // 예매 날짜
        String reserveDate = "2023 - 09 - 11";
        // 예매 개수 
        int reserverInt = 2;
        
        System.out.println("poster쪽  id : "+id);
        

        
     // "길찾기" 버튼 생성
      		ImageIcon originalIcon1 = new ImageIcon("./src/img/길찾기.png");
              Image originalImage1 = originalIcon1.getImage();
              Image scaledImage1 = originalImage1.getScaledInstance(70, 30, Image.SCALE_SMOOTH);
              ImageIcon mapgobtn = new ImageIcon(scaledImage1);
              JButton mapgobtn1 = new JButton(mapgobtn);
              
              mapgobtn1.setBounds(295, 550, 70, 30);
              mapgobtn1.setBorderPainted(false); // 버튼 외각선 지우기
              mapgobtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
              mapgobtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
              add(mapgobtn1);
              
              // 호버 시에 표시할 이미지 설정
              ImageIcon hoverIcon1 = new ImageIcon("./src/img/예매hover.png");
              Image scaledHoverImage1 = hoverIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
              reservebtn1.setRolloverIcon(new ImageIcon(scaledHoverImage1));
       
              // 호버 시에 표시할 이미지 설정
              ImageIcon hoverIcon2 = new ImageIcon("./src/img/길찾기hover.png");
              Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH);
              mapgobtn1.setRolloverIcon(new ImageIcon(scaledHoverImage2));
     		
     		
     		mapgobtn1.addActionListener(new ActionListener() {
     			
     			@Override
     			public void actionPerformed(ActionEvent e) {
     				try {
     		            // 크롬 브라우저 열기
     					String URL = posterInfoList.get(i).getPlaceURL();
     		            Desktop.getDesktop().browse(new URI(URL));
     		        } catch (IOException | URISyntaxException ex) {
     		            ex.printStackTrace(); // 예외 처리
     		        }
     				
     			}
     		});
        
        
		reservebtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매 버튼 클릭시
				Window window = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window != null) {
                    window.dispose(); 
                }
				System.out.println(artInfo.getArtName()+" : 예매 버튼 클릭");
				FrameBase.getInstance(new FrameReserve(artInfo, artInfo.getArtName()));	
				reserInfoList.add(new ArtReserInfo(id,selectArt,reseveTime , reserveDate,reserverInt));
				a.show();
				
			}
		});
		
		
		
		
	}
	
}
