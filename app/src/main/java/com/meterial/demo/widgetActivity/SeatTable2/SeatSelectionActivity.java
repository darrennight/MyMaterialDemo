package com.meterial.demo.widgetActivity.SeatTable2;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.meterial.demo.R;
import sviolet.turquoise.enhance.app.TAppCompatActivity;
import sviolet.turquoise.enhance.app.annotation.inject.ResourceId;
import sviolet.turquoise.util.bitmap.BitmapUtils;
import sviolet.turquoise.util.droid.MeasureUtils;

/**
 * https://github.com/shepherdviolet/SeatSelectionView
 */
@ResourceId(R.layout.seat_selection)
public class SeatSelectionActivity extends TAppCompatActivity {

    @ResourceId(R.id.seat_selection_selection_view)
    private SeatSelectionView seatSelectionView;//选座控件
    @ResourceId(R.id.seat_selection_bottom_bar)
    private LinearLayout bottomBar;//底部栏
    @ResourceId(R.id.seat_selection_cinema_name)
    private TextView cinemaNameView;
    @ResourceId(R.id.seat_selection_session)
    private TextView sessionView;
    @ResourceId(R.id.seat_selection_bottom_bar_item_container)
    private LinearLayout selectedItemContainer;
    @ResourceId(R.id.seat_selection_bottom_bar_total_price)
    private TextView totalPriceTextView;
    @ResourceId(R.id.seat_selection_bottom_bar_price_details)
    private TextView priceDetailTextView;

    private SeatImagePoolImpl imagePool;//图片池

    private MySelectedSeats selectedSeats;
    private AuditoriumInfo auditoriumInfo;
    private SeatTable seatTable;

    @Override
    protected void onInitViews(Bundle savedInstanceState) {
        initData();
        initView();
        initSeatSelectionView(seatTable);

    }

    @Override
    protected void afterDestroy() {
        //销毁图片池(内含Bitmap)
        imagePool.destroy();
    }

    private void initData(){
        auditoriumInfo = DataEmulate.initAuditoriumInfo();
//        seatTable = DataEmulate.initSeatTable1(getApplicationContext());
        seatTable = DataEmulate.initSeatTable2(getApplicationContext());
//        seatTable = DataEmulate.initSeatTable3(getApplicationContext());
    }

    private void initView(){
        selectedSeats = new MySelectedSeats(
                seatSelectionView,
                auditoriumInfo,
                getApplicationContext(),
                bottomBar,
                selectedItemContainer,
                totalPriceTextView,
                priceDetailTextView);

        cinemaNameView.setText(auditoriumInfo.getCinemaName());
        sessionView.setText(auditoriumInfo.getSession());
    }

    private void initSeatSelectionView(SeatTable seatTable){

        //配置座位数据
        seatSelectionView.setData(seatTable);
        //设置背景色
        seatSelectionView.setBackground(0xFFF0F0F0);
        //配置行标记
        seatSelectionView.setRowBar(new RowBarImpl(MeasureUtils.dp2px(getApplicationContext(), 18), 10, 0x80000000, 0xFFF0F0F0, MeasureUtils.dp2px(getApplicationContext(), 12)));
        //配置屏幕标记
        seatSelectionView.setScreenBar(new ScreenBarImpl(0.5f, MeasureUtils.dp2px(getApplicationContext(), 25), 0.05f, 0xFFC0C0C0, 0xFF505050, auditoriumInfo.getAuditoriumName(), MeasureUtils.dp2px(getApplicationContext(), 16)));
        //配置概要图
        seatSelectionView.setOutlineMap(new OutlineMapImpl(MeasureUtils.getScreenWidth(getApplicationContext()) * 2 / 5, 0x70000000, 0xFFFAFAFA, 0xFFFF5050, 0xFF20FF20, 0xC0F0F020, MeasureUtils.dp2px(getApplicationContext(), 1f)));
        //配置概要图显示时间
        seatSelectionView.setOutlineDelay(1000);
        //配置中线
        seatSelectionView.setMidLine(new MidLineImpl(MeasureUtils.dp2px(getApplicationContext(), 2), 0xFFC0C0C0, true, new float[]{MeasureUtils.dp2px(getApplicationContext(), 2), MeasureUtils.dp2px(getApplicationContext(), 5)}));

        //配置座位各种状态的图片
        imagePool = new SeatImagePoolImpl();
        imagePool.setImage(SeatType.SINGLE, SeatState.AVAILABLE, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_available));
        imagePool.setImage(SeatType.SINGLE, SeatState.UNAVAILABLE, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_unavailable));
        imagePool.setImage(SeatType.SINGLE, SeatState.SELECTED, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_selected));
        imagePool.setImage(SeatType.COUPLE, SeatState.AVAILABLE, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_couple_available));
        imagePool.setImage(SeatType.COUPLE, SeatState.UNAVAILABLE, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_couple_unavailable));
        imagePool.setImage(SeatType.COUPLE, SeatState.SELECTED, BitmapUtils.decodeFromResource(getResources(), R.mipmap.seat_couple_selected));
        seatSelectionView.setImagePool(imagePool);

        //配置座位选择监听器
        seatSelectionView.setSeatSelectionListener(new SeatSelectionListener() {
            @Override
            public boolean onSeatSelect(Seat seat) {
                //处理座位选择事件
                return selectedSeats.onSelect(seat);
            }

            @Override
            public boolean onSeatDeselect(Seat seat) {
                //处理座位选择事件
                return selectedSeats.onDeselect(seat);
            }

            @Override
            public void onUnavailableSeatSelect(Seat seat) {

            }

            @Override
            public void onInvalidAreaClick() {

            }
        });

    }

}