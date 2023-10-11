package frame.reserve;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;
import frame.base.FrameBase;
import frame.home.FramePosterClick;
import model.member.ArtReserInfo;
import model.member.ArtReserInfoList;
import model.member.Member;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;


public class FrameReserve extends JPanel {
	
	
    private ArtGalleryInfo info;
    private String artName; // 추가: 전달된 예약에 필요한 예술 작품 이름
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> timeComboBox;
    
    public FrameReserve(ArtGalleryInfo info, String artName) {
        this.info = info;
        this.artName = artName;
        
        setSize(400, 700);
        setLayout(null);
        setVisible(true);

        // 이미지 표시
        
        ImageIcon originalIcon9 = new ImageIcon(info.getImageURL());
        Image originalImage9 = originalIcon9.getImage();
        Image scaledImage9 = originalImage9.getScaledInstance(360, 280, Image.SCALE_SMOOTH);
        ImageIcon posterImage1 = new ImageIcon(scaledImage9);
		JLabel imageLabel=new JLabel(posterImage1);
        imageLabel.setSize(360, 280);
        imageLabel.setLocation(20, 70);
        add(imageLabel);

        // 티켓 수량 선택
        JLabel ticketLabel = new JLabel("티켓 수량:"); // 라벨 생성
        ticketLabel.setBounds(30, 460, 80, 30); // 라벨 위치와 크기 설정
        add(ticketLabel); // 라벨을 패널에 추가
        

        // 티켓 수량을 선택할 수 있는 스피너 생성
        SpinnerModel ticketSpinnerModel = new SpinnerNumberModel(1, 1, 9, 1); // 스피너 모델 생성 (최소값: 0, 최대값: 9, 증가값: 1)
        JSpinner ticketSpinner = new JSpinner(ticketSpinnerModel); // 스피너 생성 및 모델 설정
        
        JFormattedTextField ticketTextField = ((JSpinner.DefaultEditor) ticketSpinner.getEditor()).getTextField(); // 텍스트 필드 가져오기 (선택된 값 표시를 위해)
        //ticketTextField.setBackground(Color.WHITE);
        ticketTextField.setEditable(false); // 텍스트 필드를 수정 불가능하도록 설정 (스피너 값을 직접 입력하지 못하게 함)
        ticketSpinner.setBounds(120, 460, 50, 30); // 스피너 위치와 크기 설정
        add(ticketSpinner); // 스피너를 패널에 추가

        // 시간대 선택
        JLabel timeLabel = new JLabel("시간대:");
        timeLabel.setBounds(30, 410, 80, 30);
        add(timeLabel);

        try {
            ArtGalleryList artGalleryList = new ArtGalleryList();
            List<String> timeSlots = artGalleryList.generateTimeSlots(info.getStarttime(), info.getEndtime(), 120);

            String[] timeOptions = timeSlots.toArray(new String[timeSlots.size()]);
            timeComboBox = new JComboBox<>(timeOptions); // 시간대 선택 컴보박스 초기화
            timeComboBox.setBounds(120, 410, 80, 30);
            add(timeComboBox);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // 날짜 선택
        JLabel dateLabel = new JLabel("날짜:");
        dateLabel.setBounds(30, 360, 80, 30);
        add(dateLabel);
        
        UtilDateModel model = new UtilDateModel();
        model.setValue(new Date());		// 디폴트값 : 오늘날짜 
        JDatePanelImpl datePanel = new JDatePanelImpl(model);
        datePanel.setBackground(Color.WHITE);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());     
        datePicker.setBounds(120, 360, 150, 30);
        add(datePicker);
        
        // 예약 목록 테이블 생성 
        String[] columnNames = {"예약번호", "예술 작품", "날짜", "시간", "티켓 수량"};
        tableModel = new DefaultTableModel(columnNames, 0); // ??
        reservationTable = new JTable(tableModel);
        reservationTable.setVisible(false);

        JScrollPane scrollPane = new JScrollPane(reservationTable);
        scrollPane.setBounds(30, 600, 350, 100);
        scrollPane.setVisible(false); // 이 부분 추가
        add(scrollPane);
        
        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (datePicker.getModel().getValue() != null) {
                    // 날짜 선택이 있는 경우
                    int year = model.getYear();
                    int month = model.getMonth() + 1;
                    int day = model.getDay();
                    String chosenDateStr = year + "-" + month + "-" + day;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        Date chosenDate = sdf.parse(chosenDateStr);

                        if (chosenDate.before(info.getDateStart()) || chosenDate.after(info.getDateEnd())) {
                            // 선택한 날짜가 유효한 범위 내에 없는 경우
                            JOptionPane.showMessageDialog(FrameReserve.this, "전시 운영 기간이 아닙니다.", "경고", JOptionPane.WARNING_MESSAGE);
                            datePicker.getModel().setValue(null);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        ImageIcon originalIcon10 = new ImageIcon("./src/img/뒤로가기.png");
        Image originalImage10 = originalIcon10.getImage();
        Image scaledImage10 = originalImage10.getScaledInstance(50, 40, Image.SCALE_SMOOTH);
        ImageIcon posterImage10 = new ImageIcon(scaledImage10);
        JButton back = new JButton(posterImage10);
		back.setSize(50,40);
		back.setLocation(30,30);
		back.setBorderPainted(false);
		back.setContentAreaFilled(false);
		back.setFocusPainted(false);
		
		add(back);
		
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Window window = SwingUtilities.windowForComponent(FrameReserve.this);
	            if (window != null) {
	                window.dispose();
	            }
	            
	            //예정 전시로 돌아가는 전시회 이름들
	            if(artName.equals("문도멘도 판타스틱시티라이프") || artName.equals("요시토모 나라") || artName.equals("세르주 블로크展 ′KISS′") || artName.equals("캣아트 : 고양이 미술사")) {
	            	FrameBase.getInstance(new FramePosterClick(Member.tokeniD,artName,"FrameSoonPage"));
	            } else {
	            FrameBase.getInstance(new FramePosterClick(Member.tokeniD,artName,""));
	            }
			}
		});
        
