package view.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.member.MemberController;
import controller.member.MemberList;
import model.member.Member;



public class FrameIDSearch extends JPanel{
	static String filename = "회원명단.txt";
	JPanel frameLoginPanel;
	
	
	public FrameIDSearch() {
		this(null);
	}
	
	public FrameIDSearch(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		// JPanel 구조
		setLayout(null);
		setBackground(new Color(255, 255, 240));
		setSize(400, 700);
		
		setVisible(true);
		
		JLabel lName = new JLabel("이름");
		JLabel lPhone = new JLabel("전화번호");
		JTextField tfName = new JTextField(10);
		JTextField tfPhone = new JTextField(10);

		lName.setSize(300, 50);
		lName.setLocation(getWidth() / 2 - 160, 100);
		lName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		lPhone.setSize(300, 50);
		lPhone.setLocation(getWidth() / 2 - 190, 170);
		lPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		tfName.setSize(270, 50);
		tfName.setLocation(getWidth() / 2 -120, 100);
		tfName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfPhone.setSize(270, 50);
		tfPhone.setLocation(getWidth() / 2 -120, 170);
		tfPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		
		add(lName);
		add(lPhone);
		add(tfName);
		add(tfPhone);
		
		JButton btnIDFind = new JButton("아이디 찾기");
		JButton btnCancle = new JButton("취소");
		

		btnIDFind.setSize(300, 40);
		btnIDFind.setLocation(getWidth() / 4 - 50, 260);
		btnIDFind.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		btnCancle.setSize(300, 40);
		btnCancle.setLocation((int) btnIDFind.getLocation().getX(), (int) btnIDFind.getLocation().getY() + 50);
		btnCancle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		
		add(btnIDFind);
		add(btnCancle);
		
		
		// 엔터 키 이벤트 처리
        tfPhone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // 엔터 키를 눌렀을 때 btnIDFind의 ActionListener 호출
                    btnIDFind.doClick();
                }
            }
        });
		
		btnIDFind.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = tfName.getText();
				String userPhone = tfPhone.getText();
				
				MemberController cm = new MemberController();
                ArrayList<Member> memberArr = cm.readFile(filename);
                MemberList memberList = new MemberList();
                
                for (int i = 0; i < memberArr.size(); i++) {
                    memberList.addMember(memberArr.get(i));
                }

                String foundID = memberList.findID(userName,userPhone);

                if (foundID != null) {
                    JOptionPane.showMessageDialog(null, "아이디를 찾았습니다 : " + foundID);
                    tfName.setText("");
                    tfPhone.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "일치하는 정보를 찾을 수 없습니다.");
                }
            

				
				
			}
		});
		
		btnCancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
		        add(new FrameLogin());
		        revalidate();
		        repaint();
			}
		});
	}
}
