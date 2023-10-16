package frame.reserve;

import javax.swing.*;

import artDB.ArtGalleryInfo;
import frame.base.FrameBase;
import frame.home.FramePosterClick;
import frame.home.Home;
import frame.home.ListPanel;
import model.member.ArtReserInfo;
import model.member.ArtReserInfoList;
import model.member.Member;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGalleryConfirm extends JFrame {
    private FramePosterClick framePosterClick;
    private ArtGalleryInfo info;
    
    public FrameGalleryConfirm() {
    	
    }
	public FrameGalleryConfirm(String selectedName, String selectedDate, String selectedTime, int selectedTicket,ArtGalleryInfo info) {
    	 this.framePosterClick = framePosterClick; // FramePosterClick 인스턴스 초기화
    	 this.info = info;
    	 String totalfee;
    	 
    	// 프레임 설정
    	Toolkit tk = Toolkit.getDefaultToolkit();//해상도
        setTitle("예약 확인");
        setSize(300, 200); // 크기를 더 크게 조정
        setBounds(((int) tk.getScreenSize().getWidth() / 3 + 60), 
				((int) tk.getScreenSize().getHeight()) / 2 - 200,
				300, 200);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        // 패널 생성
        JPanel confirmPanel = new JPanel(new GridLayout(6, 1)); // GridLayout을 사용하여 컴포넌트들을 세로로 배치

        // 라벨들 생성 및 추가
        confirmPanel.add(new JLabel("전시회 이름: " + selectedName));
        confirmPanel.add(new JLabel("예약 날짜: " + selectedDate));
        confirmPanel.add(new JLabel("예약 시간: " + selectedTime));
        confirmPanel.add(new JLabel("티켓 개수: " + selectedTicket));

        if(info.getFee().equals("무료")) {
        	totalfee = info.getFee();
        	confirmPanel.add(new JLabel("총 가격: " + totalfee));
        } else {

        	String feeWithComma = info.getFee(); // 예: "15,000"
        	String feeWithoutComma = feeWithComma.replaceAll(",", ""); // 쉼표 제거: "15000"
        	int fee = Integer.parseInt(feeWithoutComma); // 정수로 변환
        	int feeInt = fee * selectedTicket; // 계산
        	totalfee = Integer.toString(feeInt); // 결과를 문자열로 변환

        	confirmPanel.add(new JLabel("총 가격: " + totalfee));
        }
        
      //취소 버튼 생성 및 추가
        ImageIcon originalIcon13 = new ImageIcon("./src/img/취소.png");
        Image originalImage13 = originalIcon13.getImage();
        Image scaledImage13 = originalImage13.getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        ImageIcon posterImage13 = new ImageIcon(scaledImage13);
        JButton closebtn = new JButton(posterImage13);
        
        closebtn.setBorderPainted(false);
        closebtn.setContentAreaFilled(false);
        closebtn.setFocusPainted(false);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        
        // 취소 버튼 호버
        ImageIcon closbtn1 = new ImageIcon("./src/img/취소hover.png");
        Image scaledHoverImage12 = closbtn1.getImage().getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        closebtn.setRolloverIcon(new ImageIcon(scaledHoverImage12));
        
        closebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
        
        
        
        
     // 닫기 버튼 생성 및 추가
        ImageIcon originalIcon10 = new ImageIcon("./src/img/확인1.png");
        Image originalImage10 = originalIcon10.getImage();
        Image scaledImage10 = originalImage10.getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        ImageIcon posterImage10 = new ImageIcon(scaledImage10);
        JButton paymentbtn = new JButton(posterImage10);
        paymentbtn.setBorderPainted(false);
        paymentbtn.setContentAreaFilled(false);
        paymentbtn.setFocusPainted(false);
        
        // 예약버튼 호버
        ImageIcon reserveButton1 = new ImageIcon("./src/img/확인1hover.png");
        Image scaledHoverImage1 = reserveButton1.getImage().getScaledInstance(120, 30, Image.SCALE_SMOOTH);
        paymentbtn.setRolloverIcon(new ImageIcon(scaledHoverImage1));
        
        paymentbtn.addActionListener(new ActionListener() {
        	
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	ArtReserInfo reservation = new ArtReserInfo(Member.tokeniD, info, selectedTime, selectedDate, selectedTicket,totalfee);

                ArtReserInfoList artReserInfoList = new ArtReserInfoList();

                ArtReserInfoList.addReservation(reservation);
                
                info.addCnt(selectedTicket);         

                dispose(); // 현재 창 닫기
                
                FrameBase.getInstance(new Home(ListPanel.whatfiltername));
                
                
                
            }
        });
        buttonPanel.add(paymentbtn);
        buttonPanel.add(closebtn);
        confirmPanel.add(buttonPanel);

        add(confirmPanel); // 패널을 프레임에 추가

        setVisible(true); // 프레임 보이게 설정
    }

	@Override
	public void dispose() {
		super.dispose();
	}

	
}