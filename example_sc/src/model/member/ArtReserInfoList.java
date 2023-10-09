package model.member;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import artDB.ArtGalleryInfo;

public class ArtReserInfoList {
	private static ArrayList<ArtReserInfo> arr;
    private List<ArtReserInfo> filteredList = new ArrayList<ArtReserInfo>();

    public ArtReserInfoList() {
        if (arr == null) {
        	init();
        }

    }
    
    public void init()
    {
    	arr = new ArrayList<ArtReserInfo>(); 
 
    }

	public void show() {
		for( ArtReserInfo a : arr)
		{
			System.out.println(a.toString());
		}
	}
	public List<ArtReserInfo> getArtReserInfoList() {
		return arr;
	}
    
    
}
