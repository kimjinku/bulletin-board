package main.java;

import java.text.SimpleDateFormat;

public class Article {
    private int id;// 게시물 번호 - 무언가를 식별하기위한 데이터를 id로 많이 쓴다.

    // 제목
    private String title;
    // 내용
    private String content;

    private String regDate;

    private int views;


    public Article(int id, String title, String content, String regDate) {
        this.title = title;
        this.content = content;
        this.id = id;
        this.regDate = regDate;


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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
}
//public  void increaseViews(){
//    this.views ++;
// } 웬만하면 클래스 내에서 데이터를 처리하지 않는다.

