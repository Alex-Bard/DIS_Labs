package com.company;

public abstract class Form {
    Logic logic;

    Form(Logic logic) {
        this.logic = logic;
    }

    public abstract void show();
}