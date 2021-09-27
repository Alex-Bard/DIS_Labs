package com.company;


import java.io.IOException;
import java.util.Arrays;

public class Logger {
    private Graphics app;

    public Logger(Graphics app) {
        this.app = app;
    }
    public void printMass(byte [] mass){
        app.addToTextArea("----------------------------------- \n " +
                "коды сымволов результата: \n");
        for (int i = 0; i < mass.length; i++)
            app.addToTextArea(Byte.toString(mass[i]) + "\n");
        app.addToTextArea("-----------------------------------\n");
    }
    public void printResult(byte [] res){
        app.addToTextArea("----------------------------------- \n " +
                "результат: \n");

        app.addToTextArea(new String(res) +"\n");
        app.addToTextArea("-----------------------------------\n");
    }
    public void printReverseResult(byte [] res, int pos){
        byte [] tmp;
        tmp = res.clone();
        int k = res.length-1;
        int h = pos;
        for (int i = res.length; i > pos; i--){
            tmp[k--] = res[h++];
        }
        app.addToTextArea("----------------------------------- \n " +
                "отраженный результат: \n");

        app.addToTextArea(new String(tmp) +"\n");
        app.addToTextArea("-----------------------------------\n");
    }
    public void printException(IOException e){
        app.addToTextArea("----------------------------------- \n " +
                "исключение: \n");

        app.addToTextArea(e.getMessage() +"\n");
        app.addToTextArea("-----------------------------------\n");
    }
}
