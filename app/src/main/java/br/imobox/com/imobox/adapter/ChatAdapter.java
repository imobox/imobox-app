package br.imobox.com.imobox.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import br.imobox.com.imobox.R;
import br.imobox.com.imobox.model.Message;

/**
 * Created by Wilder on 15/11/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {

    private List<Message> messages;

    public ChatAdapter(List<Message> messages) {
        setList(messages);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);
        return new ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Message message = messages.get(position);
        if (!message.isMe()) {
            ViewGroup.LayoutParams layoutParams = viewHolder.message.getLayoutParams(); // Step 1.
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) layoutParams; // Step 2.
            params.gravity = Gravity.LEFT;
            viewHolder.message.setLayoutParams(params);
        }
        viewHolder.message.setText(message.getMessage());
    }

    public void replaceData(List<Message> movies) {
        setList(movies);
        notifyDataSetChanged();
    }

    private void setList(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public Message getItem(int position) {
        return messages.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView message;

        public ViewHolder(View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.message);
        }
    }
}
