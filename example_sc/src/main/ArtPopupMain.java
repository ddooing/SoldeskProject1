package main;

import frame.base.FrameBase;
import frame.base.FrameDisplay;
import frame.home.FrameLanding;
import frame.home.Home;


public class ArtPopupMain {
	public static void main(String[] args) {
		
		FrameDisplay.getInstance(new FrameLanding());
	}
}
