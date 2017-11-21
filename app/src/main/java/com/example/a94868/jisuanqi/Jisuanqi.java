package com.example.a94868.jisuanqi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Arrays;
import bsh.EvalError;
import java.lang.Integer;
import bsh.Interpreter;

public class Jisuanqi extends AppCompatActivity implements View.OnClickListener{
    private Button number0,number1,number2,number3,number4,number5,number6,number7,number8,
            number9,add,reduce,divide,multiply,point,clear,back,exit,sqrt,result,sin,cos,mi,danzhuan,jinzhuan;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jsq);
        jisuanqi();
    }
    public void jisuanqi(){
        number0= (Button) findViewById(R.id.ling);
        number1= (Button) findViewById(R.id.yi);
        number2= (Button) findViewById(R.id.er);
        number3= (Button) findViewById(R.id.san);
        number4= (Button) findViewById(R.id.si);
        number5= (Button) findViewById(R.id.wu);
        number6= (Button) findViewById(R.id.liu);
        number7= (Button) findViewById(R.id.qi);
        number8= (Button) findViewById(R.id.ba);
        number9= (Button) findViewById(R.id.jiu);
        result= (Button) findViewById(R.id.dengyu);
        point= (Button) findViewById(R.id.dian);
        add= (Button) findViewById(R.id.jia);
        reduce= (Button) findViewById(R.id.jian);
        back= (Button) findViewById(R.id.tuige);
        clear= (Button) findViewById(R.id.qingchu);
        divide= (Button) findViewById(R.id.chu);
        exit= (Button) findViewById(R.id.tuichu);
        sqrt= (Button) findViewById(R.id.kaigen);
        multiply= (Button) findViewById(R.id.cheng);
        sin= (Button) findViewById(R.id.sin);
        cos= (Button) findViewById(R.id.cos);
        mi= (Button) findViewById(R.id.pingfang);
        danzhuan= (Button) findViewById(R.id.danwei);
        jinzhuan= (Button) findViewById(R.id.jinzhi);
        textView= (TextView) findViewById(R.id.textView);
        textView.setText("");
        result.setOnClickListener(this);
        number0.setOnClickListener(this);
        number1.setOnClickListener(this);
        number2.setOnClickListener(this);
        number3.setOnClickListener(this);
        number4.setOnClickListener(this);
        number5.setOnClickListener(this);
        number6.setOnClickListener(this);
        number7.setOnClickListener(this);
        number8.setOnClickListener(this);
        number9.setOnClickListener(this);
        back.setOnClickListener(this);
        clear.setOnClickListener(this);
        exit.setOnClickListener(this);
        sqrt.setOnClickListener(this);
        multiply.setOnClickListener(this);
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        point.setOnClickListener(this);
        divide.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        mi.setOnClickListener(this);
        danzhuan.setOnClickListener(this);
        jinzhuan.setOnClickListener(this);
    }
    private String getResult(String exp){
        Interpreter bsh = new Interpreter();
        Number result = null;
        try {
            exp = filterExp(exp);
            result = (Number)bsh.eval(exp);
        } catch (EvalError e) {
            e.printStackTrace();
            return "算数公式错误";
        }
        exp = result.doubleValue()+"";
        if(exp.endsWith(".0"))
            exp = exp.substring(0, exp.indexOf(".0"));
        return exp;
    }
    private String filterExp(String exp) {
        String num[] = exp.split("");
        String temp = null;
        int begin=0,end=0;
        for (int i = 1; i < num.length; i++) {
            temp = num[i];
            if(temp.matches("[+-/()*]")){
                if(temp.equals(".")) continue;
                end = i - 1;
                temp = exp.substring(begin, end);
                if(temp.trim().length() > 0 && temp.indexOf(".")<0)
                    num[i-1] = num[i-1]+".0";
                begin = end + 1;
            }
        }
        return Arrays.toString(num).replaceAll("[\\[\\], ]", "");
    }
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ling:
                textView.append("0");
                break;
            case R.id.yi:
                textView.append("1");
                break;
            case R.id.er:
                textView.append("2");
                break;
            case R.id.san:
                textView.append("3");
                break;
            case R.id.si:
                textView.append("4");
                break;
            case R.id.wu:
                textView.append("5");
                break;
            case R.id.liu:
                textView.append("6");
                break;
            case R.id.qi:
                textView.append("7");
                break;
            case R.id.ba:
                textView.append("8");
                break;
            case R.id.jiu:
                textView.append("9");
                break;
            case R.id.tuichu:
                finish();
                break;
            case R.id.jia:
                textView.append("+");
                break;
            case R.id.jian:
                textView.append("-");
                break;
            case R.id.tuige:
                String s =  textView.getText().toString();
                if(s.length()>0) {
                    textView.setText("" + s.substring(0, s.length() - 1));
                }
                break;
            case R.id.dian:
                textView.append(".");
                break;
            case R.id.qingchu:
                textView.setText("");
                break;
            case R.id.kaigen:
                if(textView.getText().toString().length()>0) {
                    double num = Double.valueOf(textView.getText().toString());
                    num = Math.sqrt(num);
                    textView.setText("" + num);
                }
                break;
            case R.id.sin:
                if(textView.getText().toString().length()>0) {
                    double sss = Double.valueOf(textView.getText().toString());
                    sss = Math.sin(sss);
                    textView.setText("" + sss);
                }
                break;
            case R.id.cos:
                if(textView.getText().toString().length()>0) {
                    double ccc = Double.valueOf(textView.getText().toString());
                    ccc = Math.cos(ccc);
                    textView.setText("" + ccc);
                }
                break;
            case R.id.pingfang:
                    double ppp1;
                    double ppp = Double.valueOf(textView.getText().toString());
                    ppp1 = ppp*ppp;
                    textView.setText("" + ppp1);
                break;
            case R.id.danwei:
                    double mmm = Double.valueOf(textView.getText().toString());
                    mmm = 3.2808399*mmm;
                    textView.setText("" + mmm);
                break;
            case R.id.jinzhi:
                int aaa = Integer.valueOf(textView.getText().toString());
                String aaa1 = Integer.toBinaryString(aaa);
                textView.setText("" + aaa1);
                break;
            case R.id.cheng:
                textView.append("*");
                break;
            case R.id.chu:
                textView.append("/");
                break;
            case R.id.dengyu:
                String result=getResult(textView.getText().toString());
                textView.setText(result);
                break;

        }
    }
}
