import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class E02MyFrame extends JFrame {
	
	public E02MyFrame() {
		// 다른 초기화 구현 +
		// initUI()
		initUI();
	}
	
	private void initUI() {
		
		setLayout(null); // 컴포넌트 배치 방법 설정 (절대 좌표로 설정)
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우가 닫힐 때 프로그램도 종료.
		setSize(500, 400); // 윈도우 크기 설정
		setTitle("자바 GUI 연습"); // 캡션바에 표시할 내용 설정
		
		JButton button3 = new JButton("클릭하시오."); // 버튼 만들기
		button3.setSize(200, 50); // 버튼 크기 설정
		button3.setLocation(150, 150);
		button3.addActionListener(e -> {  
			
			Container container = getContentPane(); // 윈도우에서 사용자 영역 반환
			int r = (int) Math.floor(Math.random() * 256);
			int g = (int) Math.floor(Math.random() * 256);
			int b = (int) Math.floor(Math.random() * 256);
			Color c = new Color(r, g, b);
			container.setBackground(c);
			
		}); // 버튼 클릭 처리기 등록
		
		add(button3); // 윈도우에 버튼 부착
		
	}
	
	public static void main(String[] args) {
		
		JFrame frame = new E02MyFrame(); // 윈도우 인스턴스 만들기.
		frame.setVisible(true); // 윈도우를 화면에 표시.
		
	}

}

