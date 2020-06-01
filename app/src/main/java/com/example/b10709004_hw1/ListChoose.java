package com.example.b10709004_hw1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListChoose extends AppCompatActivity {

    private Button goback;
    private Button goclear;
    private TextView txtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        goback=(Button)findViewById(R.id.go_back);
        goback.setOnClickListener(btnback);
        goclear=(Button)findViewById(R.id.go_backclean);
        goclear.setOnClickListener(btnclear);
        txtv=(TextView)findViewById(R.id.fruit_tview);
        Intent intentThatStartedThisActivity =this.getIntent();
        Bundle bundle = intentThatStartedThisActivity.getExtras();
        int number = bundle.getInt("Counting");
        txtv.setText("你剛剛選了"+number+"個項目");
    }


    private Button.OnClickListener btnback=new Button.OnClickListener(){
        public void onClick(View v)
        {
            finish();
        }
    };


    private Button.OnClickListener btnclear=new Button.OnClickListener(){
        public void onClick(View v) {
            Intent intent = new Intent(ListChoose.this,MainActivity.class);
            startActivity(intent);
        }
    };
}

