package java1023ExternalLibrary;

import junit.framework.TestCase;

public class SampleTest extends TestCase {
	
	public void test1() {
		System.out.printf("덧셈:%d\n", new Sample().add(300, 33));
	}
	
	public void test2() {
		System.out.printf("뺄셈:%d\n", new Sample().minus(300, 33));
	}

}
