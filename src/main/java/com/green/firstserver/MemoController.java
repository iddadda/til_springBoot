package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController// 빈(Bean) 등록, 스프링 컨테이너 객체 생성을 대리로 맡김
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    // DI 받는 방법 3가지
    // 필드, setter(메소드주입), 생성자 <- 요것만 사용하도록!

//    아래 코드를 lombok이 생성해주는 @RequiredArgsConstructor을 사용한다.
//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }

    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: " + id);
        return memoService.selMemo(id);
    }

    @PostMapping("/memo")
//    @RequestBody는 JSON 데이터를 받을거야.
    public String postMemo(@RequestBody MemoPostReq req) {
        System.out.println("Post Memo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }
}
