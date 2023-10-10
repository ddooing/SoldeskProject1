package artDB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArtGalleryList {
	private static ArrayList<ArtGalleryInfo> arr;

	public ArtGalleryList() {
		if (arr == null) {
			Info();
		}
	}

	public List<ArtGalleryInfo> Info() {
		ArrayList<ArtGalleryInfo> arr = new ArrayList<ArtGalleryInfo>();

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// 1번
			Date startDate = dateFormat.parse("2023-08-20");
			Date endDate = dateFormat.parse("2023-10-22");
			arr.add(new ArtGalleryInfo("하이브리드 그라운드", "무료", "자하미술관", startDate, endDate, "10:00 ~ 18:00",
					"https://naver.me/F1IMO8wD", "src/poster/하이브리드 그라운드.jpg", 1));

			// 2번
			startDate = dateFormat.parse("2023-10-11");
			endDate = dateFormat.parse("2023-10-25");
			arr.add(new ArtGalleryInfo("히피한남 단체전:WABABABA", "무료", "히피 한남", startDate, endDate, "11:00 ~ 19:00",
					"https://naver.me/GfM6tYKk", "src/poster/히피한남 단체전.jpg",
					2));

			// 3번
			startDate = dateFormat.parse("2023-09-21");
			endDate = dateFormat.parse("2024-01-07");
			arr.add(new ArtGalleryInfo("스티키몬스터랩: 스틸 라이프", "15,000 원", "그라운드시소 성수", startDate, endDate, "10:00 ~ 19:00",
					"https://naver.me/5pNEZlT0", "src/poster/스티키몬스터랩.gif",
					3));

			// 4번
			startDate = dateFormat.parse("2023-09-15");
			endDate = dateFormat.parse("2023-10-22");
			arr.add(new ArtGalleryInfo("쿨라 링: 이야기군도", "무료", "팩토리2", startDate, endDate, "11:00 ~ 19:00",
					"https://naver.me/xevjReXL",
					"src/poster/쿨라 링.jpg", 0));
			// 5번
			startDate = dateFormat.parse("2023-10-04");
			endDate = dateFormat.parse("2024-08-25");
			arr.add(new ArtGalleryInfo("박노해 : 올리브나무 아래", "무료", "라 카페 갤러리", startDate, endDate, "11:00 ~ 22:00",
					"https://naver.me/5pNH7n6b", "src/poster/박노해.jpg", 0));
			// 6번
			startDate = dateFormat.parse("2023-08-30");
			endDate = dateFormat.parse("2023-10-22");
			arr.add(new ArtGalleryInfo("아니쉬 카푸어 개인전", "무료", "삼청동 국제갤러리", startDate, endDate, "10:00 ~ 18:00",
					"https://naver.me/IG6G4KcH", "src/poster/아니쉬 카푸어 개인전.png", 0));
			// 7번
			startDate = dateFormat.parse("2023-09-05");
			endDate = dateFormat.parse("2023-10-14");
			arr.add(new ArtGalleryInfo("유에 민쥔 개인전", "20,000 원", "갤러리광화", startDate, endDate, "11:00 ~ 19:00",
					"https://naver.me/FPuN115R", "src/poster/",
					5));
			// 8번
			startDate = dateFormat.parse("2023-06-15");
			endDate = dateFormat.parse("2023-10-22");
			arr.add(new ArtGalleryInfo("환혼 : 빛과 그림자", "무료", "탕 컨템포러리 아트", startDate, endDate, "10:30 ~ 20:00",
					"https://naver.me/FPuN115R", "src/poster/환혼.jpg", 7));
			// 9번
			startDate = dateFormat.parse("2023-07-22");
			endDate = dateFormat.parse("2023-10-27");
			arr.add(new ArtGalleryInfo("알폰스무하 이모션 인 서울", "20,000 원", "DDP 뮤지엄 전시 1관", startDate, endDate,
					"10:00 ~ 20:00", "https://naver.me/FRDLUpbE",
					"src/poster/알폰스무하 이모션 인 서울.jpg",
					0));

			// 10번
			startDate = dateFormat.parse("2023-09-14");
			endDate = dateFormat.parse("2023-10-14");
			arr.add(new ArtGalleryInfo("동물 없는 동물원 展", "15,000 원", "DDP 뮤지엄 전시 1관", startDate, endDate, "10:00 ~ 20:00",
					"https://naver.me/FRDLUpbE",
					"src/poster/동물 없는 동물원 展.png", 1));
			// 11번
			startDate = dateFormat.parse("2023-05-05");
			endDate = dateFormat.parse("2023-10-20");
			arr.add(new ArtGalleryInfo("피터팬 전시회", "22,000 원", "k현대미술관 지하 1층", startDate, endDate, "10:00 ~ 19:00",
					"https://naver.me/535BKkXf",
					"src/poster/피터팬 전시회.jpg",
					0));

			// 12번
			startDate = dateFormat.parse("2023-05-26");
			endDate = dateFormat.parse("2023-10-19");
			arr.add(new ArtGalleryInfo("전자적 숲: 소진된 인간", "2,000 원", "국립현대미술관 서울", startDate, endDate, "10:00 ~ 18:00",
					"https://naver.me/54Vkke2z",
					"src/poster/전자적 숲.jpg",
					9));

			// 13번
			startDate = dateFormat.parse("2023-07-27");
			endDate = dateFormat.parse("2023-12-03");
			arr.add(new ArtGalleryInfo("김범 개인전 바위가 되는 법", "12,000 원", "리움미술관", startDate, endDate, "10:00 ~ 18:00",
					"https://naver.me/xxxR7VMU",
					"src/poster/김범 개인전 바위가 되는 법.jpg", 13));
			// 14번
			startDate = dateFormat.parse("2023-09-02");
			endDate = dateFormat.parse("2023-10-31");
			arr.add(new ArtGalleryInfo("Rai 개인전", "무료", "갤러리 플레이리스트", startDate, endDate, "11:00 ~ 18:00",
					"https://naver.me/5nPbHtBL",
					"src/poster/Rai 개인전.jpg", 2));

			// 곧전시 목록들
			// 15번
			startDate = dateFormat.parse("2023-10-19");
			endDate = dateFormat.parse("2023-11-29");
			arr.add(new ArtGalleryInfo("캣아트 : 고양이 미술사", "15,000 원", "서울특별시 송파구 신천동 29-1 KT송파타워 3층", startDate, endDate,
					"10:00 ~ 19:00", "https://naver.me/F9znHvY8",
					"src/poster/캣아트.jpg", 0));

			// 16번
			startDate = dateFormat.parse("2023-10-19");
			endDate = dateFormat.parse("2024-03-31");
			arr.add(new ArtGalleryInfo("세르주 블로크展 ′KISS′", "무료", "뉴스뮤지엄 연희", startDate, endDate, "11:00 ~ 19:00",
					"https://naver.me/5QuqLMhp",
					"src/poster/세르주 블로크展 ′KISS′.jpg",
					0));

			// 17번
			startDate = dateFormat.parse("2023-10-23");
			endDate = dateFormat.parse("2023-11-21");
			arr.add(new ArtGalleryInfo("요시토모 나라", "무료", "페이스갤러리", startDate, endDate, "10:00 ~ 18:00",
					"https://naver.me/GHEVTodl",
					"src/poster/요시모토 나라.png", 0));

			// 18번
			startDate = dateFormat.parse("2023-10-30");
			endDate = dateFormat.parse("2023-12-31");
			arr.add(new ArtGalleryInfo("문도멘도 판타스틱시티라이프", "15,000 원", "그라운드시소 서촌", startDate, endDate, "10:00 ~ 19:00",
					"https://naver.me/xKQWUady",
					"src/poster/문도멘도 판타스틱시티라이프.jpg",
					0));

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return arr;
	}
}