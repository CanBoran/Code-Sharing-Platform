package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    private final String CODE = "public static void main(String[] args) {\n" +
                        "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                        "}";
    private final String TITLE = "Code";

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping(path = "/code", produces = "text/html")
    public ResponseEntity<String> getCode() {
        return ResponseEntity.ok()
                .body("<title>" + TITLE + "</title>"
                        + "<pre>" + CODE + "</pre>");
    }

    @GetMapping(path = "/api/code", produces = "application/json;charset=UTF-8")
    public Map<String, String> getCode2() {
        HashMap<String, String> codeResponse = new HashMap();
        codeResponse.put("code", CODE);
        return codeResponse;
    }
}
