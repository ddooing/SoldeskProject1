
package frame.home;


import javax.swing.*;
import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import controller.member.MemberToken;
import frame.base.FrameBase;
import frame.underbtn.FrameSearch_1;
import view.login.FrameLogin;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import model.member.*;

public class Home extends JPanel {
	
	private JPanel posterPanel;
	private JPanel homePanel;
    private JPanel listPanel;
    private JPanel filterMenuFrame;
    private String setFilter;
    
    JToggleButton recent_btn;
    JToggleButton popula_btn;
    JToggleButton free_btn;
    JToggleButton soonEnd_btn;
    ButtonGroup buttonGroup;
    
    List<ArtReserInfo> reserInfoList;
    
    public Home(String filter) {
    	setFilter=filter;
    	
        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);

      //예매 추가하기

        ArtReserInfoList a = new ArtReserInfoList();
         reserInfoList =a.getArtReserInfoList();

           
     // 이미지
        ImageIcon imageSearch = new ImageIcon("./src/img/30.png");
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

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
        
        
        baseButton(); //버튼 생성
        buttonSetting(); //버튼 세팅 
        
        listPanel = new ListPanel(filter); // 리스트 보이게될 listPanel
        
    	add(listPanel);

    	btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//새로운 FrameBase창 생성
				FrameBase.getInstance(new FrameSearch_1());
				dispose();
			}
		});
		recent_btn.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {// 한번 눌렀을때(활성화)
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/img/최신버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    recent_btn.setIcon(two);

                     remove(listPanel);
                     listPanel = new ListPanel("최신");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/img/최신버튼2.png");
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
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/img/인기버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    popula_btn.setIcon(two);
                    
            
                     remove(listPanel);
                     listPanel = new ListPanel("인기");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/img/인기버튼2.png");
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
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/img/무료버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    free_btn.setIcon(two);
                    
            

                     remove(listPanel);
                     listPanel = new ListPanel("무료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/img/무료버튼2.png");
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
                	
					ImageIcon originalIcon2 = new ImageIcon("./src/img/곧종료버튼.png");
                    Image scaledImage2 = originalIcon2.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
                    ImageIcon two = new ImageIcon(scaledImage2);
                    soonEnd_btn.setIcon(two);
                    
					
                     remove(listPanel);
                     listPanel = new ListPanel("곧종료");
                     add(listPanel);
                     revalidate();
                     repaint();
    				
                } else {//비활성화 버튼
                	ImageIcon originalIcon2 = new ImageIcon("./src/img/곧종료버튼2.png");
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
    	ImageIcon originalIcon2 = new ImageIcon("./src/img/최신버튼2.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon two = new ImageIcon(scaledImage2);
         recent_btn  = new JToggleButton(two);
        recent_btn .setBounds(30, btnsHeight, 60, 30);
        recent_btn .setContentAreaFilled(false);
        recent_btn .setBorderPainted(false);
        buttonGroup.add(recent_btn);
        add(recent_btn);
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon2 = new ImageIcon("./src/img/최신버튼.png");
        Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        recent_btn.setRolloverIcon(new ImageIcon(scaledHoverImage2));
        
        ImageIcon originalIcon1 = new ImageIcon("./src/img/인기버튼2.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon one = new ImageIcon(scaledImage1);
        popula_btn  = new JToggleButton(one);
        popula_btn .setBounds(recent_btn.getX() + recent_btn.getWidth() + 5, btnsHeight, 60, 30);
        popula_btn .setContentAreaFilled(false);
        popula_btn .setBorderPainted(false);
        buttonGroup.add(popula_btn );
        add(popula_btn );

     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon1 = new ImageIcon("./src/img/인기버튼.png");
        Image scaledHoverImage1 = hoverIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        popula_btn.setRolloverIcon(new ImageIcon(scaledHoverImage1));

        ImageIcon originalIcon3 = new ImageIcon("./src/img/무료버튼2.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon three = new ImageIcon(scaledImage3);
         free_btn  = new JToggleButton(three);
        free_btn .setBounds(popula_btn.getX() + popula_btn.getWidth() + 5, btnsHeight, 60, 30);
        free_btn .setContentAreaFilled(false);
        free_btn .setBorderPainted(false);
        buttonGroup.add(free_btn );
        add(free_btn );
        
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon3 = new ImageIcon("./src/img/무료버튼.png");
        Image scaledHoverImage3 = hoverIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        free_btn.setRolloverIcon(new ImageIcon(scaledHoverImage3));

        ImageIcon originalIcon4 = new ImageIcon("./src/img/곧종료버튼2.png");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon four = new ImageIcon(scaledImage4);
        soonEnd_btn  = new JToggleButton(four);
        soonEnd_btn.setBounds(free_btn.getX() + free_btn.getWidth() + 5, btnsHeight, 80, 30);
        soonEnd_btn.setContentAreaFilled(false);
        soonEnd_btn.setBorderPainted(false);
        buttonGroup.add(soonEnd_btn);
        add(soonEnd_btn);
     
     // 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon4 = new ImageIcon("./src/img/곧종료버튼.png");
        Image scaledHoverImage4 = hoverIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        soonEnd_btn.setRolloverIcon(new ImageIcon(scaledHoverImage4));
    }

    public void buttonSetting() {
    	if(setFilter.equals("최신"))
    	{
    		recent_btn.setSelected(true);
    		ImageIcon originalIcon2 = new ImageIcon("./src/img/최신버튼.png");
            Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
            ImageIcon two = new ImageIcon(scaledImage2);
            recent_btn.setIcon(two);
    	}else if(setFilter.equals("인기"))
    	{
    		popula_btn.setSelected(true);
    		ImageIcon originalIcon2 = new ImageIcon("./src/img/인기버튼.png");
            Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
            ImageIcon two = new ImageIcon(scaledImage2);
            popula_btn.setIcon(two);
    		
    	}else if(setFilter.equals("무료"))
    	{
    		free_btn.setSelected(true);
    		ImageIcon originalIcon2 = new ImageIcon("./src/img/무료버튼.png");
            Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
            ImageIcon two = new ImageIcon(scaledImage2);
            free_btn.setIcon(two);
    	}else if(setFilter.equals("곧종료"))
    	{
    		soonEnd_btn.setSelected(true);
    		ImageIcon originalIcon2 = new ImageIcon("./src/img/곧종료버튼.png");
            Image scaledImage2 = originalIcon2.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
            ImageIcon two = new ImageIcon(scaledImage2);
            soonEnd_btn.setIcon(two);
    	}
    }
    public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}

}

