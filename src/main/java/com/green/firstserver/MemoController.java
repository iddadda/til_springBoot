package com.green.firstserver;

import com.green.firstserver.model.MemoPostReq;
import org.springframework.web.bind.annotation.*;


@RestController// 빈(Bean) 등록, 스프링 컨테이너 객체 생성을 대리로 맡김
public class MemoController {
    @GetMapping("/memo")
    public String getMemo() {
        return "Hello Memo!";
    }

    @GetMapping("/memo/{board_id}")
    public String getMemo(@PathVariable("board_id") int board_id) {
        System.out.println("Board ID: " + board_id);
        return "Hello Board! - board ID: " + board_id;
    }

    @PostMapping("/memo")
//    @RequestBody는 JSON 데이터를 받을거야.
    public String postMemo(@RequestBody MemoPostReq req) {
        System.out.println("Post Memo: " + req);
        return "Post Board!";
    }
}
