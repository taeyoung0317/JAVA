package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SelectFrame extends JFrame {

	JComboBox oop;
	JList language;

	// JComboBox 와 JList 에 데이터를 출력하기 위한 배열
	String [] ar;
	String [] br;

	// 버튼
	JButton btn;

	// 테이블
	JTable table;

	// 입력할 번호를 저장할 변수
	int idx = 3;
	// 부품명과 수량을 입력할 텍스트 필드
	JTextField txtName, txtCom;
	// 제조회사를 선택할 콤보박스
	JComboBox cbNo;
	// 삽입과 삭제를 위한 버튼
	JButton btnInsert, btnDelete;

	public SelectFrame() {

		ar = new String[4];
		ar[0] = "---";// 필수 선택이 아닌 것처럼 구현(콤보박스는 무조건 하나를 선택해야하기 때문에)
		ar[1] = "Encapsulation - 캡슐화";
		ar[2] = "Inheritance - 상속성";
		ar[3] = "Polymorphism - 다형성";

		br = new String[4];
		br[0] = "Java";
		br[1] = "JavaScript";
		br[2] = "SQL";
		br[3] = "Swift";

		oop = new JComboBox(ar);
		language = new JList(br);
		btn = new JButton("확인");
		JPanel panel = new JPanel();
		panel.add(oop);
		panel.add(language);
		panel.add(btn);

		add("North", panel);

		// btn을 누르면 oop에서 선택한 항목과 language에서 선택한 항목을 콘솔 출력
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 콤보박스에서 선택한 항목의 인덱스를 찾아오기
				int x = oop.getSelectedIndex();
				System.out.printf("ComboBox : %s\n", ar[x]);
				// 리스트에서 선택한 항목의 인덱스 집합 찾아오기
				int[] y = language.getSelectedIndices();
				for (int temp : y) {
					System.out.printf("JList : %s\n", br[temp]);
				}
			}

		});

		// 테이블에 출력할 데이터 배열을 생성
		String[] headers = { "No.", "부품명", "제조회사", "부품수량(ea)" };
		String[][] datas = { { "1", "릴레이", "파나소닉", "32" }, 
				{ "2", "서보모터", "LS", "3" },
				{ "3", "드라이버", "공구상가", "12" }
			};

		// 데이터 배열을 가지고 테이블에 출력할 모델을 생성
		DefaultTableModel model = new DefaultTableModel(datas, headers);
		// 테이블 생성
		table = new JTable(model);
		// 테이블은 스크롤 가능한 Pane 위에 출력해야 합니다.
		JScrollPane sc = new JScrollPane(table);
		add(sc);

		JLabel lblName = new JLabel("부품명");
		txtName = new JTextField(20);
		JLabel lblNo = new JLabel("부품수량");
		String[] arNo = new String[100];
		for (int i = 0; i < 100; i = i + 1) {
			arNo[i] = String.format("%d", i + 1);
		}
		cbNo = new JComboBox(arNo);

		JLabel lblCom = new JLabel("제조회사");
		txtCom = new JTextField(20);

		btnInsert = new JButton("추가");
		btnDelete = new JButton("삭제");

		JPanel southPanel = new JPanel();
		southPanel.add(lblName);
		southPanel.add(txtName);
		southPanel.add(lblNo);
		southPanel.add(cbNo);
		southPanel.add(lblCom);
		southPanel.add(txtCom);
		southPanel.add(btnInsert);
		southPanel.add(btnDelete);

		add("South", southPanel);

		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				int no = cbNo.getSelectedIndex() + 1;
				String com = txtCom.getText();
				// name은 좌우공백없이 2자이상
				if (name.trim().length() < 2) {
					JOptionPane.showMessageDialog(null, "부품명은 2자 이상 입력하십시오.");
					return;
				}
				if (com.trim().length() < 1) {
					JOptionPane.showMessageDialog(null, "제조회사명을 입력하십시오.");
					return;
				}
				
				//JTable은 MVC 패턴으로 구현
				//JTable은 화면에 출력되는 부분만 제어
				//데이터 삽입과 삭제는 모델이 수행
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				idx =idx+1;
				String [] row = {idx+"",name.trim(),com.trim(),no+""};
				//데이터 추가
				model.addRow(row);
				JOptionPane.showMessageDialog(null, "부품 추가 완료.");
				//입력도구들을 초기화
				txtName.setText("");
				cbNo.setSelectedIndex(0);
				txtCom.setText("");
				
			}

		});
		
		//삭제 버튼 클릭 이벤트 구현
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//테이블에서 선택된 행번호 가져오기
				int idx = table.getSelectedRow();
				//선택이 안된 경우는 음수
				if(idx<0) {
					JOptionPane.showMessageDialog(
							null, "삭제할 항목을 선택해 주시기 바랍니다.");
					return;
				}
				
				//정말로 삭제할 것인지 확인
				int r = JOptionPane.showConfirmDialog(
						null, "항목에서 제거하시겠습니까?","삭제",
						JOptionPane.OK_CANCEL_OPTION);
				//OK를 눌렀을 때만 삭제
				if(r==JOptionPane.OK_OPTION) {
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				model.removeRow(idx);
				}
			}
			
		});
		

		// 닫기 버튼을 누를 때 종료해주는 기능 추가
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(200, 200, 500, 500);
		// 배치되는 컴포넌트 크기들을 가지고 프레임의 사이즈를 조정
		pack();
		setTitle("항목선택.");
		setVisible(true);
	}

}
