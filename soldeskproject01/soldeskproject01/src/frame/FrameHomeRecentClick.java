package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;

public class FrameHomeRecentClick extends JPanel {

    private JPanel posterPanel;
    private int currentPage = 0; // 현재 페이지 인덱스
    private int postersPerPage = 4; // 한 페이지당 포스터 개수
    private int totalPosters = 18; // 전체 포스터 개수
    private int totalPages = (int) Math.ceil((double) totalPosters / postersPerPage); // 총 페이지 수
    private List<ArtGalleryInfo> posterInfoList; // 전체 포스터 정보 리스트
    private List<ArtGalleryInfo> filteredList; // getcnt() 값이 0이 아닌 포스터 정보 리스트

    public FrameHomeRecentClick() {
        this(null);
    }

    public FrameHomeRecentClick(JPanel homePanel) {
        // 포스터 넣는곳 패널 새로 생성
        posterPanel = new JPanel();
        posterPanel.setLayout(null);
        posterPanel.setBackground(Color.white);
        posterPanel.setSize(361, 500);
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

        // posterInfoList를 최대 14개까지로 자르기
        if (posterInfoList.size() > 18) {
            posterInfoList = posterInfoList.subList(0, 18);
        }

        // getcnt() 값이 0이 아닌 항목만을 포함하는 리스트 생성
        filteredList = new ArrayList<>();
        for (ArtGalleryInfo info : posterInfoList) {
            if (info.getCnt() != 0) {
                filteredList.add(info);
            }
        }

        // 여기서 posterInfoList를 최신 날짜를 기준으로 정렬합니다.
        Collections.sort(posterInfoList, new Comparator<ArtGalleryInfo>() {
            @Override
            public int compare(ArtGalleryInfo o1, ArtGalleryInfo o2) {
                // 날짜를 비교하여 내림차순 정렬
                return o2.getDateEnd().compareTo(o1.getDateEnd());
            }
        });

        updatePosters();
    }

