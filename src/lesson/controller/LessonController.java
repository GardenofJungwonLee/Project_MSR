package lesson.controller;

import java.util.ArrayList;

import lesson.exception.NotExistException;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.People;
import lesson.service.LessonInfoService;
import net.sf.json.JSONArray;
import view.EndView;
import view.FailView;

public class LessonController {
	private static LessonController instance = new LessonController();
	private LessonInfoService service = LessonInfoService.getInstance();

	private LessonController() {}
	public static LessonController getInstance() {
		return instance;
	}
	// ��� ���� �˻�
	public void infoListView() {
		ArrayList<LessonInfo> infoList = service.getAllLessonInfos();
		if (infoList.size() != 0) {
			EndView.infoListView(infoList);
		} else {
			EndView.messageView("-- ���� ���� ���ǰ� �����ϴ� --");
		}
	}
	// Ư�� ���� �˻� (���� �̸�)
	public void infoViewByTitle(String lessonName) {
		LessonInfo info = service.getLessonInfoByTitle(lessonName);
		if (info != null) {
			EndView.infoViewByTitle(info);
		} else {
			EndView.messageView("-- �ش� ������ ���Ǵ� �������� �ʽ��ϴ� --");
		}
	}
	// Ư�� ���� �˻� (������ �̸�)
	public void infoViewByTeacher(String teacherName) {
		ArrayList<LessonInfo> infoList = service.getLessonInfoByTeacher(teacherName);
		if (infoList.size() != 0) {
			EndView.infoViewByTeacher(infoList);
		} else {
			EndView.messageView("-- �ش� �������� ���Ǵ� �������� �ʽ��ϴ� --");
		}
	}
	// ���ο� ���� �߰�
	public void insertLessonInfo(LessonInfo newInfo) {
		service.infoInsert(newInfo);
		EndView.messageView("-- ���������� �߰� �Ǿ����ϴ� --");
	}
	// �����ϴ� ���� ����(�̸� ���� �˻�, ������ �ٲٱ�)
	public void updateLessonInfo(String lessonName, People people) {
		try {
			service.infoUpdate(lessonName, people);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	// ���� ���� ����
	public void discountLessonPrice(String lessonName, int discountRate) {
		try {
			service.priceDiscount(lessonName, discountRate);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}	
	// ���� ���� ����(���� ����)
	public void deleteLessonInfo(String infoName) {
		try {
			service.infoDelete(infoName);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	// DB ���� jsonArray�� ��ȯ
	public JSONArray jsonConvert() {
		JSONArray jsonArray = new JSONArray();
		for (LessonInfo info : service.getAllLessonInfos()) {
			jsonArray.add(info);
		}
		EndView.messageView("-- ���������� ��ȯ �Ǿ����ϴ� --");
		return jsonArray;
	}
}