package com.guliash.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DescriptionActivity extends AppCompatActivity {

    private TextView mDescText, mNameText, mExamplesText;

    private Topic mTopic;

    public static final String TOPIC = "topic";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.back_button);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Bundle args = (savedInstanceState != null ? savedInstanceState : getIntent().getExtras());

        mTopic = args.getParcelable(TOPIC);

        mNameText = (TextView)findViewById(R.id.name);
        mDescText = (TextView)findViewById(R.id.desc);
        mExamplesText = (TextView) findViewById(R.id.examples);

        mNameText.setText(mTopic.name);
        mDescText.setText(mTopic.description);
        mExamplesText.setText(TextUtils.join("\n\n", transformExamples()));
    }

    private List<String> transformExamples() {
        List<String> examples = new ArrayList<>();
        for(String example : mTopic.examples) {
            examples.add("●  " + example);
        }
        return examples;
    }

}
