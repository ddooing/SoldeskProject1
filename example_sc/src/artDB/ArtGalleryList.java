package artDB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ArtGalleryList {
	private static ArrayList<ArtGalleryInfo> arr;
	
	public ArtGalleryList() {
		if(arr == null) {
			System.out.println("null");
			init();
		}
		else {
			getArtGalleryInfoList();
		}
	}
	
	public ArrayList<ArtGalleryInfo> init() {
		arr = new ArrayList<ArtGalleryInfo>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 1번
            Date startDate = dateFormat.parse("2023-09-22");
            Date endDate = dateFormat.parse("2023-10-12");
            arr.add(new ArtGalleryInfo("열작", "무료", "커넥트플레이스 서울역4층", startDate, endDate, "11:00 ~ 21:00", "https://naver.me/GyNv7dGv", "https://og-data.s3.amazonaws.com/media/exhibitions/image/13639/ei_13639.jpeg", 1));
            
            // 2번
            startDate = dateFormat.parse("2023-10-11");
            endDate = dateFormat.parse("2023-10-25");
            arr.add(new ArtGalleryInfo("히피한남 단체전:WABABABA", "무료", "히피 한남", startDate, endDate, "11:00 ~ 19:00", "https://naver.me/GfM6tYKk", "https://archivist.kr/show/image/20231005_hippiehannamgallery.jpg", 2));
            
            // 3번
            startDate = dateFormat.parse("2023-10-19");
            endDate = dateFormat.parse("2023-11-29");
            arr.add(new ArtGalleryInfo("캣아트 : 고양이 미술사", "15,000 원", "서울특별시 송파구 신천동 29-1 KT송파타워 3층", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/F9znHvY8", "https://image.aladin.co.kr/product/15876/24/cover500/k462533530_1.jpg", 3));
            
            // 4번
            startDate = dateFormat.parse("2023-10-30");
            endDate = dateFormat.parse("2023-12-31");
            arr.add(new ArtGalleryInfo("문도멘도 판타스틱시티라이프", "15,000 원", "그라운드시소 서촌", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/xKQWUady", "https://groundseesaw.co.kr/wp-content/uploads/2023/05/MENDO_KV_2%EC%B0%A8_230418-1-1-1500x2193.jpg", 4));
            
            // 5번
            startDate = dateFormat.parse("2023-09-21");
            endDate = dateFormat.parse("2024-01-07");
            arr.add(new ArtGalleryInfo("스티키몬스터랩: 스틸 라이프", "15,000 원", "그라운드시소 성수", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/5pNEZlT0", "https://ticketimage.interpark.com/Play/image/large/23/23011168_p.gif", 5));
            
			 startDate = dateFormat.parse("2023-07-22");
	    	 endDate = dateFormat.parse("2023-10-27");
	    	
	    	arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울 전시회","20000","DDP 뮤지엄 전시 1관",
	    			 startDate, endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
					"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
					5));
	    	
	    	
	    	 startDate = dateFormat.parse("2023-09-14");
	    	 endDate = dateFormat.parse("2023-10-14");
	    	
	    	arr.add(new ArtGalleryInfo("동물 없는 동물원 展","15000","DDP 뮤지엄 전시 1관",
	    			 startDate, endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
					"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
					5));
	    	
	    	 startDate = dateFormat.parse("2023-05-05");
	    	 endDate = dateFormat.parse("2023-10-20");
	    	
	    	arr.add(new ArtGalleryInfo("피터팬 전시회","22000","k현대미술관 지하 1층",
	    			 startDate, endDate,"10:00 ~ 19:00","https://naver.me/535BKkXf",
					"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/06/26/1000000101/1000000101_detail_025.jpg",7));
	
	    	
	    	 startDate = dateFormat.parse("2023-09-05");
	    	 endDate = dateFormat.parse("2023-10-21");
	    	
	    	arr.add(new ArtGalleryInfo("요시토모 나라","무료","페이스갤러리",
	    			 startDate, endDate,"10:00 ~ 18:00","https://naver.me/GHEVTodl",
					"https://og-data.s3.amazonaws.com/media/exhibitions/image/13608/ei_13608.png",6));
	    	
	    	 startDate = dateFormat.parse("2023-05-26");
	    	 endDate = dateFormat.parse("2023-10-19");
	    	
	    	arr.add(new ArtGalleryInfo("전자적 숲:소진된 인간","2000","국립현대미술관 서울",
	    			 startDate, endDate,"10:00 ~ 18:00","https://naver.me/54Vkke2z",
					"https://vulktiuibwqqvtbjzlie.supabase.co/storage/v1/object/public/images/exhibition/representative/11931fba-8122-4515-80e2-1e33d8bc9637_poster_2.jpg",4));

	    	
		} catch (ParseException e) {
            e.printStackTrace();
        }
		return arr;
		
	}

	
	public ArrayList<ArtGalleryInfo> getArtGalleryInfoList() {
        return arr;
    }
	
	//모든 정보 확인 최신순 x 
	public void see()
	{
		 for (ArtGalleryInfo s : arr) {
		         System.out.println(s.toString());
		    }
	}
	
	// 날짜 간 15일 이하 차이 여부를 확인하는 메서드
	private boolean isWithin15Days(Date currentDate, Date endDate) {
	    long diffInMillis = endDate.getTime() - currentDate.getTime();
	    long daysDifference = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

	    return daysDifference <= 15;
	}
	
	// 곧 종료 정보 .. return 
	public  void soonEnd(Date currentDate)
	{//ArrayList<ArtGalleryInfo>
		ArrayList<ArtGalleryInfo> filteredList = new ArrayList<ArtGalleryInfo>();
			
		for (ArtGalleryInfo info : arr) {
	        // 종료 날짜가 currentDate 이후이면서 15일 이하로 차이나는 항목을 filteredList에 추가
	        if (info.getDateEnd().after(currentDate) && isWithin15Days(currentDate, info.getDateEnd())) {
	            filteredList.add(info);
	        }
	    }
		
		//return filteredList;
		for (ArtGalleryInfo info : filteredList)
			System.out.println(info.toString());
	}
	
}
