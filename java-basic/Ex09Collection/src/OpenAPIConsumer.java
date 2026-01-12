import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAPIConsumer {

	public static void main(String[] args) throws Exception {
		
		// HttpClient : HTTP 요청을 수행하는 도구.
		HttpClient client = HttpClient.newHttpClient();
		
		// 요청 객체 만들기
		String sUrl = "https://jsonplaceholder.typicode.com/posts/1";
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sUrl)).GET().build();
		
		HttpResponse<String> response =  
				client.send(request, HttpResponse.BodyHandlers.ofString()); // 응답 처리기
//		System.out.printlan(response.toString());		
//		System.out.println(response.body().getClass());
//		System.out.println(response.body());	
		
		String json = response.body();
		// String -> Post 클래스의 인스턴스로 변환. -> 역직렬화 (Deserialization)
		// -> jackson-databind 패키지 설치 필요4
		ObjectMapper mapper = new ObjectMapper();
		Post post = mapper.readValue(json, Post.class);
		System.out.println(post); // 자동으로 post.toString() 호출
	}
}
