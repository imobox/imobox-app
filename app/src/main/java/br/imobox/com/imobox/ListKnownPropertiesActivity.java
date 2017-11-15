package br.imobox.com.imobox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.imobox.com.imobox.adapter.KnownPropertiesCustomAdapter;
import br.imobox.com.imobox.adapter.PropertiesCustomAdapter;
import br.imobox.com.imobox.model.Propertie;

public class ListKnownPropertiesActivity extends AppCompatActivity {

    private KnownPropertiesCustomAdapter knownPropertiesCustomAdapter;
    private ArrayList<Propertie> propertiesList;
    private RecyclerView listProperties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_known_properties);

        listProperties = (RecyclerView) findViewById(R.id.list_properties);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        listProperties.setLayoutManager(mLayoutManager);

        propertiesList = new ArrayList<>();

        propertiesList.add(new Propertie(1, "1", "y", 00.00, false));
        propertiesList.add(new Propertie(2, "2", "y", 00.00, true));
        propertiesList.add(new Propertie(3 ,"3", "y", 00.00, true));
        propertiesList.add(new Propertie(4, "4", "y", 00.00, true));

        knownPropertiesCustomAdapter = new KnownPropertiesCustomAdapter(getBaseContext(), propertiesList);

        listProperties.setAdapter(knownPropertiesCustomAdapter);
    }

}
