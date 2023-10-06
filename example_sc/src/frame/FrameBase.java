package frame;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameBase extends JFrame{
	private static FrameBase instance;

	private FrameBase(JPanel e) {
		//시스템 정보(화면 크기를 얻기 위한 Toolkit)
		Toolkit tk = Toolkit.getDefaultToolkit();//해상도

		//기본 JFrame 구조
		setTitle("미술관소개");
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
		ImageIcon backGround = new ImageIcon("./src/backimg.png");
		//ImageIcon imagebottom = new ImageIcon("./src/하단버튼배경.jpg");
		JLabel lblBackGround = new JLabel(backGround);
		//JLabel lblImagebottom = new JLabel(imagebottom);
		lblBackGround.setSize(400, 700);
		//lblImagebottom.setSize(580, 124);
		lblBackGround.setLocation(0, 0); 
		//lblImagebottom.setLocation(-90, 600);
		//e.add(lblImagebottom);
		e.add(lblBackGround);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
	
	public static void getDispose() {
		instance.dispose();
	}
}
