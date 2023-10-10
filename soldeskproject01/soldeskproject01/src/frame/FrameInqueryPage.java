package frame;

import javax.swing.*;

import artDB.ArtGalleryInfo;
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
/*
    private ArtGalleryInfo info;
    private String artName; // 추가: 전달된 예약에 필요한 예술 작품 이름
   
    public FrameInqueryPage(ArtGalleryInfo info, String artName) {
        this.info = info;
        this.artName = artName;
        
        setSize(400, 700);
        setLayout(null);
        setVisible(true);

        // 이미지 표시
        JLabel imageLabel = new JLabel(HtmlUtils.imgHtmlParser(info.getImageURL()));
        imageLabel.setSize(360, 250);
        imageLabel.setLocation(20, 70);
        add(imageLabel);
        
        JLabel posterTitle = new JLabel(ArtGalleryInfo.getArtName());
        posterTitle.setBounds(x + 20, y + 160, posterWidth, 20);
        posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
        add(posterTitle);
        
        JLabel posterplace = new JLabel(posterInfo.getPlace());
        posterplace.setBounds(x + 20, y + 175, posterWidth, 20);
        posterplace.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 10));
        add(posterplace);
        
        JLabel posterDate = new JLabel(dateFormat.format(posterInfo.getDateStart()) + "~" + dateFormat.format(posterInfo.getDateEnd()));
        posterDate.setBounds(x + 20, y + 190, posterWidth, 20);
        posterDate.setFont(new Font("나눔스퀘어OTF Bold", Font.PLAIN, 10));
        add(posterDate);

        // 구분선 추가
        JSeparator separator1 = new JSeparator();
        separator1.setBounds(20, 395, 360, 10); // 구분선의 위치와 크기 조정
        separator1.setForeground(Color.BLACK);
        add(separator1);
    }*/
}
