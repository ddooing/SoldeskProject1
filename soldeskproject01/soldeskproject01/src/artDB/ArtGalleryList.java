package artDB;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArtGalleryList {
	private static ArrayList<ArtGalleryInfo> arr;
	private static ArrayList<MyGallery> reserveList;
	private List<ArtGalleryInfo> filteredList = new ArrayList<ArtGalleryInfo>();
	Calendar currentDate = Calendar.getInstance();
	Date now = currentDate.getTime();//현재 날짜
	
	public ArtGalleryList() {
		if(arr == null) {
			init();
		}
		if (reserveList == null) {
			new ArrayList<MyGallery>();
		}
	}// ArtGalleryList
	
	public static List<ArtGalleryInfo> Info() {
		// 전시회 정보 리스트, 예매 정보 리스트
		ArrayList<ArtGalleryInfo> arr = new ArrayList<ArtGalleryInfo>();
		
		return arr;
	}
		
	public void init() {
			arr = new ArrayList<ArtGalleryInfo>();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {// String artName, String time, String fee, String addressLink, Date dateStart, Date dateEnd,
				// String placeURL, String id, String imageURL
				
				// 1번
		            Date startDate = dateFormat.parse("2023-09-22");
		            Date endDate = dateFormat.parse("2023-10-12");
		            arr.add(new ArtGalleryInfo("열작", "무료", "커넥트플레이스 서울역4층", startDate, endDate, 
		            		"11:00 ~ 21:00", "https://naver.me/GyNv7dGv, wi", 
		            		"https://og-data.s3.amazonaws.com/media/exhibitions/image/13639/ei_13639.jpeg", 1));

		            // 2번
		            startDate = dateFormat.parse("2023-10-11");
		            endDate = dateFormat.parse("2023-10-25");
		            arr.add(new ArtGalleryInfo("히피한남 단체전:WABABABA", "무료", "히피 한남", startDate, endDate,
		            		"11:00 ~ 19:00", "https://naver.me/GfM6tYKk",
		            		"https://archivist.kr/show/image/20231005_hippiehannamgallery.jpg", 2));

		            // 3번
		            startDate = dateFormat.parse("2023-10-19");
		            endDate = dateFormat.parse("2023-11-29");
		            arr.add(new ArtGalleryInfo("캣아트 : 고양이 미술사", "15,000 원", "서울특별시 송파구 신천동 29-1 KT송파타워 3층", startDate, endDate,
		            		"10:00 ~ 19:00", "https://naver.me/F9znHvY8", 
		            		"https://image.aladin.co.kr/product/15876/24/cover500/k462533530_1.jpg", 3));

		            // 4번
		            startDate = dateFormat.parse("2023-10-30");
		            endDate = dateFormat.parse("2023-12-31");
		            arr.add(new ArtGalleryInfo("문도멘도 판타스틱시티라이프", "15,000 원", "그라운드시소 서촌", startDate, endDate,
		            		"10:00 ~ 19:00", "https://naver.me/xKQWUady", 
		            		"https://groundseesaw.co.kr/wp-content/uploads/2023/05/MENDO_KV_2%EC%B0%A8_230418-1-1-1500x2193.jpg", 4));

		            // 5번
		            startDate = dateFormat.parse("2023-09-21");
		            endDate = dateFormat.parse("2024-01-07");
		            arr.add(new ArtGalleryInfo("스티키몬스터랩: 스틸 라이프", "15,000 원", "그라운드시소 성수", startDate, endDate, 
		            		"10:00 ~ 19:00", "https://naver.me/5pNEZlT0", 
		            		"https://ticketimage.interpark.com/Play/image/large/23/23011168_p.gif", 5));

					 startDate = dateFormat.parse("2023-07-22");
			    	 endDate = dateFormat.parse("2023-10-27");
			    	 // 6번
			    	arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울 전시회","20000","DDP 뮤지엄 전시 1관",
			    			 startDate, endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
							"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
							5));

			    	// 7
			    	 startDate = dateFormat.parse("2023-09-14");
			    	 endDate = dateFormat.parse("2023-10-14");

			    	 arr.add(new ArtGalleryInfo("동물 없는 동물원 展","15000","DDP 뮤지엄 전시 1관",
			    			 startDate, endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
							"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
							5));
			    	 
			    	 // 8
			    	 startDate = dateFormat.parse("2023-05-05");
			    	 endDate = dateFormat.parse("2023-10-20");

			    	 arr.add(new ArtGalleryInfo("피터팬 전시회","22000","k현대미술관 지하 1층",
			    			 startDate, endDate,"10:00 ~ 19:00","https://naver.me/535BKkXf",
							"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/06/26/1000000101/1000000101_detail_025.jpg",7));

			    	 // 9
			    	 startDate = dateFormat.parse("2023-09-05");
			    	 endDate = dateFormat.parse("2023-10-21");

			    	 arr.add(new ArtGalleryInfo("요시토모 나라","무료","페이스갤러리",
			    		startDate, endDate,"10:00 ~ 18:00","https://naver.me/GHEVTodl",
						"https://og-data.s3.amazonaws.com/media/exhibitions/image/13608/ei_13608.png",6));

			    	 // 10
			    	 startDate = dateFormat.parse("2023-07-22");
			    	 endDate = dateFormat.parse("2023-10-27");

			    	 arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울 전시회","20000","DDP 뮤지엄 전시 1관",
								startDate,endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
								"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
								5));

			    	 //11
			    	 startDate = dateFormat.parse("2023-09-14");
			    	 endDate = dateFormat.parse("2023-10-14");

			    	 arr.add(new ArtGalleryInfo("동물 없는 동물원 展","15000","DDP 뮤지엄 전시 1관",
								startDate,endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
								"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
								5));
			    	 //12
			    	 startDate = dateFormat.parse("2023-05-05");
			    	 endDate = dateFormat.parse("2023-10-20");

			    	 arr.add(new ArtGalleryInfo("피터팬 전시회","22000","k현대미술관 지하 1층",
							startDate,endDate,"10:00 ~ 19:00","https://naver.me/535BKkXf",
							"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/06/26/1000000101/1000000101_detail_025.jpg",7));
							
			    	 //13
			    	 startDate = dateFormat.parse("2023-05-26");
			    	 endDate = dateFormat.parse("2023-10-19");

			    	 arr.add(new ArtGalleryInfo("전자적 숲:소진된 인간","20000","국립현대미술관 서울",
			    			 startDate, endDate,"10:00 ~ 18:00","https://naver.me/54Vkke2z",
							"https://vulktiuibwqqvtbjzlie.supabase.co/storage/v1/object/public/images/exhibition/representative/11931fba-8122-4515-80e2-1e33d8bc9637_poster_2.jpg",4));

			    	 //14
			    	 startDate = dateFormat.parse("2023-09-05");
			    	 endDate = dateFormat.parse("2023-10-21");

			    	arr.add(new ArtGalleryInfo("요시토모 나라","무료","페이스갤러리",
						startDate,endDate,"10:00 ~ 18:00","https://naver.me/GHEVTodl",
						"https://og-data.s3.amazonaws.com/media/exhibitions/image/13608/ei_13608.png",6));

			    	 
			}catch (Exception e) {
					e.printStackTrace();
			}
		} // init()
	
	 // 정보 
    public List<ArtGalleryInfo> getPosters(){
    	return arr;
    }//getPosters()
	
    //최신 - dateStart가 최신인거 
    public List<ArtGalleryInfo> getSortByDateStart() {
        // Comparator를 사용하여 dateStart를 기준으로 정렬
    	for (ArtGalleryInfo info : arr) {
			// 시작날짜가 현재보다 이전이거나 같은
			if (info.getDateStart().before(now) || info.getDateStart().equals(now)) 
			{
				filteredList.add(info);
			}
    	}
		Collections.sort(filteredList, new Comparator<ArtGalleryInfo>() {
            @Override
            public int compare(ArtGalleryInfo o1, ArtGalleryInfo o2) {
                Date date1 = o1.getDateStart();
                Date date2 = o2.getDateStart();
                return date2.compareTo(date1); // dateStart 내림차순 정렬
            }
        });
		for(ArtGalleryInfo a:filteredList )
        {
        	System.out.println(a.getdateStart());
        }
		
		return filteredList;
			
    }
    
    
	// 곧 종료 - 종료 날짜가 currentDate 이후이면서 15일 이하로 차이나는 항목
	public List<ArtGalleryInfo> getsoonEndPosters()
	{
		for (ArtGalleryInfo info : arr) {
	        if (info.getDateEnd().after(now) && isWithin15Days(now, info.getDateEnd())) {
	            filteredList.add(info);
	        }
	    }
		/* 확인용
        for(ArtGalleryInfo a:filteredList )
        {
        	System.out.println(a.toString());
        }
        */
		
		return filteredList;
	}//getsoonEndPosters()
	
	//15일 차이 함수 
	public boolean isWithin15Days(Date currentDate, Date endDate) {
	    long diffInMillis = endDate.getTime() - currentDate.getTime();
	    long daysDifference = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

	    return daysDifference <= 15;
	}//isWithin15Days()
	
	
	// 무료 필터 -가격이 무료인 전시회 정보들
	public List<ArtGalleryInfo> getFreePosters()
	{	
		for (ArtGalleryInfo info : arr) {
			// 시작날짜가 현재보다 이전이거나 같은
			if (info.getDateStart().before(now) || info.getDateStart().equals(now)) {
				if (info.getFee().equals("무료")) {
	            	filteredList.add(info);
	            }
	            /* 확인용
	            for(ArtGalleryInfo a:filteredList )
	            {
	            	System.out.println(a.toString());
	            }
	            */
			}      
        }
		return filteredList;
	}//getFreePosters()

		
		
	// 인기 필터 - 예매(cnt) 많은 순 
	public List<ArtGalleryInfo> getPopulaPosters()
	{
		for (ArtGalleryInfo info : arr) {
			// 시작날짜가 현재보다 이전이거나 같은
			if (info.getDateStart().before(now) || info.getDateStart().equals(now)) 
			{
				
		        filteredList.add(info); 
			}
		}
		
		Collections.sort(filteredList, new Comparator<ArtGalleryInfo>()
		{
            @Override
            public int compare(ArtGalleryInfo o1, ArtGalleryInfo o2) 
            {
                // getcnt() 값을 비교하여 오름차순 정렬
                return Integer.compare(o2.getCnt(), o1.getCnt());
            }
        });
		
		/*
		// 확인
        
        for(ArtGalleryInfo a:filteredList)
        {
        	System.out.println(a.getPo());
        }
        */
		return filteredList;
	}//getPopulaPosters()

	
	public ArtGalleryInfo searchGallery(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addReserveInfo(MyGallery m) {
		// TODO Auto-generated method stub
		
	}

		
	
	
	
	
}

