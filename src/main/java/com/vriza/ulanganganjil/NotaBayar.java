package com.vriza.ulanganganjil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NotaBayar extends AppCompatActivity {

    TextView getdata1, getdata2, getdata3, getdata4;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nota_bayar);

        getdata1=findViewById(R.id.TvNamaProduk);
        getdata2=findViewById(R.id.TvHarga);
        getdata3=findViewById(R.id.TvJumlah);
        getdata4=findViewById(R.id.total_price);
        confirm = findViewById(R.id.confirm_button);
        getdata1.setText(getIntent().getStringExtra("Data1"));
        getdata2.setText(getIntent().getStringExtra("Data2"));
        getdata3.setText(getIntent().getStringExtra("Data3"));
        getdata4.setText(getIntent().getStringExtra("Data4"));

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotaBayar.this, Thankyou.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }

}