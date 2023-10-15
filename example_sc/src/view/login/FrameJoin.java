package view.login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.member.MemberController;
import frame.base.FrameDisplay;
import model.member.Member;
import model.member.MemberList;


public class FrameJoin extends JPanel {

	static String filename = "회원명단.txt";
	JPanel frameJoinPanel;
	private JPanel posterPanel;
	
	public FrameJoin() {
		this(null);
	}

	public FrameJoin(JPanel homePanel) {
		this.frameJoinPanel = homePanel;
		/*
		posterPanel = new JPanel();
	    posterPanel.setLayout(null);
	    posterPanel.setSize(363,70);
	    posterPanel.setLocation(20, 610);
	    posterPanel.setBackground(new Color(255, 255, 255));
	    posterPanel.setVisible(true);
	    add(posterPanel);*/

		// JPanel 구조
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setSize(400, 700);

		// 아이디, 비번 입력창
		JLabel ljoin = new JLabel("회 원 가 입");
		JLabel lID = new JLabel("아이디");
		JLabel lPW = new JLabel("비밀번호");
		JLabel lname = new JLabel("이름");
		JLabel ltel = new JLabel("전화번호");

		JTextField tfID = new JTextField(10);
		JPasswordField tfPW = new JPasswordField(10);
		JTextField tfname = new JTextField(10);
		JTextField tftel = new JTextField(10);

		ljoin.setSize(300, 40);
		ljoin.setLocation(getWidth() / 2 - 50, 60);
		ljoin.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));

		lID.setSize(100, 40);
		lID.setLocation(40, 150);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		lPW.setSize(100, 40);
		lPW.setLocation(20, 200);
		lPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		lname.setSize(100, 40);
		lname.setLocation(53, 250);
		lname.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));


		ltel.setSize(100, 40);
		ltel.setLocation(20, 300);
		ltel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tfID.setSize(280, 40);
		tfID.setLocation(getWidth() / 4 , 150);
		tfID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tfPW.setSize(280, 40);
		tfPW.setLocation(getWidth() / 4 , 200);
		tfPW.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));
		tfPW.setEchoChar('*');

		tfname.setSize(280, 40);
		tfname.setLocation(getWidth() / 4, 250);
		tfname.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		tftel.setSize(280, 40);
		tftel.setLocation(getWidth() / 4, 300);
		tftel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		add(ljoin);
		add(lID);
		add(lPW);
		add(lname);
		add(ltel);
		add(tfID);
		add(tfPW);
		add(tfname);
		add(tftel);

		 // 완료 버튼 이미지와 리스너 설정
        ImageIcon originalDoneIcon = new ImageIcon("./src/img/완료.png");
        Image scaledDoneImage = originalDoneIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon doneIcon = new ImageIcon(scaledDoneImage);

        ImageIcon originalDoneHoverIcon = new ImageIcon("./src/img/완료hover.png");
        Image scaledDoneHoverImage = originalDoneHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon doneHoverIcon = new ImageIcon(scaledDoneHoverImage);

        JButton btnDone = new JButton(doneIcon);

        btnDone.setSize(140, 40);
        btnDone.setLocation(135, 400);
        btnDone.setContentAreaFilled(false);
        btnDone.setBorderPainted(false);
        btnDone.setFocusPainted(false);
        

        // 완료 버튼에 마우스 리스너 추가
        btnDone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnDone.setIcon(doneHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnDone.setIcon(doneIcon); // 마우스를 떼면 원래 이미지로 변경
            }
        });
        
        

        // 이전 버튼 이미지와 리스너 설정
        ImageIcon originalHomeIcon = new ImageIcon("./src/img/회원가입_이전.png");
        Image scaledHomeImage = originalHomeIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon homeIcon = new ImageIcon(scaledHomeImage);

        ImageIcon originalHomeHoverIcon = new ImageIcon("./src/img/회원가입_이전hover.png");
        Image scaledHomeHoverImage = originalHomeHoverIcon.getImage().getScaledInstance(140, 40, Image.SCALE_SMOOTH);
        ImageIcon homeHoverIcon = new ImageIcon(scaledHomeHoverImage);

        JButton btnHome = new JButton(homeIcon);

        btnHome.setSize(140, 40);
        btnHome.setLocation(135, (int) btnDone.getLocation().getY() + 50);
        btnHome.setContentAreaFilled(false);
        btnHome.setBorderPainted(false);
        btnHome.setFocusPainted(false);

        // 이전 버튼에 마우스 리스너 추가
        btnHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btnHome.setIcon(homeHoverIcon); // 마우스를 가져다 대면 hover 이미지로 변경
            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnHome.setIcon(homeIcon); // 마우스를 떼면 원래 이미지로 변경
            }
        });

		add(btnDone);
		add(btnHome);

		// 버튼 이벤트
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String inputID = tfID.getText();
				String inputPW = new String(tfPW.getPassword());
				String inputName = tfname.getText();
				String inputTel = tftel.getText();

				if (!inputID.isEmpty() && (!inputPW.isEmpty()) && !inputName.isEmpty() && !inputTel.isEmpty()) {
					
					MemberController cm = new MemberController();
					ArrayList<Member> memberArr = cm.readFile(filename);
					MemberList memberList = new MemberList();

					for (int i = 0; i < memberArr.size(); i++) {
						memberList.addMember(memberArr.get(i));
					}

					String idCheck = memberList.joinMember(inputID);
					
					if(!idCheck.isEmpty()) {
						JOptionPane.showMessageDialog(null, idCheck);
						return;
					}

					try (BufferedWriter br = new BufferedWriter(new FileWriter("회원명단.txt", true))) {

						br.write(inputID + "/");
						br.write(inputPW + "/");
						br.write(inputName + "/");
						br.write(inputTel + "\n");
						System.out.println("저장완료");
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
					}

					JOptionPane.showMessageDialog(null, "회원가입에 성공했습니다.");
					System.out.println("회원가입 성공");
					dispose();

				} else {
					JOptionPane.showMessageDialog(null, "회원가입이 실패했습니다.");
				}

			}
		});

		
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

	}// 생성자
	
	public void dispose() {
	    JFrame parent = (JFrame) this.getTopLevelAncestor();
	    parent.dispose();
	}
}