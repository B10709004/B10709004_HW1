package com.example.b10709004_hw1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MyAdapter mAdapter;
    private RecyclerView mNumbersList;
    private Button mButton;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<LikeFruit> mData = new ArrayList<>();
        //建立項目
        for(int i=0;i<100;i++)
        {
            LikeFruit data=new LikeFruit("項目"+i);
            mData.add(data);
        }
        mNumbersList = (RecyclerView) findViewById(R.id.ry_view);
        mAdapter = new MyAdapter(mData);
        mNumbersList.setAdapter(mAdapter);
        mNumbersList.setLayoutManager(new LinearLayoutManager(this));
        mButton=(Button)findViewById(R.id.bt_sure);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter = mAdapter.getCounter();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,ListChoose.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Counting",counter);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
