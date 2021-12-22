package com.example.dialapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class DetailsFragment extends Fragment {

    private ImageView iv;
    private TextView tvName;
    private TextView tvNumber;
    private ImageButton btn;

    private int image;
    private String name;
    private String number;


    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);

        setViews(view);

        name = DetailsFragmentArgs.fromBundle(getArguments()).getName();
        number = DetailsFragmentArgs.fromBundle(getArguments()).getNumber();
        image = DetailsFragmentArgs.fromBundle(getArguments()).getImage();


        iv.setImageResource(image);
        tvName.setText(name);
        tvNumber.setText(number);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + number));
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        return view;
    }

    private void setViews(View view) {
        iv = view.findViewById(R.id.details_iv);
        tvName = view.findViewById(R.id.details_tv_name);
        tvNumber = view.findViewById(R.id.details_tv_number);
        btn = view.findViewById(R.id.details_btn_call);
    }
}