package com.cowin.vaccine.slot.notifier.util;

import com.cowin.vaccine.slot.notifier.config.*;
import static java.lang.String.format;
import java.net.*;
import java.util.*;
import javax.annotation.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.*;
import org.springframework.util.*;
import org.springframework.web.reactive.function.client.*;
import reactor.core.publisher.*;

@Component
public class WebClientUtil {
    @Autowired  private ApiProperties apiProperties;
    private HttpHeaders headers;
    private URI uri;

    @PostConstruct
    private void setUp() throws URISyntaxException {
        uri = new URI(apiProperties.getUrl());
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
 //   headers.put("authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJiZjliNDk1OC02MmYxLTQ4MDctOGI1YS03ZGU4YzdkNjc2NDMiLCJ1c2VyX2lkIjoiYmY5YjQ5NTgtNjJmMS00ODA3LThiNWEtN2RlOGM3ZDY3NjQzIiwidXNlcl90eXBlIjoiQkVORUZJQ0lBUlkiLCJtb2JpbGVfbnVtYmVyIjo5MTc1NDc5ODcwLCJiZW5lZmljaWFyeV9yZWZlcmVuY2VfaWQiOjQ4NzgxNzQyOTY5NDUwLCJzZWNyZXRfa2V5IjoiYjVjYWIxNjctNzk3Ny00ZGYxLTgwMjctYTYzYWExNDRmMDRlIiwidWEiOiJNb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXaW42NDsgeDY0KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvOTAuMC40NDMwLjkzIFNhZmFyaS81MzcuMzYiLCJkYXRlX21vZGlmaWVkIjoiMjAyMS0wNS0wOVQxMTo0NToyNC40MTlaIiwiaWF0IjoxNjIwNTYwNzI0LCJleHAiOjE2MjA1NjE2MjR9.fqnE6QAs1KxTbrlxnQKkdl1L44YR-t0KRSQLKHN1JFY");
        headers.setBearerAuth("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJiZjliNDk1OC02MmYxLTQ4MDctOGI1YS03ZGU4YzdkNjc2NDMiLCJ1c2VyX2lkIjoiYmY5YjQ5NTgtNjJmMS00ODA3LThiNWEtN2RlOGM3ZDY3NjQzIiwidXNlcl90eXBlIjoiQkVORUZJQ0lBUlkiLCJtb2JpbGVfbnVtYmVyIjo5MTc1NDc5ODcwLCJiZW5lZmljaWFyeV9yZWZlcmVuY2VfaWQiOjQ4NzgxNzQyOTY5NDUwLCJzZWNyZXRfa2V5IjoiYjVjYWIxNjctNzk3Ny00ZGYxLTgwMjctYTYzYWExNDRmMDRlIiwidWEiOiJNb3ppbGxhLzUuMCAoV2luZG93cyBOVCAxMC4wOyBXaW42NDsgeDY0KSBBcHBsZVdlYktpdC81MzcuMzYgKEtIVE1MLCBsaWtlIEdlY2tvKSBDaHJvbWUvOTAuMC40NDMwLjkzIFNhZmFyaS81MzcuMzYiLCJkYXRlX21vZGlmaWVkIjoiMjAyMS0wNS0wOVQxMTo0NToyNC40MTlaIiwiaWF0IjoxNjIwNTYwNzI0LCJleHAiOjE2MjA1NjE2MjR9.fqnE6QAs1KxTbrlxnQKkdl1L44YR-t0KRSQLKHN1JFY");
    }
    public WebClient.ResponseSpec getAndRetrieve() { return WebClient.builder().build()
                .get()
                .uri(uri)
                .headers(httpHeaders -> httpHeaders.putAll(headers))
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> logAndThrowException(response, uri))
                .onStatus(HttpStatus::is5xxServerError, response -> logAndThrowException(response, uri));
    }

    protected static Mono<? extends Throwable> logAndThrowException(
            ClientResponse response, URI uri) {
        HttpStatus status = response.statusCode();
        return response
                .bodyToMono(String.class)
                .flatMap(
                        body -> {
                            String msg =
                                    format("Received HTTP %s and body [%s] while fetching [%s].", status, body, uri);
                            return Mono.error(new Exception(msg));
                        });
}
}