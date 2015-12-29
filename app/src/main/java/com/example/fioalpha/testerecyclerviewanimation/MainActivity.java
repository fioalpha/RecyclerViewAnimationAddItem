package com.example.fioalpha.testerecyclerviewanimation;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Pessoas p1 = new Pessoas("Wesley");
    Pessoas p2 = new Pessoas("Wesley");
    Pessoas p3 = new Pessoas("Wesley");
    Pessoas p4 = new Pessoas("Wesley");
    Pessoas p5 = new Pessoas("Wesley");
    Pessoas p6 = new Pessoas("Wesley");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);

        List<Pessoas> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        final MyAdapter adapter = new MyAdapter(lista);

        recyclerView.setAdapter(adapter);

        final TextView texto = (TextView)findViewById(R.id.input);
        texto.getText();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(texto.getText().length() > 0){
                    Toast.makeText(MainActivity.this, "texto", Toast.LENGTH_SHORT).show();
                    adapter.add(new Pessoas(texto.getText()+""));
                    adapter.notifyDataSetChanged();
                    recyclerView.scrollToPosition(adapter.getItemCount()-1);
                }
            }

        });
    }

    public class Pessoas{
        public String nome;

        public Pessoas(String nome){
            this.nome = nome;
        }
    }
}
