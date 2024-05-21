package com.ourhome.api.chatgpt.entity;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class RequestRunner {
	
	private final String HOST_URL = "https://api.openai.com/v1/chat/completions";
	
	@Value("openai.api-key")
	private String API_KEY;
	
	private String get(String jsonMessage) {
		OkHttpClient client = new OkHttpClient();
		
		RequestBody body = RequestBody.create(jsonMessage, MediaType.get("application/json; charset=utf-8"));
		
		Request request = new Request.Builder()
				.url(HOST_URL)
				.post(body)
				.addHeader("Content-Type", "application/json")
				.addHeader("Authorization", "Bearer " + HOST_URL)
				.build();
		
		try (Response response = client.newCall(request).execute()) {
			if (!response.isSuccessful()) {
				System.out.println(response.body());
			}
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		return null;
	}
}
