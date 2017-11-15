package br.imobox.com.imobox.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.imobox.com.imobox.R;
import br.imobox.com.imobox.helper.DownloadImageTask;
import br.imobox.com.imobox.model.Propertie;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class PropertiesCustomAdapter extends RecyclerView.Adapter<PropertiesCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Propertie> propertieList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public LinearLayout ll_list;

        public MyViewHolder(View view) {
            super(view);
            name          = (TextView) view.findViewById(R.id.name);
            image        = (ImageView) view.findViewById(R.id.image);
            ll_list = (LinearLayout) view.findViewById(R.id.ll_list);
        }
    }

    public PropertiesCustomAdapter(Context mContext, List<Propertie> propertieList) {
        this.mContext = mContext;
        this.propertieList = propertieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_propertie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Propertie propertie = propertieList.get(position);
        holder.name.setText("" + propertie.getName());

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, listSchedulesActivity.class);
//                intent.putExtra("id", "" + evento.getId());
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                mContext.startActivity(intent);
            }
        });

        new DownloadImageTask(holder.image).execute("http://f.i.uol.com.br/folha/esporte/images/16225746.jpeg");
    }

    @Override
    public int getItemCount() {
        return propertieList.size();
    }

}
