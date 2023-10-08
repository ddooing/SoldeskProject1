package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class FilterMenuFrame extends JPanel {

	public FilterMenuFrame() {
		// 패널의 위치와 크기 설정
		setSize(361,40);
		setLocation(20, 95);
		setLayout(null);
	    // 패널의 배경색을 핑크색으로 설정
	    setBackground(Color.pink);
	    

        // 필터 버튼 (인기, 최신, 무료, 곧 종료) 추가
	    ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
        ImageIcon two = new ImageIcon(originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH));
        JButton two2 = new JButton(two);
        two2.setBounds(4, 2, 60, 30);
        two2.setContentAreaFilled(false);
        two2.setBorderPainted(false);
       add(two2);
       
        ImageIcon originalIcon1 = new ImageIcon("./src/인기.png");
        ImageIcon one = new ImageIcon(originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH));
        JButton one1 = new JButton(one);
       // one1.setSize(60,30);
        one1.setBounds(two2.getX() + two2.getWidth() + 5, 2, 60, 30);
        one1.setContentAreaFilled(false);
        one1.setBorderPainted(false);
        add(one1);

        

        ImageIcon originalIcon3 = new ImageIcon("./src/무료.png");
        ImageIcon three = new ImageIcon(originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH));
        JButton three3 = new JButton(three);
        three3.setBounds(one1.getX() + one1.getWidth() + 5, 2, 60, 30);
        three3.setContentAreaFilled(false);
        three3.setBorderPainted(false);
        add(three3);

        ImageIcon originalIcon4 = new ImageIcon("./src/곧종료.png");
        ImageIcon four = new ImageIcon(originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH));
        JButton four4 = new JButton(four);
        four4.setBounds(three3.getX() + three3.getWidth() + 5, 2, 80, 30);
        four4.setContentAreaFilled(false);
        four4.setBorderPainted(false);
        add(four4);
        
        one1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new FrameHomePopularClick());
			
			}
		});
        
        two2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
        three3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new Home());
			
				
			}
		});
        
        four4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}
}
