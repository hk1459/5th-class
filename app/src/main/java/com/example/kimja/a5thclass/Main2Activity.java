package com.example.kimja.a5thclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView = (TextView)findViewById(R.id.textView) ;
        editText = (EditText)findViewById(R.id.editText) ;
//        Intent intent = getIntent();
//        String aaaa = intent.getStringExtra("aaaa");
//        textView.setText(aaaa);

        Intent intent = getIntent();
        String msgas = intent.getStringExtra("msg");
        int num1 = intent.getIntExtra("num1",0);

        student sss = intent.getParcelableExtra("student1");
        String str = sss.toString();

        editText.setText(str);
    }
    public  void onClick(View v){ //정보 보내주기 및 종료
        Intent intent = new Intent();
        intent.putExtra("remakemsg",editText.getText().toString());
        setResult(RESULT_OK,intent);

        finish();
    }
}
