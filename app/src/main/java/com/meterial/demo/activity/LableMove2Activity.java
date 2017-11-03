package com.meterial.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.meterial.demo.R;
import com.meterial.demo.customview.TitleView;

/**
 * TODO
 *
 * @author zenghao
 * @since 2017/8/18 上午11:41
 */
public class LableMove2Activity extends AppCompatActivity {

    private TitleView titleView = null;
    private Button btnAdd = null;
    private Button btnDel = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lable_move2);
        initView();
    }

    /**
     * 初始化组件
     */
    public void initView() {
        titleView = (TitleView) findViewById(R.id.title_view);
        btnAdd = (Button) findViewById(R.id.btn_add);
        btnDel = (Button) findViewById(R.id.btn_del);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //titleView.setTitleContent(titleView.getTitleContent() + "人鱼线,狗公腰,刚过队长太帅了");
                titleView.setTitleContent("哈哈哈哈哈哈");
                //titleView.setTitleContent("哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈人鱼线,狗公腰,刚过队长太帅了");
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (titleView.getTitleContent().length() > 15) {
                    titleView.setTitleContent(titleView.getTitleContent().substring(0, titleView.getTitleContent().length() - 15));
                }
            }
        });
    }
}
