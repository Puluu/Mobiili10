package com.example.a10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapteri extends ArrayAdapter<String> {
    private Context context;
    ArrayList<String> datalista;

    public ArrayAdapteri(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.datalista = objects;

        }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.activity_main, parent, false);
        LinearLayout linearLayout = (LinearLayout)v;
        TextView textView = v.findViewById(R.id.textView1);
        EditText editText = v.findViewById(R.id.editText1);
        textView.setText(editText.getText().toString().format(datalista.get(position)));

        return linearLayout;
    }
}
