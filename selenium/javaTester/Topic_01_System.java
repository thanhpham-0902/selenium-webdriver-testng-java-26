package javaTester;

public class Topic_01_System {

	public static void main(String[] args) {
		//lay ra noi luu tru
		String projectPath = System.getProperty("user.dir");
		System.out.println(projectPath);

		//lay ra he dieu hanh dang dung
		String osName = System.getProperty("os.name");
		System.out.println(osName);
	}

}
