package lesson.model;

import java.util.ArrayList;

import lesson.model.dto.Area;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.Teacher;

public class LessonModelVirtualDB {
	private static LessonModelVirtualDB instance = new LessonModelVirtualDB();
	private ArrayList<LessonInfo> lessonInfoList = new ArrayList<>();

	private  LessonModelVirtualDB() {
		Teacher teacher1 = new Teacher("조정식", 37, 10000, "Star", 7);
		Teacher teacher2 = new Teacher("김기훈", 50, 8000, "Good", 20);
		Teacher teacher3 = new Teacher("빌리", 32, 7500, "Best", 3);
		Assistant assistant1 = new Assistant("이정원", 29, 5000, 16);
		Assistant assistant2 = new Assistant("변영인", 34, 2500, 32);
		Assistant assistant3 = new Assistant("아일리시", 28, 3500, 6);
		LessonInfo lsInfo = new LessonInfo("ENG001", new Lesson("[EBS는 단연, 조정식] EBS 변형문제 패키지", 2, 18),
				teacher1, assistant1, new Area("강남구", 200, 1));
		lessonInfoList.add(lsInfo);		
		lsInfo = new LessonInfo("ENG002", new Lesson("[2020 NEW] 기본기 패키지 (천일문 완성 X Reading Skills)", 7, 22),
				teacher2, assistant2, new Area("서대문구", 300, 3));
		lessonInfoList.add(lsInfo);
		lsInfo = new LessonInfo(
				"ENG003", new Lesson("[2020 NEW 확실해! 패키지] 빈칸편 + 순서삽입편", 3 , 21),
				teacher3, assistant3, new Area("서초구" , 1000, 1));
		lessonInfoList.add(lsInfo);
		lsInfo = new LessonInfo(
				"ENG004", new Lesson("어법 끝! 5.0 (경사관까지 대비하는 수능 어법 심화 문제풀이)", 2 , 10),
				teacher3, assistant3, new Area("서초구", 1250, 4));
		lessonInfoList.add(lsInfo);
	}

	// singtone design
	public static LessonModelVirtualDB getInstance() {
		return instance;
	}

	// infoList 리턴
	public ArrayList<LessonInfo> getLessonInfoList() {
		return instance.lessonInfoList;
	}

	// info 추가
	public void insertInfo(LessonInfo lessonInfo) {
		lessonInfoList.add(lessonInfo);
	}

	// info 삭제
	public void deleteInfo(LessonInfo lessonInfo) {
		lessonInfoList.remove(lessonInfo);
	}
}