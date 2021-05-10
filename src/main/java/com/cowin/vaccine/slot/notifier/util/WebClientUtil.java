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
    @Autowired private CowinPortalProperties cowinPortalProperties;
    private HttpHeaders headers;
    private URI uri;

    @PostConstruct
    private void setUp() throws URISyntaxException {
        uri = new URI(apiProperties.getUrl());
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(cowinPortalProperties.getToken());
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