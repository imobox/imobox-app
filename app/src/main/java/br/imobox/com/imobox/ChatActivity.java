package br.imobox.com.imobox;

import android.content.DialogInterface;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.imobox.com.imobox.adapter.ChatAdapter;
import br.imobox.com.imobox.helper.DownloadImageTask;
import br.imobox.com.imobox.model.Message;
import br.imobox.com.imobox.utils.Constants;

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.chat_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.rate){
            displayDialog();
        } else {

        }
        return super.onOptionsItemSelected(item);
    }

    private void displayDialog(){
        LayoutInflater factory = LayoutInflater.from(this);
        final View deleteDialogView = factory.inflate(R.layout.rate_dialog, null);
        final AlertDialog deleteDialog = new AlertDialog.Builder(this).create();
        deleteDialog.setView(deleteDialogView);
        final RatingBar starsBar = deleteDialogView.findViewById(R.id.rating_stars_gn);
        starsBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(ChatActivity.this, v+" estrelas dadas ao corretor.", Toast.LENGTH_SHORT).show();
                deleteDialog.dismiss();
            }
        });
//                starsBar.setOnTouchListener(new View.OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View view, MotionEvent motionEvent) {
//                        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
//                            float touchPositionX = motionEvent.getX();
//                            float width = starsBar.getWidth();
//                            float starsf = touchPositionX / width * 5.0f;
//                            float stars = starsf + 1;
//                            starsBar.setRating(stars);
//                            deleteDialog.dismiss();
//                        }
//                        return true;
//                    }
//                });
        deleteDialog.show();
    }
}
