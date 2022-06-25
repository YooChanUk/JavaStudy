package kunsan.psback0.lecture04;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.lang.System.Logger;

public class exStream2 {
	//static Logger log = LoggerFactory.getLogger(MainSN.class);
	public static void main(String[] args) {
	String[] sn = {
	"110101‐4xxxxxx", "881225‐1xxxxxx",
	"010815‐3xxxxxx", "881225‐1xxxxxx",
	"081111‐4xxxxxx", "771225‐1xxxxxx",
	"800101‐2xxxxxx", "701225‐1xxxxxx",
	"950101‐1xxxxxx", "101212‐3xxxxxx"
	};
	// 1. 전체 인원수 구하기
	// count() 집계함수, sum(), average(),...
	long totalCnt = Arrays.asList(sn).stream().count();
	//log.debug("전체 :"+totalCnt+"명");
	// 2. 남자, 여자 인원수 구하기 ‐ filter(람다)
	long maleCnt = Arrays.asList(sn).stream().filter(s -> Integer.parseInt(s.substring(7, 8))%2==1).count();
	//log.debug("남자 :"+maleCnt+"명");
	long femaleCnt = Arrays.asList(sn).stream().filter(s -> Integer.parseInt(s.substring(7, 8))%2==0).count();
	//log.debug("남자 :"+femaleCnt+"명");
	// 3. 나이 리스트 만들기 ‐ map(람다)
	Calendar c = Calendar.getInstance();
	// 2021 ‐ 1999 = 22 ‐> 2021‐2099+100
	int y = c.get(Calendar.YEAR) - 2000; // 2021‐2000 ‐‐> 21
	List<Integer> ageList = Arrays.asList(sn).stream().map(s -> {
	int age = y - Integer.parseInt(s.substring(0, 2));
	return age > 0 ? age : age+100;
	}).collect(Collectors.toList());
	ageList.stream().forEach(age -> System.out.print(age+" ")); // 10 33 20 33 13 44 41 51 26 11
	
	
	// 4. 나이의 총합 ‐ reduce(초기치, 람다)
	int ageTotal = ageList.stream().reduce(0, (result, age) -> result+age);
	//log.debug("ageTotal :"+ageTotal); // 282
	// 5. 나이의 최대값
	int maxAge = ageList.stream().reduce(Integer.MIN_VALUE,(a,b)-> a>b? a:b); // 0/10, 10/33, 33/20, ...44/51, 51/26, 51/11
	//log.debug("maxAge :"+maxAge);
	int minAge = ageList.stream().reduce(Integer.MAX_VALUE,(a,b)-> a>b? b:a);
	//log.debug("minAge :"+minAge);
	// 정렬한 스트림을 다시 다른 리스트로...
	List<Integer> ageListAsc = ageList.stream().sorted().collect(Collectors.toList());
	for(int age : ageListAsc) {
	System.out.println(age);
	}
	Collections.sort(ageList); // ageList 자체를 정렬
	for(int age : ageList) {
	System.out.println(age);
	}
	}
}
