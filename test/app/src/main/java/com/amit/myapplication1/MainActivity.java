package com.amit.myapplication1;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telecom.Call;
import android.view.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private List<MessageModel> msgList;
    private MessageListAdapter messageListAdapter;
    private String  sample = "Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.";
    private String  sample2 = "Lorem Ipsum has been the industry";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar);
        View view =getSupportActionBar().getCustomView();
        Toolbar toolbar=(Toolbar)view.getParent();
        toolbar.setContentInsetsAbsolute(0,0);
        //#E7E7E9
        recyclerView = findViewById(R.id.recyclerView);
        // Set Layout Manager
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        // Limiting the size
        recyclerView.setHasFixedSize(true);
        // Initialize list items
        init();
    }

    private  void init(){
        msgList =new ArrayList<>();
        // Initiating Adapter
        messageListAdapter =new MessageListAdapter(MainActivity.this);
        recyclerView.setAdapter(messageListAdapter);

        msgList.add(new MessageModel(sample,"04:30 PM","Deepak Jain",true));
        msgList.add(new MessageModel(sample,"04:30 PM","Amit Saha",false));
        msgList.add(new MessageModel(sample,"04:30 PM","Seemab Afreen",true));
        msgList.add(new MessageModel(sample,"04:30 PM","Piyas De",false));

        // Set items to adapter
        messageListAdapter.setMessages(msgList);
        messageListAdapter.notifyDataSetChanged();
    }
}
