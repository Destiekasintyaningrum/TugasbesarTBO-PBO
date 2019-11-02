package com.example.root.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class dekripsiaes extends AppCompatActivity{

    Button btn;
    EditText frmkunci,frmpesan,frmhasildekripsi;
    String kunci,pesanterenkripsi,decrypted;
    Aes ae=new Aes();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tampilan_dekripsi);
        btn=(Button)findViewById(R.id.dekripsipesan);
        frmkunci=(EditText)findViewById(R.id.formkuncidek);
        frmpesan=(EditText)findViewById(R.id.formpesanterenkripsi);
        frmhasildekripsi=(EditText)findViewById(R.id.formhasildekripsi);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kunci=frmkunci.getText().toString();
                pesanterenkripsi=frmpesan.getText().toString();
                try {
                    decrypted=ae.decText(pesanterenkripsi,kunci.getBytes(),ae.ivk);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                frmhasildekripsi.setText(decrypted);
            }
        });

    }
}
