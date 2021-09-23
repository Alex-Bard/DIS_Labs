package com.company;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class ButtonHandler {
private Graphics app;
private Logger logger;


    public void click(){
        String result = "";
        String name = app.getNameTextField();
        String famyli = app.getFamyliTextField();
        byte [] resultBytes;
        resultBytes = xorString(name, famyli);
        logger.printMass(resultBytes);
        logger.printResult(resultBytes);

        try{
            result = encodeString(resultBytes);
            //encodeString(resultBytes.getBytes(StandardCharsets.UTF_8));
            int l = 1;
        }
        catch (IOException e){
            e.printStackTrace();
            logger.printException(e);

        }
        finally {
            app.setResultTextField(result);
        }

    }
    private byte[] xorString(String Str1, String Str2){
        byte [] result, name, family;
        String tmp;
        int i;

        //StringBuilder sb = new StringBuilder();

        if (Str1.length() > Str2.length()){
            tmp = Str1;
            Str1 = Str2;
            Str2 = tmp;
        }
       // family = new byte[Str2.length()];
        result = new byte[Str2.length()];
       // name = new byte[Str1.length()];
        name = Str1.getBytes(StandardCharsets.UTF_8);
        family = Str2.getBytes(StandardCharsets.UTF_8);

        for(i = 0; i < name.length; i++)
            result[i] = (byte) (name[i] ^ family[i]);

        for (int j = i; j < family.length;j++)
            result[j] = family[j];

         logger.printReverseResult(result, name.length);

        //result += Str2.substring(i,Str2.length());
        return result;
    }
    private String reverseStringAt(String str,int Start){
        str = str.substring(Start, str.length());
        return new StringBuilder(str).reverse().toString();
    }
    private String encodeString( byte [] bytes) throws java.io.IOException{


        String res = StandardCharsets.UTF_8.newDecoder()
                .onMalformedInput(CodingErrorAction.REPORT)
                .onUnmappableCharacter(CodingErrorAction.REPORT)
                .decode(ByteBuffer.wrap(bytes))
                .toString();

        for (Character character : res.toCharArray())
            if (Character.isISOControl(character))
                throw new IOException("some characters are control");
        return res;

    }
    public void addGraphisLink(Graphics app){
        this.app = app;
    }
    public void addLoggerLink(Logger logger){
        this.logger = logger;
    }
}
