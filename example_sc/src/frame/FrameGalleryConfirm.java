package frame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;

public class FrameGalleryConfirm extends JFrame {
    public FrameGalleryConfirm(String selectedName, String selectedDate, String selectedTime, int selectedTicket) {
        // 프레임 설정
        setTitle("예약 확인");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 패널 생성
        JPanel confirmPanel = new JPanel(new GridLayout(5, 1)); // GridLayout을 사용하여 컴포넌트들을 세로로 배치

       
        // 라벨들 생성 및 추가
        confirmPanel.add(new JLabel("전시회 이름: " + selectedName));
        confirmPanel.add(new JLabel("예약 날짜: " + selectedDate));
        confirmPanel.add(new JLabel("예약 시간: " + selectedTime));
        confirmPanel.add(new JLabel("티켓 개수: " + selectedTicket));

        // 닫기 버튼 생성 및 추가
        JButton closeButton = new JButton("닫기");
        closeButton.addActionListener(e -> dispose()); // 버튼 클릭 시 창 닫기
        confirmPanel.add(closeButton);

        add(confirmPanel); // 패널을 프레임에 추가

        setVisible(true); // 프레임 보이게 설정
    }
}