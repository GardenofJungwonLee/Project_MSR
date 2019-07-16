package lesson.log;

public class Log4J {

	private static Log4J instance = new Log4J();

	public Log4J() {
	}

	public static Log4J getInstance() {
		return instance;
	}

	public String info(String name) {
		return "안녕하세요, " + name + "님";
	}

	public String warn() {
		return "권한이 없습니다";

	}

	public String error() {
		return "요청하신 정보를 수행할 수 없습니다";
	}

	public String right() {
		return "요청하신 정보를 수행하였습니다";
	}

}