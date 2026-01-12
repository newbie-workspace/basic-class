import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) {
		
		System.out.println("***** 서버가 시작되었습니다. *****");
		
		ServerSocket listener = null; // 클라이언트의 연결 요청을 수신해서 통신 채널을 만들고 연결하는 도구 
		try {
			// 소켓만들기 + bind + listen
			listener = new ServerSocket(9900, 100); // port, 대기열 크기	
			
			while (true) {
				
				// 반환된 Socket 객체는 연결된 클라이언트와 통신할 수 있는
				Socket socket = listener.accept(); // 클라이언트 연결 수신 ( 동기 방식 동작 ) + 통신 채널 생성 및 연결	
				InputStream is = null;
				InputStreamReader isr = null;
				BufferedReader br = null;
				OutputStream os = null;
				PrintWriter pw = null;
				
				try {
					is = socket.getInputStream(); // 네트워크와 연결된 데이터 송수신 도구 (읽기/쓰기 도구)
					isr = new InputStreamReader(is);
					br = new BufferedReader(isr);
					String message = br.readLine();	
					System.out.printf("[%s] : %s\n", socket.getRemoteSocketAddress(), message);
					
					os = socket.getOutputStream();
					pw = new PrintWriter(os); 
					pw.println("[MESSAGE FROM SERVER] : " + message); // 클라이언트로 데이트 전송
					pw.flush(); // 전송되지 않은 데이터 강제 전송 
					
				} catch (Exception ex2) {
					ex2.printStackTrace();
				} finally {
					try { br.close(); } catch (Exception ex2) {}
					try { isr.close(); } catch (Exception ex2) {}
					try { is.close(); } catch (Exception ex2) {}
					try { pw.close(); } catch (Exception ex2) {}
					try { os.close(); } catch (Exception ex2) {}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try { listener.close(); } catch (Exception ex) {}
		}
		

	}

}
