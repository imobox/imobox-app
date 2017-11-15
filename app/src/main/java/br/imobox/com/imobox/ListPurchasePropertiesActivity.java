package br.imobox.com.imobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Properties;

import br.imobox.com.imobox.adapter.PropertiesCustomAdapter;
import br.imobox.com.imobox.model.Propertie;
import br.imobox.com.imobox.utils.Constants;

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

        propertiesList.add(new Propertie(1, Constants.title[0],  Constants.link[0], Constants.price[0]));
        propertiesList.add(new Propertie(2, Constants.title[1],  Constants.link[1], Constants.price[0]));
        propertiesList.add(new Propertie(3 ,Constants.title[2],  Constants.link[2], Constants.price[0]));
        propertiesList.add(new Propertie(4, Constants.title[3],  Constants.link[3], Constants.price[0]));

        propertiesCustomAdapter = new PropertiesCustomAdapter(getBaseContext(), propertiesList);

        listProperties.setAdapter(propertiesCustomAdapter);
    }
}
