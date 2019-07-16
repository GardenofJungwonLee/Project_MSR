package lesson.log;

import java.util.ArrayList;

public class Common {
	private static Log4J log = Log4J.getInstance();
	private static ArrayList<String> idList = new ArrayList<>();
	private static boolean commonAuthority;

	public static void login() {
		System.out.println(log.info("회원"));
	}

	public static String loginGUI(String id) {
		commonAuthority = true;
		return log.info(id);
	}

	public static void loginFail() {
		System.out.println(log.warn());
	}

	public static void addID(String id) {
		idList.add(id);
	}

	public static ArrayList<String> getIdList() {
		return idList;
	}
	
	public static boolean getCommonAuthority() {
		return commonAuthority;
	}

}