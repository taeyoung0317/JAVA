package java0917;

public class Person {
	
	//각각의 속성을 private 변수로 생성
	private String name;
	private String phone;
	private String address;
	private int age;
	
	//접근자 메소드 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//디버깅을 위한 메소드 생성
	@Override
	public String toString() {
		return "Person [name=" + name + ", phone=" + phone + ", address=" + address + ", age=" + age + "]";
	}
	
	
	
}
