package com.green.firstserver.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemoGetOneRes {
    private String title;
    private String content;
    private String createdAt;
}