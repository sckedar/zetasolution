@RestController
public class TestCLIController {

	@GetMapping("/")
	public String sayhello() {
		return "Hello Spring CLI test!";
	}
}