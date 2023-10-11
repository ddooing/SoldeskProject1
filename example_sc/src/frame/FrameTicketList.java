package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import controller.member.MemberToken;

public class FrameTicketList extends JPanel{
	
	public FrameTicketList(String id)
	{
		// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

        JLabel menuline = new JLabel(menuLine); // 메뉴선
        JLabel text = new JLabel("티켓 "); 
        
        text.setSize(200,50);
        text.setLocation(40, 60);
        text.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 30));
        
        menuline.setSize(380, 5);
        menuline.setLocation(10, text.getY() + text.getHeight());
        
        add(text);
        add(menuline);  
        
        //back 버튼
        ImageIcon originalIcon10 = new ImageIcon("./src/img/뒤로가기.png");
		Image originalImage10 = originalIcon10.getImage();
		Image scaledImage10 = originalImage10.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
		ImageIcon posterImage10 = new ImageIcon(scaledImage10);
		JButton back = new JButton(posterImage10);
		back.setSize(50, 40);
		back.setLocation(30, 30);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);

		add(back);

		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.windowForComponent((Component) e.getSource()); // 현재 창 닫기
				if (window != null) {
					window.dispose();
				}
				FrameBase.getInstance(new Home());
			}
		});
	}
	
}