        // 예약 버튼
		ImageIcon originalIcon11 = new ImageIcon("./src/img/결제하기.png");
        Image originalImage11 = originalIcon11.getImage();
        Image scaledImage11 = originalImage11.getScaledInstance(120, 40, Image.SCALE_SMOOTH);
        ImageIcon posterImage11 = new ImageIcon(scaledImage11);
        JButton reserveButton = new JButton(posterImage11);
        reserveButton.setBounds(140, 550, 120, 40);
        reserveButton.setBorderPainted(false); // 버튼 외각선 지우기
        reserveButton.setContentAreaFilled(false); // 버튼 투명하게 지우기(이미지는 남음)
        reserveButton.setFocusPainted(false); // 버튼 선택 표시 지우기
        add(reserveButton);
        
        // 예약버튼 호버
        ImageIcon reserveButton1 = new ImageIcon("./src/img/결제하기hover.png");
        Image scaledHoverImage1 = reserveButton1.getImage().getScaledInstance(120, 40, Image.SCALE_SMOOTH);
        reserveButton.setRolloverIcon(new ImageIcon(scaledHoverImage1));

        reserveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedTicket = (int) ticketSpinner.getValue();
                String selectedTime = (String) timeComboBox.getSelectedItem(); 

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String selectedDate = "";
                String selectedName = info.getArtName();

                JFormattedTextField dateTextField = datePicker.getJFormattedTextField();

                if (datePicker.getModel().getValue() != null) {
                    int year = model.getYear();
                    int month = model.getMonth() + 1;
                    int day = model.getDay();
                    String chosenDateStr = year + "-" + month + "-" + day;
                    try {
                        Date chosenDate = sdf.parse(chosenDateStr);
                        selectedDate = sdf.format(chosenDate);

                        if (selectedTicket > 0 && !selectedDate.isEmpty()) {
                            Vector<Object> rowData = new Vector<>();
                            rowData.add(tableModel.getRowCount() + 1);
                            rowData.add(selectedName);
                            rowData.add(selectedDate);
                            rowData.add(selectedTime);
                            rowData.add(selectedTicket);

                            tableModel.addRow(rowData);

                            ArtReserInfo reservation = new ArtReserInfo(Member.tokeniD, info, selectedTime, selectedDate, selectedTicket);

                            ArtReserInfoList artReserInfoList = new ArtReserInfoList();

                            ArtReserInfoList.addReservation(reservation);

                            ticketSpinner.setValue(1);
                            timeComboBox.setSelectedIndex(0);
                            datePicker.getModel().setValue(null);

                            FrameGalleryConfirm confirmFrame = new FrameGalleryConfirm(selectedName, selectedDate, selectedTime, selectedTicket,info);
                            confirmFrame.setVisible(true);
                        } else if (selectedTicket == 0) {
                            JOptionPane.showMessageDialog(FrameReserve.this, "티켓 수량을 확인해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                        }
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(FrameReserve.this, "날짜를 선택해주세요.", "경고", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
