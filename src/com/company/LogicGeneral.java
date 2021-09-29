package com.company;

import javax.swing.*;

public class LogicGeneral extends Logic{
    GeneralForm app;


    LogicGeneral(FormManager manager){
        super(manager);
        this.createForm();
    }

    @Override
    void createForm() {
        app = new GeneralForm(this);
        app.show();
    }
    public void click(int butt){

    }
    public void pressLabMenu(Labs lab){
        switch (lab){
            case LAB1 ->
                    manager.createWinLaba1();
            case LAB2 ->
                    manager.createWinLaba2();
        }
    }
    public void writeToErrorArea(String text){
        app.addToTextArea(text);
    }
}
