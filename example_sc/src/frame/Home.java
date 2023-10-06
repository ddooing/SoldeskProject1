package frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Home extends JPanel {
	/*
    private int currentImageIndex = 0;
    
    private String[] imagePaths = {
            "./src/Between StarShine and Clay.jpg",
            "./src/디올 성수.jpg",
            "./src/라인프렌즈.jpg",
            "./src/쿨라링.jpg"
    };
	*/
    private JLabel imageLabel;
    private Timer imageTimer;
    ImageIcon icon;

    public Home() {
    	
		
        setSize(400, 700);
        setVisible(true);
        
        
        ImageIcon imageSearch = new ImageIcon("./src/searchicon.png");

        JButton btnGal = new JButton("전시회");
        JButton btnPop = new JButton("팝업스토어");
        JButton btnSearch = new JButton(imageSearch);

        JButton btnEnd = new JButton("");
        JButton btnBack = new JButton("");
        JButton btnHome = new JButton("");
        JButton btnTicket = new JButton("");
        JButton btnSoon = new JButton("");
        
        
        btnGal.setSize(200, 50);
        btnGal.setLocation(-30, 25);
        btnGal.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
        btnGal.setContentAreaFilled(false);
        btnGal.setBorderPainted(false);
        

        btnPop.setSize(200, 50);
        btnPop.setLocation(100, 25);
        btnPop.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
        btnPop.setContentAreaFilled(false);
        btnPop.setBorderPainted(false);
        
        
        btnSearch.setSize(40,40);
        btnSearch.setLocation(btnPop.getX() + btnPop.getWidth()+10, 30);
        btnSearch.setBorderPainted(false); //버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); //버튼 선택표시 지우기
         
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

        add(btnGal);
        add(btnPop);
        add(btnSearch);
        
     // 이미지 레이블 생성
        imageLabel = new JLabel();
        imageLabel.setBounds(40, btnGal.getY() + btnGal.getHeight() + 10, 400, 400); // 위치를 버튼 아래로 조절
        add(imageLabel);
        /*
        // 이미지 레이블 초기화
        updateImage();

        // 이미지 변경 타이머 생성
        imageTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentImageIndex = (currentImageIndex + 1) % imagePaths.length;
                updateImage();
            }
        });
*/
        // 타이머 시작
        imageTimer.start();
        
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
        
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 검색 아이콘 클릭시 화면 바뀌는것 입력
			}
		});

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

        
    }
    /*
    private void updateImage() {
        if (currentImageIndex >= 0 && currentImageIndex < imagePaths.length) {
            ImageIcon imageIcon = new ImageIcon(imagePaths[currentImageIndex]);
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT)); // 이미지 크기 조절
            imageLabel.setIcon(imageIcon);
            
        }
    }*/

}
