package lesson.view;

import java.util.ArrayList;

import lesson.model.dto.LessonInfo;
import net.sf.json.JSONArray;

public class EndView {
	//모든 강의 출력
	public static void infoListView(ArrayList<LessonInfo> infoList) {
		for (int i = 0; i < infoList.size(); i++) {
			System.out.println("[강의 " + (i + 1) + "]\n" + infoList.get(i) + "\n");
		}
	}
	//일반 메세지 출력
	public static void messageView(String message) {
		System.out.println(message);
	}
	//개별 강의 출력(강의 제목기준)
	public static void infoViewByTitle(LessonInfo info) {
		System.out.println(info);
	}
	//개별 강의 출력(선생님 이름기준)
	public static void infoViewByTeacher(ArrayList<LessonInfo> infoList) {
		for(LessonInfo info : infoList) {
			System.out.println(info);
		}	
	}
	//json array 출력
	public static void jsonView(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.println(jsonArray.get(i));	
		}
	}
}