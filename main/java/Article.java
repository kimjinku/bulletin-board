package main.java;

import java.text.SimpleDateFormat;

public class Article {
    private int id;// 게시물 번호 - 무언가를 식별하기위한 데이터를 id로 많이 쓴다.

    // 제목
    private String title;
    // 내용
    private String content;



    public Article(int id,String title, String content) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
