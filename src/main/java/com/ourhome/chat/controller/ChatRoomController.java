package com.ourhome.chat.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.chat.entity.ChatRoom;
import com.ourhome.chat.entity.CreateRequestDto;
import com.ourhome.chat.service.ChatRoomService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("/room")
@Tag(name = "Chat Room Controller", description = "채팅 API")
public class ChatRoomController {

	private final ChatRoomService chatRoomService;

	ChatRoomController(ChatRoomService chatRoomService) {
		this.chatRoomService = chatRoomService;
	}

	@GetMapping("/entered")
	@Operation(
		description = "사용자가 참여하고 있는 리스트를 조회하는 API",
		parameters = {
			@Parameter(name = "userId", description = "사용자 고유번호")			
		},
		responses = {
			@ApiResponse(responseCode = "200", description = "사용자가 참여하고 있는 채팅방 리스트 조회 성공", content = @Content(schema = @Schema(implementation = List.class))),
			@ApiResponse(responseCode = "204", description = "사용자가 참여하고 있는 채팅방이 없습니다.")			
		}	
	)
	public ResponseEntity<?> getEnteredList(@RequestParam(name = "userId") long userId) {
		List<ChatRoom> rooms = chatRoomService.getEnteredList(userId);
		
		if (rooms == null || rooms.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(rooms);
	}

	@PostMapping
	@Operation(
		description = "새로운 채팅방을 생성하는 API",
		responses = {
			@ApiResponse(responseCode = "200", description = "채팅방이 생성되었습니다.")			
		},
		requestBody = @RequestBody(
			description = "채팅창을 생성하기 위한 집 고유번호와 이름",
			required = true,
			content = @Content(
				schema = @Schema(
					implementation = CreateRequestDto.class
				)
			)
		)
	)
	public void createChatRoom(@org.springframework.web.bind.annotation.RequestBody CreateRequestDto requestDto) {
		System.out.println(requestDto);
		chatRoomService.save(requestDto);
	}

	@GetMapping("/{roomId}/message")
	@Operation(
		description = "채팅방의 메시지를 조회하는 API",
		responses = {
			@ApiResponse(responseCode = "200", description = "메시지 조회를 성공했습니다.")
		}
	)
	public ResponseEntity<?> messageList(@PathVariable(value = "roomId") long roomId) {

		// List<Message> room = chatRoomService.getMessageList(roomId);

		return null;
	}
}