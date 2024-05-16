package com.ourhome.chat.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.chat.entity.EnteredRoom;
import com.ourhome.chat.service.RoomService;
import com.ourhome.chat.service.RoomServiceImpl;

@RestController
@RequestMapping("/api/v1/room")
public class RoomController {

	private final RoomService service;
	
	RoomController(RoomServiceImpl service) {
		this.service = service;
	}
	
	@GetMapping("")
	public List<EnteredRoom> list() {
		return service.findAll();
	}
}
