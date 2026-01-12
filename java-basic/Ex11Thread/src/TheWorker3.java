
public class TheWorker3 extends Thread {
	
	public void doWork() {
		
		System.out.println("2. doWork의 처음");
		
		try {
			
			Thread.sleep(1000 * 10);// 10초간 실행 중지 -> 깨어날 때 예외 발생
			
		} catch (InterruptedException e) {} 
		
		System.out.println("3. doWork의 끝");
		
	}

	@Override
	public void run() { // 비동기 방식의 호출을 실행하는 메서드
		
		doWork();
	}

}
