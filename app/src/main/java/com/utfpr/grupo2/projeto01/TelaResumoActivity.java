package com.example.matheuszilio.aula_1004_widgets;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.ScrollView;
import android.widget.Toast;

public class TelaResumoActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela_resumo);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollViewResumo);
        Button button = (Button) findViewById(R.id.btnInfoPresenca);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(TelaResumoActivity.this, TelaPresencaActivity.class);
                startActivity(it);
            }
        });
    }

    public void mostrarMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_tela_resumo);
        popupMenu.show();
        //ImageButton imageButton = (ImageButton) findViewById(R.id.menu);
        //Toast("funciona");
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.editar:
                Toast("Editar");
                return true;
            case R.id.excluir:
                Toast("Excluir");
                return true;
            default:
                return false;
        }
    }

    private void Toast(String msg){
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
