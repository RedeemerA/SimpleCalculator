package com.fanshuff.rma.simplecalculator.page.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.fanshuff.rma.simplecalculator.R;

public class MainActivity extends AppCompatActivity {


    private static String ERROR = "ERROR";

    private TextView mTextViewResult;

    private Button mButtonAC, mButtonSwitchPN, mButtonExponential, mButtonDivision, mButtonMul, mButtonAdd,
            mButtonSub, mButtonAmount, mButtonSpot,
            mButtonZero, mButtonOne, mButtonTwo, mButtonThree, mButtonFour, mButtonFive, mButtonSix,
            mButtonSeven, mButtonEight, mButtonNine;

    private boolean isClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initListener();
    }

    private void initView() {
        mTextViewResult = findViewById(R.id.tv_main_result);

        mButtonAC = findViewById(R.id.bt_main_clear);
        mButtonSwitchPN = findViewById(R.id.bt_main_switch_PN);
        mButtonExponential = findViewById(R.id.bt_main_exponential);
        mButtonDivision = findViewById(R.id.bt_main_division);
        mButtonMul = findViewById(R.id.bt_main_mul);
        mButtonAdd = findViewById(R.id.bt_main_add);
        mButtonSub = findViewById(R.id.bt_main_sub);
        mButtonAmount = findViewById(R.id.bt_main_amount);
        mButtonSpot = findViewById(R.id.bt_main_spot);
        mButtonZero = findViewById(R.id.bt_main_zero);
        mButtonOne = findViewById(R.id.bt_main_one);
        mButtonTwo = findViewById(R.id.bt_main_two);
        mButtonThree = findViewById(R.id.bt_main_three);
        mButtonFour = findViewById(R.id.bt_main_four);
        mButtonFive = findViewById(R.id.bt_main_five);
        mButtonSix = findViewById(R.id.bt_main_six);
        mButtonSeven = findViewById(R.id.bt_main_seven);
        mButtonEight = findViewById(R.id.bt_main_eight);
        mButtonNine = findViewById(R.id.bt_main_nine);
    }

    private void initListener() {
        mButtonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNumber(view);
            }
        });

        mButtonSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setNumber(view);
            }
        });


        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperation(view);
            }
        });

        mButtonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperation(view);
            }
        });

        mButtonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperation(view);
            }
        });

        mButtonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperation(view);
            }
        });

        mButtonExponential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOperation(view);
            }
        });

        mButtonAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isClear){
                    isClear=false;
                }
                mTextViewResult.setText("");
            }
        });

        mButtonAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getResult();
            }
        });

        mButtonSwitchPN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchPN();
            }
        });

    }

    private void setNumber(View view){
        String str = mTextViewResult.getText().toString();
        if(isClear){
            isClear=false;
            str="";
            mTextViewResult.setText("");
        }
        mTextViewResult.setText(str+((Button)view).getText());
    }

    private void switchPN(){
        String exp=mTextViewResult.getText().toString();
        if(exp==null||exp.equals("")){
            //因为内容为空 所以不进行操作
            return ;
        }
        if(!exp.contains(" ")){
            exp = importTooManyPoint(exp);
            if (exp.equals(ERROR)){
                return;
            }
            double cnt=Double.parseDouble(exp);
            //没有运算符所以直接转换
            cnt = 0-cnt;
            if(!exp.contains(".")) {
                int res = (int) cnt;
                mTextViewResult.setText(String.valueOf(res));
            }else {
                mTextViewResult.setText(String.valueOf(cnt));}


        }else{
            //有运算符，得出计算出结果再进行转换
            getResult();
            switchPN();
        }

    }

    private void setOperation(View view){
        String str = mTextViewResult.getText().toString();
        if(isClear){
            isClear=false;
            str="";
            mTextViewResult.setText("");
        }
        if(str.contains("+")||str.contains("-")||str.contains("×")||str.contains("÷")||str.contains("^")) {
            str=str.substring(0,str.indexOf(" "));
        }
        mTextViewResult.setText(str+" "+((Button)view).getText()+" ");
    }

    private String importTooManyPoint(String s1){

        int pointNumberS1 = 0;
        for (int i = 0; i < s1.length(); i++){
            if (String.valueOf(s1.charAt(i)).equals(".")){
                pointNumberS1++;
            }
        }
        if (pointNumberS1 > 1){
            //包含多个"." 报错
            mTextViewResult.setText("0");
            Toast.makeText(MainActivity.this, "IMPORT ERROR", Toast.LENGTH_SHORT).show();
            return ERROR;
        }else{
            //如果开头是"."则在前面添加0
            if (String.valueOf(s1.charAt(0)).equals(".")){
                s1 = "0"+s1;
                return s1;
            }
        }
        return s1;

    }

    private void getResult() {
        String exp=mTextViewResult.getText().toString();
        if(exp==null||exp.equals("")) return ;


        if(!exp.contains(" ")){
            //因为没有运算符所以不用运算
            return ;
        }
        if(isClear){
            isClear=false;
            return;
        }
        isClear=true;


        //截取运算符前面的字符串
        String s1=exp.substring(0,exp.indexOf(" "));
        s1 = importTooManyPoint(s1);
        if (s1.equals(ERROR)){
            return;
        }
        //截取的运算符
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);
        //截取运算符后面的字符串
        String s2=exp.substring(exp.indexOf(" ")+3);
        s2 = importTooManyPoint(s2);
        if (s2.equals(ERROR)){
            return;
        }
        double cnt=0;
        //如果s1,s2都不为空，正常执行运算逻辑
        if(!s1.equals("")&&!s2.equals("")){
            double d1=Double.parseDouble(s1);
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d1+d2;
            }
            if(op.equals("-")){
                cnt=d1-d2;
            }
            if(op.equals("×")){
                cnt=d1*d2;
            }
            if(op.equals("÷")){
                if(d2==0) cnt=0;
                else cnt=d1/d2;
            }
            if(op.equals("^")){
                if (d1 == 0){
                    cnt = 0;
                }
                else if (d2 == 0){
                    cnt = 1;
                }
                else{
                    cnt = Math.pow(d1,d2);
                }
            }
            if(!s1.contains(".")&&!s2.contains(".")&&!op.equals("÷")) {
                int res = (int) cnt;
                mTextViewResult.setText(res+"");
            }else {
                mTextViewResult.setText(cnt+"");}
        }
        //如果s1不是空    s2是空  就执行下一步
        else if(!s1.equals("")&&s2.equals("")){
            double d1=Double.parseDouble(s1);
            if(op.equals("+")){
                cnt=d1;
            }
            if(op.equals("-")){
                cnt=d1;
            }
            if(op.equals("×")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if (op.equals("^")){
                //这里默认认为用户 d1^0
                cnt=1;
            }
            if(!s1.contains(".")) {
                int res = (int) cnt;
                mTextViewResult.setText(String.valueOf(res));
            }else {
                mTextViewResult.setText(String.valueOf(cnt));}
        }
        //如果s1是空    s2不是空  就执行下一步
        else if(s1.equals("")&&!s2.equals("")){
            double d2=Double.parseDouble(s2);
            if(op.equals("+")){
                cnt=d2;
            }
            if(op.equals("-")){
                cnt=0-d2;
            }
            if(op.equals("×")){
                cnt=0;
            }
            if(op.equals("÷")){
                cnt=0;
            }
            if (op.equals("^")){
                cnt=0;
            }
            if(!s2.contains(".")) {
                int res = (int) cnt;
                mTextViewResult.setText(String.valueOf(res));
            }else {
                mTextViewResult.setText(String.valueOf(cnt));}
        }
        else {
            mTextViewResult.setText("");
        }
    }
}