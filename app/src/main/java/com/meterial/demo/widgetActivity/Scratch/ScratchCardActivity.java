package com.meterial.demo.widgetActivity.Scratch;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.meterial.demo.R;
import java.util.Random;

/**
 * https://github.com/myinnos/AndroidScratchCard
 * @author zenghao
 * @since 2018/11/6 下午2:35
 */
public class ScratchCardActivity extends AppCompatActivity {
    private TextView textView, txReload;
    private ScratchCard mScratchCard;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scratch_card);
        textView = (TextView) findViewById(R.id.textView);
        txReload = (TextView) findViewById(R.id.txReload);
        loadRandomNumber();

        mScratchCard = (ScratchCard) findViewById(R.id.scratchCard);
        mScratchCard.setOnScratchListener(new ScratchCard.OnScratchListener() {
            @Override
            public void onScratch(ScratchCard scratchCard, float visiblePercent) {
                if (visiblePercent > 0.3) {
                    mScratchCard.setVisibility(View.GONE);
                    Toast.makeText(ScratchCardActivity.this, "Content Visible", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadRandomNumber();
            }
        });
    }

    private void loadRandomNumber(){
        Random rand = new Random();
        String randomNum = String.valueOf(20 + rand.nextInt((100 - 20) + 1));
        textView.setText(randomNum);
    }
}