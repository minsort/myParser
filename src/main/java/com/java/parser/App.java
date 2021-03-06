package com.java.parser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "selenium\\chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://4pda.to/");
        for (int i=2;i<=3;i++){
            WebElement paginationButton = webDriver.findElement(By.xpath("//*[@id=\"RiQkeIPQCR\"]/ul/li[" + i + "]/a"));

            paginationButton.click();
            WebElement poostButton = webDriver.findElement(By.xpath("//*[@id=\"RiQkeIPQCR\"]/article[1]/div[2]/h2/a/span"));
            poostButton.click();

            WebElement poostButton2 = webDriver.findElement(By.xpath("//*[@id=\"NOkqh5JBuQDgYZYmj8\"]/article[2]/div[2]/h2/a/span"));
            poostButton2.click();
        }



       /*
       JSOUP!!!!!!!!!

       List<Post> posts = new ArrayList<>();

        //Подключаемся к странице - теперь все в doc
        Document doc = Jsoup.connect("https://4pda.to/").get();

        System.out.println("Заголовок главной страницы: " + doc.title() + "\nАдрес сайта: " + doc.baseUri());
        StringBuffer a = new StringBuffer("Ожидайте... Поиск результатов");
        System.out.println(a);

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
        posts.forEach(System.out::println);*/

    }
}
