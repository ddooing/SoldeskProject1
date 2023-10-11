package frame;

import javax.swing.*;
import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import model.member.Member;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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


    public FrameSoonPage() {
    	/*
    	 setLayout(null);
    	    setBackground(Color.pink);
    	    setSize(361,500); // ListPanel 과 같은 사이즈 
    	    setLocation(20, 135);
    	  */
    	setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        // ArtGalleryList 객체 생성
        ArtGalleryList artgallerylist = new ArtGalleryList();
        posterInfoList = artgallerylist.getsoonPosters();
        this.totalPosters = posterInfoList.size();
        this.totalPages = (int) Math.ceil((double) totalPosters / postersPerPage);
        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
     
        updatePosters();
   
    }

    private void updatePosters() {

    	// 이미지
        ImageIcon imageSearch = new ImageIcon("./src/img/30.png");
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선
        
        JLabel text = new JLabel("전시 예정"); //!!
        
        text.setSize(200,50);
        text.setLocation(40, 40);
        text.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 30));
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
        btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.windowForComponent((Component) e.getSource()); // 현재 창 닫기
                if (window != null) {
                    window.dispose();
                }
				//새로운 FrameBase창 생성
				FrameBase.getInstance(new FrameSearch_1());
			}
		});
        
    	
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int posterWidth = 120;
        int posterHeight = 160;
        //setLocation(20, 135);
        int x1 = 30;//10; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int x2 = 200;//190; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int y1 = 165;//30; // 패널의 위쪽 모서리에서부터의 y 좌표
        int y2 = 385;//250; // 패널의 위쪽 모서리에서부터의 y 좌표

        int startIndex = currentPage * postersPerPage;
        int endIndex = Math.min(startIndex + postersPerPage, posterInfoList.size());


        for (int i = startIndex; i < endIndex; i++) {
            int x = (i % 2 == 0) ? x1 +15: x2 +15;
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
            add(posterImage);

            JLabel posterTitle = new JLabel(posterInfo.getArtName());
            posterTitle.setBounds(x + 10, y + 170, posterWidth, 20);
            posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
            add(posterTitle);

            JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
            posterDate.setBounds(x + 10, y + 190, posterWidth, 20);
            posterDate.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
            add(posterDate);

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
                            
                        }
                    }
                }
            });
        }

        
        
        

        
        }
        
    


}
