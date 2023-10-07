package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ListPanel extends JPanel {
	public ListPanel() {
		// 패널의 위치와 크기 설정
        setBounds(19, 123, 362, 500);

        // 패널의 배경색을 핑크색으로 설정
        setBackground(Color.pink);
	}
}
