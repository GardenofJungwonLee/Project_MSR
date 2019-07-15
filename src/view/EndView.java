package view;

import java.util.ArrayList;

import lesson.model.dto.LessonInfo;
import net.sf.json.JSONArray;

public class EndView {
	//��� ���� ���
	public static void infoListView(ArrayList lessonList) {
		for (int i = 0; i < lessonList.size(); i++) {
			System.out.println("[���� " + (i + 1) + "]\n" + lessonList.get(i) + "\n");
		}
	}
	
	//�Ϲ� �޼��� ���
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	//���� ���� ���(���� �������)
	public static void infoViewByTitle(LessonInfo info) {
		System.out.println(info);
	}
	//���� ���� ���(������ �̸�����)
	public static void infoViewByTeacher(ArrayList<LessonInfo> infoList) {
		for(LessonInfo info : infoList) {
			System.out.println(info);
		}
		
	}
	//json array ���
	public static void jsonView(JSONArray jsonArray) {
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.println(jsonArray.get(i));	
		}
	}
	

}
