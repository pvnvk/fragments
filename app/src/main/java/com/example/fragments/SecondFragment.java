package com.example.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment implements View.OnClickListener {

    LinearLayout layout;
    Button mGoBt;
    EditText mEnterEt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mGoBt =(Button)getView().findViewById(R.id.go_bt);
        mEnterEt =(EditText)getView().findViewById(R.id.personName);

        mGoBt.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        LayoutInflater vi=(LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=vi.inflate(R.layout.dynamic_view,null);

        TextView textView=(TextView)view.findViewById(R.id.person);
        textView.setText(mEnterEt.getText().toString());

        ViewGroup insertPoint=(ViewGroup) getView().findViewById(R.id.insert);
        insertPoint.addView(view);
    }
}
