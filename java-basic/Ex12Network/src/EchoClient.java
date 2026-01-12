import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			
			System.out.print("서버로 전송할 메시지 (종료는 q) : ");
			String message = scanner.nextLine();
			
			if (message.equalsIgnoreCase("q")) {
				System.out.println("통신을 종료합니다.");
				break;
			}
			
			Socket socket = null;
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			OutputStream os = null;
			PrintWriter pw = null;
			
			try {
				
				// 소켓 만들기 + 서버 연결
				//socket = new Socket("127.0.0.1", 9900); // 127.0.0.1 == localhost == 같은 컴퓨터
				socket = new Socket("192.168.0.253", 9900);
				
				try {
					os = socket.getOutputStream();
					pw = new PrintWriter(os);
					pw.println(message);
					pw.flush(); // 전송되지 않은 데이터 강제 전송 
					
					is = socket.getInputStream(); // 네트워크와 연결된 데이터 송수신 도구 (읽기/쓰기 도구)
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					String rMessage = br.readLine();	
					System.out.println(rMessage);
					
				} catch (Exception ex2) {
					ex2.printStackTrace();
				} finally {
					try { br.close(); } catch (Exception ex2) {}
					try { isr.close(); } catch (Exception ex2) {}
					try { is.close(); } catch (Exception ex2) {}
					try { pw.close(); } catch (Exception ex2) {}
					try { os.close(); } catch (Exception ex2) {}
				}		
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				try { socket.close(); } catch (Exception ex) {}
			}
		}
	}
}
