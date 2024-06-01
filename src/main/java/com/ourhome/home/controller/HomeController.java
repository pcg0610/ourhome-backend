package com.ourhome.home.controller;

import java.util.List;

import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.auth.service.UserService;
import com.ourhome.home.entity.ComboboxItemDto;
import com.ourhome.home.entity.FavoriteEntity;
import com.ourhome.home.entity.Home;
import com.ourhome.home.entity.SearchCondition;
import com.ourhome.home.service.HomeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/homes")
@Validated
public class HomeController {

	private final HomeService homeService;
	private final UserService userService;

	HomeController(HomeService homeService, UserService userService) {
		this.homeService = homeService;
		this.userService = userService;
	}

	@GetMapping("")
	@Operation(summary = "매물 리스트를 조회한다.", description = "이름, 주소지 등 필터링 조건에 맞는 매물 리스트를 반환한다.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "성공적으로 리스트를 조회했습니다."),
			@ApiResponse(responseCode = "204", description = "조건에 맞는 매물이 없습니다."),
			@ApiResponse(responseCode = "400", description = "검색 조건이 유효하지 않습니다.")
	})
	public ResponseEntity<?> list(
			@Parameter(description = "매물을 필터링하는 객체", required = false) @Valid @ModelAttribute SearchCondition searchCondition) {

		List<Home> homeList = homeService.getHomeList(searchCondition);

		if (homeList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(homeList);
	}

	@GetMapping("/{homeId}")
	@Operation(summary = "매물 하나를 조회한다.", description = "매물 하나에 대한 모든 정보를 조회한다. 조회할 객체의 아이디가 있어야 한다.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "성공적으로 조회했습니다."),
			@ApiResponse(responseCode = "204", description = "존재하지 않은 아이디입니다.")
	})
	public ResponseEntity<?> detail(
			@Parameter(description = "조회할 매물의 아이디") @PathVariable(value = "homeId") long homeId) {

		Home home = homeService.getHome(homeId);

		if (home == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(home);
	}

	@GetMapping("/favorites/{userId}")
	@Operation(summary = "사용자의 즐겨찾기 매물 리스트를 조회", description = "사용자가 즐겨찾기한 매물들을 조회한다.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "사용자가 즐겨찾기한 매물 리스트입니다."),
			@ApiResponse(responseCode = "204", description = "사용자가 즐겨찾기한 매물이 없습니다."),
			@ApiResponse(responseCode = "400", description = "사용자 아이디를 반드시 포함해야 합니다.")
	})
	public ResponseEntity<?> favoritesList(
			@Parameter(required = true) @RequestParam(required = true) @Valid long userId) {

		if (!userService.exists(userId)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userId + "는 존재하지 않는 사용자 고유번호입니다.");
		}

		List<Home> favoritesList = homeService.getFavoritesList(userId);

		if (favoritesList.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(favoritesList);
	}

	@PostMapping("/favorites")
	public ResponseEntity<?> insertFavoriteItem(@RequestBody(required = true) @Valid FavoriteEntity favorite) {
		int check = homeService.insertFavoriteItem(favorite.getUserId(), favorite.getHomeId());

		return new ResponseEntity<>(check, check == 1 ? HttpStatus.CREATED : HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("/favorites/{homeId}")
	public ResponseEntity<?> deleteFavoriteItem(@RequestBody FavoriteEntity favorite) {
		int check = homeService.deleteFavoriteItem(favorite.getUserId(), favorite.getHomeId());

		if (check == 1) {
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();

	}
}