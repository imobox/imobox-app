package br.imobox.com.imobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Properties;

import br.imobox.com.imobox.adapter.PropertiesCustomAdapter;
import br.imobox.com.imobox.model.Propertie;

public class ListPurchasePropertiesActivity extends AppCompatActivity {
    private PropertiesCustomAdapter propertiesCustomAdapter;
    private ArrayList<Propertie> propertiesList;
    private RecyclerView listProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_purchase_properties);

        listProperties = (RecyclerView) findViewById(R.id.list_properties);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        listProperties.setLayoutManager(mLayoutManager);

        propertiesList = new ArrayList<>();

        propertiesList.add(new Propertie(1, "x", "y", 00.00));
        propertiesList.add(new Propertie(2, "x", "y", 00.00));
        propertiesList.add(new Propertie(3 ,"x", "y", 00.00));
        propertiesList.add(new Propertie(4, "x", "y", 00.00));

        propertiesCustomAdapter = new PropertiesCustomAdapter(getBaseContext(), propertiesList);

        listProperties.setAdapter(propertiesCustomAdapter);
    }
}
