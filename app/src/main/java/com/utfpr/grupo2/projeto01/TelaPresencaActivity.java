package com.example.matheuszilio.aula_1004_widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.Toast;

public class TelaPresencaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_tela_presenca);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewPresenca);
    }

}
