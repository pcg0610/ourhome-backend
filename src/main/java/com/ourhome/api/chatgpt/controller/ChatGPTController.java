package com.ourhome.api.chatgpt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.api.chatgpt.entity.Query;

@RestController
@RequestMapping("/chatgpt")
public class ChatGPTController {

	@GetMapping("")
	public ResponseEntity<?> requestLocationCoords(Query query) {
		
		
		
		return null;
	}
}
