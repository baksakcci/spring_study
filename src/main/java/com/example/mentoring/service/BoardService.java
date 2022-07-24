package com.example.mentoring.service;

import com.example.mentoring.entity.Board;
import com.example.mentoring.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시물 전체 보여주기
    @Transactional(readOnly = true)
    public List<Board> getBoards() {
        List<Board> boards = boardRepository.findAll();
        return boards;
    }

    // 게시물 1개 보여주기
    @Transactional(readOnly = true)
    public Board getBoard(Long id) {
        Board board = boardRepository.findById(id).get();
        return board;
    }

    // 게시물 저장하기
    @Transactional
    public Board saveBoard(Board board) {
        return boardRepository.save(board);
    }

    // 게시물 수정하기
    @Transactional
    public Board updateBoard(Board updateBoard, Long id) {
        Board originalBoard = boardRepository.findById(id).get();

        originalBoard.setTitle(updateBoard.getTitle());
        originalBoard.setContent(updateBoard.getContent());

        return originalBoard;
    }

    // 게시물 삭제하기
    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

}
