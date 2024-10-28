package com.vriza.ulanganganjil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailProduk extends AppCompatActivity {

    TextView product, price, total_ril;
    EditText quantity;
    Button beliButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail_produk);

        product = findViewById(R.id.product_name);
        price = findViewById(R.id.product_price);
        total_ril = findViewById(R.id.total_ril);
        quantity = findViewById(R.id.quantity_input);
        beliButton = findViewById(R.id.beli_button);

        product.setText(getIntent().getStringExtra("DataProduk1"));
        price.setText("Rp. " + getIntent().getStringExtra("DataProduk2"));

        ImageView DataGambar = findViewById(R.id.product_image);
        int imageSrc = getIntent().getIntExtra("imageSrc", 0);

        if (imageSrc != 0) {
            DataGambar.setImageResource(imageSrc);
        }

        quantity.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT) {
                hitungTotal();
            }
            return false;
        });


        beliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendData = new Intent(DetailProduk.this, NotaBayar.class);
                sendData.putExtra("Data1", product.getText().toString());
                sendData.putExtra("Data2", price.getText().toString());
                sendData.putExtra("Data3", quantity.getText().toString());
                sendData.putExtra("Data4", total_ril.getText().toString());
                sendData.putExtra("Data5", imageSrc);

                startActivity(sendData);
                finish();
            }
        });
    }

    private void hitungTotal() {
        String hargaText = price.getText().toString().replace("Rp. ", "").trim();
        int harga = Integer.parseInt(hargaText);
        int jumlah = Integer.parseInt(quantity.getText().toString());

        if (jumlah == 0) {
            jumlah = 1;
            quantity.setText(String.valueOf(jumlah));
        }

        int total = harga * jumlah;

        total_ril.setText("Rp. " + String.valueOf(total));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}