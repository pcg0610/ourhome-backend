package com.ourhome.home.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.home.dto.HomeCreateRequestDto;
import com.ourhome.home.entity.Home;
import com.ourhome.home.service.HomeService;
import com.ourhome.home.util.SearchCondition;

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

	HomeController(HomeService homeService) {
		this.homeService = homeService;
	}

	@GetMapping("")
	@Operation(summary = "매물 리스트를 조회한다.", description = "이름, 주소지 등 필터링 조건에 맞는 매물 리스트를 반환한다.", method = "GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "성공적으로 리스트를 조회했습니다."),
			@ApiResponse(responseCode = "204", description = "조건에 맞는 매물이 없습니다."),
			@ApiResponse(responseCode = "400", description = "검색 조건이 유효하지 않습니다.")
	})
	public ResponseEntity<?> getHomeList(
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
			@ApiResponse(responseCode = "204", description = "존재하지 않은 매물입니다.")
	})
	public ResponseEntity<?> getHome(
			@Parameter(description = "조회할 매물의 아이디") @PathVariable(value = "homeId") long homeId) {

		Home home = homeService.getHome(homeId);

		if (home == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok().body(home);
	}

	@PostMapping("")
	@Operation(summary = "매물 등록", description = "매물을 등록한다.", method = "POST")
	@ApiResponses(value = {
		@ApiResponse(responseCode = "200", description = "매물 등록 성공"),
		@ApiResponse(responseCode = "400", description = "매물 등록 실패"),
		@ApiResponse(responseCode = "401", description = "권한이 없습니다.")
	})
	public ResponseEntity<?> createHome(@RequestBody HomeCreateRequestDto createRequestDto) {
		// TODO 매물 객체 생성 기능 구현
		// TODO 요청 객체에서 사용자 고유번호 추출 구현
		String userId = null;
		homeService.addHome(createRequestDto);
		return null;
	}
}