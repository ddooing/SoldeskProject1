package artDB;

import java.text.ParseException;
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
    private List<ArtGalleryInfo> filteredList = new ArrayList<ArtGalleryInfo>();
    Calendar currentDate = Calendar.getInstance();
    Date now = currentDate.getTime();//현재 날짜
    
    public ArtGalleryList() {
        if (arr == null) {
        	init();
        }
    }
    
    public void init(){
        arr = new ArrayList<ArtGalleryInfo>(); 
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            // 1번
            Date startDate = dateFormat.parse("2023-08-20");
            Date endDate = dateFormat.parse("2023-10-22");
            arr.add(new ArtGalleryInfo("하이브리드 그라운드", "무료", "자하미술관", startDate, endDate, "10:00 ~ 18:00", "https://naver.me/F1IMO8wD", "https://cdn.misulin.co.kr/news/photo/202308/1676_6540_2753.jpg", 1));
            
            // 2번
            startDate = dateFormat.parse("2023-10-11");
            endDate = dateFormat.parse("2023-10-25");
            arr.add(new ArtGalleryInfo("히피한남 단체전:WABABABA", "무료", "히피 한남", startDate, endDate, "11:00 ~ 19:00", "https://naver.me/GfM6tYKk", "https://archivist.kr/show/image/20231005_hippiehannamgallery.jpg", 2));
            
            // 3번
            startDate = dateFormat.parse("2023-09-21");
            endDate = dateFormat.parse("2024-01-07");
            arr.add(new ArtGalleryInfo("스티키몬스터랩: 스틸 라이프", "15,000 원", "그라운드시소 성수", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/5pNEZlT0", "https://ticketimage.interpark.com/Play/image/large/23/23011168_p.gif", 3));
            
            // 4번
            startDate = dateFormat.parse("2023-09-15");
            endDate = dateFormat.parse("2023-10-22");
            arr.add(new ArtGalleryInfo("쿨라 링: 이야기군도", "무료", "팩토리2", startDate, endDate, "11:00 ~ 19:00",
                  "https://naver.me/xevjReXL",
                  "https://artlecture.com/data/uploads/2023/9/20230920/a125afaeb00d657694277ddce02349d5.jpg", 0));
            // 5번
            startDate = dateFormat.parse("2023-10-04");
            endDate = dateFormat.parse("2024-08-25");
            arr.add(new ArtGalleryInfo("박노해 : 올리브나무 아래", "무료", "라 카페 갤러리",  startDate, endDate, "11:00 ~ 22:00",
                  "https://naver.me/5pNH7n6b", "https://www.munhakin.kr/news/photo/202309/2090_2621_857.jpg", 0));
            // 6번
            startDate = dateFormat.parse("2023-08-30");
            endDate = dateFormat.parse("2023-10-22");
            arr.add(new ArtGalleryInfo("아니쉬 카푸어 개인전", "무료", "삼청동 국제갤러리",  startDate, endDate, "10:00 ~ 18:00",
                  "https://naver.me/IG6G4KcH", "https://img.marieclairekorea.com/2023/08/mck_64ec358f75b8a.png", 0));
            // 7번
            startDate = dateFormat.parse("2023-09-05");
            endDate = dateFormat.parse("2023-10-14");
            arr.add(new ArtGalleryInfo("유에 민쥔 개인전", "20,000 원", "갤러리광화",  startDate, endDate, "11:00 ~ 19:00",
                  "https://naver.me/FPuN115R", "https://cdn.epoquehannam.com/news/photo/202309/1289_3045_400.jpg", 5));
            // 8번
            startDate = dateFormat.parse("2023-06-15");
            endDate = dateFormat.parse("2023-10-22");
            arr.add(new ArtGalleryInfo("환혼 : 빛과 그림자", "무료", "탕 컨템포러리 아트",  startDate, endDate, "10:30 ~ 20:00",
                  "https://naver.me/FPuN115R", "https://cdn.mhns.co.kr/news/photo/202304/552099_672831_5133.jpg", 7));
         // 9번
            startDate = dateFormat.parse("2023-07-22");
        	endDate = dateFormat.parse("2023-10-27");
        	arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울","20,000 원","DDP 뮤지엄 전시 1관",
    				startDate,endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
    				"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/09/39/1000000113/1000000113_detail_010.jpg",
    				0));
        	// 10번
        	startDate = dateFormat.parse("2023-09-14");
        	endDate = dateFormat.parse("2023-10-14");
        	arr.add(new ArtGalleryInfo("동물 없는 동물원 展","15,000 원","DDP 뮤지엄 전시 1관",
    				startDate,endDate,"10:00 ~ 20:00","https://naver.me/FRDLUpbE",
    				"https://cdn.discoverynews.kr/news/photo/202309/1032783_1049509_1455.png",
    				0));
        	// 11번
        	startDate = dateFormat.parse("2023-05-05");
        	endDate = dateFormat.parse("2023-10-20");
        	arr.add(new ArtGalleryInfo("피터팬 전시회","22,000 원","k현대미술관 지하 1층",
    				startDate,endDate,"10:00 ~ 19:00","https://naver.me/535BKkXf",
    				"https://cdn-pro-web-250-118.cdn-nhncommerce.com/exhibition2_godomall_com/data/goods/23/06/26/1000000101/1000000101_detail_025.jpg",0));
            
        	//곧종료 
        	// 12번
        	startDate = dateFormat.parse("2023-05-26");
        	endDate = dateFormat.parse("2023-10-22");
        	arr.add(new ArtGalleryInfo("전자적 숲; 소진된 인간","2,000 원","국립현대미술관 서울",
    				startDate,endDate,"10:00 ~ 18:00","https://naver.me/54Vkke2z",
    				"https://vulktiuibwqqvtbjzlie.supabase.co/storage/v1/object/public/images/exhibition/representative/11931fba-8122-4515-80e2-1e33d8bc9637_poster_2.jpg",9));
        	
            // 13번
            startDate = dateFormat.parse("2023-07-27");
            endDate = dateFormat.parse("2023-10-15");
            arr.add(new ArtGalleryInfo("김범 개인전 바위가 되는 법", "12,000 원", "리움미술관", startDate, endDate,
                    "10:00 ~ 18:00", "https://naver.me/xxxR7VMU",
                    "https://og-data.s3.amazonaws.com/media/exhibitions/image/13472/ei_13472.jpg",
                    13));
            // 14번
            startDate = dateFormat.parse("2023-09-02");
            endDate = dateFormat.parse("2023-10-19");
            arr.add(new ArtGalleryInfo("Rai 개인전", "무료", "갤러리 플레이리스트", startDate, endDate,
                    "11:00 ~ 18:00", "https://naver.me/5nPbHtBL",
                    "https://og-data.s3.amazonaws.com/media/exhibitions/image/13623/ei_13623.jpg",
                    2));
           
            
            
            // 곧전시 목록들
         // 15번
            startDate = dateFormat.parse("2023-10-19");
            endDate = dateFormat.parse("2023-10-27");
            arr.add(new ArtGalleryInfo("캣아트 : 고양이 미술사", "15,000 원", "서울특별시 송파구 신천동 29-1 KT송파타워 3층", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/F9znHvY8", "https://image.aladin.co.kr/product/15876/24/cover500/k462533530_1.jpg", 0));
            
         // 16번
            startDate = dateFormat.parse("2023-10-30");
            endDate = dateFormat.parse("2023-10-14");
            arr.add(new ArtGalleryInfo("문도멘도 판타스틱시티라이프", "15,000 원", "그라운드시소 서촌", startDate, endDate, "10:00 ~ 19:00", "https://naver.me/xKQWUady", "https://groundseesaw.co.kr/wp-content/uploads/2023/05/MENDO_KV_2%EC%B0%A8_230418-1-1-1500x2193.jpg", 0));
            
         // 17번
        	startDate = dateFormat.parse("2023-09-05");
        	endDate = dateFormat.parse("2023-10-21");
        	arr.add(new ArtGalleryInfo("요시토모 나라","무료","페이스갤러리",
    				startDate,endDate,"10:00 ~ 18:00","https://naver.me/GHEVTodl",
    				"https://og-data.s3.amazonaws.com/media/exhibitions/image/13608/ei_13608.png",0));
        	
         // 18번
            startDate = dateFormat.parse("2023-05-26");
            endDate = dateFormat.parse("2023-10-19");
            arr.add(new ArtGalleryInfo("세르주 블로크展 ′KISS′","무료","뉴스뮤지엄 연희",startDate,endDate,
                  "11:00 ~ 19:00","https://naver.me/5QuqLMhp",
                  "https://timeticket.co.kr/wys2/file_attach_thumb/2023/09/27/1695799829-30-3_wonbon_N_7_255x357_70_2.jpg", 
                  0));  
            
            
            
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    
    // 정보 
    public List<ArtGalleryInfo> getPosters(){
    	return arr;
    }
	
	// 곧 종료 정보 :종료 날짜가 currentDate 이후이면서 15일 이하로 차이나는 항목
	public List<ArtGalleryInfo> getsoonEndPosters()
	{
		for (ArtGalleryInfo info : arr) {
	        if (info.getDateEnd().after(now) && isWithin15Days(now, info.getDateEnd())) {
	            filteredList.add(info);
	        }
	    }
		
		return filteredList;
	}
	
	//15일 차이 함수 
	public boolean isWithin15Days(Date currentDate, Date endDate) {
	    long diffInMillis = endDate.getTime() - currentDate.getTime();
	    long daysDifference = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);

	    return daysDifference <= 15;
	}
	
	// 가격이 무료인 전시회 정보들
	public List<ArtGalleryInfo> getFreePosters()
	{	
		for (ArtGalleryInfo info : arr) {
			// 시작날짜가 현재보다 이전이거나 같은
			if (info.getDateStart().before(now) || info.getDateStart().equals(now)) {
				if (info.getFee().equals("무료")) {
	            	filteredList.add(info);
	            }
	            
	            for(ArtGalleryInfo a:filteredList )
	            {
	            	System.out.println(a.toString());
	            }
			}      
        }
		return filteredList;
	}

	public List<ArtGalleryInfo> getPopulaPosters()
	{
		for (ArtGalleryInfo info : arr) {
		
			// posterInfoList를 getcnt() 값에 따라 정렬
	        Collections.sort(info, new Comparator<ArtGalleryInfo>() {
	            @Override
	            public int compare(ArtGalleryInfo o1, ArtGalleryInfo o2) {
	                // getcnt() 값을 비교하여 오름차순 정렬
	                return Integer.compare(o2.getCnt(), o1.getCnt());
	            }
	        });
DF		
	}
	
}