package com.example.dialapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {
    private ImageView iv;
    private TextView tvName;
    private TextView tvNumber;
    private ImageButton btn;

    private int image;
    private String name;
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        setViews();

        Intent intent = getIntent();
        image = intent.getIntExtra("image", 0);
        name = intent.getStringExtra("name");
        number = intent.getStringExtra("number");

        iv.setImageResource(image);
        tvName.setText(name);
        tvNumber.setText(number);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(DetailsActivity.this,
                        new String[]{Manifest.permission.CALL_PHONE},
                        1);
            }
        });
    }

    private void setViews() {
        iv = findViewById(R.id.details_iv);
        tvName = findViewById(R.id.details_tv_name);
        tvNumber = findViewById(R.id.details_tv_number);
        btn = findViewById(R.id.details_btn_call);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:" + number));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            ActivityCompat.requestPermissions(DetailsActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    1);
        }

    }
}
