package csv;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class NoLibraryMain {

	public static void main(String[] args) {
		//파일의 내용을 문자열로 읽기 위한 스트림을 생성
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/503main/Documents/apple.csv")))){
			//데이터를 저장할 리스트
			List<Apple>list=new ArrayList<>();
			//첫번째 줄은 데이터로 사용하지 않기 위해서 만듬
			boolean flag = false;
			//줄단위로 읽기
			while(true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				//첫번째 줄의 데이터는 파싱하지 않음
				if(flag == false) {
					flag = true;
					continue;
				}
				//한 줄로 읽어서 ,로 분할
				String [] ar = line.split(",");
				//한 줄의 데이터를 저장할 객체를 생성
				Apple apple = new Apple();
				apple.setName(ar[0]);
				apple.setPrice(Integer.parseInt(ar[1]));
				String day = ar[2];
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date date = sdf.parse(day);
				apple.setDay(date);
				
				//객체를 리스트에 추가
				list.add(apple);	
			}
			
			for(Apple result : list) {
				System.out.printf("%s\n",result);
			}
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
