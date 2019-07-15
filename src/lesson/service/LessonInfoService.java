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
	// ��� lessonInfo ����
	public ArrayList<LessonInfo> getAllLessonInfos() {
		return infoVirtualData.getLessonInfoList();
	}
	// ���� �������� �˻��Ͽ� lessonInfo ����
	public LessonInfo getLessonInfoByTitle(String lessonName) {
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getLesson().getTitle().equals(lessonName)) {
				return info;
			}
		}
		return null;
	}
	// ������ �̸����� �˻��Ͽ� lessonInfo ����
	public ArrayList<LessonInfo> getLessonInfoByTeacher(String teacherName) {
		ArrayList<LessonInfo> infoList = new ArrayList<LessonInfo>();
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getTeacher().getName().equals(teacherName)) {
				infoList.add(info);
			}
		}
		return infoList;
	}
	// info �߰�
	public void infoInsert(LessonInfo newInfo) {
		infoVirtualData.insertInfo(newInfo);
	}
	// info ���� (lessonName ����)
	public void infoDelete(String lessonName) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xx\n");
		} else {
			infoVirtualData.deleteInfo(info);
		}
	}
	// info ���� (������ ����)
	public void infoUpdate(String lessonName, People people) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xx\n");
		} else if(people instanceof Teacher) {
			info.setTeacher((Teacher)people);
		} else if(people instanceof Assistant) {
			info.setAssistant((Assistant)people);
		} 
	}
	// info ���� (���� �� �����Ͽ� ����)
	public void priceDiscount(String lessonName, int discountRate) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xx\\n");
		} else {
			Lesson lesson = info.getLesson();
			lesson.setPrice(lesson.getPrice() * (100 - discountRate) / 100);
		}
	}
}