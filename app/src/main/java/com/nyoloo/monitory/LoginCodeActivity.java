package com.nyoloo.monitory;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginCodeActivity extends AppCompatActivity {

    @BindView(R.id.txtCheckCodeAgree)
    TextView txtAgree;
    @BindView(R.id.edtInputCode)
    EditText edtInputCode;
    @BindString(R.string.check_code_warning_empty_title)
    String emptyTitle;
    @BindString(R.string.check_code_warning_empty_desc)
    String emptyMessage;
    @BindString(R.string.warning_title)
    String warningTitle;

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_code);
        ButterKnife.bind(this);

        // Convert string dengan tag html </b> ke bentuk html kemudian di set ke textAgree
        txtAgree.setText(Html.fromHtml(getString(R.string.check_code_text_agreement)));


    }
    @OnClick(R.id.btnCheckCode)
    public void masuk(View view) {
        //Menampung nilai string dari edittext
        String code = edtInputCode.getText().toString();

        //validasi jika inputan kode masih kosong
        if (isStringEmpty(code)) {
            //menampilkan dialog pesan warning
            showWarningMessage();
        } else {
            //Pindah halaman
            startActivity(new Intent(this, BiodataActivity.class));
        }
    }
    public static boolean isStringEmpty(String str) {
        return "".equals(str);
    }

    public void showWarningMessage(){
        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_warning_dialog);
        dialog.setTitle(warningTitle);

        // set the custom dialog components - text, image and button
        TextView textTitle = dialog.findViewById(R.id.txtWarningDialogTitle);
        TextView text = dialog.findViewById(R.id.txtWarningDialogDesc);
        Button dialogButton = dialog.findViewById(R.id.btnWarningDialogOk);

        textTitle.setText(emptyTitle);
        text.setText(emptyMessage);

        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(v -> dialog.dismiss());

        dialog.show();
    }
}