package frame.underbtn;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import frame.base.FrameBase;
import frame.home.Home;
import frame.reserve.FrameReserve;
import model.member.ArtReserInfo;

public class FrameRandomPage extends JPanel {

	JPanel framehomePanel;
	private int ad;
	private List<ArtGalleryInfo> posterInfoList;

	public FrameRandomPage() {
		this(null); // 생성자 매개변수 없이 호출하면 밑에 있는 생성자 매개변수 있는 것으로 실행되는 코드
	}

	public FrameRandomPage(JPanel homePanel) {
		ArtGalleryList artgallerylist = new ArtGalleryList();

		setSize(400, 700);
		setLayout(null);

		setVisible(true);

		JLabel titleLabel = new JLabel("랜덤 전시 추천");
		titleLabel.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 24));
		titleLabel.setForeground(Color.BLACK);
		titleLabel.setBounds(120, 30, 300, 50);
		add(titleLabel);

		while (true) {
			int i = new Random().nextInt(artgallerylist.getPosters().size() - 4);
			ad = i;
			posterInfoList = artgallerylist.getPosters();

			makeArtInfo(artgallerylist, i);
			break;
		}

	}

	public void makeArtInfo(ArtGalleryList artInfo, int i) {

		ImageIcon originalIcon9 = new ImageIcon(posterInfoList.get(i).getImageURL());
		Image originalImage9 = originalIcon9.getImage();
		Image scaledImage9 = originalImage9.getScaledInstance(360, 280, Image.SCALE_SMOOTH);
		ImageIcon posterImage1 = new ImageIcon(scaledImage9);
		JLabel fImage = new JLabel(posterImage1);
		fImage.setSize(360, 280);
		fImage.setLocation(20, 70);
		add(fImage);

		// dateStart 포맷팅
		Date dateStart = artInfo.getPosters().get(i).getDateStart();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDateStart = dateFormat.format(dateStart);

		// dateEnd 포맷팅
		Date dateEnd = artInfo.getPosters().get(i).getDateEnd();
		String formattedDateEnd = dateFormat.format(dateEnd);

		JLabel title = new JLabel("<HTML><body>" + artInfo.getPosters().get(i).getArtName() + "</body></HTML>");

		JLabel placendate = new JLabel("<HTML><body>" + artInfo.getPosters().get(i).getPlace() + "<br>"
				+ formattedDateStart + " ~ " + formattedDateEnd + "</body></HTML>");

		JLabel story = new JLabel("<HTML><body>" + "관람시간 : " + artInfo.getPosters().get(i).getStarttime()+ " ~ " + artInfo.getPosters().get(i).getEndtime() + "<br>" + "입장료 : "
				+ artInfo.getPosters().get(i).getFee() + "<br>" + "주소 : " + artInfo.getPosters().get(i).getPlace()
				+ "</body></HTML>");

		// "예약" 버튼 생성
		ImageIcon originalIcon = new ImageIcon("./src/img/예매.png");
		Image originalImage = originalIcon.getImage();
		Image scaledImage = originalImage.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
		ImageIcon reservebtn = new ImageIcon(scaledImage);
		JButton reservebtn1 = new JButton(reservebtn);

		reservebtn1.setBounds(300, 450, 60, 30);
		reservebtn1.setBorderPainted(false); // 버튼 외각선 지우기
		reservebtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
		reservebtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
		add(reservebtn1);

		title.setSize(400, 30);
		title.setLocation(30, 360);
		title.setBackground(new Color(255, 255, 255));
		title.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 25));

		placendate.setSize(400, 60);
		placendate.setLocation(30, 410);
		placendate.setBackground(new Color(255, 255, 255));
		placendate.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 18));

		story.setSize(400, 70);
		story.setLocation(30, 500);
		story.setBackground(new Color(255, 255, 255));
		story.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 16));

		// 구분선 추가
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
		separator1.setForeground(Color.BLACK);
		add(separator1);

		JSeparator separator2 = new JSeparator();
		separator2.setBounds(20, 490, 360, 10); // 구분선의 위치와 크기 조정
		separator2.setForeground(Color.BLACK);
		add(separator2);

		add(title);
		add(placendate);
		add(story);

		// "길찾기" 버튼 생성
		ImageIcon originalIcon1 = new ImageIcon("./src/img/길찾기.png");
		Image originalImage1 = originalIcon1.getImage();
		Image scaledImage1 = originalImage1.getScaledInstance(70, 30, Image.SCALE_SMOOTH);
		ImageIcon mapgobtn = new ImageIcon(scaledImage1);
		JButton mapgobtn1 = new JButton(mapgobtn);

		mapgobtn1.setBounds(295, 550, 70, 30);
		mapgobtn1.setBorderPainted(false); // 버튼 외각선 지우기
		mapgobtn1.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
		mapgobtn1.setFocusPainted(false); // 버튼 선택 표시 지우기
		add(mapgobtn1);

		// 호버 시에 표시할 이미지 설정
		ImageIcon hoverIcon2 = new ImageIcon("./src/img/길찾기hover.png");
		Image scaledHoverImage2 = hoverIcon2.getImage().getScaledInstance(70, 30, Image.SCALE_SMOOTH);
		mapgobtn1.setRolloverIcon(new ImageIcon(scaledHoverImage2));

		// 호버 시에 표시할 이미지 설정
        ImageIcon hoverIcon1 = new ImageIcon("./src/img/예매hover.png");
        Image scaledHoverImage1 = hoverIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        reservebtn1.setRolloverIcon(new ImageIcon(scaledHoverImage1));
		
		mapgobtn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 크롬 브라우저 열기
					String URL = posterInfoList.get(i).getPlaceURL();
					Desktop.getDesktop().browse(new URI(URL));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace(); // 예외 처리
				}

			}
		});

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
		
reservebtn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 예매 버튼 클릭시
				Window window = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window != null) {
                    window.dispose(); 
                }
				
                FrameBase.getInstance(new FrameReserve(posterInfoList.get(i), posterInfoList.get(i).getArtName()));
	
				
				
			}
		});
	}

}
