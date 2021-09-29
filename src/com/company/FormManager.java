package com.company;

public class FormManager {
    private LogicLab1 logicLab1;
    private LogicGeneral logic;
    public void createFirstform(){

        logic = new LogicGeneral(this);

    }
    public void createWinLaba1(){
        logicLab1 = new LogicLab1(this);
    }
    public void createWinLaba2(){
        /*logicLab2 = new LogicLab2(this);*/
    }
    public void printErrorToGeneralForm(String text){
        logic.writeToErrorArea(text);
    }
}
