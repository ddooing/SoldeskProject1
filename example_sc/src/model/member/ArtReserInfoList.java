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


	public List<ArtReserInfo> getArtReserInfoList() {
		return arr;
	}
    
	// id의 예약 리스트 
	public ArrayList<ArtReserInfo> getIdReserList(){
		ArrayList<ArtReserInfo> idReserlist = new ArrayList<ArtReserInfo>();
		
		for( ArtReserInfo a :arr)
		{
			if(a.getId().equals(Member.tokeniD))
			{
				idReserlist.add(a);
				//확인용
				//System.out.println(Member.tokeniD + "가 예약한 리스트 "+a.toString());
			}
		}
		return idReserlist;
	}

	
	public static void addReservation(ArtReserInfo reservation) {
		// TODO Auto-generated method stub
		arr.add(reservation);
	}
	
	
    /*
    //확인용
	public void show() {
		for( ArtReserInfo a : arr)
		{
			System.out.println(a.toString());
		}
	}*/
    
}
