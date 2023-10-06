package frame;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import artDB.ArtGalleryInfo;
import artDB.ArtGalleryList;

public class FrameHomePopularClick extends JPanel{

	JPanel framehomePanel;
	
	public FrameHomePopularClick() {
		this(null);
	}
	
	public FrameHomePopularClick(JPanel homePanel) {
		this.framehomePanel = homePanel;
		ImageIcon icon;
		ArtGalleryList artGalleryList = new ArtGalleryList();
		List<ArtGalleryInfo> galleryList = artGalleryList.Info();

	
	    	 // ArtGalleryList 객체 생성
	        
	    	
	        setSize(400, 700);
	        setLayout(null);
	        setVisible(true);
	        
	        ImageIcon originalIcon = new ImageIcon("./src/인기클릭.png");
	        Image originalImage = originalIcon.getImage();
	        Image scaledImage = originalImage.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
	        
	        ImageIcon originalIcon1 = new ImageIcon("./src/searchicon.png");
	        Image originalImage1 = originalIcon1.getImage();
	        Image scaledImage1 = originalImage1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	        
	        ImageIcon imageSearch = new ImageIcon(scaledImage1);
	        ImageIcon imagePopular = new ImageIcon(scaledImage);
	        
	        
	        JButton btnSearch = new JButton(imageSearch);
	        JButton btnPopular = new JButton(imagePopular);
	        
	        
	        btnPopular.setBounds(20,100,50,30);
	        btnPopular.setContentAreaFilled(false);
	        btnPopular.setBorderPainted(false);
	        btnPopular.setFocusPainted(false); //버튼 선택표시 지우기
	        
	        
	        btnSearch.setSize(30,30);
	        btnSearch.setLocation(330, 30);
	        btnSearch.setBorderPainted(false); //버튼 외각선 지우기
	        btnSearch.setContentAreaFilled(false); //버튼 투명하게 지우기(이미지는 남음)
	        btnSearch.setFocusPainted(false); //버튼 선택표시 지우기
	         
	    
	        add(btnSearch);
	        add(btnPopular);
	        
	      
	        
	        
	        
	        
	   
	        btnSearch.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// 검색 페이지이동
				}
			});

	        btnPopular.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					removeAll();
			        add(new Home());
			        revalidate();
			        repaint();
				}
			});
	      
	}
}
