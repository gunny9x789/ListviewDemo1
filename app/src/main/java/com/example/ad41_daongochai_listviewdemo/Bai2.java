package com.example.ad41_daongochai_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2 extends AppCompatActivity implements View.OnClickListener {
    private TextView tv1;
    private TextView tv2;
    private TextView tvShow;
    private TextView tvShow2;
    private EditText et;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;
    private Button btnDel;
    private Button btnClear;
    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnThapPhan;
    private Button btnBang;
    private List<Double> listNumber;// = new ArrayList<Double>();
    private List<String> listMatch;// = new ArrayList<String>();
    private String sNumber;
    private String thapPhan;
    private StringBuffer showNumber;
    private int i;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        listNumber = new ArrayList<Double>();
        listMatch = new ArrayList<String>();
        showNumber = new StringBuffer();

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tvShow = findViewById(R.id.tv_show);
        tvShow2 = findViewById(R.id.tv_show2);
        et = findViewById(R.id.et);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnDel = findViewById(R.id.btn_del);
        btnClear = findViewById(R.id.btn_clear);
        btnCong = findViewById(R.id.btn_cong);
        btnTru = findViewById(R.id.btn_tru);
        btnNhan = findViewById(R.id.btn_nhan);
        btnChia = findViewById(R.id.btn_chia);
        btnThapPhan = findViewById(R.id.btn_thapPhan);
        btnBang = findViewById(R.id.btn_bang);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setBackgroundResource(R.drawable.tv_on);
                tv2.setBackgroundResource(R.drawable.tv_off);
                Intent intent = new Intent(Bai2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        setBtnClick();


    }

    public void setBtnClick() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);

        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);

        btnThapPhan.setOnClickListener(this);
        btnBang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        listNumber = new ArrayList<Double>();
