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

public class FirstFragment extends Fragment {

    TextView MmobileTv;
    TextView MemailTv;
    ImageView Mphoto;
    Button McallBt;
    Button MmailBt;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.first_fragment,container,false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        MmobileTv = (TextView)getView().findViewById(R.id.MmobileTv);
        MemailTv=(TextView)getView().findViewById(R.id.MemailTv);
        Mphoto=(ImageView)getView().findViewById(R.id.Mphoto);
        McallBt=(Button)getView().findViewById(R.id.McallBt);
        MmailBt=(Button)getView().findViewById(R.id.MmailBt);

        MmobileTv.setText("123456789");
        MemailTv.setText("abcd@gmail.com");
        Mphoto.setImageResource(R.drawable.app);

        McallBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=MmobileTv.getText().toString();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));
                startActivity(callIntent);
            }
        });

        MmailBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String to=MemailTv.getText().toString();
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

    }
}
