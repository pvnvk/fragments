package com.example.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FirstFragment extends Fragment {

    TextView mMobileTv;
    TextView mEmailTv;
    ImageView mPhotoIv;
    Button mCallBt;
    Button mMailBt;
    Button mGotoBt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.first_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMobileTv = (TextView)getView().findViewById(R.id.mobile_tv);
        mEmailTv =(TextView)getView().findViewById(R.id.email_tv);
        mPhotoIv =(ImageView)getView().findViewById(R.id.photo_iv);
        mCallBt =(Button)getView().findViewById(R.id.call_bt);
        mMailBt =(Button)getView().findViewById(R.id.mail_bt);
        mGotoBt =(Button)getView().findViewById(R.id.goto_bt);

        mMobileTv.setText("123456789");
        mEmailTv.setText("abcd@gmail.com");
        mPhotoIv.setImageResource(R.drawable.app);

        mCallBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number= mMobileTv.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });

        mMailBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to= mEmailTv.getText().toString();
                String subject="for checking";
                String message="hi,how are you?";
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);
                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        mGotoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();

                //fragment
                SecondFragment secondFragment=new SecondFragment();
                transaction.replace(R.id.pageContainer,secondFragment);


                transaction.commit();
            }
        });

    }
}
