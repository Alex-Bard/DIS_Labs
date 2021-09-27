package com.company;
import java.awt.*;
import java.time.format.DateTimeFormatter;

public class Main {
    static private Graphics app;
    public static void main(String[] args) {

        ButtonHandler handler = new ButtonHandler();

        app = new Graphics(handler); // объект графического интерфейса
        app.show();
        handler.addGraphisLink(app);
        Logger logger = new Logger(app);
        handler.addLoggerLink(logger);
        //получение даты
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy 'г. 'HH:mm:ss");
        String timeNow = java.time.ZonedDateTime.now().format(dtf);
        app.setStatusLabel("текущая дата и время: " + timeNow);
    }
            /*app.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExp();
            }
        });*/
}
