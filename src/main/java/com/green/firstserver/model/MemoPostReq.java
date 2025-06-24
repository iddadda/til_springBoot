package com.green.firstserver.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 클라이언트에서 받은 데이터 프론트->백엔드 (데이터베이스로 보낼 데이터)
public class MemoPostReq {
    private String title;
    private String content;


}
