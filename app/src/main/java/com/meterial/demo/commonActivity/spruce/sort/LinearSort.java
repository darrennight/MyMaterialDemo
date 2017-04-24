package com.meterial.demo.commonActivity.spruce.sort;

import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class LinearSort extends DistancedSort {

    private final Direction direction;

    public enum Direction {
        TOP_TO_BOTTOM,
        BOTTOM_TO_TOP,
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /**
     * Establishes the delay between object animations and their direction based on distance,
     * delay, and a value from the Direction enum
     * @param interObjectDelay delay between object animations
     * @param reversed flag to indicate if the animation should be reversed
     * @param direction enum value of the direction the animation should start from and end with
     */
    public LinearSort(long interObjectDelay, boolean reversed, Direction direction) {
        super(interObjectDelay, reversed);
        if (direction == null) {
            throw new NullPointerException("Direction can't be null and must be of a valid type");
        }
        this.direction = direction;
    }

    @Override
    public List<SpruceTimedView> getViewListWithTimeOffsets(ViewGroup parent, List<View> children) {
        return super.getViewListWithTimeOffsets(parent, children);
    }


    @Override
    public PointF getDistancePoint(ViewGroup parent, List<View> children) {
        PointF point = super.getDistancePoint(parent, children);
        switch (direction) {
            case TOP_TO_BOTTOM:
                return new PointF(parent.getWidth() / 2.0F, 0F);
            case BOTTOM_TO_TOP:
                return new PointF(parent.getWidth() / 2.0F, parent.getHeight());
            case LEFT_TO_RIGHT:
                return new PointF(0F, parent.getHeight() / 2.0F);
            case RIGHT_TO_LEFT:
                return new PointF(parent.getWidth(), parent.getHeight() / 2.0F);
            default:
                throw new AssertionError("Must be a valid Direction argument type");
        }
    }

    @Override
    public double getDistanceBetweenPoints(PointF left, PointF right) {
        switch (direction) {
            case BOTTOM_TO_TOP:
            case TOP_TO_BOTTOM:
                left.x = 0F;
                right.x = 0F;
                break;
            case LEFT_TO_RIGHT:
            case RIGHT_TO_LEFT:
                left.y = 0F;
                right.y = 0F;
                break;
        }
        return Utils.euclideanDistance(left, right);
    }
}