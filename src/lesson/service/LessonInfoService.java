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

	private LessonInfoService() {
	}

	public static LessonInfoService getInstance() {
		return instance;
	}

	public ArrayList<LessonInfo> getAllLessonInfos() {
		return infoVirtualData.getLessonInfoList();
	}

	public LessonInfo getLessonInfoByTitle(String lessonName) {
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getLesson().getTitle().equals(lessonName)) {
				return info;
			}
		}
		return null;
	}

	public ArrayList<LessonInfo> getLessonInfoByTeacher(String teacherName) {
		ArrayList<LessonInfo> infoList = new ArrayList<LessonInfo>();
		for (LessonInfo info : getAllLessonInfos()) {
			if (info != null && info.getTeacher().getName().equals(teacherName)) {
				infoList.add(info);
			}
		}
		return infoList;
	}

	public void infoInsert(LessonInfo newInfo) {
		infoVirtualData.insertInfo(newInfo);
	}

	public void infoDelete(String lessonName) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xxxxxxx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xxxxxxx\n");
		} else {
			infoVirtualData.deleteInfo(info);
		}
	}

	public void infoUpdate(String lessonName, People people) throws NotExistException {
		/* lessonName���� lessonInfo �ҷ��´�
		 * People -> Teacher, Assistant => �ڷ����� ���� �з� �Ѵ�
		 * - Teacher ��, ���ΰ��縦 �ٲ��ش�
		 * - Assistant ��, �������縦 �ٲ��ش�
		 */
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xxxxxxx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xxxxxxx\n");
		} else if(people instanceof Teacher) {
			info.setTeacher((Teacher)people);
		} else if(people instanceof Assistant) {
			info.setAssistant((Assistant)people);
		} 
	}

	public void priceDiscount(String lessonName, int discountRate) throws NotExistException {
		LessonInfo info = getLessonInfoByTitle(lessonName);
		if (info == null) {
			throw new NotExistException("xxxxxxx �ش� �̸��� ���Ǵ� �������� �ʽ��ϴ�. xxxxxxx\n");
		} else {
			Lesson lesson = info.getLesson();
			lesson.setPrice(lesson.getPrice() * (100 - discountRate) / 100);
		}
		
	}
}