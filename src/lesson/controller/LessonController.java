package lesson.controller;

import java.util.ArrayList;

import lesson.exception.NotExistException;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.People;
import lesson.service.LessonInfoService;
import lesson.view.EndView;
import lesson.view.FailView;
import net.sf.json.JSONArray;

public class LessonController {
	private static LessonController instance = new LessonController();
	private LessonInfoService service = LessonInfoService.getInstance();

	private LessonController() {}
	public static LessonController getInstance() {
		return instance;
	}
	// 모든 강의 검색
	public void infoListView() {
		ArrayList<LessonInfo> infoList = service.getAllLessonInfos();
		if (infoList.size() != 0) {
			EndView.infoListView(infoList);
		} else {
			EndView.messageView("-- 진행 중인 강의가 없습니다 --");
		}
	}
	// 특정 강의 검색 (강의 이름)
	public void infoViewByTitle(String lessonName) {
		LessonInfo info = service.getLessonInfoByTitle(lessonName);
		if (info != null) {
			EndView.infoViewByTitle(info);
		} else {
			EndView.messageView("-- 해당 제목의 강의는 존재하지 않습니다 --");
		}
	}
	// 특정 강의 검색 (선생님 이름)
	public void infoViewByTeacher(String teacherName) {
		ArrayList<LessonInfo> infoList = service.getLessonInfoByTeacher(teacherName);
		if (infoList.size() != 0) {
			EndView.infoViewByTeacher(infoList);
		} else {
			EndView.messageView("-- 해당 선생님의 강의는 존재하지 않습니다 --");
		}
	}
	// 새로운 강의 추가
	public void insertLessonInfo(LessonInfo newInfo) {
		service.infoInsert(newInfo);
		EndView.messageView("-- 정상적으로 추가 되었습니다 --");
	}
	// 존재하는 강의 수정(이름 기준 검색, 선생님 바꾸기)
	public void updateLessonInfo(String lessonName, People people) {
		try {
			service.infoUpdate(lessonName, people);
			EndView.messageView("-- 정상적으로 수정 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	// 강의 가격 할인
	public void discountLessonPrice(String lessonName, int discountRate) {
		try {
			service.priceDiscount(lessonName, discountRate);
			EndView.messageView("-- 정상적으로 수정 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}	
	// 개별 강의 삭제(강의 제목)
	public void deleteLessonInfo(String infoName) {
		try {
			service.infoDelete(infoName);
			EndView.messageView("-- 정상적으로 삭제 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	// DB 값들 jsonArray로 변환
	public JSONArray jsonConvert() {
		JSONArray jsonArray = new JSONArray();
		for (LessonInfo info : service.getAllLessonInfos()) {
			jsonArray.add(info);
		}
		EndView.messageView("-- 정상적으로 변환 되었습니다 --");
		return jsonArray;
	}
}