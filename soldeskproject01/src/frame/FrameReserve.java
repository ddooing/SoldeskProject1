package frame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import artDB.ArtGalleryInfo;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class FrameReserve extends JPanel {

    private ArtGalleryInfo info;
    private String artName; // 추가: 전달된 예약에 필요한 예술 작품 이름
   
    public FrameReserve(ArtGalleryInfo info, String artName) {
        this.info = info;
        this.artName = artName;
        
        setSize(400, 700);
        setLayout(null);
        setVisible(true);

        // 이미지 표시
        JLabel imageLabel = new JLabel(HtmlUtils.imgHtmlParser(info.getImageURL()));
        imageLabel.setSize(360, 280);
        imageLabel.setLocation(20, 70);
        add(imageLabel);

        // 티켓 수량 선택
        JLabel ticketLabel = new JLabel("티켓 수량:"); // 라벨 생성
        ticketLabel.setBounds(30, 360, 80, 30); // 라벨 위치와 크기 설정
        add(ticketLabel); // 라벨을 패널에 추가

        // 티켓 수량을 선택할 수 있는 스피너 생성
        SpinnerModel ticketSpinnerModel = new SpinnerNumberModel(1, 0, 99, 1); // 스피너 모델 생성 (최소값: 0, 최대값: 9, 증가값: 1)
        JSpinner ticketSpinner = new JSpinner(ticketSpinnerModel); // 스피너 생성 및 모델 설정
        JFormattedTextField ticketTextField = ((JSpinner.DefaultEditor) ticketSpinner.getEditor()).getTextField(); // 텍스트 필드 가져오기 (선택된 값 표시를 위해)
        ticketTextField.setEditable(false); // 텍스트 필드를 수정 불가능하도록 설정 (스피너 값을 직접 입력하지 못하게 함)
        ticketSpinner.setBounds(120, 360, 50, 30); // 스피너 위치와 크기 설정
        add(ticketSpinner); // 스피너를 패널에 추가

        // 시간대 선택
        JLabel timeLabel = new JLabel("시간대:");
        timeLabel.setBounds(30, 410, 80, 30);
        add(timeLabel);

        String[] timeOptions = {"08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00"};
        JComboBox<String> timeComboBox = new JComboBox<>(timeOptions);
        timeComboBox.setBounds(120, 410, 80, 30);
        add(timeComboBox);

        // 날짜 선택
        JLabel dateLabel = new JLabel("날짜:");
        dateLabel.setBounds(30, 460, 80, 30);
        add(dateLabel);
        
        UtilDateModel model = new UtilDateModel();
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setBounds(120, 460, 150, 30);
        add(datePicker);

        // 예약 버튼
        JButton reserveButton = new JButton("결제하기");
        reserveButton.setBounds(150, 550, 100, 40);
        add(reserveButton);

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 예약 버튼 클릭 시 실행되는 코드 작성
                int selectedTicket = (int) ticketSpinner.getValue();
                String selectedTime = (String) timeComboBox.getSelectedItem();

                // 선택된 날짜 가져오기
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String selectedDate;
                String selectedName = info.getArtName();

                if (datePicker.getModel().getValue() != null) {
                    int year = model.getYear();
                    int month = model.getMonth() + 1;
                    int day = model.getDay();
                    String chosenDateStr = year + "-" + month + "-" + day;
                    try {
                        Date chosenDate = sdf.parse(chosenDateStr);
                        selectedDate= sdf.format(chosenDate);
                        // 여기에 예약 정보 처리하는 코드를 추가하세요.
                        new FrameGalleryConfirm(selectedName, selectedDate,selectedTime ,selectedTicket); 
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("날짜를 선택해주세요.");
                }
            }
        });
    }
    
}

