package lesson.log;

public class Common {
	private static Log4J log = Log4J.getInstance();

	public static void login() {
		System.out.println(log.info("ȸ��"));
	}

	public static void loginFail() {
		System.out.println(log.warn());
	}

}