package com.nyoloo.monitory;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.nyoloo.monitory.DoneActivity.ID_EXTRA_MSG_EXIT;
// Tanggal Pengerjaan   : 26-April-2022
// Nama                 : Nur Fauzan Halim
// NIM                  : 10119226
// Kelas                : IF-6
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        if (getIntent().getBooleanExtra(ID_EXTRA_MSG_EXIT, false)) {
            finish();
        }
    }


    @OnClick(R.id.btnWalkthroughStart)
    void mulai() {
        Intent intent = new Intent(this, LoginCodeActivity.class);
        startActivity(intent);
    }
}