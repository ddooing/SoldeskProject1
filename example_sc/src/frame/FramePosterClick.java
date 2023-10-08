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

public class FramePosterClick extends JPanel {
	
	JPanel framehomePanel;
	private int ad;
	private List<ArtGalleryInfo> posterInfoList;
	
	public FramePosterClick() {
		this(null,null);
	}
	
	public FramePosterClick(ActionEvent e, String artname) {
		
		ArtGalleryList artgallerylist = new ArtGalleryList();
    	
        setSize(400, 700);
        setLayout(null);
        setVisible(true);
        
        
        
        for(int i=0; i<artgallerylist.Info().size();i++) {
        	if(artname.equals(artgallerylist.Info().get(i).getArtName())) {
        		makeArtInfo(artgallerylist, i);
        		break;
        	}
        }
        
        
	}
	
	public void makeArtInfo(ArtGalleryList artGalleryList, int i) {
		JLabel fImage=new JLabel(HtmlUtils.imgHtmlParser(artGalleryList.Info().get(i).getImageURL()));
        fImage.setSize(360,300);
        fImage.setLocation(20,70);
        add(fImage);
        
        // dateStart 포맷팅
        Date dateStart = artGalleryList.Info().get(i).getDateStart();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDateStart = dateFormat.format(dateStart);

        // dateEnd 포맷팅
        Date dateEnd = artGalleryList.Info().get(i).getDateEnd();
        String formattedDateEnd = dateFormat.format(dateEnd);
		
        JLabel title = new JLabel("<HTML><body>" +artGalleryList.Info().get(i).getArtName() + "</body></HTML>");
        
        JLabel placendate = new JLabel("<HTML><body>" +artGalleryList.Info().get(i).getPlace() + "<br>" 
        + formattedDateStart + " ~ " + formattedDateEnd +"</body></HTML>");
        
		JLabel story = new JLabel("<HTML><body>" +
						"관람시간 : " + artGalleryList.Info().get(i).getTime() + "<br>" + 
						"입장료 : " + artGalleryList.Info().get(i).getFee() + "<br>" + 
						"주소 : " + artGalleryList.Info().get(i).getPlace() + "</body></HTML>");
		
		// "예약" 버튼 생성
		ImageIcon originalIcon = new ImageIcon("./src/예매.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon reservebtn = new ImageIcon(scaledImage);
        JButton reservebtn1 = new JButton(reservebtn);
        
        reservebtn1.setBounds(300, 470, 50, 30);
        reservebtn1.setBorderPainted(false); // 버튼 외각선 지우기
        reservebtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        reservebtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
        add(reservebtn1);
        
     
        
		title.setSize(400,30);
		title.setLocation(30, 380);
		title.setBackground(new Color(255, 255, 255));
		title.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));
		
		placendate.setSize(400,60);
		placendate.setLocation(30, 430);
		placendate.setBackground(new Color(255, 255, 255));
		placendate.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		
		story.setSize(400, 70);
		story.setLocation(30, 520);
		story.setBackground(new Color(255, 255, 255));
		story.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));
		
		// 구분선 추가
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(20, 415, 360, 10); // 구분선의 위치와 크기 조정
		separator1.setForeground(Color.BLACK); 
		add(separator1);
		
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(20, 510, 360, 10); // 구분선의 위치와 크기 조정
		separator2.setForeground(Color.BLACK); 
		add(separator2);
		
		
		add(title);
		add(placendate);
		add(story);
		
		// "길찾기" 버튼 생성
 		ImageIcon originalIcon1 = new ImageIcon("./src/길찾기.png");
         Image originalImage1 = originalIcon1.getImage();
         Image scaledImage1 = originalImage1.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
         ImageIcon mapgobtn = new ImageIcon(scaledImage1);
         JButton mapgobtn1 = new JButton(mapgobtn);
         
         mapgobtn1.setBounds(300, 550, 50, 30);
         mapgobtn1.setBorderPainted(false); // 버튼 외각선 지우기
         mapgobtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
         mapgobtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
         add(mapgobtn1);
		
		
		mapgobtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
		            // 크롬 브라우저 열기
					String URL = artGalleryList.Info().get(i).getPlaceURL();
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
				System.out.println(artGalleryList.Info().get(i).getArtName()+" : 예매 버튼 클릭");
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
