package com.example.root.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class enkripsiaes extends AppCompatActivity{
    Button btn;
    EditText frmkunci,frmpesan,frmhasilenkripsi;
    String kunci,pesan,encrypted;
    Aes ae=new Aes();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_enkripsi);

        btn=(Button)findViewById(R.id.enkripsipesan);
        frmkunci=(EditText)findViewById(R.id.formkunci);
        frmpesan=(EditText)findViewById(R.id.formpesan);
        frmhasilenkripsi=(EditText)findViewById(R.id.formhasilenkripsi);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kunci=frmkunci.getText().toString();
                pesan=frmpesan.getText().toString();
                try {
                    encrypted=ae.encText(pesan,kunci.getBytes(),ae.ivk);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                    frmhasilenkripsi.setText(encrypted);
            }
        });

    }
}
