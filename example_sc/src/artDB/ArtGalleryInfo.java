package artDB;

import java.util.Date;

public class ArtGalleryInfo {
	private String artName; 		// 전시회 이름
	//private String addressLink;		// 전시회 링크
	private String fee;             // 입장료
	private String place;			// 전시회 장소
	private Date dateStart;       // 시작날짜
	private Date dateEnd;         // 종료날짜
	private String time;			// 전시 시간
	private String placeURL;        // 지도 url
	private String imageURL;		// 이미지 url
	private Integer cnt;			// 예매수
	
	public ArtGalleryInfo(String artName, String fee, String tag ,String addressName, String fee, String date, String placeURL, String id, String imageURL) {
		this.artName = artName;
		this.phone = phone;
		this.tag = tag;
		this.addressName = addressName;
		this.fee = fee;
		this.date = date;
		this.placeURL = placeURL;
		this.id = id;
		this.imageURL = imageURL;
	}

	public String getArtName() {
		return artName;
	}

	public String getPhone() {
		return phone;
	}
	
	public String getTag() {
		return tag;
	}

	public String getAddressName() {
		return addressName;
	}

	public String getFee() {
		return fee;
	}

	public String getDate() {
		return date;
	}

	public String getPlaceURL() {
		return placeURL;
	}

	public String getId() {
		return id;
	}

	public String getImageURL() {
		return imageURL;
	}
	
	public void infoshortPrint() {
		System.out.println("| "+ artName+" |");
		System.out.println("| "+ date+" |");
		System.out.println("| "+ tag + " |");
		System.out.println("| "+ fee+" |");
	}
	
	public void infoFullPrint() {
		System.out.println("| 전시 : " + artName);
		System.out.println("| 태그 : " + tag);
		System.out.println("| 전시 : " + artName);
	} 
}
