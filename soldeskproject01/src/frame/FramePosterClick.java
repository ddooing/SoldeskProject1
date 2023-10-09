package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class FramePosterClick extends JPanel {
	// 전시회 조회 페이지
	JPanel framehomePanel;
	private int ad;
	private List<ArtGalleryInfo> posterInfoList;
	private ArtGalleryInfo artGalleryInfo;
	
	public FramePosterClick() {
		this(null,null);
	}
	
	public FramePosterClick(ActionEvent e, String artname) {
	    ArtGalleryList artgallerylist = new ArtGalleryList();
	    setSize(400, 700);
	    setLayout(null);
	    setVisible(true);

	    for (ArtGalleryInfo info : artgallerylist.Info()) {
	        if (info.getArtName().equals(artname)) {
	            this.artGalleryInfo = info; // save the selected exhibition info
	            break;
	        }
	    }

	    if (this.artGalleryInfo != null) { // if a valid exhibition is selected
	        makeArtInfo(this.artGalleryInfo); // make the screen with the selected exhibition's info
	    }
	}
	
	public void makeArtInfo(ArtGalleryInfo info) {
		JLabel fImage=new JLabel(HtmlUtils.imgHtmlParser(info.getImageURL()));
		fImage.setSize(360,280);
		fImage.setLocation(20,70);
		add(fImage);

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		// dateStart 포맷팅
		Date dateStart = info.getDateStart();
		String formattedDateStart = dateFormat.format(dateStart);

		// dateEnd 포맷팅
		Date dateEnd = info.getDateEnd();
		String formattedDateEnd = dateFormat.format(dateEnd);

		JLabel title = new JLabel("<HTML><body>" +info.getArtName() + "</body></HTML>");

		JLabel placendate = new JLabel("<HTML><body>" +info.getPlace() + "<br>" 
		+ formattedDateStart + " ~ " + formattedDateEnd +"</body></HTML>");

		 ImageIcon menuLine =new ImageIcon("./src/line3.png");
	        JLabel menuline = new JLabel(menuLine);// 메뉴선
	        menuline.setSize(380, 5);
	        menuline.setLocation(30, 450 );
	        add(menuline);
	        
		
		JLabel story = new JLabel("<HTML><body>" +
						"관람시간 : " + info.getTime() + "<br>" +
						"입장료 : " + info.getFee() + "<br>" +
						"주소 : " + info.getPlace() + "</body></HTML>");
		
		// "예약" 버튼 생성
		ImageIcon originalIcon = new ImageIcon("./src/예매.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon reservebtn = new ImageIcon(scaledImage);
        JButton reservebtn1 = new JButton(reservebtn);
        
        reservebtn1.setBounds(300, 450, 50, 30);
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
		separator2.setBounds(10, 490, 360, 10); // 구분선의 위치와 크기 조정
		separator2.setForeground(Color.BLACK); 
		add(separator2);
		
		
		add(title);
		add(placendate);
		add(story);
		
		
		reservebtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(info.getArtName()+" : 예매 버튼 클릭");
			}
		});
		
		reservebtn1.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 예매 버튼 클릭 시 실행되는 코드
		        // FrameReserve 인스턴스 생성
		        FrameReserve frameReserve = new FrameReserve(info);
		        
		        // 현재 창 닫기
		        Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());
		        if (window1 != null) {
		            window1.dispose();
		        }
		        
		        // FrameReserve 페이지로 이동
		        FrameBase.getInstance(frameReserve);
		    }
		});
		
		JButton back1 = new JButton();
		back1.setSize(50,40);
		back1.setLocation(30,640);
		back1.setBorderPainted(false);
		back1.setContentAreaFilled(false);
		back1.setFocusPainted(false);
		add(back1);
		
		back1.addActionListener(new ActionListener() {
			
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