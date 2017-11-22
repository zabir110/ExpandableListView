package com.example.user.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    //This list for parent....
    List<String>list;
    //map for child which 1st element indicates the parent 2nd element for childs
    Map<String,List<String> >topics;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filldata();
        //It is not possible to use default setAdapter() so we need to use a class
        //because  when we sent a setAdapter(new ExpandableListAdapter)-->obj but it is a
        // interface so need to implements it another class but BaseExpantableListAdapter class alredy implement it
        // So we just need to extend it
        expandableListView =(ExpandableListView)findViewById(R.id.expandable);
        listAdapter=new ExpantableListAdapter(this,list,topics);
        expandableListView.setAdapter(listAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this,list.get(groupPosition)+":"+topics.get(list.get(groupPosition)).get(childPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });


    }
    public  void filldata()
    {
        list=new ArrayList<>();
        topics=new HashMap<>();

        list.add("Java");
        list.add("C++");
        list.add("C");
        list.add("Python");

        List<String> java=new ArrayList<>();
        java.add("Object Oriented concept");
        java.add("Thread");
        java.add("Data base");

        List<String> cplusplus =new ArrayList<>();
        cplusplus.add("Object Oriented concept");
        cplusplus.add("Polymarphism");
        cplusplus.add("Encapsulation");

        List<String> c =new ArrayList<>();
        c.add("Object Oriented concept");
        c.add("Structure");
        c.add("Enam");

        List<String> phython =new ArrayList<>();
        phython.add("Algorithm");
        phython.add("Data structure");
        phython.add("Encapsulation");

        topics.put("Java",java);
        topics.put("C++",cplusplus);
        topics.put("C",c);
        topics.put("Python",phython);

    }
}
