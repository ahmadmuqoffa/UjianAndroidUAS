package com.example.ujianandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edNamaDepan = (EditText) findViewById(R.id.edNamaDepan);
        EditText edNamaBelakang = (EditText) findViewById(R.id.edNamaBelakang);
        EditText edUmur = (EditText) findViewById(R.id.edUmur);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String isian_nama_depan = edNamaDepan.getText().toString();
                String isian_nama_belakang = edNamaBelakang.getText().toString();
                String isian_umur = edUmur.getText().toString();

                if(isian_nama_depan.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Isian masih kosong", Toast.LENGTH_SHORT).show();
                }else{
                    int umur = Integer.parseInt(isian_umur);

                    String status;
                    if (umur < 10) {
                        status = "Anak";
                    } else if (umur < 20) {
                        status = "Remaja";
                    } else if (umur < 40) {
                        status = "Dewasa";
                    } else {
                        status = "Tua";
                    }

                    String nama_lengkap = isian_nama_depan.concat(" ").concat(isian_nama_belakang);
                    daftar_nama.clear();
                    for(int i = 1; i <= umur; i++){
                        daftar_nama.add(i + ". " + nama_lengkap + ", Status : " + status);
                    }
                    edNamaDepan.setText("");
                    edNamaBelakang.setText("");
                    edUmur.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }
        });
    }
}