package ru.hoticecream.helloaspectj.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import ru.hoticecream.helloaspectj.R;


public class MainActivity extends Activity {

    private TextView mGreetingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGreetingText = (TextView) findViewById(R.id.greeting_message);
        setGreetingMessage("Hello Android");
    }

    private void setGreetingMessage(String message) {
        mGreetingText.setText(message);
    }
}
