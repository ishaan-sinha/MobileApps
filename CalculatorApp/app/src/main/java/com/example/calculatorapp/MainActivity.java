package com.example.calculatorapp;

import static android.text.TextUtils.substring;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    Button b11;
    Button b12;
    Button b13;
    Button b14;
    Button b15;
    Button b16;
    Button b17;
    Button b18;
    Button b19;
    Button b20;

    TextView t1;
    TextView t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MediaPlayer np = MediaPlayer.create(this, R.raw.click);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        b10 = findViewById(R.id.button10);
        b11 = findViewById(R.id.button11);
        b12 = findViewById(R.id.button12);
        b13 = findViewById(R.id.button13);
        b14 = findViewById(R.id.button14);
        b15 = findViewById(R.id.button15);
        b16 = findViewById(R.id.button16);
        b17 = findViewById(R.id.button17);
        b18 = findViewById(R.id.button18);
        b19 = findViewById(R.id.button19);
        b20 = findViewById(R.id.button20);
        t1 = findViewById(R.id.textView1);
        t2 = findViewById(R.id.textView);
        Button buttonList1[]= {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b14,b16, b17, b18, b19};
        for(int i = 0; i < buttonList1.length; i++){
            int finalI = i;
            buttonList1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(t1.getText().toString().equals("0")){ t1.setText(buttonList1[finalI].getText().toString());}
                    else{t1.setText(t1.getText().toString()+buttonList1[finalI].getText().toString());}
                }
            });
        }
        Button buttonList2[]= {b4,b8,b12, b16, b17, b18, b19};
        for(int i = 0; i < buttonList2.length; i++){
            int finalI = i;
            buttonList2[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    t1.setText(t1.getText().toString()+buttonList2[finalI].getText().toString());
                }
            });
        }
        b20.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 10);
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(t1.getText().toString().length()>0){t1.setText(t1.getText().toString().substring(0, t1.getText().toString().length()-1));}
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("0");
            }
        });


        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    np.start();
                    String s = t1.getText().toString();

                    t2.setText(s);
                /*
                b2.setText(String.valueOf(Pattern.matches("\\d[*+-/]\\d", s)));
                while(Pattern.matches("\\d[*+-/]\\d", s)){
                    b2.setText(s);
                    s = s.substring(0, s.length()-2);
                    t1.setText(s);
                }

                 */
                    //ArrayList<String> arrOfStr = new ArrayList<String>(Arrays.asList(s.split("(?=[+-*/()]|(?<=[+-*/()]))")));
                    ArrayList<String> arrOfStr = new ArrayList<String>(Arrays.asList(s.split("(?=[-*/+()]|(?<=[-*/+()]))")));
                    for(String m: arrOfStr){
                        if(m.equals("")){ t1.setText("error");
                            break;}
                    }

                    //System.out.println(Arrays.toString(arrOfStr.toArray()));
                    while (arrOfStr.contains("(") && arrOfStr.contains(")")) {
                        int a = arrOfStr.lastIndexOf("(");
                        int b = arrOfStr.subList(a, arrOfStr.size()).indexOf(")")+a;
                        String temp = "";
                        for (int i = a + 1; i < b; i++) {
                            temp += arrOfStr.get(i);
                        }
                        for (int i = 0; i < b - a + 1; i++) {
                            arrOfStr.remove(a);
                        }
                        arrOfStr.add(a, evaluate(temp));

                    }
                    if(arrOfStr.contains("(")||arrOfStr.contains(")")){t1.setText( "error");}else {
                        String listString = String.join("", arrOfStr);
                        String eval = evaluate(listString);
                        BigDecimal stripped = new BigDecimal(eval).setScale(6, RoundingMode.HALF_UP).stripTrailingZeros();
                        t1.setText(stripped.toPlainString());
                    }
                } catch (Exception e) {
                    t1.setText("error");
                }
            }
        });
    }
    public String evaluate(String a) throws ConcurrentModificationException {
        int c;
        int b;

        ArrayList<String> arrOfStr = new ArrayList<String>(Arrays.asList(a.split("((?=[-+/*])|(?<=[-+/*]))")));
        System.out.println(Arrays.toString(new List[]{arrOfStr}));
        int size = arrOfStr.size();
        try{
        for(int i = 1; i< arrOfStr.size(); i+=1) {
            //System.out.println(arrOfStr.get(i));

            if (arrOfStr.get(i).equals("")) {
                return "error";
            }
            if (arrOfStr.get(i).equals("*") || arrOfStr.get(i).equals("/")) {
                //List<String> temp = arrOfStr.subList(i-1,i+2);
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(arrOfStr.get(i - 1));
                temp.add(arrOfStr.get(i));
                temp.add(arrOfStr.get(i + 1));
                //System.out.println(Arrays.toString(new List[]{temp}));
                arrOfStr.remove(i);
                arrOfStr.remove(i);
                arrOfStr.remove(i - 1);
                arrOfStr.add(i - 1, String.valueOf(biteEvaluate(temp)));
                i--;
            }
        }
            size = arrOfStr.size();
            for (int i = size - 1; i >= 1; i--) {
                if (arrOfStr.get(i).equals("+") || arrOfStr.get(i).equals("-")) {
                    //List<String> temp = arrOfStr.subList(i-1,i+2);
                    ArrayList<String> temp = new ArrayList<String>();
                    temp.add(arrOfStr.get(i - 1));
                    temp.add(arrOfStr.get(i));
                    temp.add(arrOfStr.get(i + 1));
                    //System.out.println(Arrays.toString(new List[]{temp}));
                    arrOfStr.remove(i);
                    arrOfStr.remove(i);
                    arrOfStr.remove(i - 1);
                    arrOfStr.add(i - 1, String.valueOf(biteEvaluate(temp)));
                }
            }

        } catch(Exception e){
            return "error";
        }

         /*
        while(arrOfStr.contains("*") || arrOfStr.contains("/")){
            c = arrOfStr.indexOf("*");
            b = arrOfStr.indexOf("/");
            if((c<0 || b<c) && b>0){
                List<String> temp = arrOfStr.subList(b-1,b+2);
                System.out.println(Arrays.toString(new List[]{temp}));
                arrOfStr.remove(b);
                arrOfStr.remove(b);
                arrOfStr.remove(b-1);
                arrOfStr.add(b-1, String.valueOf(biteEvaluate(temp)));
            }
            else{
                List<String> temp = arrOfStr.subList(c-1,c+2);
                System.out.println(Arrays.toString(new List[]{temp}));
                arrOfStr.remove(c);
                arrOfStr.remove(c);
                arrOfStr.remove(c-1);
                arrOfStr.add(c-1, String.valueOf(biteEvaluate(temp)));
            }
        }
        while(arrOfStr.contains("+") || arrOfStr.contains("-")){
            c = arrOfStr.indexOf("+");
            b = arrOfStr.indexOf("-");
            if((c<0 || b<c) && b>0){
                List<String> temp = arrOfStr.subList(b-1,b+2);
                System.out.println(Arrays.toString(new List[]{temp}));
                arrOfStr.remove(b);
                arrOfStr.remove(b);
                arrOfStr.remove(b-1);
                arrOfStr.add(b-1, String.valueOf(biteEvaluate(temp)));
            }
            else{
                List<String> temp = arrOfStr.subList(c-1,c+2);
                System.out.println(Arrays.toString(new List[]{temp}));
                arrOfStr.remove(c);
                arrOfStr.remove(c);
                arrOfStr.remove(c-1);
                arrOfStr.add(c-1, String.valueOf(biteEvaluate(temp)));
            }
        }
        */

        return arrOfStr.get(0);
    }
    public double biteEvaluate(ArrayList<String> a) {
        //String[] arrOfStr = a.split("((?=[+-/*])|(?<=[+-/*]))");
        //System.out.println(a);
        try {
            double first = Double.parseDouble(a.get(0));
            double second = Double.parseDouble(a.get(2));
            switch (a.get(1)) {
                case "+":
                    return first + second;

                case "-":
                    return first - second;

                case "*":
                    return first * second;

                case "/":
                    return first / second;

            }
            return 1.0;
        } catch (Exception e){
            System.out.println(e);
        }
        return 1.0;
    }
}