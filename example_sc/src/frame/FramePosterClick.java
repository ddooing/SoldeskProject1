package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.io.File;

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
	
	String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로
	
	public FramePosterClick() {
		this(null,null);
	}
	
	public FramePosterClick(ActionEvent e, String artname) {
		
		ArtGalleryList artgallerylist = new ArtGalleryList();
        posterInfoList = artgallerylist.Info();
    	
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
		ImageIcon originalIcon9 = new ImageIcon(posterInfoList.get(i).getImageURL());
        Image originalImage9 = originalIcon9.getImage();
        Image scaledImage9 = originalImage9.getScaledInstance(364, 300, Image.SCALE_SMOOTH);
        ImageIcon posterImage1 = new ImageIcon(scaledImage9);
        
		JLabel fImage=new JLabel(posterImage1);
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
		// 폰트 적용을 위해 한줄한줄씩 다 고쳐야 됌 
        
        JLabel title = new JLabel(artGalleryList.Info().get(i).getArtName());
        
        JLabel place = new JLabel(artGalleryList.Info().get(i).getPlace());
        
        JLabel date = new JLabel(formattedDateStart + " ~ " + formattedDateEnd);
        
		JLabel time = new JLabel("관람시간 : " + artGalleryList.Info().get(i).getTime());
		
		JLabel fee = new JLabel("입장료 : " + artGalleryList.Info().get(i).getFee());
		
		JLabel address = new JLabel("주소 : " + artGalleryList.Info().get(i).getPlace());
		
		
		// "예약" 버튼 생성
		ImageIcon originalIcon = new ImageIcon("./src/예매.png");
        Image originalImage = originalIcon.getImage();
        Image scaledImage = originalImage.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon reservebtn = new ImageIcon(scaledImage);
        JButton reservebtn1 = new JButton(reservebtn);
        
        reservebtn1.setBounds(300, 470, 60, 30);
        reservebtn1.setBorderPainted(false); // 버튼 외각선 지우기
        reservebtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        reservebtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
        add(reservebtn1);
        
        try {
            // TTF 파일을 읽어서 Font 객체 생성
            Font baseFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));

            // 원하는 폰트 스타일과 크기로 설정
            
            Font customFontTitle = baseFont.deriveFont(Font.BOLD, 25);
            Font customFontPlacendate = baseFont.deriveFont(Font.BOLD, 18);
            Font customFontStory = baseFont.deriveFont(Font.BOLD, 16);
        
		title.setSize(400,30);
		title.setLocation(30, 380);
		title.setBackground(new Color(255, 255, 255));
		title.setFont(customFontTitle);
		
		place.setSize(400,30);
		place.setLocation(30, 430);
		place.setBackground(new Color(255, 255, 255));
		place.setFont(customFontPlacendate);
		
		date.setSize(400,30);
		date.setLocation(30, 460);
		date.setBackground(new Color(255, 255, 255));
		date.setFont(customFontPlacendate);
		
		time.setSize(400, 23);
		time.setLocation(30, 520);
		time.setBackground(new Color(255, 255, 255));
		time.setFont(customFontStory);
		
		fee.setSize(400, 23);
		fee.setLocation(30, 543);
		fee.setBackground(new Color(255, 255, 255));
		fee.setFont(customFontStory);
		
		address.setSize(400, 23);
		address.setLocation(30, 566);
		address.setBackground(new Color(255, 255, 255));
		address.setFont(customFontStory);
		
		} catch (IOException | FontFormatException e) {
		    e.printStackTrace();
		}
		
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
		add(place);
		add(date);
		add(time);
		add(fee);
		add(address);
		
		// "길찾기" 버튼 생성
 		ImageIcon originalIcon1 = new ImageIcon("./src/길찾기.png");
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
         ImageIcon hoverIcon1 = new ImageIcon("./src/예매hover.png");
         Image scaledHoverImage1 = hoverIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
         reservebtn1.setRolloverIcon(new ImageIcon(scaledHoverImage1));
  
         // 호버 시에 표시할 이미지 설정
         ImageIcon hoverIcon2 = new ImageIcon("./src/길찾기hover.png");
         Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH);
         mapgobtn1.setRolloverIcon(new ImageIcon(scaledHoverImage2));
		
		
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
