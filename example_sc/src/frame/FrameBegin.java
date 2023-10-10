package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryList;

import view.login.FrameJoin;
import view.login.FrameLogin;

public class FrameBegin extends JPanel {
	
	private JPanel posterPanel;
   
    ImageIcon icon;
    public FrameBegin() {
    	this(null);
    }

    
    public FrameBegin(JPanel homePanel) {
        // ArtGalleryList와 PopupList 객체 생성
        ArtGalleryList artgallerylist = new ArtGalleryList();
        
        posterPanel = new JPanel();
	    posterPanel.setLayout(null);
	    posterPanel.setSize(363,70);
	    posterPanel.setLocation(20, 610);
	    posterPanel.setVisible(true);
	    add(posterPanel);
        
        // JPanel 구조 설정
        //setBackground(Color.white);
        
        setLayout(null);
        setSize(400, 700);
        setVisible(true);
        
        
        // 로고 이미지
        ImageIcon logoImage = new ImageIcon("./src/LOGO.jpg");
        JLabel logoLabel = new JLabel(logoImage);
        logoLabel.setSize(300, 300); 
        logoLabel.setLocation(45, 100); 
        
        add(logoLabel);
        
        // 로그인 버튼
        ImageIcon originalLoginIcon = new ImageIcon("./src/로그인.png");
        Image scaledLoginImage = originalLoginIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon loginIcon = new ImageIcon(scaledLoginImage);
        JButton btnLogin = new JButton(loginIcon);

        // 회원가입 버튼
        ImageIcon originalJoinIcon = new ImageIcon("./src/회원가입.png");
        Image scaledJoinImage = originalJoinIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon joinIcon = new ImageIcon(scaledJoinImage);
        JButton btnJoin = new JButton(joinIcon);
        
        
        // 회원가입 버튼 이미지와 리스너 설정
        ImageIcon originalJoinHoverIcon = new ImageIcon("./src/회원가입hover.png");
        Image scaledJoinHoverImage = originalJoinHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon joinHoverIcon = new ImageIcon(scaledJoinHoverImage);

        btnJoin.setSize(140, 40);
        btnJoin.setLocation(135, 540);
        btnJoin.setContentAreaFilled(false);
        btnJoin.setBorderPainted(false);
        btnJoin.setFocusPainted(false);

        // 회원가입 버튼에 마우스 리스너 추가
        btnJoin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnJoin.setIcon(joinHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnJoin.setIcon(joinIcon); // 마우스를 떼면 원래 이미지로 변경
            }
        });

        // 로그인 버튼 이미지와 리스너 설정
        ImageIcon originalLoginHoverIcon = new ImageIcon("./src/로그인hover.png");
        Image scaledLoginHoverImage = originalLoginHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon loginHoverIcon = new ImageIcon(scaledLoginHoverImage);

        btnLogin.setSize(140, 40);
        btnLogin.setLocation(135, 470);
        btnLogin.setContentAreaFilled(false);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);

        // 로그인 버튼에 마우스 리스너 추가
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnLogin.setIcon(loginHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnLogin.setIcon(loginIcon); // 마우스를 떼면 원래 이미지로 변경
            }
        });
		
		
		add(btnLogin);
		add(btnJoin);
		
		
		
		//로그인 버튼 
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new FrameLogin());

			}
		});

		// 회원가입 버튼
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new FrameJoin());
			}
		});
}
}
