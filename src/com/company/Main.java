package com.company;
import java.awt.*;

public class Main {
    static private Graphics app;

    public static void main(String[] args) {

        FormManager manager = new FormManager();
        manager.createFirstform();
        //Logger logger = new Logger(app);
       /* handler.addLoggerLink(logger);
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
}
