package com.meterial.demo.widgetActivity.SeatTable2;


/**
 * 座位数据解析器
 *
 * Created by S.Violet on 2016/10/24.
 */

public interface SeatDataParser {

    SeatTable parse() throws SeatDataParseException;

}