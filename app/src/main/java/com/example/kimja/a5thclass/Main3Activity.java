package com.example.kimja.a5thclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    ListView listView;
    EditText editText;
    Button button;
    ArrayList<String> data = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setListview();
        button = (Button)findViewById(R.id.button) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void onClick(View v){
        data.add(editText.getText().toString());
        adapter.notifyDataSetChanged();
    }
    public void setListview(){
        listView = (ListView)findViewById(R.id.list1);
        editText = (EditText)findViewById(R.id.editText1) ;
        //데이터 만들기
        data.add("사과");
        data.add("포도");
        data.add("복숭아");

        //어댑터 만들기 (데이터와 화면을 연결)
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {  //길게누를시 삭제
                data.remove(position);  //삭제
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}
