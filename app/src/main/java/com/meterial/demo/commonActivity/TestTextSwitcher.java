package com.meterial.demo.commonActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.meterial.demo.R;
import com.meterial.demo.customview.FadingTextView;

import static com.meterial.demo.customview.FadingTextView.SECONDS;

/**
 *TextSwitcher
 * @author zenghao
 * @since 17/4/6 下午2:02
 */
public class TestTextSwitcher extends AppCompatActivity implements ViewSwitcher.ViewFactory{

    private TextSwitcher mSwitcher;
    String[] strs=new String[]{
            "疯狂Java讲义",
            "疯狂Android讲义",
            "疯狂ajax讲义",
            "轻量级Java EE企业应用实战"
    };
    private  int curStr;
    private FadingTextView fadingTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_text_switcher);
        mSwitcher = ((TextSwitcher) findViewById(R.id.textSwitcher));
        mSwitcher.setFactory(this);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        mSwitcher.setInAnimation(in);
        mSwitcher.setOutAnimation(out);

        findViewById(R.id.btn_switch_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next();
                fadingTextView.setTimeout(2, SECONDS);
                fadingTextView.forceRefresh();
            }
        });

        mSwitcher.setText("hahahah");


        fadingTextView = (FadingTextView) findViewById(R.id.fadingTextView);
        fadingTextView.setTimeout(2, SECONDS);
    }

    @Override
    public View makeView() {
        TextView textView = new TextView(this);
        textView.setTextSize(36);
        textView.setTextColor(Color.parseColor("#FF5B26"));
        return textView;
    }

    public void next(){
        mSwitcher.setText(strs[curStr++%strs.length ]);
    }
}
