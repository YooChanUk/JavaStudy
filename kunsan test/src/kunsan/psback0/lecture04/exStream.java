package kunsan.psback0.lecture04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class exStream 
{
	public static void main(String args[])
	{
		String[] sn = {
				"110101‐4xxxxxx", "881225‐1xxxxxx",
				"010815‐3xxxxxx", "881225‐1xxxxxx",
				"081111‐4xxxxxx", "771225‐1xxxxxx",
				"800101‐2xxxxxx", "701225‐1xxxxxx",
				"950101‐1xxxxxx", "101212‐3xxxxxx"
				};
		
		// 0. 수집된 데이터를 다루기 편한(List) 자료구조로 변경
		List<String> list = Arrays.asList(sn);
		
		// 1. 전체 출력
		list.stream().forEach(s->System.out.println(s));
		
		// 2. 전체 인원
		long count = list.stream().count();
		
		System.out.println(count+"명");
		
		// 3. 여자 몇명?
		// filter : 원하는 데이터를 추출
		// filter(입력값 하나, 리턴값이 boolean) ‐> 결과물은 리턴값이 true인 스트림만
		long femaleCount = list.stream().filter(s -> Integer.parseInt(s.substring(7, 8))%2==0).count();
		System.out.println(femaleCount);
		list.stream().filter(s -> Integer.parseInt(s.substring(7, 8))%2==0).forEach(s -> System.out.println(s));
		
		// map : 기존 데이터를 이용하여 새로운 데이터
		// 나이 추출 하여 나이순 리스트를 생성
		// 4. 스트림 ‐> 새로운 리스트 형성
		// 주민번호 리스트 ‐> 주민번호 스트림 ‐> 나이 리스트 ‐> 나이 스트림 ‐> 나이 리스트
		Calendar c = Calendar.getInstance();
		int y = c.get(Calendar.YEAR) - 2000;
		// map(입력값 하나, 리턴값이 기본타입값) ‐> 결과물은 리턴값들로 만들어진 새로운 스트림
		List<Integer> ageList = new ArrayList<>();
		list.stream().map((s) -> {
									int age = y - Integer.parseInt(s.substring(0, 2));
									return age > 0 ? age : age+100;
									}).sorted().forEach(s -> 
									{System.out.println(s); 
										ageList.add(s);});
		
		// 람다식 if문을 사용하기가....if문을 대신가능한 삼항연산자를 많이 사용

		//list.stream().map((s) -> {
									//int age = y-Integer.parseInt(s.substring(0, 2));
									//return age > 0 ? age : age+100;
									//}).sorted().forEach(s -> ageList.add(s)); // 다시 리스트로....
		
		System.out.println(ageList);
		}
	}
