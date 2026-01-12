import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
		
	// 목록을 관리하는 변수
	private ArrayList<NewTodo> todos = new ArrayList<>();
	private Scanner scanner= new Scanner(System.in);
	
	public ToDoApp() {
		
		// 여기에 파일에서 데이터를 읽는 코드 구현 : 생성자를 이용해서!
		load();
	}
	
	// 기능 메서드
	// 1. 메뉴 보여주기 + 선택
	// 2. 등록
	// 3. 목록 보기
	// 4. 검색
	// 5. 삭제
	// 6. 수정
	
	public String selectTask() {
		
		System.out.println("=== === === === === === = 연락처 관리 = === === === === === ===");
		System.out.print("1. 등록  ");
		System.out.print("2. 수정  ");
		System.out.print("3. 삭제  ");
		System.out.print("4. 목록  ");
		System.out.print("5. 검색  ");
		System.out.print("6. 저장  ");
		System.out.println("0. 종료");
		System.out.println("=== === === === === === === === === === === === === === ===");
		System.out.print("작업을 선택하시오.");
		String selectedTask = scanner.nextLine();
		return selectedTask;
	}
	
	public void add() {
		
		System.out.print("할 일 : ");
		String title = scanner.nextLine();
		NewTodo todo = new NewTodo(title);		
		todos.add(todo);
	}
	
	public void showList(ArrayList<NewTodo> list) {
		
		for (NewTodo todo : list) {
			System.out.println(todo);
		}
	}
	
	public ArrayList<NewTodo> search() {
		
		System.out.print("검색 키워드 : ");
		String searchWord = scanner.nextLine();
		ArrayList<NewTodo> result = new ArrayList<>();
		
		for(NewTodo todo : todos) {
			if(todo.getTitle().contains(searchWord)) { // 부분 일치 검색.
				result.add(todo);
			}
		}
		
		return result;
	}
	
	public void delete() {
		
		// 검색
		ArrayList<NewTodo> result = search();
		// 목록 표시
		showList(result);
		// 삭제 선택 -> 삭제
		System.out.println("삭제할 할 일 번호 : ");
		String id = scanner.nextLine();
		
		for (int i = result.size() - 1; i > 0; i--) { // 뒤에서 앞으로 가는 반복.
			
			NewTodo todo = todos.get(i);
			if (todos.get(i).getId() == Integer.parseInt(id)) {
				todos.remove(todo);
				break;
			}
		}
	}
	
	public void save() {
		
		String fileName = "todos.dat";
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(todos);
			
		} catch (Exception ex) {
			
			ex.printStackTrace(); // 개발하는 과정에서 사용하는 코드 : 오류 메시지 출력.
			
		} finally {
			
			try { oos.close(); } catch (Exception ex) {} // oos.close(), fos.close() 는 반드시 실행되어야 하므로 따로 try 를 finally 에다가 해야 한다.
			try { fos.close(); } catch (Exception ex) {}
			
		}
	}
	
	public void load() {
		
		String fileName = "todos.dat";
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			
			// 예외 발생이 의심되는 영역 - 여기서 발생한 예외만 catch 해서 처리 가능. 
			
			File f = new File(fileName); // File : 파일의 정보를 다루는 클래스.
			
			if (f.exists()) {
				fis = new FileInputStream(f);
				ois = new ObjectInputStream(fis);
				todos = (ArrayList<NewTodo>)ois.readObject();
				int lastId = todos.getLast().getId();
				NewTodo.setNextId(lastId + 1);
			}
			
		} catch (Exception ex) {
			
			// 예외가 발생하면 실행되는 영역.
			ex.printStackTrace(); // 개발용 오류 출력 메시지.
			
		} finally {
			
			// 예외 발생 여부와 상관없이 무조건 실행.
			try {fis.close();} catch (Exception x){} // oos.close(), fos.close() 는 반드시 실행되어야 하므로 따로 try 를 finally 에다가 해야 한다.
			try {ois.close();} catch (Exception x){}	
		}
	}
	
	public void run() {
		
		// 여기에 파일에서 데이터를 읽는 코드 구현할 수 있다.
		
		while(true) {
			
			System.out.println();
			String task = selectTask();
			System.out.println();
			
			switch(task) {
			
				case "0" : 
					
					System.out.println("프로그램을 종료합니다."); return ; 
					
				case "1" : 
				
					add();
					break;
					
				case "2" :
					
					break;
					
				case "3" :
					
					break;
					
				case "4" :
					
					if (todos.size() == 0) { // size : ArrayList 에 포함된 요소 갯수. (배열의 length)
						System.out.println("등록된 할 일이 없음");
					} else {
						showList(todos);
					}
					
					break;
					
				case "5" :
					
					ArrayList<NewTodo> result = search();
					
					if (result.size() == 0) { // size : ArrayList 에 포함된 요소 갯수. (배열의 length)
						System.out.println("검색 결과가 없습니다.");
					} else {
						showList(result);
					}
					
					break;
					
				case "6" :
					save();
					break;
					
				default  : 
					
					System.out.println("지원하지 않는 키 입력");
			}
		}
	}
	
	public static void main(String[] args) {
		
		ToDoApp app = new ToDoApp();
		app.run();
	}
}












