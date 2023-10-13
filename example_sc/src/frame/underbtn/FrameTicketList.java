package frame.underbtn;

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
import frame.base.FrameBase;
import frame.home.Home;
import model.member.ArtReserInfo;
import model.member.Member;


public class FrameTicketList extends JPanel{

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

		Member m = new Member();
        
        idReserlist = new ArrayList<ArtReserInfo>();
      
        idReserlist =m.getTiketList(); // 내 티켓 정보 리스트 가져옴 

		
        updatePosters( );
	
	}
	
	
	private void updatePosters() {

        int posterWidth = 60;
        int posterHeight = 80;
        

        
        List<ArtGalleryInfo> filteredList = new ArrayList<>();

        int x= 40; 
    	int y= 130;
       for (int i = 0; i < idReserlist.size(); i++) {
            
            ArtReserInfo posterInfo = idReserlist.get(i);
            	
                //filteredList.add(posterInfo);

                ImageIcon originalIcon9 = new ImageIcon(posterInfo.getA().getImageURL());
                Image originalImage9 = originalIcon9.getImage();
                Image scaledImage9 = originalImage9.getScaledInstance(posterWidth, posterHeight, Image.SCALE_SMOOTH);
                ImageIcon posterImage1 = new ImageIcon(scaledImage9);
                JLabel posterImage = new JLabel(posterImage1);
                posterImage.setBounds(x, y, posterWidth, posterHeight);
                add(posterImage);
                //System.out.println("posterImage 1 : "+posterInfo.getImageURL());

                JLabel posterTitle = new JLabel(posterInfo.getA().getArtName());
                posterTitle.setBounds(posterImage.getX()+posterWidth+10,posterImage.getY()+posterImage.getWidth()/2 -5,
                		150,30);
                posterTitle.setFont(new Font("나눔스퀘어OTF Bold", Font.BOLD, 14));
                add(posterTitle);
                
                
                ImageIcon infoclickimg = new ImageIcon("./src/img/info_btn.png");
                
                JButton infoclick_btn = new JButton(infoclickimg);
                infoclick_btn.setBounds(posterTitle.getX()+posterTitle.getWidth()+50,posterImage.getY()+posterImage.getWidth()/2 -5,
                		30, 30);
                infoclick_btn.setBorderPainted(false);
                infoclick_btn.setContentAreaFilled(false);
                add(infoclick_btn);
                
                ImageIcon menuLine = new ImageIcon("./src/img/line3.png");

                JLabel menuline = new JLabel(menuLine); // 메뉴선
                menuline.setSize(380, 5);
                menuline.setLocation(10,posterImage.getY()+posterImage.getHeight()+10);

                add(menuline);  
                
                y=menuline.getY()+30;
                
                infoclick_btn.addActionListener(new ActionListener() {
        			
        			@Override
        			public void actionPerformed(ActionEvent e) {
        				
        				FrameBase.getInstance(new FrameInqueryPage(posterInfo));
        				
        			}
        		});
                

                
            }
	
       
    }
	

	
	
}

