package com.hfad.starbuzz;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class BeverageActivity extends AppCompatActivity {
    static final String EXTRA_BEVERAGEID = "83nrow";

    private Button returnButton;
    private ImageView imageView;
    private TextView nameView;
    private TextView descriptionView;

    private Beverage beverage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beverage);
        Intent receivedIntent = getIntent();
        int beverageid = (int)receivedIntent.getLongExtra(EXTRA_BEVERAGEID, 0);
        beverage = Beverage.beverages[beverageid];

        wireWidgets();
        populateViews();
        setListeners();
    }


    private void wireWidgets() {
        returnButton = findViewById(R.id.button_beverage_back);
        imageView = findViewById(R.id.imageView_beverage_image);
        nameView = findViewById(R.id.textView_beverage_name);
        descriptionView = findViewById(R.id.textView_beverage_description);
    }

    private void populateViews() {
        int imageId = beverage.getImageResourceId();
        String name = beverage.getName();
        String description = beverage.getDescription();
        imageView.setImageResource(imageId);
        nameView.setText(name);
        descriptionView.setText(description);
    }

    private void setListeners() {
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent(BeverageActivity.this, BeverageCategoryActivity.class);
                startActivity(returnIntent);
            }
        });
    }
}
