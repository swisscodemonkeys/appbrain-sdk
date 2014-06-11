package com.appbrain.example;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.appbrain.AdListAdapter;
import com.appbrain.AppBrain;

public class ListAdsActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1);
        for (int i = 0; i < 100; i++) {
            adapter.add("Item " + i);
        }

        final AdListAdapter adAdapter = AppBrain.getAds().wrapListAdapter(this, adapter);
        listView.setAdapter(adAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = adAdapter.getItemPosition(position);
                Toast.makeText(ListAdsActivity.this, "Item " + itemPosition + " pressed",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
