package com.green.firstserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// DB에서 튜플 하나를 담아 응답할 때 사용
public class MemoGetRes {
    private int id;
    private String title;
    private String content;

}
