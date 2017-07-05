package com.meterial.demo.RatingBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;

/**
 * https://github.com/ome450901/SimpleRatingBar
 *
 * @author zenghao
 * @since 2017/5/15 下午3:30
 */
public class TestRatinBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_rating_bar);
        final ScaleRatingBar scaleRatingBar = (ScaleRatingBar) findViewById(R.id.simpleRatingBar);
        final BaseRatingBar baseRatingBar = (BaseRatingBar) findViewById(R.id.baseRatingBar);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentRating = scaleRatingBar.getRating();
                scaleRatingBar.setRating(currentRating + 1);

                currentRating = baseRatingBar.getRating();
                baseRatingBar.setRating(currentRating + 1);
            }
        });
    }
}
