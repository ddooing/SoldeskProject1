package frame;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import artDB.ArtGalleryList;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

public class Home extends JPanel {

    private JLabel imageLabel;
    //private Timer imageTimer;
    ImageIcon icon;
    JPanel framehomePanel;

    public Home() {
    	this(null);
    }
    public Home(JPanel homePanel) {
    	this.framehomePanel = homePanel;
    	//list 객체생성
    	ArtGalleryList artgallerylist = new ArtGalleryList();
		
    	// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        // 이미지 
        	// 검색 아이콘
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        	//선
        ImageIcon menuLine =new ImageIcon("./src/line3.png");
        
        
        JButton btnSearch = new JButton(imageSearch);// 검색 버튼
        JLabel menuline = new JLabel(menuLine);// 메뉴선  
        
        // 검색 아이콘
        btnSearch.setSize(50,50);
        btnSearch.setLocation(310, 40);
        btnSearch.setBorderPainted(false); //버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); //버튼 선택표시 지우기
        
        // 선 
        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());
        //add(btnGal);
        //add(btnPop);
        
        int btnsHeight = menuline.getY() + menuline.getHeight()+10;
        
        //인기 필터
        ImageIcon originalIcon1 = new ImageIcon("./src/인기.png");
        Image originalImage1 = originalIcon1.getImage();
        Image scaledImage1 = originalImage1.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        
		ImageIcon one = new ImageIcon(scaledImage1);
		JButton one1 = new JButton(one);
		one1.setBounds(30,btnsHeight,60, 30);
		one1.setContentAreaFilled(false);
		one1.setBorderPainted(false);
		add(one1);
        
		//최신 필터
		ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
        Image originalImage2 = originalIcon2.getImage();
        Image scaledImage2 = originalImage2.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        
		ImageIcon two = new ImageIcon(scaledImage2);
		JButton two2 = new JButton(two);
		two2.setBounds(one1.getX() + one1.getWidth() + 5,btnsHeight,60, 30);
		two2.setContentAreaFilled(false);
		two2.setBorderPainted(false);
		add(two2);
		
		// 무료 필터
		ImageIcon originalIcon3 = new ImageIcon("./src/무료.png");
        Image originalImage3 = originalIcon3.getImage();
        Image scaledImage3 = originalImage3.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        
		ImageIcon three = new ImageIcon(scaledImage3);
		JButton three3 = new JButton(three);
		three3.setBounds(two2.getX() + two2.getWidth() + 5,btnsHeight,60, 30);
		three3.setContentAreaFilled(false);
		three3.setBorderPainted(false);
		add(three3);
		
		// 곧종료 필터
		ImageIcon originalIcon4 = new ImageIcon("./src/곧종료.png");
        Image originalImage4 = originalIcon4.getImage();
        Image scaledImage4 = originalImage4.getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        
		ImageIcon four = new ImageIcon(scaledImage4);
		JButton four4 = new JButton(four);
		four4.setBounds(three3.getX() + three3.getWidth() + 5,btnsHeight,80, 30);
		four4.setContentAreaFilled(false);
		four4.setBorderPainted(false);
		add(four4);
        
        
        //필터 버튼 add 
        add(btnSearch);
        add(menuline);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int posterWidth = 120;
        int posterHeight = 160;

        // 1번 첫 번째 영역: 포스터 이미지
        JButton posterImage1=new JButton(HtmlItils1.imgHtmlParser(artgallerylist.Info().get(0).getImageURL()));
        posterImage1.setBounds(50, 160, posterWidth, posterHeight);
        add(posterImage1);

        // 1번 두 번째 영역: 포스터 제목
        JLabel posterTitle1 = new JLabel(artgallerylist.Info().get(0).getArtName());
        posterTitle1.setBounds(50, 330, posterWidth, 20);
        posterTitle1.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
        add(posterTitle1);

