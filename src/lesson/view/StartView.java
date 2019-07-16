package lesson.view;

import java.util.Scanner;

import lesson.controller.LessonController;
import lesson.log.Admin;
import lesson.log.Common;
import lesson.model.dto.Area;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.Teacher;

public class StartView {
	public static void main(String[] args) {
		// Log4J를 통한 로그인 관리
		System.out.print("ID 입력 : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		scanner.close();
		boolean adminAuthority = false;
		if (id.equals("Admin")) {
			Admin.login();
			adminAuthority = true;
		} else if (id.equals("Teacher")) {
			Common.login();
		} else {
			System.out.println("존재하지 않는 ID입니다!");
			return;}
		// 메인 기능
		LessonController controller = LessonController.getInstance();
		System.out.println("== 전체 강의 검색 ==");
		controller.infoListView();
		
		System.out.println("== 강의 제목 검색 ==");
		controller.infoViewByTitle("[EBS는 단연, 조정식] EBS 변형문제 패키지");

		System.out.println("\n== 선생님 이름 검색 ==");
		controller.infoViewByTeacher("빌리");

		System.out.println("\n== 강의 추가 후 선생님 이름 검색 ==");
		if (adminAuthority) {
		controller.insertLessonInfo(
				new LessonInfo("ENG008", 
				new Lesson("천일문 핵심 (5주에 끝내는 핵심 문법, 구문 총정리)", 2, 9),
				new Teacher("김기훈", 50, 8000, "Good", 20), 
				new Assistant("변영인", 38, 8500, 90),
				new Area("분당구", 200, 4)));
		} else {System.out.println("권한이 없습니다!");}
		controller.infoViewByTeacher("김기훈");
	
		System.out.println("\n== 강의 삭제 후 선생님 이름 검색 ==");
		if (adminAuthority) {
		controller.deleteLessonInfo("[EBS는 단연, 조정식] EBS 변형문제 패키지");
		} else {System.out.println("권한이 없습니다!");}
		controller.infoViewByTeacher("조정식");
		
		System.out.println("\n== 보조선생님 수정 후 선생님 이름 검색 ==");
		if (adminAuthority) {
		controller.updateLessonInfo("천일문 핵심 (5주에 끝내는 핵심 문법, 구문 총정리)", 
				new Assistant("변영휜", 40, 7500, 10));
		} else {System.out.println("권한이 없습니다!");}
		controller.infoViewByTeacher("김기훈");
		
		System.out.println("\n== json객체 변환 및 출력 ==");
		EndView.jsonView(controller.jsonConvert());
	
		System.out.println("\n== 강좌 가격 할인 ==");
		controller.discountLessonPrice("[2020 NEW 확실해! 패키지] 빈칸편 + 순서삽입편", 40);
		controller.infoViewByTeacher("빌리");
		}
}
