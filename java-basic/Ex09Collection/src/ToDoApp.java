import java.util.ArrayList;
import java.util.Scanner;

public class ToDoApp {
		
	// 목록을 관리하는 변수
	private ArrayList<NewTodo> todos = new ArrayList<>();
	private Scanner scanner= new Scanner(System.in);
	// 기능 메서드
	// 1. 메뉴 보여주기 + 선택
	// 2. 등록
	// 3. 목록 보기
	// 4. 검색
	// 5. 삭제
	// 6. 수정
	
	public String selectTask() {
		
		System.out.println("=== === === === === 연락처 관리 === === === === ===");
		System.out.print("1. 등록  ");
		System.out.print("2. 수정  ");
		System.out.print("3. 삭제  ");
		System.out.print("4. 목록  ");
		System.out.print("5. 검색  ");
		System.out.println("0. 종료");
		System.out.println("=== === === === === === === === === === === ===");
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
			if(todo.getTitle().contains(searchWord)) { // 부분 일치 검색
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
		
		for (int i = result.size() - 1; i > 0; i--) { // 뒤에서 앞으로 가는 반복
			
			NewTodo todo = todos.get(i);
			if (todos.get(i).getId() == Integer.parseInt(id)) {
				todos.remove(todo);
				break;
			}
		}
	}
	
	public void run() {
	
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
					
					if (todos.size() == 0) { // size : ArrayList 에 포함된 요소 갯수 (배열의 length)
						System.out.println("등록된 할 일이 없음");
					} else {
						showList(todos);
					}
					
					break;
					
				case "5" :
					
					ArrayList<NewTodo> result = search();
					
					if (result.size() == 0) { // size : ArrayList 에 포함된 요소 갯수 (배열의 length)
						System.out.println("검색 결과가 없습니다.");
					} else {
						showList(result);
					}
					
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












