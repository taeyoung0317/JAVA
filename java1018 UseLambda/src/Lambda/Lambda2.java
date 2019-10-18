package Lambda;

//메소드가 1개만 선언되어 있는지 확인해주는 어노테이션
@FunctionalInterface
interface Inter1{
	public void method();
}

@FunctionalInterface
interface Inter2{
	public void method(int i);
}

@FunctionalInterface
interface Inter3{
	public int method(int i,int j);
}


public class Lambda2 {

	public static void main(String[] args) {
		Inter1 inter1 =()->{
			System.out.printf("매개변수 없는 람다\n");
		};
		inter1.method();
		
		Inter2 inter2 = (i)//괄호생략가능 매개변수가 하나라서
				->{
			for(int x = 0;x<i;x=x+1) {
				System.out.printf("매개변수가 있는 람다\n");
			}
		};
		inter2.method(5);
		
		Inter3 inter3 = (i,j)->{
			return (i+j)/3;
		};
		int result = inter3.method(3, 6);
		System.out.printf("result:%d\n", result);
		
		Inter3 inter4 = new Inter3() {
			public int method(int i, int j) {
				return (i+j)/3;
			}
		};
	}

}
