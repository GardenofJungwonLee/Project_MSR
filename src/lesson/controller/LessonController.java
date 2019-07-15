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
	/*
	 * -��� - ��� �˻� => lessonlist�ȿ� �ִ� ��� info�� ���� - ���� �˻� (��������, ���Ǽ�����) => �������� -
	 * �ߺ�X => ���Ǽ����� - ���� ��. - �߰� - ���� (��������) - ������Ʈ (���� �̸�, ������, ����)
	 */
	private static LessonController instance = new LessonController();
	private LessonInfoService service = LessonInfoService.getInstance();

	private LessonController() {
	}

	public static LessonController getInstance() {
		return instance;
	}

	// ��� ���� �˻�
	public void infoListView() {
		ArrayList infoList = service.getAllLessonInfos();
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

	// ���ο� ���� ����
	public void insertLessonInfo(LessonInfo newInfo) {
		service.infoInsert(newInfo);
		EndView.messageView("-- ���������� �߰� �Ǿ����ϴ� --");
	}

	// �����ϴ� ���� ����(������ �ٲٱ�)
	public void updateLessonInfo(String lessonName, People people) {
		try {
			service.infoUpdate(lessonName, people);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}
	
	// ���� ���� ����
	public void discountLessonPrice(String lessonName, int discountRate) {
		try {
			service.priceDiscount(lessonName, discountRate);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}
	
	// ���� ���� ����(���� ����)
	public void deleteLessonInfo(String infoName) {
		try {
			service.infoDelete(infoName);
			EndView.messageView("-- ���������� ���� �Ǿ����ϴ� --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}

	// ���ǹ�ȣ�� Ű������ �ϴ� json��ü ����, ���̽��� Ű���� ������ ���̿�����
	public JSONArray jsonConvert() {
//		JSONObject jsonObject = new JSONObject();
//		for (LessonInfo info : service.getAllLessonInfos()) {
//			jsonObject.put(info.getSerialNumber(), JSONObject.fromObject(info));
//		}
//		System.out.println(jsonObject);
		JSONArray jsonArray = new JSONArray();
		for (LessonInfo info : service.getAllLessonInfos()) {
			jsonArray.add(info);
		}
		EndView.messageView("-- ���������� ��ȯ �Ǿ����ϴ� --");
		return jsonArray;
	}
	

}
