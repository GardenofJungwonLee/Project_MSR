package lesson.view;

import java.util.Scanner;

import lesson.controller.LessonController;
import lesson.log.Admin;
import lesson.log.Common;
import lesson.model.dto.Area;
import lesson.model.dto.Assistant;
import lesson.model.dto.Lesson;
import lesson.model.dto.LessonInfo;
import lesson.model.dto.Teacher;

public class StartView {
	public static void main(String[] args) {
		// Log4J�� ���� �α��� ����
		System.out.print("ID �Է� : ");
		Scanner scanner = new Scanner(System.in);
		String id = scanner.next();
		scanner.close();
		boolean adminAuthority = false;
		if (id.equals("Admin")) {
			Admin.login();
			adminAuthority = true;
		} else if (id.equals("Teacher")) {
			Common.login();
		} else {
			System.out.println("�������� �ʴ� ID�Դϴ�!");
			return;}
		// ���� ���
		LessonController controller = LessonController.getInstance();
		System.out.println("== ��ü ���� �˻� ==");
		controller.infoListView();
		
		System.out.println("== ���� ���� �˻� ==");
		controller.infoViewByTitle("[EBS�� �ܿ�, ������] EBS �������� ��Ű��");

		System.out.println("\n== ������ �̸� �˻� ==");
		controller.infoViewByTeacher("����");

		System.out.println("\n== ���� �߰� �� ������ �̸� �˻� ==");
		if (adminAuthority) {
		controller.insertLessonInfo(
				new LessonInfo("ENG008", 
				new Lesson("õ�Ϲ� �ٽ� (5�ֿ� ������ �ٽ� ����, ���� ������)", 2, 9),
				new Teacher("�����", 50, 8000, "Good", 20), 
				new Assistant("������", 38, 8500, 90),
				new Area("�д籸", 200, 4)));
		} else {System.out.println("������ �����ϴ�!");}
		controller.infoViewByTeacher("�����");
	
		System.out.println("\n== ���� ���� �� ������ �̸� �˻� ==");
		if (adminAuthority) {
		controller.deleteLessonInfo("[EBS�� �ܿ�, ������] EBS �������� ��Ű��");
		} else {System.out.println("������ �����ϴ�!");}
		controller.infoViewByTeacher("������");
		
		System.out.println("\n== ���������� ���� �� ������ �̸� �˻� ==");
		if (adminAuthority) {
		controller.updateLessonInfo("õ�Ϲ� �ٽ� (5�ֿ� ������ �ٽ� ����, ���� ������)", 
				new Assistant("������", 40, 7500, 10));
		} else {System.out.println("������ �����ϴ�!");}
		controller.infoViewByTeacher("�����");
		
		System.out.println("\n== json��ü ��ȯ �� ��� ==");
		EndView.jsonView(controller.jsonConvert());
	
		System.out.println("\n== ���� ���� ���� ==");
		controller.discountLessonPrice("[2020 NEW Ȯ����! ��Ű��] ��ĭ�� + ����������", 40);
		controller.infoViewByTeacher("����");
		}
}
