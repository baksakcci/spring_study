package com.example.mentoring.controller;

import com.example.mentoring.entity.Board;
import com.example.mentoring.response.Response;
import com.example.mentoring.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시물 전체 보여주기
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards")
    public Response getBoards() {
        return Response.success(boardService.getBoards());
    }

    // 게시물 1개 보여주기
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/boards/{id}")
    public Response getBoard(@PathVariable("id") Long id) {
        return Response.success(boardService.getBoard(id));
    }

    // 게시물 저장 버튼 누르기 - POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/boards")
    public Response saveBoard(@RequestBody Board board) {
        return Response.success(boardService.saveBoard(board));
    }

    // 게시물 수정하고 완료 버튼 누르기
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/boards/{id}")
    public Response updateBoard(@PathVariable("id") Long id, @RequestBody Board updateBoard) {
        return Response.success(boardService.updateBoard(updateBoard, id));
    }

    // 게시물 삭제 버튼 누르기
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/boards/{id}")
    public Response deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return Response.success("삭제 완료");
    }
}
