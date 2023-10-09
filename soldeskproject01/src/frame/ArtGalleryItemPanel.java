package frame;

import javax.swing.*;
import java.awt.*;
import artDB.ArtGalleryInfo;

public class ArtGalleryItemPanel extends JPanel {
    private ArtGalleryInfo gallery;

    public ArtGalleryItemPanel(ArtGalleryInfo gallery) {
        this.gallery = gallery;
        setLayout(null);
        setPreferredSize(new Dimension(340, 120));
        setBackground(Color.white);
        // 이곳에 전시회 정보를 표시하는 코드를 추가하세요.
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // 이곳에 그래픽을 그리는 코드를 추가하세요.
    }
}
