package com.hfad.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class TopLevelActivity extends AppCompatActivity {
    private ListView optionsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_level);

        wireWidgets();
        setListeners();
    }

    private void wireWidgets() {
        optionsView = findViewById(R.id.listView_toplevel_options);
    }

    private void setListeners() {
        optionsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Class<?> targetActivity = null;
                Boolean hasTarget = false;
                switch (position) {
                    case 0:
                        targetActivity = BeverageCategoryActivity.class;
                        hasTarget = true;
                }
                if(hasTarget) {
                    Intent getListIntent = new Intent(TopLevelActivity.this,
                            targetActivity);
                    startActivity(getListIntent);
                }
            }
        });
    }
}
