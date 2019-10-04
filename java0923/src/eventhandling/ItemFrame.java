package eventhandling;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ItemFrame extends Frame {
	//List (아이템 목록)와 버튼을 배치해서 List에서 선택을 변경했을 때
	//이벤트 처리를 해보고 버튼을  눌렀을 때 List에서 어떤 항목들을 선택했는지 확인
	//Checkbox에서도 선택된 항목을 가져오기
	
	
	List list;
	Checkbox [] checkBoxs;
	Button btn;
	
	//List 나 Choice 처럼 여러 개의 항목을 출력하고 그 중에서 선택된 항목을 가져오는
	//경우에 항목을 배열이나 java.util.List로 만들어 놓는 것이 좋습니다.
	//List에 출력할 항목의 리스트
	ArrayList<String>items;
	
	public ItemFrame() {
		setLayout(new FlowLayout());
		
		//목목 만들기
		items = new ArrayList<String>();
		items.add("사과");
		items.add("배");
		items.add("감");
		items.add("수박");
		items.add("참외");
		items.add("망고");
		items.add("딸기");
		items.add("복숭아");
		items.add("자두");
		items.add("오렌지");
		items.add("포도");
		items.add("메론");
		
		//항복을 출력하는 List 생성하고 데이터 추가하기
		//6개의 항목을 보여주고 여러 개를 선택할 수 있도록 만들어줍니다.
		list = new List(6, true);
		for(String item : items) {
			list.add(item);
		}
		
		//체크박스 배열을 생성하고 각각의 데이터를 생선한 후 프레임에 추가하기
		add(list);
		
		checkBoxs = new Checkbox[5];
		checkBoxs[0]=new Checkbox("구아바");
		checkBoxs[1]=new Checkbox("바나나");
		checkBoxs[2]=new Checkbox("감귤");
		checkBoxs[3]=new Checkbox("람부탄");
		checkBoxs[4]=new Checkbox("망고스틴");
		for(Checkbox box : checkBoxs) {
			add(box);
		}
		
		//버튼을 생성하고 추가
		btn  = new Button("확인");
		add(btn);
		
		//List에서 항목을 선택했을 때 처리
		list.addItemListener(new ItemListener() {
			//List에서 항목을 
			@Override
			public void itemStateChanged(ItemEvent e) {
				//선택 항목 출력-선택이 해제되 아이템과 선택된 아이템의 인데스가 리턴됩니다.
				//System.out.printf("%s", e.getItem());
				//System.out.printf("\n");
				//선택이 변경된 내용
				//선택이 된 아이템은 1 선택이 해제된 아이템은 2가 리턴
				//System.out.printf("%d", e.getStateChange());
				//System.out.printf("\n");
				
				//어떤 메소드의 리턴타입이 Object일 때
				//출력하는 경우를 제외하고는 강제 형 변환해서 사용해야 합니다.
				if(e.getStateChange()==1) {
					System.out.printf("%s가 선택되었습니다.\n", 
							items.get((Integer)e.getItem()));
					
				}else {
					System.out.printf("%s가 선택해제 되었습니다.\n", 
							items.get((Integer)e.getItem()));

				}
							
			}
			
		});
		
		//버튼을 클릭했을 때 List에서 선택된 항목들을 출력
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//List처럼 여러 개의 항목을 출력하는 컴포넌트들은
				//자신의 항목 중에서 몇 번째 항목이 선택되었는지 리턴하는 메소드가 존재합니다.
				//getSelectedIndex, getSelectedindexes
				int [] selectedIndexes = list.getSelectedIndexes();
				//선택한 인덱스를 가지고 items에서 항목을 찾아와서 출력
				for(int i : selectedIndexes) {
					System.out.printf("%s가 선택됨\n", items.get(i));
				}
				
			}
			
		});

		
		setBounds(200,200,600,600);
		setTitle("Item Event!");
		setVisible(true);
		
	}

}
