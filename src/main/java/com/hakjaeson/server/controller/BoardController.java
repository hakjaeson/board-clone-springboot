package com.hakjaeson.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hakjaeson.server.dto.Board;
import com.hakjaeson.server.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/boards")
public class BoardController {
    @Autowired
    private BoardService boardService;
    
    
    @GetMapping()
    public ResponseEntity<?> getAll() {
        log.info("[GET] - /board 게시글 목록");
        try {
            List<Board> boardList = boardService.list();
            if(boardList==null)
                log.info("조회된 게시글 없음");
            else
                log.info("게시글 수 : " + boardList.size());

            return new ResponseEntity<>("GetAll Results", HttpStatus.OK);
            
        } catch (Exception e) {
            log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{no}")
    public ResponseEntity<?> getOne(@PathVariable Integer no) {
        log.info("[GET] - /boards/" + no + "게시글 조회");
        try {
            Board board = boardService.select(0);
            if(board==null){
                board = new Board();
                board.setTitle("데이터 없음");
                return new ResponseEntity<>(board, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(board, HttpStatus.OK); 
            }
        } catch (Exception e) {
             log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Board board) {
        try {
            return new ResponseEntity<>("Create Result", HttpStatus.OK);
        } catch (Exception e) {
             log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping()
    public ResponseEntity<?> update(@RequestBody Board board) {
        try {
            return new ResponseEntity<>("Update Result", HttpStatus.OK);
        } catch (Exception e) {
             log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{no}")
    public ResponseEntity<?> destroy(@PathVariable Integer no) {
        try {
            return new ResponseEntity<>("Destroy Result", HttpStatus.OK);
        } catch (Exception e) {
             log.error(null, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
