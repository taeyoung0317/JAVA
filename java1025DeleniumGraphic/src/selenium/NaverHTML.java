package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverHTML {

	public static void main(String[] args) {
		try {
			//드라이버 위치 등록
			System.setProperty("webdriver.chrome.driver", "/Users/503main/Downloads/chromedriver");
			//크롬 실행
			WebDriver driver = new ChromeDriver();
			//사이트 접속
			driver.get("http://www.naver.com");
			//html을 가져와서 출력
			System.out.printf("%s\n", driver.getPageSource());
			
			
		}catch(Exception e) {
			System.out.printf("크롬 실행 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
