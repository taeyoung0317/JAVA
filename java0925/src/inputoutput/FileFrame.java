package inputoutput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FileFrame extends JFrame {
	
	JButton btn;
	JTextArea ta;
	JButton btnCreateFile;
	
	public FileFrame() {
		
		JPanel p = new JPanel();
		btn = new JButton("파일 정보 확인");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//파일 대화상자를 만들고 출력하기
				JFileChooser fc = new JFileChooser();
				fc.setMultiSelectionEnabled(false);//true 여러개 선택가능, false 한개만
				int r = fc.showOpenDialog(null);
				//확인을 했다면
				StringBuilder sb = new StringBuilder();
				if(r==JFileChooser.APPROVE_OPTION) {
					File f = fc.getSelectedFile();
					Date d = new Date(f.lastModified());
					sb.append("마지막 수정날짜 : ");
					sb.append(d);
					sb.append("\n");
					
					//파일 크기 출력
					sb.append("파일크기 : ");
					long size = f.length() / 1024;
					sb.append(size);
					sb.append("Kbyte\n");
					
					//오늘 날짜를 이용해서 파일 이름 만들기
					//오늘 날짜.log 로 만들기
					//현재 시간을 만들기
					GregorianCalendar cal = new GregorianCalendar();
					//Date로 변환
					Date today = new Date(cal.getTimeInMillis());
					sb.append("오늘날짜이름 : ");
					sb.append(today.toString());
					sb.append(".log\n");
					//파일 이름 바꾸기
					//변경할 파일 경로로 생성
					//File updateFile = new File("./update.dat");
					//f.renameTo(updateFile);
					//파일의 이름이 3번째부터 뒤에 글자만 저장
					String name = f.getName();
					String mobName = name.substring(3);
					File fff = new File("./"+mobName);
					f.renameTo(fff);
										
					
					
					//파일 존재 여부 확인
					File ff = new File("./bin");
					if(ff.exists()==false) {
						sb.append("해당 파일이 존재하지 않습니다.\n");
					}else {
						sb.append("해당 파일이 존재함\n");
					}
					
					ta.setText(sb.toString());
					
				}else {
					ta.setText("선택한 파일이 없습니다.");
				}
				
			}
			
		});
		
		btnCreateFile = new JButton("파일 생성");
		btnCreateFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//파일 경로를 만들기 - 현재 디렉토리의 오늘날짜.log
				GregorianCalendar cal = new GregorianCalendar();
				Date today = new Date(cal.getTimeInMillis());
				Path path = Paths.get("./"+today.toString()+".log");
				//파일을 생성
				try {
					//예외가 발생하지 않아야 하고 현재 작업 디렉토리에 파일이 생성
					Files.createFile(path);
				} catch (Exception e1) {
					//예외메세지가 null이라고 나오면 NullPointExceotion발생
					System.out.printf("%s\n", e1.getMessage());
				}
				
				
			}
			
		});
		p.add(btnCreateFile);
		p.add(btn);
		add("North",p);
		
		ta = new JTextArea(30,40);
		add(ta);
		
		setBounds(100,100,300,300);
		pack();
		setTitle("File");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
