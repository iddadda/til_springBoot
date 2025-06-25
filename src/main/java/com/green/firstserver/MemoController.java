package com.green.firstserver;

import com.green.firstserver.model.MemoGetOneRes;
import com.green.firstserver.model.MemoGetRes;
import com.green.firstserver.model.MemoPostReq;
import com.green.firstserver.model.MemoPutReq;
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
//    초기화되지 않은 final 필드를 초기화 해주는 생성자를 생성해주는 어노테이션이다.
//    public MemoController(MemoService memoService) {
//        this.memoService = memoService;
//    }

    //    메모 목록
    @GetMapping("/memo")
    public List<MemoGetRes> getMemo() {
        return memoService.selMemoList();
    }

    //    메모 상세페이지
    @GetMapping("/memo/{id}")
    public MemoGetOneRes getMemo(@PathVariable int id) {
        System.out.println("getMemo: " + id);
        return memoService.selMemo(id);
    }

    //    메모입력
    @PostMapping("/memo")
//    @RequestBody는 JSON 데이터를 받을거야.
    public String postMemo(@RequestBody MemoPostReq req) {
        System.out.println("Post Memo: " + req);
        int result = memoService.insMemo(req);
        return result == 1 ? "성공" : "실패";
    }

//    메모수정
    @PutMapping("/memo")
    public String putMemo(@RequestBody MemoPutReq req) {
        System.out.println("Put Memo: " + req);
        int result = memoService.updMemo(req);
        return result == 1 ? "성공" : "실패";
    }

//    메모삭제
//    id는 쿼리스트링으로 받겠다.
    @DeleteMapping("/memo")
    public int deleteMemo(@RequestParam int id) {
        System.out.println("deleteMemo:" + id);
        return memoService.delMemo(id);
    }
}

