

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoApp {
	
	// 연락처 목록을 관리하는 변수
	private Scanner scanner = new Scanner(System.in);
	private ToDoDao toDoDao = new ToDoDao();
	
	public String selectTask() {
		System.out.println("***************** 연락처 관리 ******************");
		System.out.print("* 1.등록 ");
		System.out.print("2.수정 ");
		System.out.print("3.삭제 ");
		System.out.print("4.목록 ");
		System.out.print("5.검색 ");
		System.out.println("0.종료 *");
		System.out.println("**********************************************");
		System.out.print("작업을 선택하세요 : ");
		String selectedTask = scanner.nextLine();
		return selectedTask;
	}
	
	public void add() {
		ToDoDao toDoDao = new ToDoDao();
		System.out.println("할일 입력 : ");
		String title = scanner.nextLine();
		NewToDo todo = new NewToDo(title);
		toDoDao.insertToDo(todo);
	}
	
	public void edit() {
		
		System.out.println("수정할 단어 검색 : ");
		
		String keyword = scanner.nextLine();
		
		ArrayList<NewToDo> result = toDoDao.search(keyword);
		if (result.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
			return;
		} else {
			for (NewToDo todo : result) {
				System.out.println(todo);
			}
		}	
		
		try {
			System.out.println("수정할 todo 번호 입력 : ");
			boolean completed = false;
			int editNumber = scanner.nextInt();
			String editTitle = "";
			scanner.nextLine();
			
			System.out.println("a. 수정 \nb. todo 완료");
			String answer = scanner.nextLine();
			
			if (answer.equalsIgnoreCase("a")) {
				
				System.out.println("수정할 내용 입력 : ");
				editTitle = scanner.nextLine();
				toDoDao.edit(editTitle, editNumber, completed);
				
			} else if (answer.equalsIgnoreCase("b")) {
				completed = true;
				toDoDao.edit(editTitle, editNumber, completed);
			}
			
		} catch (InputMismatchException ex) {
			System.err.println("잘못된 입력입니다.");
		} finally {}
	}

	public void show(ArrayList<NewToDo> todos) {
		
		if(todos.size() == 0) {
			System.out.println("목록이 존재하지 않습니다.");
		} else {
			for (NewToDo todo : todos) {
				System.out.println(todo);
			}
		}
	}
	
	public void searchResults() {
	
		System.out.print("검색 키워드 : ");
		String keyword = scanner.nextLine();
		ArrayList<NewToDo> result = toDoDao.search(keyword);
		if (result.size() == 0) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			for (NewToDo todo : result) {
				System.out.println(todo);
			}
		}	
	}
	
	public void delete() {

		System.out.print("삭제할 todo 번호 : ");
		int id = Integer.parseInt(scanner.nextLine());
		toDoDao.deleteToDo(id);
		
	}
	
	public void run() {
		
		main: while (true) {
			System.out.println();
			String task = selectTask();
			System.out.println();
			
			switch (task) {
				case "0": 
					break main;
					
				case "1": 
					add();
					break;
					
				case "2":
					edit();
					break;
					
				case "3":
					delete();
					break;
					
				case "4":
					show(toDoDao.showToDo());
					break;
					
				case "5":
					searchResults();
					break;
	
				default : 
					System.out.println("지원하지 않는 태스크입니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}	

	public static void main(String[] args) {
		
		ToDoApp app = new ToDoApp();
		app.run();

	}
}
