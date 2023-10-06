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
import javax.swing.JTextField;

import controller.member.MemberController;
import controller.member.MemberList;
import model.member.Member;



public class FramePWSearch extends JPanel {
	static String filename123 = "회원명단.txt";
	JPanel frameLoginPanel;
	
	
	public FramePWSearch() {
		this(null);
	}
	
	public FramePWSearch(JPanel homePanel) {
		this.frameLoginPanel = homePanel;
		// JPanel 구조
		setLayout(null);
		setBackground(new Color(255, 255, 240));
		setSize(400, 700);
		
		setVisible(true);
		
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
		lPhone.setLocation(getWidth() / 2 - 190, 170);
		lPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));
		
		lID.setSize(300, 50);
		lID.setLocation(getWidth() / 2 - 175, 240);
		lID.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 15));

		tfName.setSize(270, 50);
		tfName.setLocation(getWidth() / 2 -120, 100);
		tfName.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		tfPhone.setSize(270, 50);
		tfPhone.setLocation(getWidth() / 2 -120, 170);
		tfPhone.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		
		tfId.setSize(270, 50);
		tfId.setLocation(getWidth() / 2 -120, 240);
		tfId.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		
		add(lName);
		add(lPhone);
		add(lID);
		add(tfName);
		add(tfPhone);
		add(tfId);
		
		JButton btnPWFind = new JButton("비밀번호 찾기");
		JButton btnCancle = new JButton("취소");
		

		btnPWFind.setSize(300, 40);
		btnPWFind.setLocation(getWidth() / 4 - 50, 330);
		btnPWFind.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));

		btnCancle.setSize(300, 40);
		btnCancle.setLocation((int) btnPWFind.getLocation().getX(), (int) btnPWFind.getLocation().getY() + 50);
		btnCancle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 22));
		
		add(btnPWFind);
		add(btnCancle);
		
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
                     JOptionPane.showMessageDialog(null, "비밀번호를 찾았습니다: " + foundPW);
                     
                  // 비밀번호를 찾은 후에 입력된 텍스트를 지웁니다.
                     tfName.setText("");
                     tfPhone.setText("");
                     tfId.setText("");
                     
                 } else {
                     JOptionPane.showMessageDialog(null, "일치하는 정보를 찾을 수 없습니다.");
                 }
				
			}
		});
		
		btnCancle.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				removeAll();
		        add(new FrameLogin(homePanel));
		        revalidate();
		        repaint();
			}
		});
		
	}
	
}
