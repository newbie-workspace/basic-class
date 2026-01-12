import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;

public class OpenAPIConsumer2 {

	public static void main(String[] args) throws Exception {
		
		// 아래 url 의 OpenAPI 를 호출해서 결과를 출력
		String sUrl = "https://jsonplaceholder.typicode.com/todos";
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(sUrl)).GET().build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		
		String json = response.body();
		ObjectMapper mapper = new ObjectMapper();
		Todo[] todos = mapper.readValue(json, Todo[].class);
//		for (Todo todo : todos) {
//			System.out.println(todo);
//		}
//		System.out.println();
		System.out.println(Arrays.toString(todos)); //java.util.Arrays
	}
}
