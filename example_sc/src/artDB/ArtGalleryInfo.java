package artDB;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArtGalleryInfo {
	private String artName; 		// 전시회 이름
	private String fee;             // 입장료
	private String place;			// 전시회 장소
	private Date dateStart;       // 시작날짜
	private Date dateEnd;         // 종료날짜
	private String starttime;			// 전시 시작 시간
	private String endtime;			// 전시 종료 시간
	private String placeURL;        // 지도 url
	private String imageURL;		// 이미지 파일 위치
	private Integer cnt;			// 예매수
	
	public ArtGalleryInfo(String artName, String fee,  String place, Date dateStart,
			Date dateEnd,String starttime,String endtime,String placeURL,String imageURL,Integer cnt ) {
		this.artName = artName;
		this.fee=fee;
		this.place=place;
		this.dateStart=dateStart;
		this.dateEnd=dateEnd;
		this.starttime=starttime;
		this.endtime=endtime;
		
		this.placeURL = placeURL;
		this.imageURL = imageURL;
		this.cnt=cnt;
	}
	
	public String getArtName() {
		return artName;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	

	public String getPlaceURL() {
		return placeURL;
	}

	public void setPlaceURL(String placeURL) {
		this.placeURL = placeURL;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public Integer getCnt() {
		return cnt;
	}

	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}

	//예매 추가 
	public void addCnt(int num)
	{
		this.cnt += num;
	}
	// 확인용 함수 
	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return this.artName +" 가격!!:"+this.fee+" 시작:"+dateFormat.format(this.dateStart)+ " 종료:"+dateFormat.format(this.dateEnd);
	}
	
	public String getPo()// 인기순 목록 보기
	{
		return this.artName +" cnt:"+this.cnt;
	}
	
	public String getdateStart()//최신순 목록 보기 
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return this.artName +" dateStart:"+dateFormat.format(this.dateStart);
	}
	
}
