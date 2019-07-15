package lesson.model;

import java.util.ArrayList;

import lesson.model.dto.Area;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.Teacher;

public class LessonModelVirtualDB {
	private static LessonModelVirtualDB instance = new LessonModelVirtualDB();
	private ArrayList lessonInfoList = new ArrayList<>();

	private  LessonModelVirtualDB() {
		LessonInfo lsInfo = new LessonInfo(
				"ENG001",
				new Lesson("[EBS는 단연, 조정식] EBS 변형문제 패키지", 2 , 18),
				new Teacher("조정식", 37, 10000, "Star", 7),
				new Assistant("이정원", 29, 5000, 16),
				new Area("강남구", 200, 1)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG002",
				new Lesson("[2020 NEW] 기본기 패키지 (천일문 완성 X Reading Skills)", 7 , 22),
				new Teacher("김기훈", 50, 8000, "Good", 20),
				new Assistant("변영인", 38, 8500, 90),
				new Area("서대문구", 300, 3)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG003",
				new Lesson("[2020 NEW 확실해! 패키지] 빈칸편 + 순서삽입편", 3 , 21),
				new Teacher("빌리", 32, 7500, "Best", 3),
				new Assistant("아일리시", 28, 3500, 6),
				new Area("서초구", 1000, 1)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG004",
				new Lesson("어법 끝! 5.0 (경사관까지 대비하는 수능 어법 심화 문제풀이)", 2 , 10),
				new Teacher("빌리", 32, 7500, "Best", 3),
				new Assistant("아일리시", 28, 3500, 6),
				new Area("서초구", 1250, 4)
		);
		lessonInfoList.add(lsInfo);
	}

	public static LessonModelVirtualDB getInstance() {
		return instance;
	}
	
	public ArrayList<LessonInfo> getLessonInfoList () {
		return instance.lessonInfoList;
	}
	
	public void insertInfo (LessonInfo lessonInfo) {
		lessonInfoList.add(lessonInfo);
	}
	
	public void deleteInfo (LessonInfo lessonInfo) {
		lessonInfoList.remove(lessonInfo);
	}
	
	public static void main(String[] args) {
		LessonModelVirtualDB db = LessonModelVirtualDB.getInstance();
		
		for(LessonInfo lsInfo : db.getLessonInfoList()) {
			System.out.println(lsInfo);
		}

	}

}
