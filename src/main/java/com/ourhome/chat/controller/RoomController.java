package com.ourhome.chat.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.chat.entity.RoomDto;
import com.ourhome.chat.service.RoomService;
import com.ourhome.chat.service.RoomServiceImpl;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

	private final RoomService roomService;
	
	RoomController(RoomServiceImpl roomService) {
		this.roomService = roomService;
	}
	
	@GetMapping("/entered")
	public ResponseEntity<?> enteredList(@RequestParam(value = "userId") long userId) {
		
		List<RoomDto> rooms = roomService.findAllByUserId(userId);
		
		return ResponseEntity.ok().body(rooms);
	}
}
