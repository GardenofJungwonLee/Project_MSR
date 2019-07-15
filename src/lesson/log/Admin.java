package lesson.log;

public class Admin {
	private static Log4J log = Log4J.getInstance();

	public static void login() {
		System.out.println(log.info("°ü¸®ÀÚ"));
	}

	public static void loginFail() {
		System.out.println(log.warn());
	}

}