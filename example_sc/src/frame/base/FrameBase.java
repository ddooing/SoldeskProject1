package frame.base;

import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.member.MemberToken;
import frame.home.Home;
import frame.underbtn.FrameRandomPage;
import frame.underbtn.FrameSoonPage;
import frame.underbtn.FrameTicketList;
import model.member.Member;
import view.login.FrameIDSearch;

public class FrameBase extends JFrame{
	private static FrameBase instance;

	private FrameBase(JPanel e) {
		//시스템 정보(화면 크기를 얻기 위한 Toolkit)
		Toolkit tk = Toolkit.getDefaultToolkit();//해상도

		//기본 JFrame 구조
		setTitle("ARTMEE");
		setLayout(null);
		setBounds(((int) tk.getScreenSize().getWidth() / 3), 
				((int) tk.getScreenSize().getHeight()) / 2 - 400,
				415, 738);
		getImage(e);//기본 배경 이미지
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼
	
		
		
	    
	}//생성자

	//싱글톤 기법을 사용하려고 한다
	public static void getInstance(JPanel e) {
			//static으로 선언했으므로 해당 메서드가 생성자보다도 먼저 호출된다
		instance = new FrameBase(e);//생성자를 통해 기본 프레임 정의
		
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		
		instance.revalidate(); //레이아웃 관리자에게 레이아웃정보를 다시 계산하도록 지시
		instance.repaint(); //레이아웃을 새로 그린다
	}//getInstance()
	
	//기본 프레임 이미지를 저장하기 위한 메소드
	public static void getImage(JPanel e) {
		ImageIcon backGround = new ImageIcon("./src/img/backimg.png");
		ImageIcon imagebottom = new ImageIcon("./src/img/하단바.png");
		JLabel lblBackGround = new JLabel(backGround);
		JLabel lblImagebottom = new JLabel(imagebottom);
		lblBackGround.setSize(400, 700);
		lblImagebottom.setSize(580, 124);
		lblBackGround.setLocation(0, 0); 
		lblImagebottom.setLocation(-90, 600);
		e.add(lblBackGround);
		e.add(lblImagebottom);
		
		
		JButton soon = new JButton();
		JButton home = new JButton();
		JButton ticket = new JButton();
		JButton random = new JButton();
		
		
		
		soon.setSize(50,40);
		soon.setLocation(46,640);
		soon.setBorderPainted(false);
		soon.setContentAreaFilled(false);
		soon.setFocusPainted(false);
		
		e.add(soon);
		
		soon.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(instance != null) {		// 1개 창 닫기
					instance.dispose();
					}
				FrameBase.getInstance(new FrameSoonPage());
				
			}
		});
		
		home.setSize(50,40);
		home.setLocation(137,640);
		home.setBorderPainted(false);
		home.setContentAreaFilled(false);
		home.setFocusPainted(false);
		
		e.add(home);
		
		home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(instance != null) {		// 1개 창 닫기
					instance.dispose();
					}
				FrameBase.getInstance(new Home());
			}
		});
		
		ticket.setSize(50,40);
		ticket.setLocation(210,640);
		ticket.setBorderPainted(false);
		ticket.setContentAreaFilled(false);
		ticket.setFocusPainted(false);
		
		e.add(ticket);
		
		ticket.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(instance != null) {		// 1개 창 닫기
					instance.dispose();
					}
				FrameBase.getInstance(new FrameTicketList(Member.tokeniD));
				
			}
		});
		
		
		random.setSize(50,40);
		random.setLocation(290,640);
		random.setBorderPainted(false);
		random.setContentAreaFilled(false);
		random.setFocusPainted(false);
		
		e.add(random);
		
		random.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(instance != null) {		// 1개 창 닫기
					instance.dispose();
					}
				FrameBase.getInstance(new FrameRandomPage());
			}
		});
		
		
		
	}
	
	public static void closeAllFrames() {
        if (instance != null) {
            // 모든 열려있는 창을 닫기 위해 창을 순회하면서 각 창을 닫음
            for (Frame frame : Frame.getFrames()) {
                if (frame instanceof FrameBase) {
                    continue; // FrameBase 창은 제외
                }
                frame.dispose();
            }
        }
    }
	

	@Override
	public void dispose() {
		super.dispose();
	}
	
	public static void getDispose() {
		instance.dispose();
	}
}
