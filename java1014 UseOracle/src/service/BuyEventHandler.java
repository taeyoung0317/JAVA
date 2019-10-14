package service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.BuyDao;
import domain.Buy;
import view.BuyView;

public class BuyEventHandler implements ActionListener {

	BuyView buyView;
	
	public BuyEventHandler(BuyView buyView) {
		super();
		//변수는 아무런 기호가 붙지 않으면 가까운 곳에서 만들어진 것을 사용
		//this.을 붙히면 메소드 외부에서 찾아서 사용
		//super.을 붙이면 상위 클래스에서 찾아서 사
		this.buyView = buyView;
	}
	
	//버튼을 누르거나 텍스트 필드에서 Enter키를 누를 때
	//처리를 위한 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "<<":
			if(buyView.idx==0) {
				JOptionPane.showMessageDialog(null, "첫번째 데이터입니다.");
				return;
			}
			buyView.idx = 0;
			buyView.display();
			break;
		case "<":
			//첫번째 데이터만 마지막으로 변경
			if(buyView.idx==0) {
				buyView.idx = buyView.list.size()-1;
			}else {
				buyView.idx=buyView.idx-1;
			}
			buyView.display();
			
			break;
		case ">":
			if(buyView.idx==buyView.list.size()-1) {
				buyView.idx = 0;
			}else {
				buyView.idx=buyView.idx+1;
			}
			buyView.display();
			
			
			break;
		case ">>":
			if(buyView.idx==buyView.list.size()-1) {
				JOptionPane.showMessageDialog(null, "마지막 데이터입니다.");
				return;
			}
			
			buyView.idx=buyView.list.size()-1;
			buyView.display();
			break;
		case "삭제":
			int result = JOptionPane.showConfirmDialog(null, "정말로 삭제", "삭제", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				//현재 데이터를 가져오기
				Buy buy = buyView.list.get(buyView.idx);
				//데이터베이스에서 삭제
				BuyDao dao = new BuyDao();
				dao.deleteBuy(buy.getBuycode());
				//메모리에서 삭제
				buyView.list.remove(buyView.idx);
				//idx를 조정하고 다시 출력
				buyView.idx=0;
				buyView.display();
			}
			break;
		case "수정":
			//입력한 내용 가져오기
			Buy buy = new Buy();
			//현재 데이터의 buycode를 가져와서 설정
			buy.setBuycode(buyView.list.get(buyView.idx).getBuycode());
			
			String itemname = buyView.txtItemName.getText().trim();
			if(itemname.length()<1) {
				JOptionPane.showMessageDialog(null, "아이템 이름은 필수 입력 사항입니다.");
				return;
			}			
			buy.setItmename(itemname);
			String customerid = buyView.txtCustomerId.getText().trim();
			if(customerid.length()<1) {
				JOptionPane.showMessageDialog(null, "구매자 ID는 필수 입력 사항입니다.");
				return;
			}
			buy.setCustomerid(customerid);
			String count = buyView.txtCount.getText().trim();
			int len = count.length();
			String imsi = "";
			//문자열에서 각각의 글자를 가져와서 숫자이면 imsi에 더해주고
			//숫자가 아니면 중단
			for(int i=0;i<len;i=i+1) {
				char ch = count.charAt(i);
				if(ch>='0' && ch<='9') {
					imsi = imsi + ch ;
				}else {
					break;
				}
			}
			if(imsi.length()==0) {
				imsi="0";
			}
			buy.setCount(Integer.parseInt(imsi));		
			int r = JOptionPane.showConfirmDialog(null, "정말로 수정","수정",JOptionPane.YES_NO_OPTION);
			if(r==JOptionPane.YES_OPTION) {
				
				//buyView.list.remove(buyView.idx);
				//buyView.list.add(buyView.idx, buy);
				//데이터 수정
				BuyDao dao = new BuyDao();
				dao.updateBuy(buy);
				//데이터 다시 불러오기(데이터수정 후 바로 수정된 데이터 디스플레이해서 보여줌)
				buyView.list = dao.getList();
				buyView.display();
			}
			break;
		case "지움":
			buyView.btnDelete.setEnabled(false);
			buyView.btnUpdate.setEnabled(false);
			buyView.btnSearch.setEnabled(false);
			buyView.txtItemName.setText("");
			buyView.txtCustomerId.setText("");
			buyView.txtCount.setText("");
			buyView.txtBuyDate.setText("");
			//자신의 텍스트를 변경 - 토글 버튼으로 사용
			buyView.btnClear.setText("취소");
			
			break;
		case "취소":
			buyView.btnDelete.setEnabled(true);
			buyView.btnUpdate.setEnabled(true);
			buyView.btnSearch.setEnabled(true);
			
			buyView.btnClear.setText("지움");
			
			buyView.display();
			
			break;
		}
	}

}
























