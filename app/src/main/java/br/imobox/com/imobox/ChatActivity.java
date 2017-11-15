package br.imobox.com.imobox;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.imobox.com.imobox.adapter.ChatAdapter;
import br.imobox.com.imobox.model.Message;

public class ChatActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ChatAdapter chatAdapter;
    private List<Message> messageList;
    private EditText editTextMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        recyclerView = findViewById(R.id.chatRecycler);
        editTextMessage = findViewById(R.id.editTextMessage);
        messageList = new ArrayList<>();
        chatAdapter = new ChatAdapter(messageList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);
    }


    public void addMessage(View view) {
        if (editTextMessage.getText() != null && !editTextMessage.getText().toString().isEmpty()){
            messageList.add(new Message(true, editTextMessage.getText().toString()));
            chatAdapter.replaceData(messageList);
            editTextMessage.setText("");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    messageList.add(new Message(false, "Sim!"));
                    chatAdapter.replaceData(messageList);
                }
            }, 2000);
        }
    }
}
