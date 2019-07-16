package lesson.log;

public class Admin {
	private static Log4J log = Log4J.getInstance();
	private static String adminId = "admin";
	private static boolean adminAuthority;

	public static void login() {
		System.out.println(log.info("관리자"));
	}

	public static String loginGUI() {
		adminAuthority = true;
		return log.info("관리자");
	}

	public static void loginFail() {
		System.out.println(log.warn());
	}

	public static String getAdminID() {
		return adminId;
	}
	
	public static Boolean getAdminAuthority() {
		return adminAuthority;
	}

}