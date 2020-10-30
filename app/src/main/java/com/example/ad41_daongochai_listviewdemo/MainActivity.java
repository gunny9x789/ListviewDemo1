package com.example.ad41_daongochai_listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;
    private TextView tv2;
    private ListView lvdemo;

    private List<Contact> contactList;
    private Adapter adapterContact;

    private Contact contact1;
    private Contact contact2;
    private Contact contact3;
    private Contact contact4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvdemo = findViewById(R.id.lv);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        contactList = new ArrayList<>();

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1.setBackgroundResource(R.drawable.tv_off);
                tv2.setBackgroundResource(R.drawable.et);
                Intent intent = new Intent(MainActivity.this, Bai2.class);
                startActivity(intent);
            }
        });

        contact1 = new Contact("14/11/2018", "VFMVFB", "600,000,123", "600,000,123", "0.00%");
        contact2 = new Contact("18/10/2018", "VFMVF1", "45,169,614", "44,699,147", "-1.04%");
        contact3 = new Contact("05/11/2018", "VFMBN5", "19,999,951", "21,065,916", "5.33%");
        contact4 = new Contact("6/11/2018", "SDRGV3", "10,000,163", "10,533,156", "5.33%");

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);

        do {
            contactList.add(new Contact("", "", "", "", ""));
        } while (contactList.size() < 10);

        adapterContact = new Adapter(contactList);
        lvdemo.setAdapter(adapterContact);
    }
}