package com.meterial.demo.commonActivity.drag.demo4;

public interface IFBIItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    boolean canMove(int source, int target);
}