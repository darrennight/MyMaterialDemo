package com.meterial.demo.chart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.meterial.demo.R;
import com.meterial.demo.chart.view.PieGraphView;

/**
 * TODO
 *
 * @author zenghao
 * @since 2018/4/11 下午6:29
 */
public class ChartActivity3 extends AppCompatActivity {

    private PieGraphView pie1, pie2, pie3;
    private int[] colors = new int[]{0xfff9bdbb, 0xfff36c60, 0xffce93d8, 0xffafbfff, 0xffb2dfdb, 0xff00acc1, 0xffcddc39, 0xff259b24};
    private int colorIndex;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart3);
        pie1 = (PieGraphView) findViewById(R.id.pie1);
        pie1.setRingWidthFactor(0.37f);
        pie2 = (PieGraphView) findViewById(R.id.pie2);
        pie2.setGrowWidthFactor(0.2f);
        pie3 = (PieGraphView) findViewById(R.id.pie3);
        pie3.setGrowMode(PieGraphView.GROW_MODE_BOLD);

        // 造例子数据
        PieGraphView.ItemGroup[] groups = new PieGraphView.ItemGroup[3];

        for (int i = 0; i < groups.length; i++) {
            PieGraphView.ItemGroup itemGroup = new PieGraphView.ItemGroup();
            groups[i] = itemGroup;
            itemGroup.id = "zu@" + i;
            PieGraphView.Item[] items = new PieGraphView.Item[4];
            itemGroup.items = items;

            for (int j = 0; j < items.length; j++) {
                PieGraphView.Item item = new PieGraphView.Item();
                item.id = "it@" + j;
                item.value = j * 24 + 24;
                item.color = colors[colorIndex++ % colors.length];
                items[j] = item;
            }
        }

        pie1.setData(groups);
        pie2.setData(groups);
        pie3.setData(groups);

        pie1.setItemChangeListener(new PieGraphView.ItemChangeListener() {
            @Override
            public void onItemSelected(PieGraphView.ItemGroup group, PieGraphView.Item item) {
                String msg = "group = " + group.id + ", item = " + item.id;
                Toast.makeText(ChartActivity3.this,msg,Toast.LENGTH_SHORT).show();
            }
        });
    }
}