package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import artDB.ArtGalleryList;
import popupDB.PopupList;
import view.login.FrameJoin;
import view.login.FrameLogin;

public class FrameBegin extends JPanel {
    private ImageIcon[] imageArray;
    private JLabel imageLabel;
    private JLabel recommendationtext;
    ImageIcon icon;

    public FrameBegin() {
        // ArtGalleryList와 PopupList 객체 생성
        ArtGalleryList artgallerylist = new ArtGalleryList();
        PopupList popuplist = new PopupList();

        JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);

				setOpaque(false);
				super.paintComponent(g);
			}
		};
        
        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        JButton btnLogin = new JButton("로그인");
		JButton btnJoin = new JButton("회원가입");
		
		
		panel.setLayout(null);
		
		btnLogin.setSize(250, 50);
		btnLogin.setLocation(80, 470);
		btnLogin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setBorderPainted(false);
		

		btnJoin.setSize(250, 50);
		btnJoin.setLocation(80, 540);
		btnJoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 26));
		btnJoin.setContentAreaFilled(false);
		btnJoin.setBorderPainted(false);
		
		
		add(btnLogin);
		add(btnJoin);
		
		
		
		//로그인 버튼 
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				removeAll();
				add(new FrameLogin(panel));
				revalidate();
				repaint();

			}
		});

		// 회원가입 버튼
		btnJoin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
				add(new FrameJoin(panel));
				revalidate();
				repaint();
			}
		});
}
}
