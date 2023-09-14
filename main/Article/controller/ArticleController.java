package main.Article.controller;

import main.Article.model.Article;
import main.Article.model.ArticleRepository;
import main.Article.view.ArticleView;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {

    ArticleView articleView = new ArticleView();
    ArticleRepository articleRepository = new ArticleRepository();
    Scanner scan = new Scanner(System.in);

    public void add() {
        System.out.print("게시물 제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("게시물 내용을 입력해주세요 : ");
        String content = scan.nextLine();

        articleRepository.insert(title, content);

        System.out.println("게시물이 등록되었습니다.");
    }

    public void list() {
        ArrayList<Article> articles = articleRepository.findAllArticles();
        articleView.printArticles(articles);
    }

    public void update() {

        int targetId = getParamInt(scan.nextLine(), 5);

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
        } else {
            System.out.print("제목 : ");
            String newTitle = scan.nextLine();
            System.out.print("내용 : ");
            String newContent = scan.nextLine();

            article.setTitle(newTitle);
            article.setContent(newContent);

            System.out.println("수정이 완료되었습니다.");
        }
    }

    public void delete() {
        System.out.print("삭제할 게시물 번호 : ");
        int targetId = getParamInt(scan.nextLine(), -1);

        Article article = articleRepository.findById(targetId);

        if (article == null) {
            System.out.println("없는 게시물입니다.");
        } else {
            articleRepository.delete(article);
        }
    }

    public void detail() {
        // 중복 -> 함수

        System.out.print("상세보기 할 게시물 번호를 입력해주세요 : ");
        int targetId = getParamInt(scan.nextLine(), -1);
        Article article = articleRepository.findById(targetId);



        if (article == null) {
            System.out.println("존재하지 않는 게시물입니다.");
        } else {
            article.setHit(article.getHit() + 1);
            articleView.printArticleDetail(article);
        }
    }

    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchedArticles = articleRepository.findByTitle(keyword);
        articleView.printArticles(searchedArticles);
    }
    public int getParamInt(String input, int defaulValue) {

        try {
            int num = Integer.parseInt(input);
            return num;

        }catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.");
        }

        return defaulValue;
    }
}