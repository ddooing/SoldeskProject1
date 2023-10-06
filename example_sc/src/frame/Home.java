package frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel {

    private JLabel imageLabel;
    //private Timer imageTimer;
    ImageIcon icon;

    public Home() {
    	
		
    	// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        // 이미지 
        	// 검색 아이콘
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        	//선
        ImageIcon menuLine =new ImageIcon("./src/line3.png");
        
        	// 필터 4개 
        ImageIcon one= new ImageIcon("./src/popula.png");
        ImageIcon two = new ImageIcon("./src/recent.png");
        ImageIcon three= new ImageIcon("./src/free.png");
        ImageIcon four = new ImageIcon("./src/soonEnd.png");
        
        
        
       // JButton btnGal = new JButton("전시회");
        //JButton btnPop = new JButton("팝업스토어");
        JButton btnSearch = new JButton(imageSearch);// 검색 버튼
        JLabel menuline = new JLabel(menuLine);// 메뉴선
        
        JButton popula_btn = new JButton(one);//인기 필터
        JButton recent_btn = new JButton(two);// 최신 필터
        JButton free_btn = new JButton(three);// 무료 필터
        JButton soonEnd_btn = new JButton(four);// 곧 종료 필터 
        
        /*
        JButton btnEnd = new JButton("");
        JButton btnBack = new JButton("");
        JButton btnHome = new JButton("");
        JButton btnTicket = new JButton("");
        JButton btnSoon = new JButton("");
        
        
        btnGal.setSize(200, 50);
        btnGal.setLocation(50, 25);
        btnGal.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
        btnGal.setContentAreaFilled(false);
        btnGal.setBorderPainted(false);
        

        btnPop.setSize(200, 50);
        btnPop.setLocation(100, 25);
        btnPop.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
        btnPop.setContentAreaFilled(false);
        btnPop.setBorderPainted(false);
        
        */
        // 검색 아이콘
        btnSearch.setSize(50,50);
        btnSearch.setLocation(310, 40);
        btnSearch.setBorderPainted(false); //버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); //버튼 선택표시 지우기
        
        // 선 
        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());
        //add(btnGal);
        //add(btnPop);
        
        int btnsHeight = menuline.getY() + menuline.getHeight()+2;
        
        popula_btn.setSize(31, 16); 
        popula_btn.setLocation(30,btnsHeight);
        popula_btn.setBorderPainted(false); //버튼 외각선 지우기
        popula_btn.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        popula_btn.setFocusPainted(false);
        
        recent_btn.setSize(31, 16); 
        recent_btn.setLocation(popula_btn.getX() + popula_btn.getWidth()+5,btnsHeight);
        recent_btn.setBorderPainted(false); //버튼 외각선 지우기
        recent_btn.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        recent_btn.setFocusPainted(false);
        
        free_btn.setSize(31, 16); 
        free_btn.setLocation(recent_btn.getX() + recent_btn.getWidth()+5, btnsHeight);
        free_btn.setBorderPainted(false); //버튼 외각선 지우기
        free_btn.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        free_btn.setFocusPainted(false);
        
        soonEnd_btn.setSize(37, 16); 
        soonEnd_btn.setLocation(free_btn.getX() + free_btn.getWidth()+5,btnsHeight);
        soonEnd_btn.setBorderPainted(false); //버튼 외각선 지우기
        soonEnd_btn.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        soonEnd_btn.setFocusPainted(false);
        
        
        //필터 버튼 add 
        add(btnSearch);
        add(menuline);
        add(popula_btn);
        add(recent_btn);
        add(free_btn);
        add(soonEnd_btn);
        
        
        
        /*
        btnEnd.setBorderPainted(false);
        btnEnd.setContentAreaFilled(false);
        btnEnd.setFocusPainted(false);

        btnBack.setBorderPainted(false);
        btnBack.setContentAreaFilled(false);
        btnBack.setFocusPainted(false);

        btnHome.setBorderPainted(false);
        btnHome.setContentAreaFilled(false);
        btnHome.setFocusPainted(false);

        btnTicket.setBorderPainted(false);
        btnTicket.setContentAreaFilled(false);
        btnTicket.setFocusPainted(false);

        btnSoon.setBorderPainted(false);
        btnSoon.setContentAreaFilled(false);
        btnSoon.setFocusPainted(false);
		
        int buttonWidth = 83;
        int buttonSpacing = 10;
        int yOffset = (int) getLocation().getY() / 2 + 630;
        int totalWidth = 5 * (buttonWidth + buttonSpacing) - buttonSpacing;

        btnEnd.setSize(83, 50);
        btnBack.setSize(83, 50);
        btnHome.setSize(83, 50);
        btnTicket.setSize(83, 50);
        btnSoon.setSize(83, 50);

        btnEnd.setLocation((getWidth() - totalWidth) / 2, yOffset);
        btnBack.setLocation((getWidth() - totalWidth) / 2 + buttonWidth + buttonSpacing, yOffset);
        btnHome.setLocation((getWidth() - totalWidth) / 2 + 2 * (buttonWidth + buttonSpacing), yOffset);
        btnTicket.setLocation((getWidth() - totalWidth) / 2 + 3 * (buttonWidth + buttonSpacing), yOffset);
        btnSoon.setLocation((getWidth() - totalWidth) / 2 + 4 * (buttonWidth + buttonSpacing), yOffset);
        */
        
        /*
     // 이미지 레이블 생성
        imageLabel = new JLabel();
        imageLabel.setBounds(40, btnGal.getY() + btnGal.getHeight() + 10, 400, 400); // 위치를 버튼 아래로 조절
        add(imageLabel);
        
        add(btnEnd);
        add(btnBack);
        add(btnHome);
        add(btnTicket);
        add(btnSoon);

        btnGal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        btnPop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        */
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 검색 아이콘 클릭시 화면 바뀌는것 입력
			}
		});

        /*
        btnEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
            }
        });

        btnHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrameBase.getDispose();
                FrameBase.getInstance(new Home());
            }
        });

        btnTicket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });

        btnSoon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        */

        
    }


}
