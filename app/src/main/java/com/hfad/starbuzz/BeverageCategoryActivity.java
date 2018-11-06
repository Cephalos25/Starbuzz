package com.hfad.starbuzz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class BeverageCategoryActivity extends AppCompatActivity {
    private Button returnButton;
    private ListView beverageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage_category);

        wireWidgets();
        populateViews();
        setListeners();
    }

    private void wireWidgets() {
        returnButton = findViewById(R.id.button_beveragecategory_back);
        beverageList = findViewById(R.id.listView_beveragecategory_beverages);
    }

    private void populateViews() {
        ArrayAdapter<Beverage> beverageListAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, Beverage.beverages);
        beverageList.setAdapter(beverageListAdapter);
    }

    private void setListeners() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent(BeverageCategoryActivity.this, TopLevelActivity.class);
                startActivity(returnIntent);
            }
        });
        beverageList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent getBeverageIntent = new Intent(BeverageCategoryActivity.this, BeverageActivity.class);
                getBeverageIntent.putExtra(BeverageActivity.EXTRA_BEVERAGEID, id);
                startActivity(getBeverageIntent);
            }
        });
    }
}
