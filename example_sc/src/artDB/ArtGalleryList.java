package artDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ArtGalleryList {
	private static ArrayList<ArtGalleryInfo> arr;
	
	public ArtGalleryList() {
		if(arr == null) {
			Info();
		}
	}
	
	public List<ArtGalleryInfo> Info() {
		ArrayList<ArtGalleryInfo> arr = new ArrayList<ArtGalleryInfo>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
		Date startDate11 = dateFormat.parse("2023-07-22");
    	Date endDate11 = dateFormat.parse("2023-10-27");
    	
    	arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울 전시회","20000","DDP 뮤지엄 전시 1관",
				startDate11,endDate11,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
				"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
				5));
    	
    	
    	Date startDate12 = dateFormat.parse("2023-09-14");
    	Date endDate12 = dateFormat.parse("2023-10-14");
    	
    	arr.add(new ArtGalleryInfo("동물 없는 동물원 展","15000","DDP 뮤지엄 전시 1관",
				startDate11,endDate11,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
				"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
				5));
    	
    	Date startDate13 = dateFormat.parse("2023-05-05");
    	Date endDate13 = dateFormat.parse("2023-10-20");
    	
    	arr.add(new ArtGalleryInfo("피터팬 전시회","22000","k현대미술관 지하 1층",
				startDate11,endDate11,"10:00 ~ 19:00","https://naver.me/535BKkXf",
				"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/06/26/1000000101/1000000101_detail_025.jpg",7));

    	
    	Date startDate14 = dateFormat.parse("2023-09-05");
    	Date endDate14 = dateFormat.parse("2023-10-21");
    	
    	arr.add(new ArtGalleryInfo("요시토모 나라","무료","페이스갤러리",
				startDate11,endDate11,"10:00 ~ 18:00","https://naver.me/GHEVTodl",
				"https://og-data.s3.amazonaws.com/media/exhibitions/image/13608/ei_13608.png",6));
    	
    	Date startDate15 = dateFormat.parse("2023-05-26");
    	Date endDate15 = dateFormat.parse("2023-10-19");
    	
    	arr.add(new ArtGalleryInfo("전자적 숲; 소진된 인간","2000","국립현대미술관 서울",
				startDate11,endDate11,"10:00 ~ 18:00","https://naver.me/54Vkke2z",
				"https://vulktiuibwqqvtbjzlie.supabase.co/storage/v1/object/public/images/exhibition/representative/11931fba-8122-4515-80e2-1e33d8bc9637_poster_2.jpg",4));
		
		} catch (ParseException e) {
            e.printStackTrace();
        }
		
		
		return arr;
	}
}
