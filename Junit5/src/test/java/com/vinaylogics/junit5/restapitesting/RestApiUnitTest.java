package com.vinaylogics.junit5.restapitesting;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vinaylogics.junit5.models.GithubUser;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RestApiUnitTest {

    @Test
    public void givenUserDoesNotExists_whenUserInfoIsRetrieved_then404IsReceived() throws  IOException, InterruptedException {
        // Given
        String name = RandomStringUtils.randomAlphanumeric(8);
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.github.com/users/" + name )).build();
        HttpClient httpClient = HttpClient.newBuilder().build();


        // When
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Then
        assertEquals(response.statusCode(), 404);
    }

    @Test
    public void givenRequestWithNoAcceptHeader_whenRequestIsExecuted_thenDefaultResponseContentTypeIsJson() throws IOException, InterruptedException {
        // Given
        String jsonMimeType = "application/json";
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.github.com/users/eugenp")).build();
        HttpClient httpClient = HttpClient.newBuilder().build();


        // When
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        List<String> contentType = response.headers().map().get("content-type");
        // Then
        assertFalse(contentType.isEmpty());
        assertTrue(contentType.get(0).contains(jsonMimeType));
    }

    @Test
    public void givenUserExists_whenUserInformationIsRetrieved_thenRetrievedResourceIsCorrect() throws IOException, InterruptedException {
        // Given
        HttpRequest request = HttpRequest.newBuilder(URI.create("https://api.github.com/users/eugenp")).build();
        HttpClient httpClient = HttpClient.newBuilder().build();


        // When
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // Then
        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        GithubUser githubUser = mapper.readValue(response.body(), GithubUser.class);
        assertEquals("eugenp", githubUser.getLogin());
    }
}
