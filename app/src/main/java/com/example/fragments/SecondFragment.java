package com.example.fragments;

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

import java.util.ArrayList;

public class SecondFragment extends Fragment implements View.OnClickListener {

    private LinearLayout containerLayout;
    private Button mGoBt;
    private EditText mEnterEt;
    private ArrayList<String> textList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.second_fragment,container,false);
        // fragment_second
        initList();
        return view;
    }

    private void initList() {
        /*textList.add("dinesh");
        textList.add("praveen");*/
        for (int i = 0; i < 50; i++) {
            textList.add("Position " + i);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUi();

    }

    private void initUi() {
        mGoBt =(Button)getView().findViewById(R.id.go_bt);
        mEnterEt =(EditText)getView().findViewById(R.id.personName);
        containerLayout=getView().findViewById(R.id.insert);
        mGoBt.setOnClickListener(this);
        addListToUi();
    }

    private void addListToUi() {
        for (int index = 0; index< textList.size(); index++) {
            addTextView(textList.get(index));
        }
    }

    @Override
    public void onClick(View view) {
//Todo: Check view clicked
        switch (view.getId()) {
            case R.id.go_bt :
                handleGoBtnClick();
            break;
        }
    }

    private void handleGoBtnClick() {
        addTextView(mEnterEt.getText().toString());
    }

    private void addTextView(String text) {
        View view=getLayoutInflater().inflate(R.layout.dynamic_view,null);
        TextView person=(TextView)view.findViewById(R.id.person);
        person.setText(text);
        containerLayout.addView(view);
    }
}
