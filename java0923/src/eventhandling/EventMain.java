package eventhandling;

public class EventMain {

	public static void main(String[] args) {
		//new EventFrame();
		//new EventRouting();
		//new ItemFrame();
		new LoginFrame();
		
		
		/*
		//데이터의 리스트
		ArrayList<String>list = new ArrayList<>();
		list.add("서울");
		list.add("인천");
		list.add("안양");
		list.add("수원");
		list.add("안산");
		list.add("의정부");
		list.add("부천");
		list.add("시흥");
		list.add("남양주");
		list.add("구리");
		list.add("가평");
		
		
		//삭제할 항목의 인덱스 리스트
		ArrayList<Integer>deleteList = new ArrayList<>();
		deleteList.add(0);
		deleteList.add(5);
		deleteList.add(6);
		*/
		//리스트에서 데이터를 삭제하는 메소드 remove(int index)
		//데이터의 리스트를 가지고 인덱스 리스트에 해당하는 데이터를 삭제
		//리스트에서 여러 개를 삭제 할 때는 뒤에서부터 삭제를 하던가
		//삭제할 때마다 인덱스를 변경하던가 해야합니다.
		/*
		for(int dl : deleteList) {
			System.out.printf("%d\n", dl);
		}
		*/
		
		/*
		//deleteList에서 뒤에서부터 데이터를 가져오기
		//인덱스를 가지고 여러 개를 삭제할 때는 
		//뒤에서부터 삭제해야 합니다.
		//앞에서부터 가져오면 뒤의 데이터 인덱스가 변경됩니다.
		for(int i=deleteList.size()-1;i>=0;i=i-1) {
			int idx = deleteList.get(i);
			list.remove(idx);
			
		}
		
		for(String temp : list) {
			System.out.printf("%s\n",temp);
		}
		
*/
	}

}
