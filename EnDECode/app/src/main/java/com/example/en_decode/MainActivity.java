package com.example.en_decode;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialisation
        Button bt=findViewById(R.id.b2);

        EditText plain=findViewById(R.id.plainText);

        TextView cipher=findViewById(R.id.cipherText),
                 com=findViewById(R.id.compressed);

        Spinner level=findViewById(R.id.choose);

        String[] options=new String[]{"Easy","Medium","High"};

        level.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,options));

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cipherText;

                switch (level.getSelectedItem().toString()) {

                    case "Easy":
                        cipherText=EncryptAlgo.ceaserCipher(plain.getText().toString());
                        cipher.setText(cipherText);
                        com.setText(HuffmanCode.shorten(cipherText));
                        break;
                    case "Medium":
                        break;
                    case "High":
                        break;
                    default:
                        //pop up to inform that option is not selected
                        Toast.makeText(new MainActivity(), "please select any one options above", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}