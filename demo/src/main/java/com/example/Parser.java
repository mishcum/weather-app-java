package com.example;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Parser {

    Document page;

    public Parser(String city) throws IOException  {
        String url = "https://pogoda.mail.ru/prognoz/" + city + "/14dney/";
        page = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get();
    }

    public Elements get_dates() {
        Elements dates = page.select("span[class=hdr__inner]");
        return dates;
    }
    public Elements get_times() {
        Elements timesOf24Hours = page.select("span[class=text text_block text_bold_normal text_fixed margin_bottom_10]");
        return timesOf24Hours;
    }
    public Elements get_temps() {
        Elements temperatures = page.select("span[class=text text_block text_bold_medium margin_bottom_10]");
        return temperatures;
    }
    public Elements get_conditions() {
        Elements conditions = page.select("span[class=text text_block text_light_normal text_fixed]");
        return conditions;
    }
    public Elements get_feeleng() {
        Elements feels = page.select("span[class=text text_block text_light_normal text_fixed color_gray]");
        return feels;
    }
    public Elements get_other() {
        Elements pressure = page.select("span[class=link__text]");
        return pressure;
    }

    /*public static void main(String[] args) throws IOException {
        System.out.println(new Parser("moskva").page.toString());
    }*/
}
