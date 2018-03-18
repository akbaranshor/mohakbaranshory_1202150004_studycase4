package com.example.android.asynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PencariGambarActivity extends AppCompatActivity {
    // Deklarasi variabek
    ImageView imageView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencari_gambar);
        // Inisiasi ImageView dan EditText
        imageView = findViewById(R.id.gambar);
        editText = findViewById(R.id.url_edit);
    }

    // Method untuk meload gambar
    private void loadImage(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {}
            @Override
            public void onError() {}
        });
    }

    // Tombol untuk mencari gambar
    public void cari(View view) {
        loadImage(editText.getText().toString());
    }
}