package com.vriza.ulanganganjil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    CardView card1, card2, card3, card4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        card1 = findViewById(R.id.beras_putih_container);
        card2 = findViewById(R.id.beras_merah_container);
        card3 = findViewById(R.id.beras_hitam_container);
        card4 = findViewById(R.id.beras_coklat_container);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent(MainActivity.this, DetailProduk.class);
                sendData.putExtra("DataProduk1", "Beras Putih");
                sendData.putExtra("DataProduk2", "13000");
                sendData.putExtra("imageSrc", R.drawable.beras_putih);
                startActivity(sendData);
                finish();
            }
        });


        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent(MainActivity.this, DetailProduk.class);
                sendData.putExtra("DataProduk1", "Beras Merah");
                sendData.putExtra("DataProduk2", "20000");
                sendData.putExtra("imageSrc", R.drawable.beras_merah);
                startActivity(sendData);
                finish();
            }
        });

        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent(MainActivity.this, DetailProduk.class);
                sendData.putExtra("DataProduk1", "Beras Hitam");
                sendData.putExtra("DataProduk2", "15000");
                sendData.putExtra("imageSrc", R.drawable.beras_hitam);
                startActivity(sendData);
                finish();
            }
        });

        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent(MainActivity.this, DetailProduk.class);
                sendData.putExtra("DataProduk1", "Beras Coklat");
                sendData.putExtra("DataProduk2", "20000");
                sendData.putExtra("imageSrc", R.drawable.beras_coklat);
                startActivity(sendData);
                finish();
            }
        });
    }
}