package com.example;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class TimeOfDay {

    private String time;
    private String temperature;
    private String feeling;
    private String pressure;
    private String humidity;
    private String wind;
    private String uv;
    private String chanceOfPrecip;

    public TimeOfDay(Element time, Element temperature, Element feeleng, Element pressure, Element humidity, Element wind, Element uv, Element chanceOfPrecip) {

        this.time = time.text();
        this.temperature = temperature.text();
        this.feeling = feeleng.text();
        this.pressure = pressure.text();
        this.humidity = humidity.text();
        this.wind = wind.text();
        this.uv = uv.text();
        this.chanceOfPrecip = chanceOfPrecip.text();
    }

    public String getTime() {
        return time;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getFeeling() {
        return feeling;
    }

    public String getPressure() {
        return pressure;
    }

    public String getHumidity() {
        return humidity;
    }

    public String getWind() {
        return wind;
    }

    public String getUv() {
        return uv;
    }

    public String getChanceOfPrecip() {
        return chanceOfPrecip;
    }

}

class Day {

    private String date;
    private TimeOfDay night;
    private TimeOfDay morning;
    private TimeOfDay noon;
    private TimeOfDay evening;

    public Day(Element date, Elements time, Elements temperature, Elements feeleng, Elements other) {

        this.date = date.text();

        this.night = new TimeOfDay(time.get(0), temperature.get(0), feeleng.get(0), other.get(0), other.get(1), other.get(2), other.get(3), other.get(4));
        this.morning = new TimeOfDay(time.get(1), temperature.get(1), feeleng.get(1), other.get(5), other.get(6), other.get(7), other.get(8), other.get(9));
        this.noon = new TimeOfDay(time.get(2), temperature.get(2), feeleng.get(2), other.get(10), other.get(11), other.get(12), other.get(13), other.get(14));
        this.evening = new TimeOfDay(time.get(3), temperature.get(3), feeleng.get(3), other.get(15), other.get(16), other.get(17), other.get(18), other.get(19));

    }

    public String getDate() {
        return date;
    }

    public TimeOfDay getNight() {
        return night;
    }

    public TimeOfDay getMorning() {
        return morning;
    }

    public TimeOfDay getNoon() {
        return noon;
    }

    public TimeOfDay getEvening() {
        return evening;
    }
}
public class Weather {
    
    Day day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14;

    public Weather(Elements date, Elements time, Elements temperature, Elements feeleng, Elements other) {
        this.day1 = new Day(date.get(0), sub(time, 0, 3), sub(temperature, 0, 3), sub(feeleng, 0, 3), sub(other, 0, 19));
        this.day2 = new Day(date.get(1), sub(time, 4, 7), sub(temperature, 4, 7), sub(feeleng, 4, 7), sub(other, 20, 39));
        this.day3 = new Day(date.get(2), sub(time, 8, 11), sub(temperature, 8, 11), sub(feeleng, 8, 11), sub(other, 40, 59));
        this.day4 = new Day(date.get(3), sub(time, 12, 15), sub(temperature, 12, 15), sub(feeleng, 12, 15), sub(other, 60, 79));
        this.day5 = new Day(date.get(4), sub(time, 16, 19), sub(temperature, 16, 19), sub(feeleng, 16, 19), sub(other, 80, 99));
        this.day6 = new Day(date.get(5), sub(time, 20, 23), sub(temperature, 20, 23), sub(feeleng, 20, 23), sub(other, 100, 119));
        this.day7 = new Day(date.get(6), sub(time, 24, 27), sub(temperature, 24, 27), sub(feeleng, 24, 27), sub(other, 120, 139));
        this.day8 = new Day(date.get(7), sub(time, 28, 31), sub(temperature, 28, 31), sub(feeleng, 28, 31), sub(other, 140, 159));
        this.day9 = new Day(date.get(8), sub(time, 32, 35), sub(temperature, 32, 35), sub(feeleng, 32, 35), sub(other, 160, 179));
        this.day10 = new Day(date.get(9), sub(time, 36, 39), sub(temperature, 36, 39), sub(feeleng, 36, 39), sub(other, 180, 199));
        this.day11 = new Day(date.get(10), sub(time, 40, 43), sub(temperature, 40, 43), sub(feeleng, 40, 43), sub(other, 200, 219));
        this.day12 = new Day(date.get(11), sub(time, 44, 47), sub(temperature, 44, 47), sub(feeleng, 44, 47), sub(other, 220, 239));
        this.day13 = new Day(date.get(12), sub(time, 48, 51), sub(temperature, 48, 51), sub(feeleng, 48, 51), sub(other, 240, 259));
        this.day14 = new Day(date.get(13), sub(time, 52, 55), sub(temperature, 52, 55), sub(feeleng, 52, 55), sub(other, 260, 279));
    }

    private Elements sub(Elements s, int start, int end) {
        Elements el = new Elements();
        for (int i = start; i <= end; i++) {
            el.add(s.get(i));
        }
        return el;
    }

    public Day getDay1() {
        return day1;
    }

    public Day getDay2() {
        return day2;
    }

    public Day getDay3() {
        return day3;
    }

    public Day getDay4() {
        return day4;
    }

    public Day getDay5() {
        return day5;
    }

    public Day getDay6() {
        return day6;
    }

    public Day getDay7() {
        return day7;
    }

    public Day getDay8() {
        return day8;
    }

    public Day getDay9() {
        return day9;
    }

    public Day getDay10() {
        return day10;
    }

    public Day getDay11() {
        return day11;
    }

    public Day getDay12() {
        return day12;
    }

    public Day getDay13() {
        return day13;
    }

    public Day getDay14() {
        return day14;
    }
    
    
    /*public static void main(String[] args) throws MalformedURLException, IOException {
        parseWeather r = new parseWeather("moskva");
        Weather w = new Weather(parseWeather.get_dates(), parseWeather.get_times(), parseWeather.get_temps(), parseWeather.get_feeleng(), parseWeather.get_other());
        System.out.println(w.getDay2().getNight().getTemperature());
    }*/
}
