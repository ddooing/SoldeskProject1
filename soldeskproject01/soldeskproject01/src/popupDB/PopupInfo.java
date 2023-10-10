package popupDB;

public class PopupInfo {
	private String popupName; 		// 팝업스토어 이름
	private String phone; 			// 팝업스토어 연락처
	private String tag;				// 태그
	private String addressName;		// 팝업스토어 주소
	private String fee;             // 입장료
	private String date;            // 운영날짜
	private String placeURL;        // 지도 url
	private String id;				// pk
	private String imageURL;		// 이미지 url
	
	public PopupInfo(String popupName, String phone, String tag ,String addressName, String fee, String date, String placeURL, String id, String imageURL) {
		this.popupName = popupName;
		this.phone = phone;
		this.tag = tag;
		this.addressName = addressName;
		this.fee = fee;
		this.date = date;
		this.placeURL = placeURL;
		this.id = id;
		this.imageURL = imageURL;
	}

	public String getPopupName() {
		return popupName;
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
		System.out.println("| "+ popupName+" |");
		System.out.println("| "+ date+" |");
		System.out.println("| "+ tag + " |");
		System.out.println("| "+ fee+" |");
	}
	
	public void infoFullPrint() {
		System.out.println("| 팝업스토어 : " + popupName);
		System.out.println("| 태그 : " + tag);
		//System.out.println("| 전시 : " + popupName);
	} 
	
}
