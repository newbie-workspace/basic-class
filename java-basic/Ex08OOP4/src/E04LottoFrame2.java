import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class E04LottoFrame2 extends JFrame {
	
	public E04LottoFrame2() {
		
		initUI();
	}
	
	private JButton buttonSelect;
	private JTextField[] textFields = new JTextField[6];
	private Lotto lotto = new Lotto();
	
	private void initUI() {
		
		super.setLayout(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(400, 300));
		setTitle("LottoFrame2");
		setResizable(false); 
		
		buttonSelect = new JButton("Lotto Number Generator");
		buttonSelect.setSize(350, 50);
		buttonSelect.setLocation(20, 50);
		buttonSelect.addActionListener(e -> {
			
				int[] numbers = lotto.selectWinningNumbers();
				for(int i = 0; i < 6; i++) {
					
					textFields[i].setText(String.valueOf(numbers[i]));
				}
			}
		);
		add(buttonSelect);
	
	for (int i = 0; i < textFields.length; i++) {
		
		textFields[i] = new JTextField();
		textFields[i].setSize(50, 50);
		textFields[i].setLocation(20 + i * 60, 120);
		textFields[i].setEditable(false);
		textFields[i].setHorizontalAlignment(JTextField.CENTER);
		add(textFields[i]);
	}
	
	
	}
	
	public static void main(String[] args) {
		E04LottoFrame2 frame = new E04LottoFrame2();
		frame.setVisible(true);
	}
}
	

