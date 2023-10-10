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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArtGalleryInfo getA() {
		return a;
	}

	public void setA(ArtGalleryInfo a) {
		this.a = a;
	}

	public String getReseveTime() {
		return reseveTime;
	}

	public void setReseveTime(String reseveTime) {
		this.reseveTime = reseveTime;
	}

	public String getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}

	public int getReserverInt() {
		return reserverInt;
	}

	public void setReserverInt(int reserverInt) {
		this.reserverInt = reserverInt;
	}
	
	
	
}