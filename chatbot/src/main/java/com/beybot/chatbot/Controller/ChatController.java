package com.beybot.chatbot.Controller;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping
    public ResponseEntity<Map<String, String>> askBot(@RequestBody Map<String, String> body) {
        try {
            String prompt = body.get("prompt");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> payload = new HashMap<>();
            payload.put("model", "llama3");
            payload.put("prompt", prompt);
            payload.put("stream", false);

            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(
                    "http://localhost:11434/api/generate",
                    entity,
                    Map.class
            );

            String responseText = (String) response.getBody().get("response");

            Map<String, String> result = new HashMap<>();
            result.put("answer", responseText);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("answer", "Error: " + e.getMessage());
            return ResponseEntity.status(500).body(error);
        }
    }
}