//        listMatch = new ArrayList<String>();
        switch (v.getId()) {

            case R.id.btn0: {
                et.append("0");
                break;
            }
            case R.id.btn1: {
                et.append("1");
                break;
            }
            case R.id.btn2: {
                et.append("2");
                break;
            }
            case R.id.btn3: {
                et.append("3");
                break;
            }
            case R.id.btn4: {
                et.append("4");
                break;
            }
            case R.id.btn5: {
                et.append("5");
                break;
            }
            case R.id.btn6: {
                et.append("6");
                break;
            }
            case R.id.btn7: {
                et.append("7");
                break;
            }
            case R.id.btn8: {
                et.append("8");
                break;
            }
            case R.id.btn9: {
                et.append("9");
                break;
            }
            case R.id.btn_del: {
                String matchNum = et.getText().toString();
                if (matchNum.equals("") == false) {
                    et.setText(btnDel(matchNum));
                }
                break;
            }
            case R.id.btn_clear: {
                listNumber.clear();
                listMatch.clear();
                et.setText("");
                tvShow.setText("");
                break;
            }
            case R.id.btn_cong: {
                sNumber = "";
                sNumber = et.getText() + "";
                if ((sNumber.equals("") == false) || (sNumber.trim().length() > 0)) {
                    double number = Double.parseDouble(sNumber);
                    listNumber.add(number);
                    listMatch.add("+");
                    et.setText("");
                    int find = sNumber.indexOf(".");
                    if (find >= 4 || (find < 0 && sNumber.length() >= 4)) {
                        if (find < 0 && sNumber.length() >= 4) {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() + "+");
                        } else {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber.substring(0, find));
                            thapPhan = sNumber.substring(find);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() +thapPhan+ "+");
                        }
                    } else
                        tvShow.append(sNumber + "+");

                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Không có giá trị", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                break;
            }
            case R.id.btn_tru: {
                sNumber = "";
                sNumber = et.getText() + "";
                if ((sNumber.equals("") == false) || (sNumber.trim().length() > 0)) {
                    double number = Double.parseDouble(sNumber);
                    listNumber.add(number);
                    listMatch.add("-");
                    et.setText("");
                    int find = sNumber.indexOf(".");
                    if (find >= 4 || (find < 0 && sNumber.length() >= 4)) {
                        if (find < 0 && sNumber.length() >= 4) {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() + "-");
                        } else {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber.substring(0, find));
                            thapPhan = sNumber.substring(find);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() +thapPhan+ "-");
                        }
                    } else
                        tvShow.append(number + "-");
                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Không có giá trị", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                break;
            }
            case R.id.btn_nhan: {
                sNumber = "";
                sNumber = et.getText() + "";
                if ((sNumber.equals("") == false) || (sNumber.trim().length() > 0)) {
                    double number = Double.parseDouble(sNumber);
                    listNumber.add(number);
                    listMatch.add("*");
                    et.setText("");
                    int find = sNumber.indexOf(".");
                    if (find >= 4 || (find < 0 && sNumber.length() >= 4)) {
                        if (find < 0 && sNumber.length() >= 4) {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() + "*");
                        } else {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber.substring(0, find));
                            thapPhan = sNumber.substring(find);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() +thapPhan+ "*");
                        }
                    } else
                        tvShow.append(number + "*");
                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Không có giá trị", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                break;
            }
            case R.id.btn_chia: {
                sNumber = "";
                sNumber = et.getText() + "";
                if ((sNumber.equals("") == false) || (sNumber.trim().length() > 0)) {
                    double number = Double.parseDouble(sNumber);
                    listNumber.add(number);
                    listMatch.add("/");
                    et.setText("");
                    int find = sNumber.indexOf(".");
                    if (find >= 4 || (find < 0 && sNumber.length() >= 4)) {
                        if (find < 0 && sNumber.length() >= 4) {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() + "/");
                        } else {
                            showNumber.delete(0, showNumber.length());
                            showNumber.append(sNumber.substring(0, find));
                            thapPhan = sNumber.substring(find);
                            showNumber.reverse();
                            count = 0;
                            for (i = 3; i < showNumber.length(); i += 3) {
                                if (i + count <= (showNumber.length() - 1)) {
                                    showNumber.insert((i + count), ",");
                                }
                                count += 1;
                            }
                            tvShow.append(showNumber.reverse() +thapPhan+ "/");
                        }
                    } else
                        tvShow.append(number + "/");
                }else{
                    Toast toast = Toast.makeText(getBaseContext(), "Không có giá trị", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                break;
            }
            case R.id.btn_thapPhan: {
                et.append(".");
                break;
            }
            case R.id.btn_bang:
                double kq = 0;
                sNumber = "";
                sNumber = et.getText() + "";
                if ((sNumber.equals("") == false) || (sNumber.trim().length() > 0)) {
                    double number = Double.parseDouble(sNumber);
                    listNumber.add(number);
                    et.setText("");
                } else {
                    Toast toast = Toast.makeText(getBaseContext(), "Không có giá trị", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
                for (i = 0; i < (listMatch.size()); i++) {
                    switch (listMatch.get(i)) {
                        case "+": {
                            if (i == 0) {
                                kq = listNumber.get(i) + listNumber.get(i + 1);
                            } else {
                                kq = kq + listNumber.get(i + 1);
                            }
                            break;
                        }
                        case "-": {
                            if (i == 0) {
                                kq = listNumber.get(i) - listNumber.get(i + 1);
                            } else {
                                kq = kq + listNumber.get(i + 1);
                            }
                            break;
                        }
                        case "*": {
                            if (i == 0) {
                                kq = listNumber.get(i) * listNumber.get(i + 1);
                            } else {
                                kq = kq * listNumber.get(i);
                            }
                            break;
                        }
                        case "/": {
                            if (i == 0) {
                                kq = listNumber.get(i) / listNumber.get(i + 1);
                            } else {
                                kq = kq / listNumber.get(i + 1);
                            }
                            break;
                        }
                    }
                }
                listNumber.clear();
                listMatch.clear();
                listNumber.add(kq);
                sNumber = kq + "";
                int find = sNumber.indexOf(".");
                if (find >= 4 || (find < 0 && sNumber.length() >= 4)) {
                    showNumber.delete(0, showNumber.length());
                    showNumber.append(sNumber.substring(0, find));
                    thapPhan = sNumber.substring(find);
                    showNumber.reverse();
                    count = 0;
                    for (i = 3; i < showNumber.length(); i += 3) {
                        if (i + count <= (showNumber.length() - 1)) {
                            showNumber.insert((i + count), ",");
                        }
                        count += 1;
                    }
                    tvShow.setText(" " + showNumber.reverse() + thapPhan);
                } else
                    tvShow.setText(kq + "");
                break;

            default:
                break;
        }

    }

    public String btnDel(String number) {
        int lenght = number.length();
        String match = number.substring(0, lenght - 1);
        return match;
    }


}