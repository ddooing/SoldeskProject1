package frame;

import javax.swing.*;

import artDB.ArtGalleryInfo;
import model.member.ArtReserInfo;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FrameInqueryPage extends JPanel {
	
	private ArtReserInfo reservation; // 예약 정보를 저장할 변수

	 public FrameInqueryPage(ArtReserInfo reservation) {
	        this.reservation = reservation; // 생성자에서 예약 정보를 전달받음
	        setLayout(null);
	        setSize(400, 700);
	        
	        // 이미지 표시
	        JLabel imageLabel = new JLabel("예약된 작품 이미지"); // 예약된 작품 이미지를 표시
	        imageLabel.setBackground(Color.white);
	        imageLabel.setSize(360,280);
	        imageLabel.setLocation(20, 70);
	        add(imageLabel);

	        JLabel artNameLabel = new JLabel(reservation.getA().getArtName());
	        artNameLabel.setBounds(30, 360, 400, 30);
	        add(artNameLabel);
	        
	        JLabel artplace = new JLabel(reservation.getA().getPlace());
	        artplace.setBounds(30, 410, 400, 60);
	        add(artplace);

	        JLabel dateLabel = new JLabel(reservation.getReserveDate());
	        dateLabel.setBounds(30, 500, 400, 70);
	        add(dateLabel);

	        // 구분선 추가
	        JSeparator separator1 = new JSeparator();
	        separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
	        separator1.setForeground(Color.BLACK);
	        add(separator1);

			JSeparator separator2 = new JSeparator();
			separator2.setBounds(20, 490, 360, 10); // 구분선의 위치와 크기 조정
			separator2.setForeground(Color.BLACK); 
			add(separator2);
	        
	        JLabel timeLabel = new JLabel(reservation.getReseveTime());
	        timeLabel.setBounds(20, 420, 200, 20);
	        add(timeLabel);

	        JLabel ticketLabel = new JLabel(reservation.getReserverInt() + "장");
	        ticketLabel.setBounds(20, 450, 200, 20);
	        add(ticketLabel);

	        // 뒤로 가는 버튼
	        JButton backButton = new JButton("뒤로 가기");
	        backButton.setBounds(30, 640, 50, 40);
	        add(backButton);

	        backButton.addActionListener(e -> {
	            // 뒤로 가기 버튼을 클릭하면 FrameTicketList 페이지로 이동
	            FrameTicketList frameTicketList = new FrameTicketList(); // FrameTicketList 페이지의 인스턴스 생성
	            JFrame frame = new JFrame("티켓 목록"); // JFrame 생성
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 창만 닫도록 설정
	            frame.add(frameTicketList); // FrameTicketList 페이지를 JFrame에 추가
	            frame.setSize(400, 700);
	            frame.setVisible(true);
	            
	            // 현재 창 닫기
	            Window currentWindow = SwingUtilities.windowForComponent(this);
	            if (currentWindow != null) {
	                currentWindow.dispose();
	            }
	        });
	        
	 
    }

}
