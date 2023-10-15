package view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.member.MemberController;
import controller.member.MemberList;
//import frame.base.FrameBase;
import frame.base.FrameDisplay;
import model.member.Member;

public class FramePWSearch extends JPanel {
	static String filename123 = "회원명단.txt";
	JPanel frameLoginPanel;
	private JPanel posterPanel;

	public FramePWSearch() {
		this(null);
	}

	public FramePWSearch(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		// JPanel 구조
		setLayout(null);
		setBackground(new Color(255, 255, 255));
		setSize(400, 700);

		setVisible(true);

		/*
		posterPanel = new JPanel();
	    posterPanel.setLayout(null);
	    posterPanel.setSize(363,70);
	    posterPanel.setLocation(20, 610);
	    posterPanel.setBackground(new Color(255, 255, 255));
	    posterPanel.setVisible(true);
	    add(posterPanel);*/
		
		
		JLabel lName = new JLabel("이름");
		JLabel lPhone = new JLabel("전화번호");
		JLabel lID = new JLabel("아이디");
		JTextField tfName = new JTextField(10);
		JTextField tfPhone = new JTextField(10);
		JTextField tfId = new JTextField(10);

		lName.setSize(300, 50);
		lName.setLocation(getWidth() / 2 - 160, 100);
		lName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		lPhone.setSize(300, 50);
		lPhone.setLocation(getWidth() / 2 - 180, 170);
		lPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		lID.setSize(300, 50);
		lID.setLocation(getWidth() / 2 - 170, 240);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		tfName.setSize(270, 50);
		tfName.setLocation(getWidth() / 2 - 120, 100);
		tfName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfPhone.setSize(270, 50);
		tfPhone.setLocation(getWidth() / 2 - 120, 170);
		tfPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfId.setSize(270, 50);
		tfId.setLocation(getWidth() / 2 - 120, 240);
		tfId.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		add(lName);
		add(lPhone);
		add(lID);
		add(tfName);
		add(tfPhone);
		add(tfId);

		// 아이디찾기 버튼 이미지와 리스너 설정
		ImageIcon originalLoginIcon = new ImageIcon("./src/img/비밀번호찾기_비밀번호찾기.png");
		Image scaledLoginImage = originalLoginIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
		ImageIcon loginIcon = new ImageIcon(scaledLoginImage);
		ImageIcon originalLoginHoverIcon = new ImageIcon("./src/img/비밀번호찾기_비밀번호찾기hover.png");
		Image scaledLoginHoverImage = originalLoginHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH); // 호버
																														// 이미지
																														// 크기
																														// 조정
		ImageIcon loginHoverIcon = new ImageIcon(scaledLoginHoverImage);

		// 이전 버튼 이미지와 리스너 설정
		ImageIcon originalIDSearchIcon = new ImageIcon("./src/img/아이디찾기_이전.png");
		Image scaledIDSearchImage = originalIDSearchIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
		ImageIcon idSearchIcon = new ImageIcon(scaledIDSearchImage);
		ImageIcon originalIDSearchHoverIcon = new ImageIcon("./src/img/아이디찾기_이전hover.png");
		Image scaledIDSearchHoverImage = originalIDSearchHoverIcon.getImage().getScaledInstance(140, 40,
				Image.SCALE_SMOOTH); // 호버 이미지 크기 조정
		ImageIcon idSearchHoverIcon = new ImageIcon(scaledIDSearchHoverImage);

		JButton btnCancel = new JButton(idSearchIcon);
		JButton btnPWFind = new JButton(loginIcon);

		btnPWFind.setSize(140, 40);
		btnPWFind.setLocation(135, 330);
		btnPWFind.setContentAreaFilled(false);
		btnPWFind.setBorderPainted(false);
		btnPWFind.setFocusPainted(false);

		btnCancel.setSize(140, 40);
		btnCancel.setLocation(135, (int) btnPWFind.getLocation().getY() + 50);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorderPainted(false);
		btnCancel.setFocusPainted(false);

		add(btnPWFind);
		add(btnCancel);
		
		// 버튼에 마우스 리스너 추가
				btnPWFind.addMouseListener(new MouseAdapter() {
				            @Override
				            public void mouseEntered(MouseEvent e) {
				            	btnPWFind.setIcon( loginHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
				            }

				            @Override
				            public void mouseExited(MouseEvent e) {
				            	btnPWFind.setIcon(loginIcon); // 마우스를 떼면 원래 이미지로 변경
				            }
				        });
				        
				     
						btnCancel.addMouseListener(new MouseAdapter() {
				            @Override
				            public void mouseEntered(MouseEvent e) {
				            	btnCancel.setIcon(idSearchHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
				            }

				            @Override
				            public void mouseExited(MouseEvent e) {
				            	btnCancel.setIcon(idSearchIcon); // 마우스를 떼면 원래 이미지로 변경
				            }
				        });
		

		// 엔터 키 이벤트 처리
		tfId.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					// 엔터 키를 눌렀을 때 btnIDFind의 ActionListener 호출
					btnPWFind.doClick();
				}
			}
		});

		btnPWFind.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String userName = tfName.getText();
				String userPhone = tfPhone.getText();
				String userId = tfId.getText();

				MemberController cm = new MemberController();
				ArrayList<Member> memberArr = cm.readFile(filename123);
				MemberList memberList = new MemberList();

				for (int i = 0; i < memberArr.size(); i++) {
					memberList.addMember(memberArr.get(i));
				}

				String foundPW = memberList.findPW(userId, userPhone, userName);

				if (foundPW != null) {
					JOptionPane.showMessageDialog(null, "비밀번호를 찾았습니다 : " + foundPW);

					// 비밀번호를 찾은 후에 입력된 텍스트를 지웁니다.
					tfName.setText("");
					tfPhone.setText("");
					tfId.setText("");

				} else {
					JOptionPane.showMessageDialog(null, "일치하는 정보를 찾을 수 없습니다.");
				}

			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
                FrameDisplay.getInstance(new FrameLogin());
			}
		});

	}

}
