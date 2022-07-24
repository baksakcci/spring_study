package com.example.mentoring.controller;

import com.example.mentoring.entity.Board;
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
    @GetMapping("/boards")
    public ResponseEntity<?> getBoards() {
        return new ResponseEntity<>(boardService.getBoards(), HttpStatus.OK);
    }

    // 게시물 1개 보여주기
    @GetMapping("/boards/{id}")
    public ResponseEntity<?> getBoard(@PathVariable("id") Long id) {
        return new ResponseEntity<>(boardService.getBoard(id), HttpStatus.OK);
    }

    // 게시물 저장 버튼 누르기
    @PostMapping("/boards")
    public ResponseEntity<?> saveBoard(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.saveBoard(board), HttpStatus.CREATED);
    }

    // 게시물 수정하고 완료 버튼 누르기
    @PutMapping("/boards/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable("id") Long id, @RequestBody Board updateBoard) {
        return new ResponseEntity<>(boardService.updateBoard(updateBoard, id), HttpStatus.OK);
    }

    // 게시물 삭제 버튼 누르기
    @DeleteMapping("/boards/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable("id") Long id) {
        boardService.deleteBoard(id);
        return new ResponseEntity<>("삭제 완료", HttpStatus.OK);
    }
}
