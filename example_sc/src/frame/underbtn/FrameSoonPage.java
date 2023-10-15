package frame.underbtn;

import javax.swing.*;
import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import frame.base.FrameBase;
import frame.home.FramePosterClick;
import frame.home.FramePosterClick_Soon;
import model.member.Member;
import frame.home.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

public class FrameSoonPage extends JPanel {

    private List<ArtGalleryInfo> posterInfoList; // 전체 포스터 정보 리스트


    public FrameSoonPage() {
    	// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
    	// 이미지
        ImageIcon imageSearch = new ImageIcon("./src/img/30.png");
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

        JButton btnSearch = new JButton(imageSearch); // 검색 버튼
        JLabel menuline = new JLabel(menuLine); // 메뉴선
        
        JLabel text = new JLabel("전시 예정"); 
        
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
    	
        setVisible(true);
 
        SoonListPanel listpanel = new SoonListPanel();
        add(listpanel);

   
    }


}
