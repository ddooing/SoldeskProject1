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
	        imageLabel.setSize(360, 250);
	        imageLabel.setLocation(20, 70);
	        add(imageLabel);

	        // 예약 정보 표시
	        JLabel idLabel = new JLabel("예약자 ID: " + reservation.getId());
	        idLabel.setBounds(20, 330, 200, 20);
	        add(idLabel);

	        JLabel artNameLabel = new JLabel("예약된 작품: " + reservation.getA().getArtName());
	        artNameLabel.setBounds(20, 360, 300, 20);
	        add(artNameLabel);

	        JLabel dateLabel = new JLabel("예약일: " + reservation.getReserveDate());
	        dateLabel.setBounds(20, 390, 200, 20);
	        add(dateLabel);

	        JLabel timeLabel = new JLabel("예약 시간: " + reservation.getReseveTime());
	        timeLabel.setBounds(20, 420, 200, 20);
	        add(timeLabel);

	        JLabel ticketLabel = new JLabel("티켓 수량: " + reservation.getReserverInt());
	        ticketLabel.setBounds(20, 450, 200, 20);
	        add(ticketLabel);

	        // 뒤로 가는 버튼
	        JButton backButton = new JButton("뒤로 가기");
	        backButton.setBounds(20, 550, 120, 40);
	        add(backButton);

	        backButton.addActionListener(e -> {

	            // 현재 창 닫기
	            Window currentWindow = SwingUtilities.windowForComponent(this);
	            if (currentWindow != null) {
	                currentWindow.dispose();
	            }
	        });
	        
	        // 구분선 추가
	        JSeparator separator1 = new JSeparator();
	        separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
	        separator1.setForeground(Color.BLACK);
	        add(separator1);
	 
    }
}