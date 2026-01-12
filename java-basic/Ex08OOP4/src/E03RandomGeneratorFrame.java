import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class E03RandomGeneratorFrame extends JFrame {
	
	private JButton buttonGenerate;
	private JTextField textMessage;
	
	public E03RandomGeneratorFrame() {
		initUI();
	}
	
	private void initUI() {
		
		super.setLayout(null); // 절대 좌표 및 절대 크기를 사용해서 컴포넌트 배치
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 윈도우 닫기 -> 프로그램 종료
		// setSize(400, 300);
		setSize(new Dimension(400, 300));
		setTitle("난수 발생기");
		setResizable(false); // 윈도우 크기 변경 못하게 설정
		
		buttonGenerate = new JButton("난수 만들기");
		buttonGenerate.setSize(200, 50);
		buttonGenerate.setLocation(95, 50);
		
//		buttonGenerate.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				int n = (int)Math.floor(Math.random() * 900 + 100);
//				textMessage.setText(String.valueOf(n)); // String.valueOf : 문자열이 아닌 자료형 -> 문자열
//			}
//		});
		
		buttonGenerate.addActionListener(e -> {
			
				int n = (int)Math.floor(Math.random() * 900 + 100);
				textMessage.setText(String.valueOf(n)); // String.valueOf : 문자열이 아닌 자료형 -> 문자열
				
			}
		);
		add(buttonGenerate);
		
		textMessage = new JTextField();
		textMessage.setSize(200, 51);
		textMessage.setLocation(95, 120);
		textMessage.setEditable(false);
		textMessage.setHorizontalAlignment(JTextField.CENTER);
		Font f = new Font(null, Font.BOLD, 25);
		textMessage.setFont(f);
		add(textMessage);
		
	}
	
	public static void main(String[] args) {
		
		E03RandomGeneratorFrame frame = new E03RandomGeneratorFrame();
		frame.setVisible(true);
		
	}

}
