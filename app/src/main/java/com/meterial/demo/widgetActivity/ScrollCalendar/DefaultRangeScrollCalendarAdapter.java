package com.meterial.demo.widgetActivity.ScrollCalendar;

import android.support.annotation.Nullable;

import java.util.Calendar;
import java.util.Date;


public class DefaultRangeScrollCalendarAdapter extends ScrollCalendarAdapter {

    @Nullable
    private Calendar from;
    @Nullable
    private Calendar until;

    public DefaultRangeScrollCalendarAdapter(ResProvider resProvider) {
        super(resProvider);
    }

    @Override
    protected void onCalendarDayClicked(int year, int month, int day) {
        if (isInThePast(year, month, day)) {
            return;
        }
        Calendar clickedOn = Calendar.getInstance();
        clickedOn.set(Calendar.YEAR, year);
        clickedOn.set(Calendar.MONTH, month);
        clickedOn.set(Calendar.DAY_OF_MONTH, day);
        clickedOn.set(Calendar.HOUR_OF_DAY, 0);
        clickedOn.set(Calendar.MINUTE, 0);
        clickedOn.set(Calendar.SECOND, 0);
        clickedOn.set(Calendar.MILLISECOND, 0);

        if (shouldClearAllSelected(clickedOn)) {
            from = null;
            until = null;
        } else if (shouldSetFrom(clickedOn)) {
            from = clickedOn;
            until = null;
        } else if (shouldSetUntil()) {
            until = clickedOn;
        }
    }

    @State
    @Override
    protected int getStateForDate(int year, int month, int day) {
        if (isInThePast(year, month, day)) {
            return CalendarDay.DISABLED;
        }
        if (isSelected(from, year, month, day)) {
            return CalendarDay.SELECTED;
        }
        if (isToday(year, month, day)) {
            return CalendarDay.TODAY;
        }
        if (isInRange(from, until, year, month, day)) {
            return CalendarDay.SELECTED;
        }
        return CalendarDay.DEFAULT;
    }


    private boolean isInRange(Calendar from, Calendar until, int year, int month, int day) {
        if (from == null || until == null) {
            return false;
        }
        //noinspection UnnecessaryLocalVariable
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, from.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, from.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, from.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long millis1 = calendar.getTimeInMillis();

        calendar.set(Calendar.YEAR, until.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, until.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, until.get(Calendar.DAY_OF_MONTH));
        long millis2 = calendar.getTimeInMillis();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long millis3 = calendar.getTimeInMillis();
        return millis1 <= millis3 && millis2 >= millis3;
    }

    private boolean shouldSetUntil() {
        return until == null;
    }

    private boolean shouldClearAllSelected(Calendar calendar) {
        return from != null && from.equals(calendar);
    }

    private boolean shouldSetFrom(Calendar calendar) {
        return from == null || until != null || isBefore(from, calendar);
    }

    private boolean isBefore(Calendar c1, Calendar c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        //noinspection UnnecessaryLocalVariable
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, c2.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, c2.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, c2.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long millis = calendar.getTimeInMillis();

        calendar.set(Calendar.YEAR, c1.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, c1.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));
        long millis2 = calendar.getTimeInMillis();

        return millis < millis2;
    }

    private boolean isInThePast(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long now = calendar.getTimeInMillis();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long then = calendar.getTimeInMillis();
        return now > then;
    }

    @Override
    protected boolean isAllowedToAddPreviousMonth() {
        return false;
    }

    @Override
    protected boolean isAllowedToAddNextMonth() {
        return true;
    }

    private boolean isSelected(Calendar selected, int year, int month, int day) {
        if (selected == null) {
            return false;
        }
        //noinspection UnnecessaryLocalVariable
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, selected.get(Calendar.YEAR));
        calendar.set(Calendar.MONTH, selected.get(Calendar.MONTH));
        calendar.set(Calendar.DAY_OF_MONTH, selected.get(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long millis = calendar.getTimeInMillis();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        long millis2 = calendar.getTimeInMillis();

        return millis == millis2;
    }

    private boolean isToday(int year, int month, int day) {
        //noinspection UnnecessaryLocalVariable
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        // Today in milliseconds
        long today = calendar.getTime().getTime();

        // Given day in milliseconds
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long calendarMillis = calendar.getTime().getTime();

        return today == calendarMillis;
    }

    @Nullable
    public Date getFrom() {
        return from != null ? from.getTime() : null;
    }

    @Nullable
    public Date getUntil() {
        return until != null ? until.getTime() : null;
    }
}