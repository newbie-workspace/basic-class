import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class FileDemo {
	
	public static void main(String[] args) {
		
		// 1. File 클래스 : 파일 또는 디렉터리 정보를 관리하는 클래스.
		
		File targetDir = new File("C:\\Users\\human\\Documents"); // 문자열 안에서 \ 를 표현하려면 \\.
		
		// 2. 파일 또는 디렉터리 여부 확인
		
		if(targetDir.isDirectory()) {
			
			System.out.println("디렉터리 경로입니다.");
			
		} else {
			
			System.out.println("파일 경로입니다.");
		}
		
		// 3. 디렉터리인 경우 포함된 파일과 디렉터리 목록 조회
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm"); // 날짜를 문자열로 변환하려고.
		
		File[] files = targetDir.listFiles();
		
		for (File f : files) {
		
			Date d = new Date(f.lastModified());
			
			if (f.isDirectory()) {
				
				System.out.printf("%s %5s %13s %s\n", sdf.format(d)
													, "<DIR>"
													, ""
													, f.getName());
			}
			
			if (f.isFile()) {
				
				System.out.printf("%s %5s %,13d %s\n", sdf.format(d)
													, ""
													, f.length()
													, f.getName());
			}
			
		}
	}
}
