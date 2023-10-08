package view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
	
	public FrameLogin() {
		this(null);
	}

	public FrameLogin(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		

		// JPanel 구조
		setBackground(new Color(255, 255, 240));
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

		// 하단의 버튼 설정
		JButton btnLogin = new JButton("로그인");
		JButton btnIDSearch = new JButton("아이디 찾기");
		JButton btnPWSearch = new JButton("비밀번호 찾기");
		

		btnLogin.setSize(300, 40);
		btnLogin.setLocation(getWidth() / 4 - 50, 260);
		btnLogin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		btnIDSearch.setSize(140, 40);
		btnIDSearch.setLocation((int) btnLogin.getLocation().getX(), (int) btnLogin.getLocation().getY() + 50);
		btnIDSearch.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		btnPWSearch.setSize(140, 40);
		btnPWSearch.setLocation((int) btnIDSearch.getLocation().getX()+160, (int) btnIDSearch.getLocation().getY());
		btnPWSearch.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		
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
						MemberToken.tokenID = id;
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

				
				removeAll();
		        add(new FrameIDSearch());
		        revalidate();
		        repaint();
			}
		});
		
		btnPWSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				removeAll();
		        add(new FramePWSearch());
		        revalidate();
		        repaint();
			}
		});

	}// 생성자
	
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
	


}