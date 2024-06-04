package com.example;

import java.io.IOException;
import java.net.MalformedURLException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class parseWeather {

    static Document page;

    public parseWeather(String city) throws MalformedURLException, IOException {
        parseWeather.page = get_page(city);
    }

    private static Document get_page(String city) throws MalformedURLException, IOException {
        String url = "https://pogoda.mail.ru/prognoz/" + city + "/14dney/";
        Document page = Jsoup.connect(url).userAgent("Chrome/4.0.249.0 Safari/532.5").referrer("http://www.google.com").get();
        return page;
    }

    public static Elements get_dates() {
        Elements dates = page.select("span[class=hdr__inner]");
        return dates;
    }
    public static Elements get_times() {
        Elements timesOf24Hours = page.select("span[class=text text_block text_bold_normal text_fixed margin_bottom_10]");
        return timesOf24Hours;
    }
    public static Elements get_temps() {
        Elements temperatures = page.select("span[class=text text_block text_bold_medium margin_bottom_10]");
        return temperatures;
    }
    public static Elements get_conditions() {
        Elements conditions = page.select("span[class=text text_block text_light_normal text_fixed]");
        return conditions;
    }
    public static Elements get_feeleng() {
        Elements feels = page.select("span[class=text text_block text_light_normal text_fixed color_gray]");
        return feels;
    }
    public static Elements get_other() {
        Elements pressure = page.select("span[class=link__text]");
        return pressure;
    }
}
