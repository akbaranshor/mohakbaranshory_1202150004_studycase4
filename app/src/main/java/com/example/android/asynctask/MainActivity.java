package com.example.android.asynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void cariGbr(View view) {
        // Pindah ke Pencari Gambar
        startActivity(new Intent(this, PencariGambarActivity.class));
    }

    public void listMhs(View view) {
        // Pindah ke List Mahasiswa
        startActivity(new Intent(this, ListMahasiswaActivity.class));
    }
}
