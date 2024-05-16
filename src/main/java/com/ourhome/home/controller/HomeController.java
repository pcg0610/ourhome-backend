package com.ourhome.home.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.home.entity.Home;
import com.ourhome.home.service.HomeService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	private final HomeService homeService;
	
	HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("/{homeId}")
	public ResponseEntity<?> detail(
			@Parameter(description = "조회할 매물의 아이디")
			@PathVariable(value = "homeId") long homeId) {
		Home home = homeService.getHome(homeId);
		
		return ResponseEntity.ok().body(home);
	}
	
	@GetMapping("/favorites")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "사용자가 즐겨찾기한 매물 리스트입니다."),
			@ApiResponse(responseCode = "204", description = "즐겨찾기한 매물이 없습니다!")
	})
	public ResponseEntity<?> favoritesList(@RequestBody long userId) {
		List<Home> favoritesList = homeService.getFavoritesList(userId);
		
		if (favoritesList == null || favoritesList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		return ResponseEntity.ok().body(favoritesList);
	}
	
//	@GetMapping("/")
}