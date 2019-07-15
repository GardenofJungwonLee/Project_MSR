package lesson.log;

public class Log4J {

	private static Log4J instance = new Log4J();

	public Log4J() {
	}

	public static Log4J getInstance() {
		return instance;
	}

	public String info(String name) {
		return "�ȳ��ϼ���, " + name + "��";
	}

	public String warn() {
		return "������ �����ϴ�";

	}

	public String error() {
		return "��û�Ͻ� ������ ������ �� �����ϴ�";
	}

	public String right() {
		return "��û�Ͻ� ������ �����Ͽ����ϴ�";
	}

}