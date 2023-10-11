package frame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import model.member.ArtReserInfoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.List;
import java.io.File;

public class Home extends JPanel {
	
	private JPanel posterPanel;
	private JPanel homePanel;
    private JPanel ListPanel;
    private JPanel filterMenuFrame;
    
    String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로
    
    JToggleButton recent_btn;
    JToggleButton popula_btn;
    JToggleButton free_btn;
    JToggleButton soonEnd_btn;
    ButtonGroup buttonGroup;
	
    private JLabel imageLabel;
    //private Timer imageTimer;
    ImageIcon icon;
    private JPanel listPanel;
    public Home() {
    	// JPanel 구조 설정
    	this.homePanel = homePanel;
    	
        setBackground(Color.white);
        setLayout(new BorderLayout());
        setSize(400, 700);
        
        //예매 추가하기
        ArtReserInfoList a = new ArtReserInfoList();
        //a.show();
         //reserInfoList =a.getArtReserInfoList();
         /*
          * 확인용
         for( ArtReserInfo reser : reserInfoList)
 		{
         	System.out.println(reser.toString());
 		}*/
           
     // 이미지
        
      
     // 이미지
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        ImageIcon menuLine = new ImageIcon("./src/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선

        btnSearch.setSize(50, 50);
        btnSearch.setLocation(310, 40);
        btnSearch.setBorderPainted(false); // 버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); // 버튼 선택 표시 지우기
        
        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());

        int btnsHeight = menuline.getY() + menuline.getHeight() + 10;

        // 필터 버튼 (인기, 최신, 무료, 곧 종료) 추가
        ImageIcon originalIcon1 = new ImageIcon("./src/인기버튼2.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon one = new ImageIcon(scaledImage1);
        JButton one1 = new JButton(one);
        one1.setBounds(30, btnsHeight, 60, 30);
        one1.setContentAreaFilled(false);
        one1.setBorderPainted(false);
        add(one1);
        
        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());
        add(menuline);
        
        // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon1 = new ImageIcon("./src/인기버튼.png");
        Image scaledHoverImage1 = hoverIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        one1.setRolloverIcon(new ImageIcon(scaledHoverImage1));

        ImageIcon originalIcon2 = new ImageIcon("./src/최신버튼2.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon two = new ImageIcon(scaledImage2);
        JButton two2 = new JButton(two);
        two2.setBounds(one1.getX() + one1.getWidth() + 5, btnsHeight, 60, 30);
        two2.setContentAreaFilled(false);
        two2.setBorderPainted(false);
        add(two2);
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon2 = new ImageIcon("./src/최신버튼.png");
        Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        two2.setRolloverIcon(new ImageIcon(scaledHoverImage2));

        ImageIcon originalIcon3 = new ImageIcon("./src/무료버튼2.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon three = new ImageIcon(scaledImage3);
        JButton three3 = new JButton(three);
        three3.setBounds(two2.getX() + two2.getWidth() + 5, btnsHeight, 60, 30);
        three3.setContentAreaFilled(false);
        three3.setBorderPainted(false);
        add(three3);
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon3 = new ImageIcon("./src/무료버튼.png");
        Image scaledHoverImage3 = hoverIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        three3.setRolloverIcon(new ImageIcon(scaledHoverImage3));

        ImageIcon originalIcon4 = new ImageIcon("./src/곧종료버튼2.png");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon four = new ImageIcon(scaledImage4);
        JButton four4 = new JButton(four);
        four4.setBounds(three3.getX() + three3.getWidth() + 5, btnsHeight, 80, 30);
        four4.setContentAreaFilled(false);
        four4.setBorderPainted(false);
        add(four4);
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon4 = new ImageIcon("./src/곧종료버튼.png");
        Image scaledHoverImage4 = hoverIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        four4.setRolloverIcon(new ImageIcon(scaledHoverImage4));
       
        
        listPanel = new ListPanel(""); // 리스트 보이게될 listPanel
    	add(listPanel);
    	// 필터 버튼 one1~four4
    	 one1.addActionListener(new ActionListener() {	
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                 if (window1 != null) {
                     window1.dispose(); 
                 }
 				FrameBase.getInstance(new FrameHomePopularClick());
 			}
 		});
         
         two2.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                 if (window1 != null) {
                     window1.dispose(); 
                 }
 				FrameBase.getInstance(new FrameHomeRecentClick());
 				
 			}
 		});
         
         three3.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                 if (window1 != null) {
                     window1.dispose(); 
                 }
 				FrameBase.getInstance(new FrameHomeFreeClick());
 			}
 		});
         
         four4.addActionListener(new ActionListener() {
 			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				
 				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                 if (window1 != null) {
                     window1.dispose(); 
                 }
 				FrameBase.getInstance(new FrameHomeSoonEndClick());
 				
 				
 			}    	
		
        });
        
         // 컴포넌트 추가
         add(btnSearch);
         add(menuline);
         
         // 검색 버튼 누르면
         btnSearch.addActionListener(new ActionListener() {

             @Override
             public void actionPerformed(ActionEvent e) {
                 Window window1 = SwingUtilities.windowForComponent((Component) e.getSource()); // 현재 창 닫기
                 if (window1 != null) {
                     window1.dispose();
                 }
                 // 검색 창으로 이동
                 FrameBase.getInstance(new FrameSearch_1());
             }
         });
         
         
         
         try {
             // TTF 파일을 읽어서 Font 객체 생성
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));
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
     				FrameBase.getInstance(new FrameBegin());
     				
     			}
     		});
             } catch (IOException | FontFormatException e) {
                 e.printStackTrace();
             
             }
    }
}