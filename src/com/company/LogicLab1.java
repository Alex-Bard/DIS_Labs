package com.company;


import java.io.IOException;


public class LogicLab1 extends Logic {
    private FirstForm app;

    LogicLab1(FormManager manager){
        super(manager);
        this.createForm();
    }

    public void click(int Butt){
        byte [] resultBytes, name, family;
        String result = "";
        String nameStr = app.getNameTextField();
        String familyStr = app.getFamyliTextField();
        try {
            name = toBytes(nameStr);
            family = toBytes(familyStr);

        }
        catch (Exception e){
            String Error = "wrong input";
            app.addToTextArea(genLog(Error));
            return;
        }

        resultBytes = xorString(name, family);

        app.addToTextArea(genMassage(massToString(resultBytes)));

        try {
            result = toString(resultBytes);
        }
        catch (Exception e){
            String Error = "wrong result";
            app.addToTextArea(genLog(Error));
            manager.printErrorToGeneralForm(genLog(Error));
            return;
        }
        finally {
            app.addToTextArea(genMassage("result: \"" + result+"\""));
            app.addToTextArea(genMassage("reverse result: \"" + getReverseResult(result,name.length) +"\""));
        }
        app.setResultTextField(result);
       // logger.printResult(resultBytes);

    }
    private String massToString( byte[] resultBytes){
        StringBuilder s = new StringBuilder();
        for (byte i :resultBytes){
            s.append(Byte.valueOf(i));
            s.append(" ");
        }
        return s.toString();
    }
    public String getReverseResult(String res, int pos){
        StringBuilder tmp;
        tmp = new StringBuilder(res);
        int k = res.length()-1;
        int h = pos;
        for (int i = res.length(); i > pos; i--){
            tmp.setCharAt(k--, res.charAt(h++));
        }
        return tmp.toString();
    }
    private byte[] xorString(byte[] Str1, byte[] Str2){
        byte [] result;
        byte[] tmp;
        int i;

        //StringBuilder sb = new StringBuilder();

        if (Str1.length > Str2.length){
            tmp = Str1.clone();
            Str1 = Str2;
            Str2 = tmp;
        }
        result = new byte[Str2.length];


        for(i = 0; i < Str1.length; i++)
            result[i] = (byte) (Str1[i] ^ Str2[i]);

        if (Str2.length - i >= 0)
            System.arraycopy(Str2, i, result, i, Str2.length - i);

        return result;
    }
    private byte[] toBytes(String str) throws IOException {
        return str.getBytes("windows-1251");
    }
    private String toString(byte[] bytes) throws IOException{
       return new String (bytes, "windows-1251");
    }

    public void createForm(){
        app = new FirstForm(this);
        app.show();
    }
}
