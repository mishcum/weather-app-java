package com.example;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Day {

    private final String date;
    private final TimeOfDay night;
    private final TimeOfDay morning;
    private final TimeOfDay noon;
    private final TimeOfDay evening;

    public Day(Element date, Elements time, Elements temperature, Elements conditions, Elements feeling, Elements other) {
        this.date = date.text();
        this.night = createTimeOfDay(time, temperature, conditions, feeling, other, 0);
        this.morning = createTimeOfDay(time, temperature, conditions, feeling, other, 1);
        this.noon = createTimeOfDay(time, temperature, conditions, feeling, other, 2);
        this.evening = createTimeOfDay(time, temperature, conditions, feeling, other, 3);
    }

    private TimeOfDay createTimeOfDay(Elements time, Elements temperature, Elements conditions, Elements feeling, Elements other, int index) {
        return new TimeOfDay(
                time.get(index),
                temperature.get(index),
                conditions.get(index),
                feeling.get(index),
                other.get(index * 5),
                other.get(index * 5 + 1),
                other.get(index * 5 + 2),
                other.get(index * 5 + 3),
                other.get(index * 5 + 4)
        );
    }

    public String getDate() { return date; }
    public TimeOfDay getNight() { return night; }
    public TimeOfDay getMorning() { return morning; }
    public TimeOfDay getNoon() { return noon; }
    public TimeOfDay getEvening() { return evening; }
}
