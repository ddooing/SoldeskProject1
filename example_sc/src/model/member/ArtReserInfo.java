package model.member;

import artDB.ArtGalleryInfo;

public class ArtReserInfo {
	private String id;
	private ArtGalleryInfo a;
	private String reseveTime;
	private String reserveDate;
	private int reserverInt;
	

						//로그인한 사용자의 id 
	public ArtReserInfo(String id,ArtGalleryInfo a,String reseveTime,String reserveDate,int reserverInt)
	{
		
		this.id=id;
		this.a=a;
		this.reserveDate=reserveDate;
		this.reseveTime=reseveTime;
		this.reserverInt=reserverInt;
		//System.out.println(id +" "+reserveDate+ " "+reseveTime + " "+reserverInt);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id +" "+reserveDate+ " "+reseveTime + " "+reserverInt;
	}
}
