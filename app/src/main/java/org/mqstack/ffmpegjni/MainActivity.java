package org.mqstack.ffmpegjni;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.concurrent.Callable;

/**
 * Created by mqstack on 2015/11/23.
 */
public class MainActivity extends Activity implements OnItemClickListener {

    FFmpegJni ffmpegJni = null;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] texts;
    private String[] commands;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ffmpegJni = new FFmpegJni();
        listView = (ListView) findViewById(R.id.orderList);
        texts = getResources().getStringArray(R.array.texts);
        commands = getResources().getStringArray(R.array.commands);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, texts);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        String testCommand = commands[position];
        Log.d("testCommand", testCommand);
        long i = System.currentTimeMillis();
        if (ffmpegJni.ffmpegRunCommand(testCommand) == 0) {
            Toast.makeText(this, "Cut success", Toast.LENGTH_LONG).show();
            Log.d("FFmpegJni", "Cut success");
            Log.d("FFmpegJni", "command time" + (System.currentTimeMillis() - i));

        } else {
            Toast.makeText(this, "Cut failed", Toast.LENGTH_LONG).show();
            Log.d("FFmpegJni", "Cut failed");
        }
    }
}
