package com.example.a10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    EditText editText;
    TextView textView;
    ListView listView;
    ArrayList<String> lista;
    ArrayAdapter<String> stringArrayAdapter;
    String teksti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.button1 = findViewById(R.id.nappiADD);
        this.button2 = findViewById(R.id.nappiCLEAR);
        this.button3 = findViewById(R.id.nappiFETCH);
        this.editText = findViewById(R.id.editText1);
        this.textView = findViewById(R.id.textView1);
        this.listView = findViewById(R.id.listView1);


        lista = new ArrayList<>();
        stringArrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1);
        listView.setAdapter(stringArrayAdapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teksti = editText.getText().toString();
                lista.add(teksti);
                StringBuilder stringBuilder = new StringBuilder();

                for (String s : lista){
                    stringBuilder.append(s + "," +"\n");
                }
                textView.setText(stringBuilder.toString());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.clear();
                textView.setText("");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ImageRequest request = new ImageRequest("https://loremflickr.com/320/240/" + teksti, new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        //Tänne jotain mutta mitä?????
                    }
                }, 320, 240, ImageView.ScaleType.FIT_CENTER, Bitmap.Config.ALPHA_8, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,"Jotain meni pieleen",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}
