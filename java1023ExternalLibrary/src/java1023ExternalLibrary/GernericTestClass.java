package java1023ExternalLibrary;

import org.junit.Test;

import junit.framework.Assert;

public class GernericTestClass {
	
	@Test
	public void test1() {
		//메소드의 수행결과가 333이면 메세지가 없음
		//메소드의 수행결과가 333이 아니면 예외가 발생
		Assert.assertEquals(new Sample().add(300, 33), 334);	
	}
	//@Test가 없어서 수행되지 않음
	public void test2() {
		System.out.printf("뺄셈:%d\n", new Sample().minus(300, 33));
	}

}
