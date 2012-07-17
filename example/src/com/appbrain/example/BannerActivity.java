package com.appbrain.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.appbrain.AppBrainBanner;

public class BannerActivity extends Activity {
    private static final String[] COLOR_NAMES = {
        "0, Dark and blue",
        "1, Light and blue",
        "2, Light design",
        "3, Dark and blue",
        "4, Blue and orange",
        "5, White and green",
        "6, Candy",
        "7, Sahara",
        "8, Red",
        "9, Green",
        "10, Blue",
        "11, Purple",
        "12, Light grey",
        "13: Light b&w",
    };
    private static final String[] DESIGN_NAMES = {
        "Simple 1",
        "Simple 2",
        "Arrows",
        "Ellipse"
    };
    
    private static final int TITLE_COUNT = 4, BUTTON_TEXT_COUNT = 3;
    
    private Spinner title, button, design, color;
    private FrameLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("AppLift banner playground");
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        
        title = new Spinner(this);
        String[] titles = new String[TITLE_COUNT];
        for (int i = 0; i < titles.length; i++) {
            titles[i] = "Title " + i;
        }
        title.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, titles));
        
        button = new Spinner(this);
        String[] buttons = new String[BUTTON_TEXT_COUNT];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = "Button " + i;
        }        
        button.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, buttons));
        
        design = new Spinner(this);
        design.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, DESIGN_NAMES));
        color = new Spinner(this);
        color.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, COLOR_NAMES));
        
        container = new FrameLayout(this);
        
        OnItemSelectedListener listener = new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                loadAd();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        };
        
        title.setSelection(0);
        button.setSelection(0);
        design.setSelection(0);
        color.setSelection(0);
        
        mainLayout.addView(title);
        mainLayout.addView(button);
        mainLayout.addView(design);
        mainLayout.addView(color);
        
        View filler = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 0);
        params.weight = 1.0f;
        mainLayout.addView(filler, params);
        
        mainLayout.addView(container);
        
        loadAd();
        
        setContentView(mainLayout);
        
        title.setOnItemSelectedListener(listener);
        button.setOnItemSelectedListener(listener);
        design.setOnItemSelectedListener(listener);
        color.setOnItemSelectedListener(listener);
        
    }

    private void loadAd() {
        container.removeAllViews();
        AppBrainBanner banner = new AppBrainBanner(BannerActivity.this);
        banner.setTitleIndex(title.getSelectedItemPosition());
        banner.setButtonTextIndex(button.getSelectedItemPosition());
        banner.setDesign(design.getSelectedItemPosition());
        banner.setColors(color.getSelectedItemPosition());
        container.addView(banner);
        banner.requestAd();
    }
}
