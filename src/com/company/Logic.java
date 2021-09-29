package com.company;

import java.awt.*;
import java.time.format.DateTimeFormatter;

public abstract class Logic implements logicable {
    FormManager manager;

    Logic(FormManager manager){
        this.manager = manager;
    }
    abstract void createForm();
    void sendLog(String log){

    }

    String genLog(String text){
        String log;
        log = getTime() + ":" + newLine();
        log += "Error - " + text + newLine();
        return log;
    }
    String genMassage(String text){
        String res = "";
         res += genLine() + newLine();
         res += getTime() + ":" + newLine();
         res += "massage - " + text + newLine();
         res += genLine() + newLine();
         return res;
    }
    private String genLine(){
        return "---------------------";
    }
    private String newLine(){
        return "\n";
    }
    private String getTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy 'г. 'HH:mm:ss");
        return java.time.ZonedDateTime.now().format(dtf);
    }

}
