import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class E04LottoFrame extends JFrame {
	
	E04LottoFrame() {
		display();
	}
	
	void display() {
		
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setResizable(false);
		
		JButton button = new JButton();
		button.setSize(360, 80);
		button.setLocation(100, 100);
		add(button);
		
		JTextField[] numberFields = new JTextField[6];
		
		int x = 100;
		
		for (int i = 0; i < numberFields.length; i++) {
		
			numberFields[i] = new JTextField();
			numberFields[i].setSize(60,50);
			numberFields[i].setLocation(i * 60 + x, 200);
			numberFields[i].setEditable(false);
			numberFields[i].setHorizontalAlignment(JTextField.CENTER);
			add(numberFields[i]);
		}
		
		button.addActionListener(e -> {
			
			int[] array = new int[6];
			
			for (int i = 0; i < 6; i++) {
			
				array[i]= (int) Math.floor(Math.random() * 45 + 1);
				
				for (int j = 0; j < i; j++) {
					if(array[j] == array[i]) {
						i--;
						break;
					}
				}
			}
			
			Arrays.sort(array);
			
			for (int i = 0; i < 6; i ++) {
				numberFields[i].setText(String.valueOf(array[i]));
			}
		});	
	}

	public static void main(String[] args) {
		
		E04LottoFrame frame = new E04LottoFrame();
		frame.setVisible(true);
	}
}
