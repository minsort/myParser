package com.java.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        List<Post> posts = new ArrayList<>();
        //Подключаемся к странице - теперь все в doc
        Document doc = Jsoup.connect("https://4pda.to/").get();

        System.out.println("Заголовок главной страницы:" + doc.title() + "Адрес сайта" + doc.baseUri());

        //Осуществляем поиск по атрибутам и значению и результат кладем в hrefs
        Elements hrefs = doc.getElementsByAttributeValue("itemprop", "url");


        //Идем по эллементам и выводим на экран нужные нам строки, состоящие из нужных нам атрибутов
        for (int i = 0; i < hrefs.size(); i++) {
            Element href1 = hrefs.get(i);


            Post post = new Post();
            String detailsLink = href1.attr("href");
            post.setDetailsLink(detailsLink);
            post.setTitle(href1.attr("title"));
            Document postDeteilsDoc = Jsoup.connect(detailsLink).get();
            try {
                Element autorElement = postDeteilsDoc.getElementsByClass("name").first().child(0);
                post.setAutor(autorElement.text());
                post.setAutorDetailsLink(autorElement.attr("href"));
            } catch (NullPointerException e){
                post.setAutor("Author ???");
            }
            post.setDateOfCreated(postDeteilsDoc.getElementsByClass("date").first().text());
            posts.add(post);
        }
        posts.forEach(System.out::println);
    }
}
