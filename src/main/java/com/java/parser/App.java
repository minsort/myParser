package com.java.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class App {

    public static void main(String[] args) throws IOException {

        List<Post> posts = new ArrayList<>();
        //Подключаемся к странице - теперь все в doc
        Document doc = Jsoup.connect("https://4pda.to/").get();

        //Осуществляем поиск по атрибутам и значению и результат кладем в hrefs
        Elements hrefs = doc.getElementsByAttributeValue("itemprop", "url");

        //Идем по эллементам и выводим на экран нужные нам строки, состоящие из нужных нам атрибутов
        for (int i = 0; i < hrefs.size(); i++) {
            Element href1 = hrefs.get(i);
            System.out.println(href1.attr("title") +" | " + href1.attr("href"));

            Post post = new Post();
            String datailsLink = href1.attr("href");
            post.setDatailsLink(datailsLink);
            post.setTitle(href1.attr("title"));

        }
















        //System.out.println(doc.toString());
    }
}
