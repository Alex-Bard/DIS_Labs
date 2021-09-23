package com.company;
import java.awt.*;

public class Main {
    static private Graphics app;
    public static void main(String[] args) {

        ButtonHandler handler = new ButtonHandler();

        app = new Graphics(handler); // объект графического интерфейса
        app.show();
        handler.addGraphisLink(app);
        Logger logger = new Logger(app);
        handler.addLoggerLink(logger);
    }
            /*app.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startExp();
            }
        });*/
}
