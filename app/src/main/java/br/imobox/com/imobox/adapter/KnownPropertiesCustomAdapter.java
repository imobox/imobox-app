package br.imobox.com.imobox.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import br.imobox.com.imobox.InfoPropertieActivity;
import br.imobox.com.imobox.R;
import br.imobox.com.imobox.helper.DownloadImageTask;
import br.imobox.com.imobox.model.Propertie;
import br.imobox.com.imobox.utils.Constants;

/**
 * Created by matheuscatossi on 15/11/17.
 */

public class KnownPropertiesCustomAdapter extends RecyclerView.Adapter<KnownPropertiesCustomAdapter.MyViewHolder> {

    private Context mContext;
    private List<Propertie> propertieList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView image;
        public LinearLayout ll_list;
        public CheckBox check;

        public MyViewHolder(View view) {
            super(view);
            name   = (TextView) view.findViewById(R.id.name);
            image  = (ImageView) view.findViewById(R.id.image);
            check = (CheckBox) view.findViewById(R.id.check);
            ll_list = (LinearLayout) view.findViewById(R.id.ll_list);
        }
    }

    public KnownPropertiesCustomAdapter(Context mContext, List<Propertie> propertieList) {
        this.mContext = mContext;
        this.propertieList = propertieList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item_known_propertie, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        final Propertie propertie = propertieList.get(position);
        holder.name.setText("" + propertie.getName());

        holder.check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(view.getContext(), android.R.style.Theme_DeviceDefault_Light));
                builder.setTitle(propertie.getName());
                View viewInflated = LayoutInflater.from(mContext).inflate(R.layout.modal_info_propertie, (ViewGroup) view.getRootView(), false);

                final TextView price = (TextView) viewInflated.findViewById(R.id.price);
                final TextView additional = (TextView) viewInflated.findViewById(R.id.additional);
                final TextView typeImo = (TextView) viewInflated.findViewById(R.id.typeImo);
                final TextView info = (TextView) viewInflated.findViewById(R.id.info);
                final ImageView image = (ImageView) viewInflated.findViewById(R.id.image);

                info.setText(Constants.info[propertie.getId()]);
                typeImo.setText(Constants.typeImo[propertie.getId()]);
                additional.setText(Constants.additional[propertie.getId()]);
                price.setText(Constants.price[propertie.getId()]);

                new DownloadImageTask(image).execute(propertie.getImage());

                builder.setView(viewInflated);

                holder.check.setChecked(false);

                builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.check.setChecked(true);
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        holder.check.setChecked(false);
                    }
                });

               builder.show();


            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InfoPropertieActivity.class);
                intent.putExtra("id", "" + propertie.getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });

        new DownloadImageTask(holder.image).execute(propertie.getImage());
    }

    @Override
    public int getItemCount() {
        return propertieList.size();
    }
}
