package frame;

import javax.swing.*;
import artDB.ArtGalleryInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameGalleryConfirm extends JFrame {
    
    private ArtGalleryInfo info;

    public FrameGalleryConfirm(String selectedName, String selectedDate, String selectedTime, int selectedTicket, ArtGalleryInfo info) {
        // info를 초기화
        this.info = info;

        // 프레임 설정
        Toolkit tk = Toolkit.getDefaultToolkit();
        setTitle("예약 확인");
        setSize(300, 250);
        setBounds(((int) tk.getScreenSize().getWidth() / 3 + 60), ((int) tk.getScreenSize().getHeight()) / 2 - 200, 300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 패널 생성
        JPanel confirmPanel = new JPanel(new GridLayout(6, 1));

        // 라벨들 생성 및 추가
        confirmPanel.add(new JLabel("전시회 이름: " + selectedName));
        confirmPanel.add(new JLabel("예약 날짜: " + selectedDate));
        confirmPanel.add(new JLabel("예약 시간: " + selectedTime));
        confirmPanel.add(new JLabel("티켓 개수: " + selectedTicket));
        
        if (info.getFee().equals("무료")) {
            String freefee = "무료";
            confirmPanel.add(new JLabel("총 가격: " + freefee));
        } else {
            int totalfee = Integer.parseInt(info.getFee()) * selectedTicket;
            confirmPanel.add(new JLabel("총 가격: " + totalfee));
        }

        // 닫기 버튼 생성 및 추가
        JButton closeButton = new JButton("닫기");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FrameBase.getInstance(new Home());
            }
        });
        confirmPanel.add(closeButton);

        add(confirmPanel);
        setVisible(true);
    }
}
