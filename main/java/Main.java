package main.java;

import main.java.Article;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Article> articles = new ArrayList<>();

    public static void main(String[] arg) {

        Scanner scan = new Scanner(System.in);
//        ArrayList<String> titles = new ArrayList<>(); // 여기 하나 밖에 저장을 못하는게 문제
//        ArrayList<String> contents = new ArrayList<>();

        int lastArticleId = 1;

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

                Article article = new Article(lastArticleId, title, content);
                articles.add(article);

                System.out.println("게시물이 등록되었습니다.");
                lastArticleId++;
            } else if (command.equals("list")) {
                System.out.println("==================");
                for (int i = 0; i < articles.size(); i++) {

                    Article article = articles.get(i);

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("==================");
                }
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

                    Article newArticle = new Article(targetId, newTitle, newContent);
                    articles.set(targetId, newArticle);

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
                    articles.remove(targetId);
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
                    System.out.println("==================");


                    System.out.println("상세보기");

                    System.out.printf("번호 : %d\n", article.getId());
                    System.out.printf("제목 : %s\n", article.getTitle());
                    System.out.printf("내용 : %s\n", article.getContent());
                    System.out.println("==================");
                }
                //중복 -> 함수.
            }
        }
    }

    public static Article findById(int id) {

        Article target = null; //일단 비워둠

        for (int i = 0; i < articles.size(); i++) {
            Article article = articles.get(i);
            if (id == article.getId()) {
                target = article;
            }
        }

        return target;

    }


}
