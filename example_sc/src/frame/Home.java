
package frame;


import javax.swing.*;
import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Home extends JPanel {
	
	private JPanel posterPanel;
	private JPanel homePanel;
    private JPanel listPanel;
    private JPanel filterMenuFrame;
    
    JToggleButton recent_btn;
    JToggleButton popula_btn;
    JToggleButton free_btn;
    JToggleButton soonEnd_btn;
    
    
    public Home() {

        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
     
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
        
        add(btnSearch);
        add(menuline);
        
        
        baseButton(); //버튼 
        
        listPanel = new ListPanel("무료"); // 리스트 보이게될 jpanel
        
    	add(listPanel);
		recent_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/인기.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);
            
    				// 최신필터 페이지 이동
                     // a 패널에서 기존 ListPanel을 제거
                     remove(listPanel);
                     listPanel = new ListPanel("다른");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//두번눌렀을때(비활성화)..
                	ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                     recent_btn.setIcon(two);
                }				
			}
        });

        popula_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/인기.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);
            
    				// 최신필터 페이지 이동
                     // a 패널에서 기존 ListPanel을 제거
                     remove(listPanel);
                     listPanel = new ListPanel("다른");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//두번눌렀을때(비활성화)..
                	ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                     recent_btn.setIcon(two);
                }				
			}
        });
        
        
        
        free_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/인기.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);
            
    				// 최신필터 페이지 이동
                     // a 패널에서 기존 ListPanel을 제거
                     remove(listPanel);
                     listPanel = new ListPanel("무료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//두번눌렀을때(비활성화)..
                	ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                     recent_btn.setIcon(two);
                }				
			}
        });
        
        soonEnd_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/인기.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);
            
    				// 최신필터 페이지 이동
                     // a 패널에서 기존 ListPanel을 제거
                     remove(listPanel);
                     listPanel = new ListPanel("곧종료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//두번눌렀을때(비활성화)..
                	ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                     recent_btn.setIcon(two);
                }				
			}
        });
        
        
    	
    	
    	
    	
    
   
    }
  
    
    public void baseButton() { // 버튼 init
    	
    	int btnsHeight = 105;
    	ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        
        
        ImageIcon two = new ImageIcon(scaledImage2);
         recent_btn  = new JToggleButton(two);
        recent_btn .setBounds(30, btnsHeight, 60, 30);
        recent_btn .setContentAreaFilled(false);
        recent_btn .setBorderPainted(false);
        add(recent_btn);
        
        ImageIcon originalIcon1 = new ImageIcon("./src/인기.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon one = new ImageIcon(scaledImage1);
         popula_btn  = new JToggleButton(one);
        popula_btn .setBounds(recent_btn.getX() + recent_btn.getWidth() + 5, btnsHeight, 60, 30);
        popula_btn .setContentAreaFilled(false);
        popula_btn .setBorderPainted(false);
        add(popula_btn );


        ImageIcon originalIcon3 = new ImageIcon("./src/무료.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon three = new ImageIcon(scaledImage3);
         free_btn  = new JToggleButton(three);
        free_btn .setBounds(popula_btn.getX() + popula_btn.getWidth() + 5, btnsHeight, 60, 30);
        free_btn .setContentAreaFilled(false);
        free_btn .setBorderPainted(false);
        add(free_btn );

        ImageIcon originalIcon4 = new ImageIcon("./src/곧종료.png");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon four = new ImageIcon(scaledImage4);
         soonEnd_btn = new JToggleButton(four);
        soonEnd_btn.setBounds(free_btn.getX() + free_btn.getWidth() + 5, btnsHeight, 80, 30);
        soonEnd_btn.setContentAreaFilled(false);
        soonEnd_btn.setBorderPainted(false);
        add(soonEnd_btn);
    }


}

