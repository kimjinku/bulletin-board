package main.java;


import main.java.Article;

import java.time.ZoneId;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class BoardApp {
    ArrayList<Article> articles = new ArrayList<>();

    public void start() {


        Scanner scan = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>(); // 여기 하나 밖에 저장을 못하는게 문제
//        ArrayList<String> contents = new ArrayList<>();

        Article a1 = new Article(1, "안녕하세요 반갑습니다. 자바 공부중이에요.", "내용1", getCurrentDate());
        Article a2 = new Article(2, "자바 질문좀 할게요~", "내용2", getCurrentDate());
        Article a3 = new Article(3, "정처기 따야되나요?", "내용3", getCurrentDate());
        articles.add(a1);
        articles.add(a2);
        articles.add(a3);

        int lastArticleId = 4;

        while (true) {
            System.out.print("명령어 : ");
            String command = scan.nextLine();
            if (command.equals("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            } else if (command.equals("add")) {
                System.out.print("게시물 제목을 입력해주세요 : ");
                String title = scan.nextLine();
                System.out.print("게시물 내용을 입력해주세요 : ");
                String content = scan.nextLine();


                Article article = new Article(lastArticleId, title, content, getCurrentDate());
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;

                //명령어 : list
                //  ==================
                //  번호 : 1
                //  제목 : 안녕하세요 반갑습니다. 자바 공부중이에요.
                //  ==================
                //  번호 : 2
                //  제목 : 자바 질문좀 할게요~
                //  ==================
                //  번호 : 3
                //  제목 : 정처기 따야되나요?
                //  ==================

            } else if (command.equals("list")) {
                System.out.println("==================");

                printArticles(articles);


            } else if (command.equals("update")) {
                System.out.print("수정할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();


                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다");
                } else {
                    System.out.print("제목 : ");
                    String newTitle = scan.nextLine();
                    System.out.print("내용 : ");
                    String newContent = scan.nextLine();

                    //Article newArticle = new Article(targetId, newTitle, newContent);
                    //articles.set(targetId-1, newArticle);
                    article.setTitle(newTitle);
                    article.setContent(newContent);


                    System.out.println("수정이 완료되었습니다.");

                }


            } else if (command.equals("delete")) {
                System.out.print("삭제할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();


                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다");
                } else {
                    articles.remove(article); //위치 기반 삭제
                    //remove에는 두가지 방식이 있음
                    // articles.remove(TargetId-1); = 위치 기반 삭제
                    // articles.remove(article); = 값 기반 삭제


                    System.out.printf("%d번 게시물이 삭제되었습니다.\n", targetId);

                }

            } else if (command.equals("detail")) {
                System.out.print("상세보기할 게시물 번호 : ");
                int targetId = scan.nextInt();

                scan.nextLine();

                Article article = findById(targetId);
                if (article == null) {
                    System.out.println("존재하지 않는 게시물입니다");
                } else {
                    article.setViews(article.getViews() + 1); // <- 1번방법
                    //article.increaseViews();// <- 2번방법. 비지니스 로직


                    System.out.println("==================");


                    System.out.println("상세보기");

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.printf("조회수 : %d\n", article.getViews());
                    System.out.println("==================");
                }
                //중복 -> 함수.
            } else if (command.equals("search")) {
                System.out.print("검색 키워드를 입력해주세요 : ");
                String keyword = scan.nextLine();
                ArrayList<Article> searchedArticles = new ArrayList<>();

                System.out.println("==================");
                for (int i = 0; i < articles.size(); i++) {
                    Article article = articles.get(i);
                    String title = article.getTitle();

                    if (title.contains(keyword)) {

                        searchedArticles.add(article);
                    }
                }
                printArticles(searchedArticles);

            }
        }
    }

    public Article findById(int id) {

        Article target = null; //일단 비워둠

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }


        return target;

    }

    public String getCurrentDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        String formatedNow = now.format(formatter);

        return formatedNow;
    }

    public void printArticles(ArrayList<Article> list) {
        System.out.println("==================");
        for (int i = 0; i < list.size(); i++) {

            Article article = list.get(i);

            System.out.printf("번호 : %d\n", article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.printf("등록날짜 : %s\n", article.getRegDate());

            System.out.println("==================");
        }

        //MVC
        //Model 데이터
        //View 보여지는것(UI)
        //Controller -> Model 과View 를 연결

        //MVC를 쓰는 이유
        //1. 모듈 교체 편하게 편하게 하기 위함
        //2. 관련 기술들의 집합 -> 협업에 좋다.
    }


}






