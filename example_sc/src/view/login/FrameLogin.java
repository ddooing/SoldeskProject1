package view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.member.MemberController;
import controller.member.MemberToken;

import frame.FrameBase;
import frame.FrameBegin;

import frame.Home;
import model.member.Member;
import model.member.MemberList;


public class FrameLogin extends JPanel {

	static String filename = "회원명단.txt";
	JPanel frameLoginPanel;
	private JPanel posterPanel;
	
	public FrameLogin() {
		this(null);
	}

	public FrameLogin(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		
		posterPanel = new JPanel();
	    posterPanel.setLayout(null);
	    posterPanel.setSize(363,70);
	    posterPanel.setLocation(20, 610);
	    posterPanel.setBackground(new Color(255, 255, 255));
	    posterPanel.setVisible(true);
	    add(posterPanel);

		// JPanel 구조
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(400, 700);

		// 아이디, 비번 입력창
		JLabel lID = new JLabel("ID");
		JLabel lPW = new JLabel("PW");
		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);

		lID.setSize(300, 50);
		lID.setLocation(getWidth() / 2 - 160, 100);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		lPW.setSize(300, 50);
		lPW.setLocation(getWidth() / 2 - 163, 170);
		lPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfID.setSize(270, 50);
		tfID.setLocation(getWidth() / 2 -120, 100);
		tfID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfPW.setSize(270, 50);
		tfPW.setLocation(getWidth() / 2 -120, 170);
		tfPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		tfPW.setEchoChar('*');

		add(lID);
		add(lPW);
		add(tfID);
		add(tfPW);

		// 로그인 버튼 이미지와 리스너 설정
				ImageIcon originalLoginIcon = new ImageIcon("./src/img/로그인_로그인.png");
				Image scaledLoginImage = originalLoginIcon.getImage().getScaledInstance(300, 40, Image.SCALE_SMOOTH);
				ImageIcon loginIcon = new ImageIcon(scaledLoginImage);
				ImageIcon originalLoginHoverIcon = new ImageIcon("./src/img/로그인_로그인hover.png");
				Image scaledLoginHoverImage = originalLoginHoverIcon.getImage().getScaledInstance(300, 40, Image.SCALE_SMOOTH); // 호버 이미지 크기 조정
				ImageIcon loginHoverIcon = new ImageIcon(scaledLoginHoverImage);

				// 아이디찾기 버튼 이미지와 리스너 설정
				ImageIcon originalIDSearchIcon = new ImageIcon("./src/img/아이디찾기.png");
				Image scaledIDSearchImage = originalIDSearchIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
				ImageIcon idSearchIcon = new ImageIcon(scaledIDSearchImage);
				ImageIcon originalIDSearchHoverIcon = new ImageIcon("./src/img/아이디찾기hover.png");
				Image scaledIDSearchHoverImage = originalIDSearchHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH); // 호버 이미지 크기 조정
				ImageIcon idSearchHoverIcon = new ImageIcon(scaledIDSearchHoverImage);

				// 비밀번호찾기 버튼 이미지와 리스너 설정
				ImageIcon originalPWSearchIcon = new ImageIcon("./src/img/비밀번호찾기.png");
				Image scaledPWSearchImage = originalPWSearchIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
				ImageIcon pwSearchIcon = new ImageIcon(scaledPWSearchImage);
				ImageIcon originalPWSearchHoverIcon = new ImageIcon("./src/img/비밀번호찾기hover.png");
				Image scaledPWSearchHoverImage = originalPWSearchHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH); // 호버 이미지 크기 조정
				ImageIcon pwSearchHoverIcon = new ImageIcon(scaledPWSearchHoverImage);

				JButton btnLogin = new JButton(loginIcon);
				JButton btnIDSearch = new JButton(idSearchIcon);
				JButton btnPWSearch = new JButton(pwSearchIcon);

				btnLogin.setSize(300, 40);
				btnLogin.setLocation(getWidth() / 4 - 50, 260);
				btnLogin.setContentAreaFilled(false);
				btnLogin.setBorderPainted(false);
				btnLogin.setFocusPainted(false);

				btnIDSearch.setSize(140, 40);
				btnIDSearch.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 50);
				btnIDSearch.setContentAreaFilled(false);
				btnIDSearch.setBorderPainted(false);
				btnIDSearch.setFocusPainted(false);

				btnPWSearch.setSize(140, 40);
				btnPWSearch.setLocation((int) btnIDSearch.getLocation().getX() + 160, (int) btnIDSearch.getLocation().getY());
				btnPWSearch.setContentAreaFilled(false);
				btnPWSearch.setBorderPainted(false);
				btnPWSearch.setFocusPainted(false);

				// 버튼에 마우스 리스너 추가
				btnLogin.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				        btnLogin.setIcon(loginHoverIcon); // 마우스를 가져다 대면 호버 이미지로 변경
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				        btnLogin.setIcon(loginIcon); // 마우스를 떼면 원래 이미지로 변경
				    }
				});

				btnIDSearch.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				        btnIDSearch.setIcon(idSearchHoverIcon); // 마우스를 가져다 대면 호버 이미지로 변경
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				        btnIDSearch.setIcon(idSearchIcon); // 마우스를 떼면 원래 이미지로 변경
				    }
				});

				btnPWSearch.addMouseListener(new MouseAdapter() {
				    @Override
				    public void mouseEntered(MouseEvent e) {
				        btnPWSearch.setIcon(pwSearchHoverIcon); // 마우스를 가져다 대면 호버 이미지로 변경
				    }

				    @Override
				    public void mouseExited(MouseEvent e) {
				        btnPWSearch.setIcon(pwSearchIcon); // 마우스를 떼면 원래 이미지로 변경
				    }
				});

				
				add(btnLogin);
				add(btnIDSearch);
				add(btnPWSearch);
				
				// 엔터 키 이벤트 처리
				tfPW.addKeyListener(new KeyAdapter() {
		            @Override
		            public void keyPressed(KeyEvent e) {
		                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		                    // 엔터 키를 눌렀을 때 btnIDFind의 ActionListener 호출
		                	btnLogin.doClick();
		                }
		            }
		        });
		

		// 버튼 이벤트
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				MemberController cm = new MemberController();
				ArrayList<Member> memberArr = cm.readFile(filename);
				MemberList memberList = new MemberList();

				for (int i = 0; i < memberArr.size(); i++) {
					memberList.addMember(memberArr.get(i));
				}

				String id = tfID.getText();
				String idCheck = memberList.loginMember(id);

				if (idCheck.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 확인해주세요.");
				} else {
					if (idCheck.equals(new String(tfPW.getPassword()))) {
						Member.tokeniD = id;
						System.out.println("id : "+Member.tokeniD);
						JOptionPane.showMessageDialog(null, id + "님, 환영합니다!");
						FrameBase.getInstance(new Home());
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "비밀번호를 확인해주세요.");
					}
				}

			}
		});

		btnIDSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new FrameIDSearch());
			}
		});
		
		btnPWSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new FramePWSearch());
			}
		});

	}// 생성자
	
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
	


}