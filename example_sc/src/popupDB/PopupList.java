package popupDB;

import java.util.ArrayList;
import java.util.List;


public class PopupList {
	private static ArrayList<PopupInfo> arr;
	
	public PopupList() {
		if(arr == null) {
			Info();
		}
	}
	
	public List<PopupInfo> Info() {
		ArrayList<PopupInfo> arr = new ArrayList<PopupInfo>();
		
		arr.add(new PopupInfo("라인프렌즈월드 팝업스토어 명동", "02-2118-5134", "인기", "서울 중구 남대문로 67 롯데백화점 본점 영플라자 1F", "무료", "9999-99-99 ~ 9999-99-99", "https://map.naver.com/p/search/%EB%9D%BC%EC%9D%B8%ED%94%84%EB%A0%8C%EC%A6%88%EC%9B%94%EB%93%9C%20%ED%8C%9D%EC%97%85%EC%8A%A4%ED%86%A0%EC%96%B4%20%EB%AA%85%EB%8F%99/place/1734762381?c=13.35,0,0,0,dh&isCorrectAnswer=true", "3", "https://search.pstatic.net/common/?src=https%3A%2F%2Fldb-phinf.pstatic.net%2F20230906_124%2F16939921020947pUv6_JPEG%2FSlice_1.jpg"));
		
		arr.add(new PopupInfo("디올 성수", "02-423-2133", "인기", "서울시 성동구 연무장5길 7, 디올성수", "무료", "2023. 9. 02 ~ 2023. 9. 17 ", "https://map.naver.com/p/entry/place/1289759192?lng=127.05226336915506&lat=37.54388309811852&placePath=%2Fhome&entry=plt&c=15.00,0,0,0,dh", "4", "https://adcr.naver.com/adcr?x=juqMj+EpyWwoLFTeRoZboP///w==kJzMXh1x0l7u6M50YxpfN5OpUPsBfybuWrWuUNLbM83eNopqOlQ/cAo2ghRpyZaCGZ8PG7kszwbuIAPjBR1uAVOhVUfEfvqGmIXMR41fGO+mTxyeu1C1IXrRtUThDDwNkpV53vpyC8NzklOatVyrMPfFvDWhIIBBR+O/1/oAtrYaXYsBogAosjJRDQSP6uYKTjCPBUQ3aLgvdzt4USCbNM7sjAlfGHfrNP+POMgL0rpM5/MnWUWXh4K9Q8Hu009BAaDUTiXIHb3WWK3Xki74NA7afAH16vloBgjMMwOf5l7N00xHHa18Qv3Hh6D2XwtdVtRWc8EcbhM6iWghYsDn5prawKJmVQwWpbIZhiDkyix2WRPL9BeKnpIE2cW+GiFinITs7iPBqUjV73rEGvGB0FMOlWTqv2ccLM9jxMhi1SmYfhsDwl8jFYdIeCbs0Poai7BxtWbcuYD5Cj0fOPkmwX+nHLpW8Ph5iJl/5lSdfnJhe+zgyt9WeXcRtsKR+TQppLjVPe/DKrL4s/oT82wqNI0niTxyzoOkBYYfGPHumps705Iv11raIlIbtHODRtNZPDkbR/5SwH3uSgYKVBijvsvO7+Rw5zmYQryW03uxn1TwGGNgtPpizjMZ018omFsoFPuIcvu4XxvtVTzxZcgtTlyDybeBeBFBDMbUyQQyrXQMd03o8WmlvQIQxMyqDRVX4Vdje4yK5iwAtD6Uc0IetOYT5ZFgrN9Wl+/hdGZL7JHh5KwAdQWMxo/o0k9ZL8B4UciRgU9KyHZDzLtfX06m+9mhaTqZjhuznUx5RSYpAOpYphOxp2V+WksUakXP4W4dZaQuLR+z9Jt3fk7/MLUQO9wDB2bRomVLc6q4xZf0Tdr8CTiod8lPTySOiCtgVpopHRdU1wSvjaf0+PheLr9Wz9aLzoxAByWOSOGH+0bev2bo="));
		
		return arr;
	}
}
