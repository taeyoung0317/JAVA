package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaverLogin {

	public static void main(String[] args) {
		try {
			//드라이버 위치 등록
			System.setProperty("webdriver.chrome.driver", "/Users/503main/Downloads/chromedriver");
			//크롬 실행
			WebDriver driver = new ChromeDriver();
			//사이트 접속
			driver.get("https://nid.naver.com/nidlogin.login?mode=form&url=https%3A%2F%2Fwww.naver.com");
			
			Thread.sleep(1000);
			
			//id 란에 입력하기
			driver.findElement(By.xpath("//*[@id=\"id\"]")).sendKeys("rororl238");
			//비밀번호 란에 입력하기
			driver.findElement(By.xpath("//*[@id=\"pw\"]")).sendKeys("11");
			
			Thread.sleep(1000);
			
			//로그인 버튼을 클릭
			driver.findElement(By.xpath("//*[@id=\"frmNIDLogin\"]/fieldset/input")).click();
			
			//카페에 접속
			Thread.sleep(1000);
			driver.get("카페주소");
			
			Thread.sleep(1000);
			//프레임 전환 - 코드가 프레임 태그일때
			driver.switchTo().frame(driver.findElement(By.id("down")));
			Thread.sleep(1000);
			driver.findElement(By.xpath("기록 지점")).sendKeys("입력 내용");
			driver.findElement(By.xpath("클릭지점")).click();
			
			
		}catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			e.printStackTrace();
		}
	}

}
