package com.example;

import org.jsoup.nodes.Element;

public class TimeOfDay {

    private final String time;
    private final String temperature;
    private final String feeling;
    private final String pressure;
    private final String humidity;
    private final String wind;
    private final String uv;
    private final String chanceOfPrecip;

    public TimeOfDay(Element time, Element temperature, Element feeling, Element pressure, Element humidity, Element wind, Element uv, Element chanceOfPrecip) {
        this.time = time.text();
        this.temperature = temperature.text();
        this.feeling = feeling.text();
        this.pressure = pressure.text();
        this.humidity = humidity.text();
        this.wind = wind.text();
        this.uv = uv.text();
        this.chanceOfPrecip = chanceOfPrecip.text();
    }

    public String getTime() { return time; }
    public String getTemperature() { return temperature; }
    public String getFeeling() { return feeling; }
    public String getPressure() { return pressure; }
    public String getHumidity() { return humidity; }
    public String getWind() { return wind; }
    public String getUv() { return uv; }
    public String getChanceOfPrecip() { return chanceOfPrecip; }
}
