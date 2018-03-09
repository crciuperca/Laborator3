package com.example.student.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class PhoneDialerActivity extends AppCompatActivity {

    private EditText textField;
    private Button button;
    private ImageButton call;
    private ImageButton deny;
    private ImageButton backspace;

    private ButtonListener buttonListener = new ButtonListener();
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            button = (Button)view;
            textField.setText(textField.getText().toString() + button.getText());
        }
    }

    private CallButtonListener callButtonListener = new CallButtonListener();
    class CallButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(
                        PhoneDialerActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);
            } else {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + textField.getText().toString()));
                startActivity(intent);
            }
        }
    }

    private DenyButtonListener denyButtonListener = new DenyButtonListener();
    class DenyButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            finish();
        }
    }
    private BackspaceButtonListener backspaceButtonListener = new BackspaceButtonListener();
    class BackspaceButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            if(textField.getText().length() != 0) {
                textField.setText(textField.getText().toString().substring(0, textField.getText().toString().length()-1));
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button3);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button4);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button5);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button7);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button8);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button9);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button10);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button11);
        button.setOnClickListener(buttonListener);
        button = (Button) findViewById(R.id.button12);
        button.setOnClickListener(buttonListener);

        textField = (EditText) findViewById(R.id.editText);
        textField.setText("");
        textField.setFocusable(false);
        call = (ImageButton) findViewById(R.id.imageButton1);
        call.setOnClickListener(callButtonListener);
        deny = (ImageButton) findViewById(R.id.imageButton2);
        deny.setOnClickListener(denyButtonListener);
        backspace = (ImageButton) findViewById(R.id.imageButton3);
        backspace.setOnClickListener(backspaceButtonListener);

    }
}
