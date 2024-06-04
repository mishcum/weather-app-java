package com.example;

import org.jsoup.select.Elements;

public class Weather {
    
    private final Day[] days;

    public Weather(Elements date, Elements time, Elements temperature, Elements feeling, Elements other) {
        days = new Day[14];
        for (int i = 0; i < 14; i++) {
            int timeIndex = i * 4;
            int otherIndex = i * 20;
            days[i] = new Day(
                    date.get(i),
                    sub(time, timeIndex, timeIndex + 3),
                    sub(temperature, timeIndex, timeIndex + 3),
                    sub(feeling, timeIndex, timeIndex + 3),
                    sub(other, otherIndex, otherIndex + 19)
            );
        }
    }

    private Elements sub(Elements elements, int start, int end) {
        Elements subElements = new Elements();
        for (int i = start; i <= end; i++) {
            subElements.add(elements.get(i));
        }
        return subElements;
    }

    public Day getDay(int index) {
        return days[index - 1];
    }
    
}
