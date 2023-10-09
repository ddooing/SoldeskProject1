package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListPanel extends JPanel {

	private int currentPage=0; // 현재 페이지 인덱스
    private int postersPerPage=4; // 한 페이지당 포스터 개수
    private int totalPosters; // 전체 포스터 개수
    private int totalPages = (int) Math.ceil((double) totalPosters / postersPerPage); // 총 페이지 수
    private List<ArtGalleryInfo> posterInfoList; // 전체 포스터 정보 리스트
    List<ArtGalleryInfo> filteredPosterInfoList;

    public List<ArtGalleryInfo> getFreeList(String filtername) { //전시회 리스트 가져오기

        ArtGalleryList artgallerylist = new ArtGalleryList();

        // 필터링된 포스터 정보를 담을 리스트
        filteredPosterInfoList = new ArrayList<>();
        
        if(filtername == "최신")
        {
        	filteredPosterInfoList=artgallerylist.getSortByDateStart();
        }else if(filtername == "인기")
        {
        	filteredPosterInfoList = artgallerylist.getPopulaPosters();            
        }
        else if(filtername == "무료")
        {
        	filteredPosterInfoList = artgallerylist.getFreePosters(); 
        }
        else if(filtername == "곧종료")
        {
            filteredPosterInfoList = artgallerylist.getsoonEndPosters();
            
            
        }else if(filtername == "")
        {
        	filteredPosterInfoList = artgallerylist.getPosters();
        }
        
        this.totalPosters = filteredPosterInfoList.size();
        this.totalPages = (int) Math.ceil((double) totalPosters / postersPerPage);
        
        return filteredPosterInfoList;
    }
    
    
	public ListPanel(String filtername) {
		// 패널의 위치와 크기 설정
		setSize(361,500);
		setLocation(20, 137);
		setLayout(null);
	    setBackground(new Color(241, 239, 239));//new Color(250, 241, 228) Color.white
	    
        posterInfoList = getFreeList(filtername); // 필터링된 포스터 정보를 사용
        updatePosters(currentPage, postersPerPage,totalPosters,totalPages);
        
        /*
         * 필터링된 리스트 확인용
        for(ArtGalleryInfo a:posterInfoList )
		{
			System.out.println("posterInfoList : "+ a.toString());
		}
		*/
        
        
	}
	
	private void updatePosters(int currentPage,int postersPerPage,int totalPosters, int totalPages) {

		removeAll();
        revalidate();
        repaint();
        
        // 전역으로 사용할 다음 페이지 이동 버튼
        ImageIcon originalIcon5 = new ImageIcon("./src/다음.png");
        Image originalImage5 = originalIcon5.getImage();
        Image scaledImage5 = originalImage5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon nextpage = new ImageIcon(scaledImage5);

        // 전역으로 사용할 이전 페이지 이동 버튼
        ImageIcon originalIcon6 = new ImageIcon("./src/이전.png");
        Image originalImage6 = originalIcon6.getImage();
        Image scaledImage6 = originalImage6.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prepage = new ImageIcon(scaledImage6);

        // "다음 페이지" 버튼 생성
        JButton nextpageButton = new JButton(nextpage);
        nextpageButton.setBounds(310, 460, 30, 30);
        nextpageButton.setContentAreaFilled(false);
        nextpageButton.setBorderPainted(false);
        nextpageButton.setFocusPainted(false);

        // "이전 페이지" 버튼 생성
        JButton prepageButton = new JButton(prepage);
        prepageButton.setBounds(20, 460, 30, 30);
        prepageButton.setContentAreaFilled(false);
        prepageButton.setBorderPainted(false);
        prepageButton.setFocusPainted(false);

        nextpageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 다음 페이지로 이동
                if (currentPage < totalPages - 1) { // 다음 페이지로 이동 가능한 경우에만 이동
                    prepageButton.setEnabled(true);
                    int currentPagesPlus = currentPage+1;
                    updatePosters(currentPagesPlus, postersPerPage, totalPosters, totalPages);
                    System.out.println("다음페이지 클릭");
                }
            }
        });

        // "이전 페이지" 버튼에 ActionListener 추가
        prepageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 이전 페이지로 이동
                if (currentPage > 0) { // 이전 페이지로 이동 가능한 경우에만 이동
                	int currentPagesMinus = currentPage-1;
                    updatePosters(currentPagesMinus, postersPerPage, totalPosters, totalPages);
                    System.out.println("이전페이지 클릭");
                }
            }
        });

        // "이전 페이지" 버튼을 초기에 비활성화
        prepageButton.setEnabled(false);

        // 컴포넌트 추가
        //add(btnSearch);
        add(nextpageButton);
        add(prepageButton);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int posterWidth = 120;
        int posterHeight = 160;
        int x1 = 10; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int x2 = 190; // 패널의 왼쪽 모서리에서부터의 x 좌표
        int y1 = 15; // 패널의 위쪽 모서리에서부터의 y 좌표
        int y2 = 250; // 패널의 위쪽 모서리에서부터의 y 좌표

        int startIndex = currentPage * postersPerPage;
        int endIndex = Math.min(startIndex + postersPerPage, posterInfoList.size());

        // 포스터 개수 확인용
        //System.out.println("posterInfoList.size(): "+posterInfoList.size());
        
        List<ArtGalleryInfo> filteredList = new ArrayList<>();

        for (int i = startIndex; i < endIndex; i++) {
            int x = (i % 2 == 0) ? x1 : x2;
            int y = (i < startIndex + 2) ? y1 : y2;

            ArtGalleryInfo posterInfo = posterInfoList.get(i);
            
                filteredList.add(posterInfo);

                JButton posterImage = new JButton(HtmlItils1.imgHtmlParser(posterInfo.getImageURL()));
                posterImage.setBounds(x, y, 140, posterHeight);
                posterImage.setBorderPainted(false);
                posterImage.setContentAreaFilled(false);
                add(posterImage);
                //System.out.println("posterImage 1 : "+posterInfo.getImageURL());

                JLabel posterTitle = new JLabel(posterInfo.getArtName());
                posterTitle.setBounds(x + 20, y + 160, posterWidth, 20);
                posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
                add(posterTitle);
                
                JLabel posterplace = new JLabel(posterInfo.getPlace());
                posterplace.setBounds(x + 20, y + 175, posterWidth, 20);
                posterplace.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 10));
                add(posterplace);
                
                JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
                posterDate.setBounds(x + 20, y + 190, posterWidth, 20);
                posterDate.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 10));
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
                                
                                FrameBase.getInstance(new FramePosterClick(e,posterInfo.getArtName()));			// 해당전시 페이지 출력
                            }
                        }			
                    }
                });
            }
        

        // 다음,이전 페이지 버튼을 표시할지 여부를 결정
        if (endIndex < filteredList.size()) {
            nextpageButton.setVisible(true);
        } else {
            nextpageButton.setVisible(false);
        }

        if (currentPage > 0) {
            prepageButton.setEnabled(true);
            prepageButton.setVisible(true);

        } else {
            prepageButton.setEnabled(false);
            prepageButton.setVisible(false);
        }

        if (currentPage < totalPages - 1) {
            nextpageButton.setVisible(true);
        } else {
            nextpageButton.setVisible(false);
        }
        
		
		
    }

}