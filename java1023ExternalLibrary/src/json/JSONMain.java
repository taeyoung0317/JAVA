package json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMain {

	public static void main(String[] args) {
		//웹의 문자열 가져오기
		String json = null;
		try {
			//다운로드 받을 주소 생성
			String addr = "http://swiftapi.rubypaper.co.kr:2029/hoppin/movies?version=1&page=1&count=20&genreId=&order=releasedatease";
			URL url = new URL(addr);
			//연결 객체 생성
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			//옵션 설정
			//최대 30초 동안 연결을 시도
			con.setConnectTimeout(30000);
			//헤더 설정
			con.addRequestProperty("Authorization", "KakaoAK dd9f1c07d0f4c8a1f560b7cf6b9401e5");
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			//문자열을 일시적으로 저장할 객체 생성
			StringBuilder sb = new StringBuilder();
			//줄 단위로 읽어서 sb에 추가
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line+"\n");
			}
			//문자열 변수에 대입
			json = sb.toString();
			//System.out.printf("%s\n", json);
			
			
			
		}catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			e.printStackTrace();
		}
		
		try {
			/*
			//다운로드 받은 문자열을 JSON 객체로 변환
			JSONObject data = new JSONObject(json);
			//documents라는 키의 값을 JSONArray 로 가져오기
			JSONArray documents = data.getJSONArray("documents");
			//배열을 순회
			for(int i=0;i<documents.length();i=i+1) {
				JSONObject movies = documents.getJSONObject(i);
				//문자열 불러올때
				//String thumbnail = item.getString("thumbnail");
				//대괄호로 묶인 값 불러올때
				JSONArray authors = item.getJSONArray("authors");
	
				
				
				System.out.printf("영화제목:%s 평점:%s\n", authors);
			}
			*/
			JSONObject data = new JSONObject(json);
			JSONObject hoppin = data.getJSONObject("hoppin");
			JSONObject movies = hoppin.getJSONObject("movies");
			JSONArray movie = movies.getJSONArray("movie");
			for(int i=0;i<movie.length();i=i+1) {
				JSONObject result = movie.getJSONObject(i);
				String title = result.getString("title");
				String ratingAverage = result.getString("ratingAverage");
				
				System.out.printf("영화제목:%s 평점:%s\n", title, ratingAverage);
			}

			
		}catch(Exception e) {
			System.out.printf("JSON 파싱 예외:%s\n",e.getMessage());
			e.printStackTrace();
		}
	}

}

















