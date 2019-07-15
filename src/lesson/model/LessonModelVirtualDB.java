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
				new Lesson("[EBS�� �ܿ�, ������] EBS �������� ��Ű��", 2 , 18),
				new Teacher("������", 37, 10000, "Star", 7),
				new Assistant("������", 29, 5000, 16),
				new Area("������", 200, 1)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG002",
				new Lesson("[2020 NEW] �⺻�� ��Ű�� (õ�Ϲ� �ϼ� X Reading Skills)", 7 , 22),
				new Teacher("�����", 50, 8000, "Good", 20),
				new Assistant("������", 38, 8500, 90),
				new Area("���빮��", 300, 3)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG003",
				new Lesson("[2020 NEW Ȯ����! ��Ű��] ��ĭ�� + ����������", 3 , 21),
				new Teacher("����", 32, 7500, "Best", 3),
				new Assistant("���ϸ���", 28, 3500, 6),
				new Area("���ʱ�", 1000, 1)
		);
		lessonInfoList.add(lsInfo);
		
		lsInfo = new LessonInfo(
				"ENG004",
				new Lesson("��� ��! 5.0 (�������� ����ϴ� ���� ��� ��ȭ ����Ǯ��)", 2 , 10),
				new Teacher("����", 32, 7500, "Best", 3),
				new Assistant("���ϸ���", 28, 3500, 6),
				new Area("���ʱ�", 1250, 4)
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
