package com.example.ad41_daongochai_listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    List<Contact> contactList;

    public Adapter(List<Contact> contactList) {
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_contact,parent,false);

        TextView tv_date = view.findViewById(R.id.tv_date);
        TextView tv_maccq = view.findViewById(R.id.tv_ma);
        TextView tv_gtmua = view.findViewById(R.id.tv_gtmua);
        TextView tv_gttt = view.findViewById(R.id.tv_gttt);
        TextView tv_ln = view.findViewById(R.id.tv_ln);

        Contact contact = contactList.get(position);
        tv_date.setText(contact.getDateGD());
        tv_maccq.setText(contact.getMaCCQ());
        tv_gtmua.setText(contact.getGtMua());
        tv_gttt.setText(contact.getGttt());
        tv_ln.setText(contact.getLn());

        return view;
    }
}
