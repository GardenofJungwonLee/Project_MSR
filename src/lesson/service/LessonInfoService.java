package lesson.service;

import java.util.ArrayList;

import lesson.exception.NotExistException;
import lesson.model.LessonModelVirtualDB;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.People;
import lesson.model.dto.Teacher;

public class LessonInfoService {

	private static LessonInfoService instance = new LessonInfoService();
	private LessonModelVirtualDB infoVirtualData = LessonModelVirtualDB.getInstance();

	private LessonInfoService() {}
	// singletone
	public static LessonInfoService getInstance() {
		return instance;
	}
	// 모든 lessonInfo 리턴
	public ArrayList<LessonInfo> getAllLessonInfos() {
		return infoVirtualData.getLessonInfoList();
	}
	// 강의 제목으로 검색하여 lessonInfo 리턴
	public LessonInfo getLessonInfoByTitle(String lessonName) {
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getLesson().getTitle().equals(lessonName)) {
				return info;
			}
		}
		return null;
	}
	// 선생님 이름으로 검색하여 lessonInfo 리턴
	public ArrayList<LessonInfo> getLessonInfoByTeacher(String teacherName) {
		ArrayList<LessonInfo> infoList = new ArrayList<LessonInfo>();
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getTeacher().getName().equals(teacherName)) {
				infoList.add(info);
			}
		}
		return infoList;
	}
	// info 추가
	public void infoInsert(LessonInfo newInfo) {
		infoVirtualData.insertInfo(newInfo);
	}
	// info 삭제 (lessonName 기준)
	public void infoDelete(String lessonName) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx 해당 이름의 강의는 존재하지 않습니다. xx\n");
		} else {
			infoVirtualData.deleteInfo(info);
		}
	}
	// info 수정 (선생님 수정)
	public void infoUpdate(String lessonName, People people) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx 해당 이름의 강의는 존재하지 않습니다. xx\n");
		} else if(people instanceof Teacher) {
			info.setTeacher((Teacher)people);
		} else if(people instanceof Assistant) {
			info.setAssistant((Assistant)people);
		} 
	}
	// info 수정 (가격 값 할인하여 수정)
	public void priceDiscount(String lessonName, int discountRate) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx 해당 이름의 강의는 존재하지 않습니다. xx\\n");
		} else {
			Lesson lesson = info.getLesson();
			double beforePrice = lesson.getPrice();
			lesson.setPrice(beforePrice * (100 - discountRate) / 100);
			System.out.println(beforePrice + " 만원 -> " + lesson.getPrice() + " 만원" + " (" + discountRate + " %)");
		}
	}
}