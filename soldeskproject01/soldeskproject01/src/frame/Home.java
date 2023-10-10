package frame;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import model.member.ArtReserInfoList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

public class Home extends JPanel {
	private JPanel posterPanel;
	private JPanel homePanel;
    private JPanel ListPanel;
    private JPanel filterMenuFrame;
    
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
        
      
        // 검색아이콘
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        JButton btnSearch = new JButton(imageSearch);// 검색 버튼
        
        btnSearch.setSize(50, 50);
        btnSearch.setLocation(310, 20);
        btnSearch.setBorderPainted(false); // 버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); // 버튼 선택 표시 지우기 
        add(btnSearch);
        
        // 필터 4개 
        ImageIcon one= new ImageIcon("./src/버튼예.jpg");
        ImageIcon two = new ImageIcon("./src/ㅇ.png");
        ImageIcon three= new ImageIcon("./src/ㅇ.png");
        ImageIcon four = new ImageIcon("./src/ㅇ.png");
        
        
        JButton popula_btn = new JButton("인기");//인기 필터
        JButton recent_btn = new JButton("최신");// 최신 필터
        JButton free_btn = new JButton("무료");// 무료 필터
        JButton soonEnd_btn = new JButton("곧종료");// 곧 종료 필터 
        
        
        ImageIcon menuLine =new ImageIcon("./src/line3.png");
        JLabel menuline = new JLabel(menuLine);// 메뉴선
        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());
        add(menuline);
        
        
        baseButton(); 
        
        listPanel = new ListPanel(""); // 리스트 보이게될 listPanel
    	add(listPanel);
    	
    	btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				remove(btnSearch);
				remove(menuline);
				//removeAll();
				remove(listPanel);
				remove(recent_btn);
				remove (popula_btn);
				remove (free_btn);
				remove (soonEnd_btn);
				add(new SearchPanel());
				revalidate();
				repaint();

			}
		});
    	
		recent_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/최신버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);
            
                     remove(listPanel);
                     listPanel = new ListPanel("최신");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/최신버튼2.png");
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
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/인기버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    popula_btn.setIcon(two);
            
                     remove(listPanel);
                     listPanel = new ListPanel("인기");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/인기버튼2.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    popula_btn.setIcon(two);
                }				
			}
        });
    	
    	
		free_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/무료버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    free_btn.setIcon(two);
            
                    remove(listPanel);
                     listPanel = new ListPanel("무료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/무료버튼2.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    free_btn.setIcon(two);
                }				
			}
        });
		
		soonEnd_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/곧종료버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    soonEnd_btn.setIcon(two);
					
                     remove(listPanel);
                     listPanel = new ListPanel("곧종료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/곧종료버튼2.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    soonEnd_btn.setIcon(two);
                }				
			}
        });
    }
    
    public void baseButton() { // 버튼 init
    	
    	buttonGroup = new ButtonGroup();
    	
    	int btnsHeight = 100;
    	ImageIcon originalIcon2 = new ImageIcon("./src/최신버튼2.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon two = new ImageIcon(scaledImage2);
        recent_btn  = new JToggleButton(two);
        recent_btn .setBounds(30, btnsHeight, 60, 30);
        recent_btn .setContentAreaFilled(false);
        recent_btn .setBorderPainted(false);
        buttonGroup.add(recent_btn);
        add(recent_btn);
        
        ImageIcon originalIcon1 = new ImageIcon("./src/인기버튼2.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon one = new ImageIcon(scaledImage1);
        popula_btn  = new JToggleButton(one);
        popula_btn .setBounds(recent_btn.getX() + recent_btn.getWidth() + 5, btnsHeight, 60, 30);
        popula_btn .setContentAreaFilled(false);
        popula_btn .setBorderPainted(false);
        buttonGroup.add(popula_btn );
        add(popula_btn );


        ImageIcon originalIcon3 = new ImageIcon("./src/무료버튼2.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon three = new ImageIcon(scaledImage3);
        free_btn  = new JToggleButton(three);
        free_btn .setBounds(popula_btn.getX() + popula_btn.getWidth() + 5, btnsHeight, 60, 30);
        free_btn .setContentAreaFilled(false);
        free_btn .setBorderPainted(false);
        buttonGroup.add(free_btn );
        add(free_btn );

        ImageIcon originalIcon4 = new ImageIcon("./src/곧종료버튼2.png");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon four = new ImageIcon(scaledImage4);
        soonEnd_btn  = new JToggleButton(four);
        soonEnd_btn.setBounds(free_btn.getX() + free_btn.getWidth() + 5, btnsHeight, 80, 30);
        soonEnd_btn.setContentAreaFilled(false);
        soonEnd_btn.setBorderPainted(false);
        buttonGroup.add(soonEnd_btn);
        add(soonEnd_btn);
     
    }
}