    private void updatePosters() {
        posterPanel.removeAll();
        posterPanel.revalidate();
        posterPanel.repaint();

        // 이미지
        ImageIcon imageSearch = new ImageIcon("./src/30.png");
        ImageIcon menuLine = new ImageIcon("./src/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선

        btnSearch.setSize(50, 50);
        btnSearch.setLocation(310, 40);
        btnSearch.setBorderPainted(false); // 버튼 외각선 지우기
        btnSearch.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        btnSearch.setFocusPainted(false); // 버튼 선택 표시 지우기

        menuline.setSize(380, 5);
        menuline.setLocation(10, btnSearch.getY() + btnSearch.getHeight());

        int btnsHeight = menuline.getY() + menuline.getHeight() + 10;

        // 필터 버튼 (인기, 최신, 무료, 곧 종료) 추가
        ImageIcon originalIcon1 = new ImageIcon("./src/인기클릭.png");
        Image scaledImage1 = originalIcon1.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon one = new ImageIcon(scaledImage1);
        JButton one1 = new JButton(one);
        one1.setBounds(30, btnsHeight, 60, 30);
        one1.setContentAreaFilled(false);
        one1.setBorderPainted(false);
        add(one1);

        ImageIcon originalIcon2 = new ImageIcon("./src/최신.png");
        Image scaledImage2 = originalIcon2.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon two = new ImageIcon(scaledImage2);
        JButton two2 = new JButton(two);
        two2.setBounds(one1.getX() + one1.getWidth() + 5, btnsHeight, 60, 30);
        two2.setContentAreaFilled(false);
        two2.setBorderPainted(false);
        add(two2);

        ImageIcon originalIcon3 = new ImageIcon("./src/무료.png");
        Image scaledImage3 = originalIcon3.getImage().getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon three = new ImageIcon(scaledImage3);
        JButton three3 = new JButton(three);
        three3.setBounds(two2.getX() + two2.getWidth() + 5, btnsHeight, 60, 30);
        three3.setContentAreaFilled(false);
        three3.setBorderPainted(false);
        add(three3);

        ImageIcon originalIcon4 = new ImageIcon("./src/곧종료.png");
        Image scaledImage4 = originalIcon4.getImage().getScaledInstance(80, 30, Image.SCALE_SMOOTH);
        ImageIcon four = new ImageIcon(scaledImage4);
        JButton four4 = new JButton(four);
        four4.setBounds(three3.getX() + three3.getWidth() + 5, btnsHeight, 80, 30);
        four4.setContentAreaFilled(false);
        four4.setBorderPainted(false);
        add(four4);

        one1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());    // 현재 창 닫기
                if (window1 != null) {
                    window1.dispose();
                }
                FrameBase.getInstance(new Home());
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
                Window window1 = SwingUtilities.windowForComponent((Component) e.getSource());    // 현재 창 닫기
                if (window1 != null) {
                    window1.dispose();
                }
                FrameBase.getInstance(new FrameHomeFreeClick());
            }
        });

        four4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            }
        });

        // 전역으로 사용할 다음 페이지 이동 버튼
        ImageIcon originalIcon5 = new ImageIcon("./src/다음페이지.png");
        Image originalImage5 = originalIcon5.getImage();
        Image scaledImage5 = originalImage5.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon nextpage = new ImageIcon(scaledImage5);

        // 전역으로 사용할 이전 페이지 이동 버튼
        ImageIcon originalIcon6 = new ImageIcon("./src/이전페이지.png");
        Image originalImage6 = originalIcon6.getImage();
        Image scaledImage6 = originalImage6.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon prepage = new ImageIcon(scaledImage6);

        // "다음 페이지" 버튼 생성
        JButton nextpageButton = new JButton(nextpage);
        nextpageButton.setBounds(310, 460, 40, 30);
        nextpageButton.setContentAreaFilled(false);
        nextpageButton.setBorderPainted(false);
        nextpageButton.setFocusPainted(false);

        // "이전 페이지" 버튼 생성
        JButton prepageButton = new JButton(prepage);
        prepageButton.setBounds(10, 460, 40, 30);
        prepageButton.setContentAreaFilled(false);
        prepageButton.setBorderPainted(false);
        prepageButton.setFocusPainted(false);

        nextpageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 다음 페이지로 이동
                if (currentPage < totalPages - 1) { // 다음 페이지로 이동 가능한 경우에만 이동
                    prepageButton.setEnabled(true);
                    currentPage++;
                    updatePosters();
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
                    currentPage--;
                    updatePosters();
                    System.out.println("이전페이지 클릭");
                }
            }
        });

        // "이전 페이지" 버튼을 초기에 비활성화
        prepageButton.setEnabled(false);

        // 컴포넌트 추가
        add(btnSearch);
        add(menuline);
        posterPanel.add(nextpageButton);
        posterPanel.add(prepageButton);
        
        
        
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

        int startIndex = currentPage * postersPerPage;
        int endIndex = Math.min(startIndex + postersPerPage, filteredList.size());

        for (int i = startIndex; i < endIndex; i++) {
            int x = (i % 2 == 0) ? x1 : x2;
            int y = (i < startIndex + 2) ? y1 : y2;

            ArtGalleryInfo posterInfo = filteredList.get(i);

            JButton posterImage = new JButton(HtmlItils1.imgHtmlParser(posterInfo.getImageURL()));
            posterImage.setBounds(x, y, 140, posterHeight);
            posterImage.setBorderPainted(false);
            posterImage.setContentAreaFilled(false);
            posterPanel.add(posterImage);

            JLabel posterTitle = new JLabel(posterInfo.getArtName());
            posterTitle.setBounds(x + 20, y + 170, posterWidth, 20);
            posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
            posterPanel.add(posterTitle);

            JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
            posterDate.setBounds(x + 20, y + 190, posterWidth, 20);
            posterDate.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 8));
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