import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class E01GUIApp {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame(); // 윈도우 인스턴스 만들기.
		
		frame.setLayout(null); // 컴포넌트 배치 방법 설정 (절대 좌표로 설정)
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우가 닫힐 때 프로그램도 종료.
		frame.setSize(500, 400); // 윈도우 크기 설정
		frame.setTitle("자바 GUI 연습"); // 캡션바에 표시할 내용 설정
		
		JButton button = new JButton("클릭하시오."); // 버튼 만들기
		button.setSize(140, 50); // 버튼 크기 설정
		button.setLocation(20, 150);
		
		ButtonClickHandler handler = new ButtonClickHandler();
		button.addActionListener(handler); // 버튼 클릭 처리기 등록
		frame.add(button); // 윈도우에 버튼 부착
		
		JButton button2 = new JButton("클릭하시오."); // 버튼 만들기
		button2.setSize(140, 50); // 버튼 크기 설정
		button2.setLocation(180, 150);
		button2.addActionListener(
				
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							JOptionPane.showMessageDialog(null, "클릭했음 2.");
						}
					}
					
				); // 버튼 클릭 처리기 등록
		frame.add(button2); // 윈도우에 버튼 부착
		
		JButton button3 = new JButton("클릭하시오."); // 버튼 만들기
		button3.setSize(140, 50); // 버튼 크기 설정
		button3.setLocation(340, 150);
		button3.addActionListener(e ->  
		
					{
						JOptionPane.showMessageDialog(null, "클릭했음 3.");
						
					}
					
				); // 버튼 클릭 처리기 등록
		frame.add(button3); // 윈도우에 버튼 부착
		
		
		frame.setVisible(true); // 윈도우를 화면에 표시.
		
	}

}

// ActionListener : Button 클릭에 대해 호출할 메서드 규격
class ButtonClickHandler implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "클릭했음."); // javascript 의 alert 에 해당
	}
	
}
