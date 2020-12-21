package platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class CodeSharingPlatform {

    public static void main(String[] args) {
        SpringApplication.run(CodeSharingPlatform.class, args);
    }

    @GetMapping("/code")
    public ResponseEntity<String> getCode() {
        HttpHeaders header = new HttpHeaders();
        header.set("title", "Code");

        return ResponseEntity.ok()
                .headers(header)
                .body("<title>Code</title>" + "<pre>\n" +
                        "public static void main(String[] args) {\n" +
                        "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                        "}</pre>");
    }

    @GetMapping("/api/code")
    public Map<String, String> getCode2() {
        HashMap<String, String> code = new HashMap();
        code.put("code", "public static void main(String[] args) {\n" +
            "    SpringApplication.run(CodeSharingPlatform.class, args);\n" +
                    "}");
        return code;
    }
}
