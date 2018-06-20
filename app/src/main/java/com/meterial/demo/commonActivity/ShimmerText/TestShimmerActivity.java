package com.meterial.demo.commonActivity.ShimmerText;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.meterial.demo.R;

/**
 *文字高亮
 * @author zenghao
 * @since 2018/6/15 下午3:05
 */
public class TestShimmerActivity extends AppCompatActivity {

    private GradientShaderTextView shimmerText = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_shimmer);
        shimmerText = findViewById(R.id.shimmer_text);

    }
}
