package com.meterial.demo.bottomDialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 * TODO
 *
 * @author zenghao
 * @since 16/10/17 下午4:27
 */
public class BottomDialogShowActivity extends AppCompatActivity {

    private Button btn_share;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_show);
        btn_share = ((Button) findViewById(R.id.btn_share));
        btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //EditTextDialog dialog = new EditTextDialog();
                //dialog.show(getSupportFragmentManager());


                BottomDialog.create(getFragmentManager())
                        .setViewListener(new BottomDialog.ViewListener() {
                            @Override
                            public void bindView(View v) {

                            }
                        })
                        .setLayoutRes(R.layout.dialog_layout)
                        .setDimAmount(0.9f)
                        .setTag("BottomDialog")
                        .show();
            }
        });
    }
}
