package com.ourhome.favorite.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ourhome.auth.service.UserService;
import com.ourhome.favorite.entity.CreateRequestDto;
import com.ourhome.favorite.service.FavoriteService;
import com.ourhome.home.entity.Home;
import com.ourhome.home.service.HomeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/users/{userId}/favorites") 
public class FavoriteController {

    FavoriteService favoriteService;
    UserService userService;
    HomeService homeService;

    FavoriteController(FavoriteService favoriteService, UserService userService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
    }

    @GetMapping("")
    @Operation(summary = "즐겨찾기 목록 조회", description = "사용자가 즐겨찾기한 목록을 조회", method = "GET")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "즐겨찾기 목록 조회 성공"),
        @ApiResponse(responseCode = "204", description = "즐겨찾기한 매물이 없습니다."),
        @ApiResponse(responseCode = "400", description = "잘못된 요청입니다.")
    })
    public ResponseEntity<?> getFavoriteList(@PathVariable(name = "userId") Long userId) {
        if (!userService.exists(userId)) {
            return ResponseEntity.badRequest().body("없는 사용자입니다.");
        }

        List<Home> favorites = favoriteService.getFavoriteList(userId);

        if (favorites.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        
        return ResponseEntity.ok(favorites);
    }

    @PostMapping("")
    @Operation(summary = "즐겨찾기 추가", description = "사용자의 즐겨찾기 목록에 새로운 아이템을 추가한다.", method = "POST")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "추가 성공"),
        @ApiResponse(responseCode = "400", description = "잘못된 요청입니다."),
        @ApiResponse(responseCode = "500", description = "서버 내부의 에러로 인한 실패")
    })
    public ResponseEntity<?> createFavorite(@PathVariable(name = "userId") Long userId, @RequestBody CreateRequestDto createRequestDto) {
        if(!userService.exists(userId)) {
            return ResponseEntity.badRequest().body("없는 사용자입니다.");
        }

        if (!homeService.exists(createRequestDto.getHomeId())) {
            return ResponseEntity.badRequest().body("없는 매물입니다.");
        }

        int result = favoriteService.addFavorite(createRequestDto);

        if (result == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{favoriteId}")
    @Operation(summary = "즐겨찾기 취소", description = "사용자의 즐겨찾기를 취소한다.", method = "DELETE")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "즐겨찾기 취소 성공"),
        @ApiResponse(responseCode = "400", description = "없는 즐겨찾기입니다.")
    })
    public ResponseEntity<?> removeFavorite(@PathVariable(name = "userId") Long userId, @PathVariable(name = "favoriteId") Long favoriteId) {
        if(!userService.exists(userId)) {
            return ResponseEntity.badRequest().body("없는 사용자입니다.");
        }
        
        int result = favoriteService.removeFavorite(favoriteId);

        if (result == 0) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }
}
