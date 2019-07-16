package lesson.model;

import java.util.ArrayList;

import lesson.model.dto.Area;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.Teacher;

public class LessonModelVirtualDB {
	private static LessonModelVirtualDB instance = new LessonModelVirtualDB();
	private ArrayList<LessonInfo> lessonInfoList = new ArrayList<>();

	private  LessonModelVirtualDB() {
		Teacher teacher1 = new Teacher("������", 37, 10000, "Star", 7);
		Teacher teacher2 = new Teacher("�����", 50, 8000, "Good", 20);
		Teacher teacher3 = new Teacher("����", 32, 7500, "Best", 3);
		Assistant assistant1 = new Assistant("������", 29, 5000, 16);
		Assistant assistant2 = new Assistant("������", 34, 2500, 32);
		Assistant assistant3 = new Assistant("���ϸ���", 28, 3500, 6);
		LessonInfo lsInfo = new LessonInfo("ENG001", new Lesson("[EBS�� �ܿ�, ������] EBS �������� ��Ű��", 2, 18),
				teacher1, assistant1, new Area("������", 200, 1));
		lessonInfoList.add(lsInfo);		
		lsInfo = new LessonInfo("ENG002", new Lesson("[2020 NEW] �⺻�� ��Ű�� (õ�Ϲ� �ϼ� X Reading Skills)", 7, 22),
				teacher2, assistant2, new Area("���빮��", 300, 3));
		lessonInfoList.add(lsInfo);
		lsInfo = new LessonInfo(
				"ENG003", new Lesson("[2020 NEW Ȯ����! ��Ű��] ��ĭ�� + ����������", 3 , 21),
				teacher3, assistant3, new Area("���ʱ�" , 1000, 1));
		lessonInfoList.add(lsInfo);
		lsInfo = new LessonInfo(
				"ENG004", new Lesson("��� ��! 5.0 (�������� ����ϴ� ���� ��� ��ȭ ����Ǯ��)", 2 , 10),
				teacher3, assistant3, new Area("���ʱ�", 1250, 4));
		lessonInfoList.add(lsInfo);
	}

	// singtone design
	public static LessonModelVirtualDB getInstance() {
		return instance;
	}

	// infoList ����
	public ArrayList<LessonInfo> getLessonInfoList() {
		return instance.lessonInfoList;
	}

	// info �߰�
	public void insertInfo(LessonInfo lessonInfo) {
		lessonInfoList.add(lessonInfo);
	}

	// info ����
	public void deleteInfo(LessonInfo lessonInfo) {
		lessonInfoList.remove(lessonInfo);
	}
}