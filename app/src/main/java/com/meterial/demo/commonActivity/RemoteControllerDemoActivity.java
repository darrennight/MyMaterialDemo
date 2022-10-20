package com.meterial.demo.commonActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.meterial.demo.R;
import com.meterial.demo.customview.RemoteControllerView;

/**
 * https://github.com/GuoFeilong/RemoteControllerDemo
 *
 * https://github.com/sungerk/CircularMenu
 */
public class RemoteControllerDemoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote_demo);




        RemoteControllerView remoteControllerView = findViewById(R.id.rcv_view);
        remoteControllerView.setRemoteControllerClickListener(new RemoteControllerView.OnRemoteControllerClickListener() {
            @Override
            public void topClick() {
                Toast.makeText(RemoteControllerDemoActivity.this, "topClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void leftClick() {
                Toast.makeText(RemoteControllerDemoActivity.this, "leftClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void rightClick() {
                Toast.makeText(RemoteControllerDemoActivity.this, "rightClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void bottomClick() {
                Toast.makeText(RemoteControllerDemoActivity.this, "bottomClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void centerOkClick() {
                Toast.makeText(RemoteControllerDemoActivity.this, "centerOkClick", Toast.LENGTH_SHORT).show();
            }
        });
    }


}