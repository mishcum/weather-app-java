package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;

public class WeatherGUI {

    private JFrame frame;
    private JTextField cityTextField;
    private JTextArea weatherTextArea;

    public WeatherGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel cityLabel = new JLabel("Enter City:");
        panel.add(cityLabel);

        cityTextField = new JTextField(15);
        panel.add(cityTextField);

        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    getWeatherData();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(getWeatherButton);

        weatherTextArea = new JTextArea();
        weatherTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(weatherTextArea);

        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
    }

    private void getWeatherData() throws MalformedURLException, IOException {
        String city = cityTextField.getText();
        parseWeather parser = new parseWeather(city);
        Weather weather = new Weather(parseWeather.get_dates(), parseWeather.get_times(), parseWeather.get_temps(), parseWeather.get_feeleng(), parseWeather.get_other());

        StringBuilder weatherInfo = new StringBuilder();
        weatherInfo.append("Weather for: ").append(city).append("\n\n");
        weatherInfo.append("Day 2 Night Temperature: ").append(weather.getDay(3).getNight().getTemperature()).append("\n");

        weatherTextArea.setText(weatherInfo.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WeatherGUI window = new WeatherGUI();
                window.frame.setVisible(true);
            }
        });
    }
}

