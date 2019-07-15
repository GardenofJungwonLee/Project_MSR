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
	 * -기능 - 모두 검색 => lessonlist안에 있는 모든 info를 리턴 - 개별 검색 (강좌제목, 강의선생님) => 강좌제목 -
	 * 중복X => 강의선생님 - 여러 값. - 추가 - 삭제 (강좌제목) - 업데이트 (강의 이름, 선생님, 지역)
	 */
	private static LessonController instance = new LessonController();
	private LessonInfoService service = LessonInfoService.getInstance();

	private LessonController() {
	}

	public static LessonController getInstance() {
		return instance;
	}

	// 모든 강의 검색
	public void infoListView() {
		ArrayList infoList = service.getAllLessonInfos();
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

	// 새로운 강의 저장
	public void insertLessonInfo(LessonInfo newInfo) {
		service.infoInsert(newInfo);
		EndView.messageView("-- 정상적으로 추가 되었습니다 --");
	}

	// 존재하는 강의 수정(선생님 바꾸기)
	public void updateLessonInfo(String lessonName, People people) {
		try {
			service.infoUpdate(lessonName, people);
			EndView.messageView("-- 정상적으로 수정 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}
	
	// 강의 가격 할인
	public void discountLessonPrice(String lessonName, int discountRate) {
		try {
			service.priceDiscount(lessonName, discountRate);
			EndView.messageView("-- 정상적으로 수정 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}
	
	// 개별 강의 삭제(강의 제목)
	public void deleteLessonInfo(String infoName) {
		try {
			service.infoDelete(infoName);
			EndView.messageView("-- 정상적으로 삭제 되었습니다 --");
		} catch (NotExistException e) {
			FailView.failMessageView(e.getMessage());
			// e.printStackTrace();
		}
	}

	// 강의번호를 키값으로 하는 json객체 생성, 제이슨은 키값이 단일한 값이여야함
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
		EndView.messageView("-- 정상적으로 변환 되었습니다 --");
		return jsonArray;
	}
	

}
