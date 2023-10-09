package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.member.MemberToken;

public class FrameTicketList extends JPanel{
	
	public FrameTicketList(String id)
	{
		// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        ImageIcon menuLine = new ImageIcon("./src/line3.png");

        JLabel menuline = new JLabel(menuLine); // 메뉴선
        JLabel text = new JLabel("티켓 "); 
        
        text.setSize(200,50);
        text.setLocation(40, 40);
        text.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 30));
        
        menuline.setSize(380, 5);
        menuline.setLocation(10, text.getY() + text.getHeight());
        
        add(text);
        add(menuline);  
	}
	
}