        // 1번 세 번째 영역: 포스터 기간
        JLabel posterDate1 = new JLabel(dateFormat.format(artgallerylist.Info().get(0).getDateStart()) + "~" +dateFormat.format(artgallerylist.Info().get(0).getDateEnd()));
        posterDate1.setBounds(50, 350, posterWidth, 20);
        posterDate1.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
        add(posterDate1);
        
       
        // 2번 첫 번째 영역: 포스터 이미지
        JButton posterImage2=new JButton(HtmlItils1.imgHtmlParser(artgallerylist.Info().get(1).getImageURL()));
        posterImage2.setBounds(230, 160, posterWidth, posterHeight);
        add(posterImage2);

        // 2번 두 번째 영역: 포스터 제목
        JLabel posterTitle2 = new JLabel(artgallerylist.Info().get(1).getArtName());
        posterTitle2.setBounds(230, 330, posterWidth, 20);
        posterTitle2.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
        add(posterTitle2);

        // 2번 세 번째 영역: 포스터 기간
        JLabel posterDate2 = new JLabel(dateFormat.format(artgallerylist.Info().get(1).getDateStart()) + "~" +dateFormat.format(artgallerylist.Info().get(1).getDateEnd()));
        posterDate2.setBounds(230, 350, posterWidth, 20);
        posterDate2.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
        add(posterDate2);
        
        
        
        // 3번 첫 번째 영역: 포스터 이미지
        JButton posterImage3=new JButton(HtmlItils1.imgHtmlParser(artgallerylist.Info().get(2).getImageURL()));
        posterImage3.setBounds(50, 380, posterWidth, posterHeight);
        add(posterImage3);

        // 3번 두 번째 영역: 포스터 제목
        JLabel posterTitle3 = new JLabel(artgallerylist.Info().get(2).getArtName());
        posterTitle3.setBounds(50, 550, posterWidth, 20);
        posterTitle3.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
        add(posterTitle3);

        // 3번 세 번째 영역: 포스터 기간
        JLabel posterDate3 = new JLabel(dateFormat.format(artgallerylist.Info().get(2).getDateStart()) + "~" +dateFormat.format(artgallerylist.Info().get(2).getDateEnd()));
        posterDate3.setBounds(50, 570, posterWidth, 20);
        posterDate3.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
        add(posterDate3);
        


        // 4번 첫 번째 영역: 포스터 이미지
        JButton posterImage4=new JButton(HtmlItils1.imgHtmlParser(artgallerylist.Info().get(3).getImageURL()));
        posterImage4.setBounds(230, 380, posterWidth, posterHeight);
        add(posterImage4);

        // 4번 두 번째 영역: 포스터 제목
        JLabel posterTitle4 = new JLabel(artgallerylist.Info().get(3).getArtName());
        posterTitle4.setBounds(230, 550, posterWidth, 20);
        posterTitle4.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
        add(posterTitle4);

        // 4번 세 번째 영역: 포스터 기간
        JLabel posterDate4 = new JLabel(dateFormat.format(artgallerylist.Info().get(3).getDateStart()) + "~" +dateFormat.format(artgallerylist.Info().get(3).getDateEnd()));
        posterDate4.setBounds(230, 570, posterWidth, 20);
        posterDate4.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
        add(posterDate4);
       
        
        ImageIcon originalIcon5 = new ImageIcon("./src/다음페이지.png");
        Image originalImage5 = originalIcon5.getImage();
        Image scaledImage5 = originalImage5.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        
		ImageIcon nextpage = new ImageIcon(scaledImage5);
		JButton nextpage1 = new JButton(nextpage);
		nextpage1.setBounds(330,600,40, 30);
		nextpage1.setContentAreaFilled(false);
		nextpage1.setBorderPainted(false);
		add(nextpage1);
        
		
		nextpage1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
        
        
        btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 검색페이지 이동
			}
		});
        
        
        

        
    }


}
