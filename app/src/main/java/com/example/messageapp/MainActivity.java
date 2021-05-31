 package com.example.messageapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.messageapp.Second.EXTRA_REPLY;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.android.messageapp.extra.MESSAGE ";
    private static final int TEXT_REQUEST = 1;

    private TextView mReplyView;
    private TextView mreplyHeadtextView;
    private EditText mMessageEditText;
    private TextView mreplytextheader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "...................");
        Log.d(LOG_TAG, "onCreate ");
        mMessageEditText = findViewById(R.id.editText_main);
        mreplyHeadtextView = findViewById(R.id.text_header_reply);
        mReplyView = findViewById(R.id.text_message_reply);

       /* if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("reply_vissible");
            if (isVisible){
                mreplyHeadtextView.setVisibility(View.VISIBLE);
                mReplyView.setText(savedInstanceState.getString("reply_text"));
                mReplyView.setVisibility(View.VISIBLE);
            }
        }*/
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "...................");
        Log.d(LOG_TAG, "onStart ");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "...................");
        Log.d(LOG_TAG, "onPause ");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG, "...................");
        Log.d(LOG_TAG, "onDestroy ");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "...................");
        Log.d(LOG_TAG, "onStop ");
    }


    public void launchSecondActivity(View view){
        Log.d("Button_Clicked", "Button_Clicked");
        Intent intent = new Intent(this, Second.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

   /* @Override
    protected void onSaveInstanceState(@Nullable Bundle outState){
        super.onSaveInstanceState(outState);
        if (mreplytextheader.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_vissible", true);
            outState.putString("reply_text",mReplyView.getText().toString());

        }
    }*/




    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode ==  TEXT_REQUEST)
        {
            if(resultCode == RESULT_OK){
                String reply =data.getStringExtra(EXTRA_REPLY) ;
                mreplyHeadtextView.setVisibility(View.VISIBLE);
                mReplyView.setText(reply);
                mReplyView.setVisibility(View.VISIBLE);

            }
        }

    }
}