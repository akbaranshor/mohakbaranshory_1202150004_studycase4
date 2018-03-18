package com.example.android.asynctask;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.transform.Result;

public class ListMahasiswaActivity extends AppCompatActivity {
    // Deklarasi variabel
    ListView listView;
    String[] namaMahasiswa = {"Abay", "Ucok", "Kuco", "Pandji", "Tepong",
            "Bibi", "Kuda", "Abdul", "Sinta", "Jojo"};
    Progress progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_mahasiswa);
        // Inisialisasi ListView dan set adapter
        listView = findViewById(R.id.list_view);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));
    }

    // Memulai AsyncTask
    public void mulaiAsync(View view) {
        // Instansiasi AsyncTask
        progress = new Progress();
        progress.execute();
    }

    // Inner Class AsyncTask
    class Progress extends AsyncTask<Void, String, String> {
        // Deklarasi variabel
        ProgressDialog progressDialog;
        ArrayAdapter<String> adapter;


        @Override
        protected String doInBackground(Void... voids) {

            int count = 0;
            // Foreach untuk melakukan perulangan array
            for (String nama : namaMahasiswa) {
                publishProgress(nama);
                count++;
                // Menaruh pesan, yaitu persentase dari load array
                progressDialog.setMessage(Integer.toString(count * 10) + "%");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Success";
        }

        @Override
        protected void onPostExecute(String aVoid) {
            // Ketika AsyncTask telah berakhir, ProgressDialog menghilang
            progressDialog.dismiss();
        }

        @Override
        protected void onProgressUpdate(String... values) {
            // Menambahkan string pada ArrayList
            adapter.add(values[0]);
        }

        @Override
        protected void onPreExecute() {
            // Get Adapter
            adapter = (ArrayAdapter<String>) listView.getAdapter();
            // Instansiasi ProgressDialog
            progressDialog = new ProgressDialog(ListMahasiswaActivity.this);
            progressDialog.setTitle("Loading Data");
            // Penerapan tombol Cancel
            progressDialog.setCancelable(false);
            progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel Process", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    progress.cancel(true);
                    dialog.dismiss();
                }
            });
            progressDialog.show();
        }
    }
}