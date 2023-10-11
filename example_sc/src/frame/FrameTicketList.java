package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import controller.member.MemberToken;
import model.member.ArtReserInfo;
import model.member.Member;

public class FrameTicketList extends JPanel{
	
	private int currentPage=0; // 현재 페이지 인덱스
    private int postersPerPage=4; // 한 페이지당 포스터 개수
    private int totalPosters; // 전체 포스터 개수
    private int totalPages = (int) Math.ceil((double) totalPosters / postersPerPage); // 총 페이지 수
    ArrayList<ArtReserInfo> idReserlist;
	public FrameTicketList(String id)
	{
		// JPanel 구조 설정
        setBackground(Color.white);
        setLayout(null);
        setSize(400, 700);
        
        ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

        JLabel menuline = new JLabel(menuLine); // 메뉴선
        JLabel text = new JLabel("티켓 "); 
        
        text.setSize(200,50);
        text.setLocation(40, 60);
        text.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 30));
        
        menuline.setSize(380, 5);
        menuline.setLocation(10, text.getY() + text.getHeight());
        
        add(text);
        add(menuline);  
        System.out.println(menuline.getY() + menuline.getHeight());
        //back 버튼
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

		//리스트 만들기 
		Member m = new Member();
        
        idReserlist = new ArrayList<ArtReserInfo>();
        
        System.out.println("티켓 페이지 ");
        
        idReserlist =m.getTiketList(); // 내 티켓 정보 리스트 가져옴 
        
        for(int i=0;i<idReserlist.size();i++)
        {
        	System.out.println("예약한 제목 "+ idReserlist.get(i).getA().getArtName());
        	System.out.println("예약한 날짜 "+ idReserlist.get(i).getReserveDate());
	        	
        }
        totalPosters= idReserlist.size();
		
        updatePosters( currentPage, postersPerPage, totalPosters, totalPages);
		

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
		
		
		
	}
	
	
	private void updatePosters(int currentPage,int postersPerPage,int totalPosters, int totalPages) {

		//removeAll();
       // revalidate();
       // repaint();
        
        // 전역으로 사용할 다음 페이지 이동 버튼
        ImageIcon originalIcon5 = new ImageIcon("./src/img/다음.png");
        Image originalImage5 = originalIcon5.getImage();
        Image scaledImage5 = originalImage5.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon nextpage = new ImageIcon(scaledImage5);

        // 전역으로 사용할 이전 페이지 이동 버튼
        ImageIcon originalIcon6 = new ImageIcon("./src/img/이전.png");
        Image originalImage6 = originalIcon6.getImage();
        Image scaledImage6 = originalImage6.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        ImageIcon prepage = new ImageIcon(scaledImage6);

        /*
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
	*/
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        int posterWidth = 60;
        int posterHeight = 80;
        
        //int startIndex = 0;
        //int endIndex = 1;//Math.min(startIndex + postersPerPage, idReserlist.size());

        // 포스터 개수 확인용
        //System.out.println("posterInfoList.size(): "+posterInfoList.size());
        
        List<ArtGalleryInfo> filteredList = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            
            ArtReserInfo posterInfo = idReserlist.get(i);
            	int x= 10; // 시작 
            	int y= 115;
                //filteredList.add(posterInfo);

                ImageIcon originalIcon9 = new ImageIcon(posterInfo.getA().getImageURL());
                Image originalImage9 = originalIcon9.getImage();
                Image scaledImage9 = originalImage9.getScaledInstance(posterWidth, posterHeight, Image.SCALE_SMOOTH);
                ImageIcon posterImage1 = new ImageIcon(scaledImage9);
                JLabel posterImage = new JLabel(posterImage1);
                
                add(posterImage);
                //System.out.println("posterImage 1 : "+posterInfo.getImageURL());

                JLabel posterTitle = new JLabel(posterInfo.getA().getArtName());
                posterTitle.setBounds(10, 135, posterWidth, 100);
                posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
                add(posterTitle);

                ImageIcon infoclickimg = new ImageIcon("./src/img/info_btn.png");
                Image infoclick = originalImage9.getScaledInstance(posterWidth, posterHeight, Image.SCALE_SMOOTH);
                //ImageIcon infoclickimgscale = new Ima
                //geIcon(scaledImage9);
                JButton infoclick_btn = new JButton(posterImage1);
               // infoclick_btn.setBounds(x, y, 140, posterHeight);
                infoclick_btn.setBorderPainted(false);
                infoclick_btn.setContentAreaFilled(false);
                add(infoclick_btn);
                
                ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

                JLabel menuline = new JLabel(menuLine); // 메뉴선
                menuline.setSize(380, 5);
                menuline.setLocation(10, infoclick_btn.getY() + infoclick_btn.getHeight());

                add(menuline);  
                

                
            }
	
    }
}
