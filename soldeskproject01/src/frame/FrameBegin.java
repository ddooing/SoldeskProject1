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
        setBackground(new Color(255, 192, 203));
        setLayout(null);
        setSize(400, 700);
        
        // 오늘의 전시 추천 텍스트 레이블 생성 및 설정
        recommendationtext = new JLabel("오늘의 전시 추천");
        recommendationtext.setBounds(130, 10, 300, 30);
        recommendationtext.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
        add(recommendationtext);
        
        // 이미지 배열 초기화
        imageArray = new ImageIcon[4];
        
        // 이미지를 배열에 추가 (이미지 파일 경로에 따라 수정)
        imageArray[0] = new ImageIcon("https://og-data.s3.amazonaws.com/media/exhibitions/image/13639/ei_13639.jpeg");
        imageArray[1] = new ImageIcon("./src/디올 성수.jpg");
        imageArray[2] = new ImageIcon("./src/라인프렌즈.jpg");
        imageArray[3] = new ImageIcon("./src/쿨라링.jpg");
        
        
        // 이미지를 표시할 레이블 생성
        imageLabel = new JLabel();
        imageLabel.setBounds(50, 50, 300, 400);
        add(imageLabel);

        // 랜덤 이미지 표시
        Random random = new Random();
        int randomIndex = random.nextInt(imageArray.length);
        imageLabel.setIcon(imageArray[randomIndex]);

        
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