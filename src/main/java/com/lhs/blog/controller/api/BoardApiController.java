package com.lhs.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lhs.blog.config.auth.PrincipalDetail;
import com.lhs.blog.dto.ResponseDto;
import com.lhs.blog.model.Board;
import com.lhs.blog.service.BoardService;

@RestController
public class BoardApiController {

	@Autowired
	private BoardService boardService;

	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {

		boardService.글쓰기(board,principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}

}
