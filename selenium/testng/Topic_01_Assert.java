package testng;

import org.testng.Assert;

public class Topic_01_Assert {

	public static void main(String[] args) {
		//Assert
		String fullName = "Automation Testing";
		
		//Mong đợi 1 điều kiện trả về là đúng
		Assert.assertTrue(fullName.contains("Automation"));

		//Mong đợi 1 điều kiện trả về là sai (false)
		Assert.assertFalse(fullName.contains("Automation"));
		
		//Mong đợi 2 điều kiện bằng nhau
		//Expected, Result và Actual Result bằng nhau
		Assert.assertEquals(fullName, "Automation Testing");
		
	}

}
