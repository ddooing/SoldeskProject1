package artDB;

import java.util.ArrayList;
import java.util.List;


public class ArtGalleryList {
	private static ArrayList<ArtGalleryInfo> arr;
	
	public ArtGalleryList() {
		if(arr == null) {
			Info();
		}
	}
	
	public List<ArtGalleryInfo> Info() {
		ArrayList<ArtGalleryInfo> arr = new ArrayList<ArtGalleryInfo>();
		
		arr.add(new ArtGalleryInfo("쿨라 링: 이야기군도","02-733-4883","최신","서울 종로구 자하문로 10길 15","무료",
				"2023-09-15 11:00 ~ 2023-10-22 19:00","https://map.naver.com/p/entry/place/12254368?c=15.00,0,0,0,dh",
				"1","https://cdn.imweb.me/thumbnail/20230919/eca708764058b.jpg"));
		
		arr.add(new ArtGalleryInfo("Between Starshine and Clay", "02-2233-2335", "인기", "서울 종로구 율곡로1길 37",
				"무료", "2023-09-07 10:00 ~ 2023-11-12 18:00",
				"https://map.naver.com/p/entry/place/1887526310?c=15.00,0,0,0,dh", "2",
				"https://artlogic-res.cloudinary.com/w_2400,h_2400,c_limit,f_auto,fl_lossy,q_auto/ws-artlogicwebsite0006/usr/exhibitions/images/exhibitions/233/kw-between-starshine-and-clay-2023-lowres-1.jpg"));
		
		return arr;
	}
}
