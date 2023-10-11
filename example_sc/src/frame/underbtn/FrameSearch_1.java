package frame.underbtn;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.io.File;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import frame.base.FrameBase;
import frame.home.FramePosterClick;
import frame.home.Home;
import model.member.Member;

public class FrameSearch_1 extends JPanel {

    private JPanel posterPanel;
    private int currentPage = 0; // 현재 페이지 인덱스
    private int postersPerPage = 4; // 한 페이지당 포스터 개수
    private int totalPosters = 14; // 전체 포스터 개수
    private int totalPages = (int) Math.ceil((double) totalPosters / postersPerPage); // 총 페이지 수
    private List<ArtGalleryInfo> posterInfoList; // 전체 포스터 정보 리스트
    private List<ArtGalleryInfo> filteredList; // getcnt() 값이 0이 아닌 포스터 정보 리스트
    private String searchText; // 텍스트 필드의 내용을 저장할 변수
    private JTextField textField; // 텍스트 필드를 인스턴스 변수로 선언
    String fontFilePath = "src/font/Orbit-regular.ttf"; // ttf 파일 경로

    public FrameSearch_1() {
        this(null);
    }

    
    public FrameSearch_1(JPanel homePanel) {
        // 포스터 넣는 곳 패널 새로 생성
        posterPanel = new JPanel();
        posterPanel.setLayout(null);
        posterPanel.setBackground(Color.white);
        posterPanel.setSize(361, 500);
        posterPanel.setLocation(20, 135);
        posterPanel.setVisible(true);
        add(posterPanel);

        // ArtGalleryList 객체 생성
        ArtGalleryList artgallerylist = new ArtGalleryList();
        posterInfoList = artgallerylist.getPosters();

        // filteredList 초기화
        filteredList = new ArrayList<>();

        // JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);

        // 텍스트 필드 생성
        textField = new JTextField();
        textField.setColumns(20);

        // 플레이스홀더 설정
        String placeholderText = "전시회, 전시관 검색";
        textField.setText(placeholderText);
        textField.setForeground(Color.GRAY);

        // 텍스트 필드 위치 설정
        textField.setBounds(30, 90, 280, 30);

        // 텍스트 필드 폰트 설정
        Font customFont = new Font("맑은 고딕", Font.BOLD, 14); // 원하는 폰트 설정
        textField.setFont(customFont);

        // 텍스트 필드를 포커스를 받을 수 없도록 설정
        textField.setFocusable(true);
        add(textField);

        // 포커스 이벤트 리스너 추가
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholderText)) {
                    textField.setFocusable(true); // 포커스를 받을 수 있도록 변경
                    textField.setText("");
                    textField.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setFocusable(false); // 포커스를 받을 수 없도록 변경
                    textField.setText(placeholderText);
                    textField.setForeground(Color.GRAY);
                } else {
                    // 텍스트 필드 내용을 searchText 변수에 저장
                    searchText = textField.getText();
                }
            }
        });
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Enter 키가 눌렸을 때 검색 수행
                performSearch(textField.getText());
            }
        });

        

        updatePosters();
    }

    private void updatePosters() {
        posterPanel.removeAll();
        posterPanel.revalidate();
        posterPanel.repaint();

        // 이미지
        ImageIcon imageSearch = new ImageIcon("./src/img/30.png");
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선

        btnSearch.setSize(50, 50);
        btnSearch.setLocation(310, 80);
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
				// TODO Auto-generated method stub
				performSearch(textField.getText());
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
            int x = (i % 2 == 0) ? x1 +10: x2 +10;
            int y = (i < startIndex + 2) ? y1 : y2;

            ArtGalleryInfo posterInfo = filteredList.get(i);

            ImageIcon originalIcon9 = new ImageIcon(posterInfo.getImageURL());
            Image originalImage9 = originalIcon9.getImage();
            Image scaledImage9 = originalImage9.getScaledInstance(120, 160, Image.SCALE_SMOOTH);
            ImageIcon posterImage1 = new ImageIcon(scaledImage9);
            JButton posterImage = new JButton(posterImage1);
            posterImage.setBounds(x, y, 140, posterHeight);
            posterImage.setBorderPainted(false);
            posterImage.setContentAreaFilled(false);
            posterPanel.add(posterImage);

            JLabel posterTitle = new JLabel(posterInfo.getArtName());
            posterTitle.setBounds(x + 10, y + 170, posterWidth, 20);
            try {
                // TTF 파일을 읽어서 Font 객체 생성
                Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));

                // 원하는 폰트 스타일과 크기로 설정
                customFont = customFont.deriveFont(Font.BOLD, 14); // 크기 24, 평범한 스타일로 설정
            posterTitle.setFont(customFont);
            posterPanel.add(posterTitle);

            JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
            posterDate.setBounds(x + 10, y + 190, posterWidth, 20);
            customFont = customFont.deriveFont(Font.PLAIN, 8);
            posterDate.setFont(customFont);
            posterPanel.add(posterDate);
            } catch (IOException | FontFormatException e) {
                e.printStackTrace();
            }

            posterImage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 포스터 눌렀을 때
                    
                    for (int i = 0; i < filteredList.size(); i++) {
                        if (posterInfo.getImageURL().equals(filteredList.get(i).getImageURL())) {
                            System.out.println(filteredList.get(i).getArtName()); // 클릭 이미지 전시회이름 출력

                            Window window = SwingUtilities.windowForComponent((Component) e.getSource()); // 현재 창 닫기
                            if (window != null) {
                                window.dispose();
                            }

                            FrameBase.getInstance(new FramePosterClick(Member.tokeniD,posterInfo.getArtName(),"FrameSearch_1")); // 해당전시 페이지 출력
                        }
                    }

                }
            });
        }
        
        ImageIcon originalIcon9 = new ImageIcon("./src/뒤로가기.png");
        Image originalImage9 = originalIcon9.getImage();
        Image scaledImage9 = originalImage9.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ImageIcon posterImage1 = new ImageIcon(scaledImage9);
        JButton back = new JButton(posterImage1);
		back.setSize(50,40);
		back.setLocation(30,30);
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
		
    }

    // 검색어를 이용하여 필터링
    private void performSearch(String searchText) {
        // searchText를 이용하여 검색을 수행하고, 검색 결과를 filteredList에 업데이트하는 코드를 작성
        // 이 부분에서 필터링된 포스터 정보를 가져와서 filteredList에 추가하면 됩니다.

        // 검색 결과를 초기화
        filteredList.clear();

        // 검색어 필터링 기능을 추가
        // 필터링하여 filteredList에 추가
        for (ArtGalleryInfo posterInfo : posterInfoList) {
            String artName = posterInfo.getArtName();
            String place = posterInfo.getPlace();

            // 검색어가 null이 아니고, 포스터 정보에 해당 검색어가 포함되어 있으면 filteredList에 추가
            if (searchText != null && (artName != null && artName.contains(searchText)) || (place != null && place.contains(searchText))) {
                filteredList.add(posterInfo);
            }
        }

        // 검색 결과에 따라 포스터를 업데이트
        updatePosters();
    }
}
