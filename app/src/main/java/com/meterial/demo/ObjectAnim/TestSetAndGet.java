package com.meterial.demo.ObjectAnim;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.meterial.demo.R;

/**
 * 通过包装View来间接提供set和get方法，比较推荐；
 通过监听ValueAnimator的动画过程，实现属性的改变，其中，又有两种实现方式：
 直接通过animator返回的当前值来设置
 通过animator返回的fraction(可以理解为时间片，取值0.0~1.0)自己来计算，其中要注意的是代码中将width从200~300~200，其中实际上变化的总量有200，
 所以计算时，需要从200开始，400结束，这样计算的值才不会出错，即(400 - 200) * 0.5 = 100,如果是300结束，那么在0.5时变化量为(300 - 200) * 0.5 = 50，就出错了，这点要注意。
 */
public class TestSetAndGet extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_set_and_get);

        mListView = (ListView) findViewById(R.id.animatorListView);

        String[] numList = {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout
                .simple_list_item_1, numList);
        mListView.setAdapter(mAdapter);
    }

    public void DoAnimator(View v) {

        /* 直接使用此方法不行
        ObjectAnimator animator = ObjectAnimator.ofInt(mListView,"width",200,300,200);
        animator.setDuration(2000);
        animator.start();
        */

        /* 第一种方法（推荐）*/
        ViewWrapper viewWrapper = new ViewWrapper(mListView);
        ObjectAnimator animator = ObjectAnimator.ofInt(viewWrapper,"width",200,300,200);
        animator.setDuration(2000);
        animator.start();

        /* 第二种方法 */
//        ValueAnimator valueAnimator = ValueAnimator.ofInt(200,300,200);
//        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//
//            private IntEvaluator evaluator = new IntEvaluator();
//
//            @Override
//            public void onAnimationUpdate(ValueAnimator animator) {
//
//                /* 第一种写法
//                float fraction = animator.getAnimatedFraction();
//                System.out.println("fraction:" + fraction);
//                if(fraction < 0.5f){
//                    mListView.getLayoutParams().width = evaluator.evaluate(fraction,200,400);
//                    System.out.println("<0.5:" + evaluator.evaluate(fraction,200,400));
//                }else {
//                    mListView.getLayoutParams().width = evaluator.evaluate(fraction,400,200);
//                    System.out.println(">0.5:" + evaluator.evaluate(fraction,400,200));
//                }
//                mListView.requestLayout();
//                */
//
//                /* 第二种写法 */
//                int currentValue = (int) animator.getAnimatedValue();
//                System.out.println("currentValue:" + currentValue);
//                mListView.getLayoutParams().width = currentValue;
//                mListView.requestLayout();
//            }
//        });
//        valueAnimator.setDuration(2000);
//        valueAnimator.start();

    }

    private static class ViewWrapper{

        private View targetView;

        public ViewWrapper(View view){
            this.targetView = view;
        }

        public int getWidth(){
            return  targetView.getLayoutParams().width;
        }

        public void setWidth(int widthValue){
            targetView.getLayoutParams().width = widthValue;
            targetView.requestLayout();
        }
    }
}