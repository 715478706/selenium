package testgit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngTest {

	@BeforeSuite
	public void searchBaidu5(){
		System.out.println("@BeforeSuite开始");
		Assert.assertNotEquals(1,2);

	}
	@BeforeTest
	public void searchBaidu1(){
		System.out.println("@BeforeTest开始");
		Assert.assertNotEquals(1,2);

	}
	@BeforeClass
	public void searchBaidu(){
		System.out.println("@BeforeClass开始");
		Assert.assertNotEquals(1,2);

	}
	@BeforeMethod
	public void searchBaidu6(){
		System.out.println("@BeforeMethod开始");
		Assert.assertNotEquals(1,2);

	}
	@Test
	public void searchBaidu2(){
		System.out.println("准备开始searchBaidu2");
		Assert.assertNotEquals(1,2,"你说吧，我断言失败了");

	}

	@Test
	public void searchBaidu3(){
		System.out.println("准备开始searchBaidu3");
		Assert.assertEquals(2,2,"我现在变成true");

	}
	@Test
	public void searchBaidu4(){
		System.out.println("准备开始searchBaidu4");
		Assert.assertEquals(2,2,"我现在变成true");

	}
}
