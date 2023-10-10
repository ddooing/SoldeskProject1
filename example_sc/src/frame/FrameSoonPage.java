package frame;

import javax.swing.*;
import java.io.File;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrameSoonPage extends JPanel {
	
	private JPanel posterPanel;
	private JPanel homePanel;
    private int currentPage = 0; // 현재 페이지 인덱스
    private int postersPerPage = 4; // 한 페이지당 포스터 개수
    private int totalPosters = 4; // 전체 포스터 개수
    private int totalPages = (int) Math.ceil((double) totalPosters / postersPerPage); // 총 페이지 수
    private List<ArtGalleryInfo> posterInfoList; // 전체 포스터 정보 리스트

    String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로

    public FrameSoonPage() {
        this(null);
    }

    
    public FrameSoonPage(JPanel homePanel) {
    	 this.homePanel = homePanel;
    	  
    	 // 포스터 넣는곳 패널 새로 생성
    	 posterPanel = new JPanel();
    	 posterPanel.setLayout(null);
    	    posterPanel.setBackground(Color.white);
    	    posterPanel.setSize(361,500);
    	    posterPanel.setLocation(20, 135);
    	    posterPanel.setVisible(true);
    	    add(posterPanel);
    	    
        // ArtGalleryList 객체 생성
        ArtGalleryList artgallerylist = new ArtGalleryList();
        posterInfoList = artgallerylist.Info();

        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
     
        updatePosters();
   
    }

    private void updatePosters() {

    	// 이미지
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        ImageIcon menuLine = new ImageIcon("./src/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선
        
        try {
            // TTF 파일을 읽어서 Font 객체 생성
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));

           
        JLabel text = new JLabel("전시 예정");
        
        text.setSize(200,50);
        text.setLocation(40, 45);
        // 원하는 폰트 스타일과 크기로 설정
        customFont = customFont.deriveFont(Font.BOLD, 30); // 크기 24, 평범한 스타일로 설정
        text.setFont(customFont);
        add(text);

        btnSearch.setSize(50, 50);
        btnSearch.setLocation(310, 40);
        btnSearch.setBorderPainted(false); // 버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); // 버튼 선택 표시 지우기

        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());


        // 컴포넌트 추가
        add(btnSearch);
        add(menuline);
        
     // 검색 버튼 누르면
        btnSearch.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Window window1 = SwingUtilities.windowForComponent((Component) e.getSource()); // 현재 창 닫기
                if (window1 != null) {
                    window1.dispose();
                }
                // 검색 창으로 이동
                FrameBase.getInstance(new FrameSearch_1());

            }
        });
        
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int posterWidth = 120;
        int posterHeight = 160;
        int x1 = 10; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int x2 = 190; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int y1 = 30; // 패널의 위쪽 모서리에서부터의 y 좌표
        int y2 = 250; // 패널의 위쪽 모서리에서부터의 y 좌표

        int startIndex = 14;
        int endIndex = 18;

        for (int i = startIndex; i < endIndex; i++) {
            int x = (i % 2 == 0) ? x1 : x2;
            int y = (i < startIndex + 2) ? y1 : y2;

            ArtGalleryInfo posterInfo = posterInfoList.get(i);

            ImageIcon originalIcon9 = new ImageIcon(posterInfoList.get(i).getImageURL());
            Image originalImage9 = originalIcon9.getImage();
            Image scaledImage9 = originalImage9.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            ImageIcon posterImage1 = new ImageIcon(scaledImage9);
            JButton posterImage = new JButton(posterImage1);
            posterImage.setBounds(x, y, 140, posterHeight);
            posterImage.setBorderPainted(false);
            posterImage.setContentAreaFilled(false);
            posterPanel.add(posterImage);

            JLabel posterTitle = new JLabel(posterInfo.getArtName());
            posterTitle.setBounds(x + 20, y + 170, posterWidth, 20);
            customFont = customFont.deriveFont(Font.BOLD, 14);
            posterTitle.setFont(customFont);
            posterPanel.add(posterTitle);

            JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
            posterDate.setBounds(x + 20, y + 190, posterWidth, 20);
            customFont = customFont.deriveFont(Font.PLAIN, 8);
            posterDate.setFont(customFont);
            posterPanel.add(posterDate);

            posterImage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i = 0; i < posterInfoList.size(); i++) {
                        if (posterInfo.getImageURL().equals(posterInfoList.get(i).getImageURL())) {
                            System.out.println(posterInfoList.get(i).getArtName());							// 클릭 이미지 전시회이름 출력
                            
                            Window window = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                            if (window != null) {
                                window.dispose(); 
                            }
                            
                            FrameBase.getInstance(new FramePosterClick(e,posterInfo.getArtName()));			// 해당전시 페이지 출력
                        }
                    }
                }
            });
        }

        
        
        JButton back = new JButton();
		back.setSize(50,40);
		back.setLocation(30,640);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());	// 현재 창 닫기
                if (window1 != null) {
                    window1.dispose(); 
                }
				FrameBase.getInstance(new Home());
				
			}
		});
		
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

        
        }
        
    


}
