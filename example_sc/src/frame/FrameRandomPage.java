package frame;



import java.awt.Color;
import java.io.File;
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
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryList;


public class FrameRandomPage extends JPanel {

	JPanel framehomePanel;
	private int ad;
	String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로
	
	public FrameRandomPage() {
		this(null);	//생성자 매개변수 없이 호출하면 밑에 있는 생성자 매개변수 있는 것으로 실행되는 코드
	}
	
	public FrameRandomPage(JPanel homePanel) {
		ArtGalleryList artgallerylist = new ArtGalleryList();
    	
        setSize(400, 700);
        setLayout(null);
        
        setVisible(true);
        
        JLabel titleLabel = new JLabel("랜덤 전시 추천");
        try {
            // TTF 파일을 읽어서 Font 객체 생성
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));

            // 원하는 폰트 스타일과 크기로 설정
            customFont = customFont.deriveFont(Font.BOLD, 24); // 크기 24, 평범한 스타일로 설정
            
        titleLabel.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
        }
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setBounds(120, 30, 300, 50);
        add(titleLabel);
        
      
        
        while(true) {
			int i=new Random().nextInt(artgallerylist.Info().size()-4);
			ad=i;
			
				makeArtInfo(artgallerylist, i);
				break;
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
		
		title.setSize(400,30);
		title.setLocation(30, 380);
		title.setBackground(new Color(255, 255, 255));
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
