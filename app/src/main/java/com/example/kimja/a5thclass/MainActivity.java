package com.example.kimja.a5thclass;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button b1;
    EditText editText;
    static final int _REQUEST_MSG_CODE =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.tvmessage);

//        textView = (TextView)findViewById(R.id.textView) ;
//        b1 = (Button)findViewById(R.id.b1) ;
//        Intent intent = new Intent(this, Main2Activity.class);
//        intent.putExtra("aaaa", textView.getText().toString());
//        startActivity(intent);
//        b1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//            }
//        });

    }
    public void onClick(View v){
        if(v.getId() == R.id.b2){  // 연락처 불러오기 창
            Intent intent = new Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult( intent , 0);
        }
        else if(v.getId() == R.id.b3){  // 학생정보 불러오기
            Intent intent = new Intent(this,Main2Activity.class);
            student s1 = new student("홍길동", "2017032323",20,1);
            intent .putExtra("student1",s1);
            startActivityForResult(intent,0);

        }
        else if(v.getId() == R.id.b4){  // 전화걸기
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:/01088995697"));
            startActivity(intent);


        }
        else {  //버튼1 누르면 다른 액티비티의
            Intent intent = new Intent(this,Main2Activity.class);
            intent.putExtra("msg",textView.getText().toString());

            intent.putExtra("num1",0);

            startActivityForResult(intent,_REQUEST_MSG_CODE);
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == _REQUEST_MSG_CODE){
            if(resultCode == RESULT_OK){
                String msg = data.getStringExtra("remakemsg");
                textView.setText(msg);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
