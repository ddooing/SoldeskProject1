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
    
	// id의 예약 리스트 
	public ArrayList<ArtReserInfo> getIdReserList(){
		ArrayList<ArtReserInfo> idReserlist = new ArrayList<ArtReserInfo>();
		
		for( ArtReserInfo a :arr)
		{
			if(a.getId().equals(Member.tokeniD))
			{
				idReserlist.add(a);
			}
		}
		return idReserlist;
	}
	public void showId() {
			//토큰 잘 가져옴
			System.out.println(Member.tokeniD);
		
	}

	public static void addReservation(ArtReserInfo reservation) {
		// TODO Auto-generated method stub
		arr.add(reservation);
	}

}