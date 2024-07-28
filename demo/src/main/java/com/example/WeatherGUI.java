package com.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WeatherGUI {

    private JFrame frame;
    private JTextField cityTextField;
    private JTable weatherTable;

    public WeatherGUI() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Weather App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JLabel cityLabel = new JLabel("Enter Your City:");
        panel.add(cityLabel);

        cityTextField = new JTextField(15);
        panel.add(cityTextField);

        JButton getWeatherButton = new JButton("Get Weather");
        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getWeatherData();
            }
        });
        panel.add(getWeatherButton);

        frame.add(panel, BorderLayout.NORTH);

        weatherTable = new JTable();

        JScrollPane scrollPane = new JScrollPane(weatherTable);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void getWeatherData() {
        String city = cityTextField.getText();
        city = CityNames.getName(city);
        if (city == null) {
            ErrorDialog("City not found");
        } else {

        
        try {
            Parser parser = new Parser(city);
            Weather weather = new Weather(parser.get_dates(), parser.get_times(), parser.get_temps(), parser.get_conditions(), parser.get_feeleng(), parser.get_other());

            Object[][] data = new Object[126][5];
            for (int i = 0; i < 14; i++) {
                data[i * 9][0] = weather.getDay(i + 1).getDate();
                data[i * 9 + 1][0] = "Temperature:";
                data[i * 9 + 1][1] = weather.getDay(i + 1).getNight().getTemperature();
                data[i * 9 + 1][2] = weather.getDay(i + 1).getMorning().getTemperature();
                data[i * 9 + 1][3] = weather.getDay(i + 1).getNoon().getTemperature();
                data[i * 9 + 1][4] = weather.getDay(i + 1).getEvening().getTemperature();
                data[i * 9 + 2][0] = "Condition:";
                data[i * 9 + 2][1] = weather.getDay(i + 1).getNight().getCondition();
                data[i * 9 + 2][2] = weather.getDay(i + 1).getMorning().getCondition();
                data[i * 9 + 2][3] = weather.getDay(i + 1).getNoon().getCondition();
                data[i * 9 + 2][4] = weather.getDay(i + 1).getEvening().getCondition();
                data[i * 9 + 3][0] = "Feeleng:";
                data[i * 9 + 3][1] = weather.getDay(i + 1).getNight().getFeeling();
                data[i * 9 + 3][2] = weather.getDay(i + 1).getMorning().getFeeling();
                data[i * 9 + 3][3] = weather.getDay(i + 1).getNoon().getFeeling();
                data[i * 9 + 3][4] = weather.getDay(i + 1).getEvening().getFeeling();
                data[i * 9 + 4][0] = "Pressure:";
                data[i * 9 + 4][1] = weather.getDay(i + 1).getNight().getPressure();
                data[i * 9 + 4][2] = weather.getDay(i + 1).getMorning().getPressure();
                data[i * 9 + 4][3] = weather.getDay(i + 1).getNoon().getPressure();
                data[i * 9 + 4][4] = weather.getDay(i + 1).getEvening().getPressure();
                data[i * 9 + 5][0] = "Humidity";
                data[i * 9 + 5][1] = weather.getDay(i + 1).getNight().getHumidity();
                data[i * 9 + 5][2] = weather.getDay(i + 1).getMorning().getHumidity();
                data[i * 9 + 5][3] = weather.getDay(i + 1).getNoon().getHumidity();
                data[i * 9 + 5][4] = weather.getDay(i + 1).getEvening().getHumidity();
                data[i * 9 + 6][0] = "Wind:";
                data[i * 9 + 6][1] = weather.getDay(i + 1).getNight().getWind();
                data[i * 9 + 6][2] = weather.getDay(i + 1).getMorning().getWind();
                data[i * 9 + 6][3] = weather.getDay(i + 1).getNoon().getWind();
                data[i * 9 + 6][4] = weather.getDay(i + 1).getEvening().getWind();
                data[i * 9 + 7][0] = "UV:";
                data[i * 9 + 7][1] = weather.getDay(i + 1).getNight().getUv();
                data[i * 9 + 7][2] = weather.getDay(i + 1).getMorning().getUv();
                data[i * 9 + 7][3] = weather.getDay(i + 1).getNoon().getUv();
                data[i * 9 + 7][4] = weather.getDay(i + 1).getEvening().getUv();
                data[i * 9 + 8][0] = "Chance:";
                data[i * 9 + 8][1] = weather.getDay(i + 1).getNight().getChanceOfPrecip();
                data[i * 9 + 8][2] = weather.getDay(i + 1).getMorning().getChanceOfPrecip();
                data[i * 9 + 8][3] = weather.getDay(i + 1).getNoon().getChanceOfPrecip();
                data[i * 9 + 8][4] = weather.getDay(i + 1).getEvening().getChanceOfPrecip();
                
            }
            String[] columnNames = {"Date", "Night", "Morning", "Noon", "Evening"};
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            weatherTable.setModel(model);
        } catch (Exception ex) {
            ErrorDialog("Connection failed");
        }
        }
    }

    public void ErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        WeatherGUI gui = new WeatherGUI();
        gui.initialize();
    }
}
