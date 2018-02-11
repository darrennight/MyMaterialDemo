package com.meterial.demo.menu.m5;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;
import com.meterial.demo.R;

/**
 * https://github.com/gzu-liyujiang/CircleMenu
 *
 * @author zenghao
 * @since 2018/1/22 下午2:47
 */
public class CircleMenu5Activity extends AppCompatActivity {

    private String[] itemTexts = new String[]{
            "新建皮肤 ",
            "导入皮肤",
            "我的皮肤",
            "我的素材",
            "建议反馈",
            "更多作品",
            "版本更新"
    };
    private int[] itemIcons = new int[]{
            R.drawable.ic_skin_create,
            R.drawable.ic_skin_import,
            R.drawable.ic_skin_manage,
            R.drawable.ic_skin_material,
            R.drawable.ic_about,
            R.drawable.ic_product,
            R.drawable.ic_upgrade
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_menu5);
        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu_items);
        circleMenu.setRotating(true);//是否启用旋转
        circleMenu.setItems(itemTexts, itemIcons);//显示文字及图标
        //circleMenu.setItems(itemIcons);//只显示图标
        circleMenu.setIconSize(60);//图标大小，单位为dp
        circleMenu.setOnItemClickListener(new CircleMenu.OnItemClickListener() {
            @Override
            public void onItemClick(CircleMenu.ItemView view) {
                Toast.makeText(CircleMenu5Activity.this, itemTexts[view.getPosition()], Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.circle_menu_center).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CircleMenu5Activity.this, "click center", Toast.LENGTH_SHORT).show();
            }
        });
    }

}