package com.meterial.demo.commonActivity.CustomLayoutAnimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.GridLayout;
import com.meterial.demo.R;

public class TestCustomLayoutAnimationController extends AppCompatActivity implements
        CustomLayoutAnimationController.CurrentIndexListener {

    private GridLayout gridLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation_controller);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);


        ScaleAnimation animation = new ScaleAnimation(1, 0, 1, 0, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);

        CustomLayoutAnimationController customLayoutAnimationController = new
                CustomLayoutAnimationController(animation);
        customLayoutAnimationController.setOrder(CustomLayoutAnimationController.CUSTOM_ORDER);
        customLayoutAnimationController.setDelay(0.2f);
        customLayoutAnimationController.setCurrentIndexListener(this);
        gridLayout.setLayoutAnimation(customLayoutAnimationController);
    }

    @Override
    public int currentIndex(CustomLayoutAnimationController controller, int count, int index) {
        int result = 1;
        switch (index % 4) {
            case 0:
                result = 3;
                break;
            case 1:
                result = 4;
                break;
            case 2:
                result = 5;
                break;
            case 3:
                result = 6;
                break;
        }
        return  result;
    }
}