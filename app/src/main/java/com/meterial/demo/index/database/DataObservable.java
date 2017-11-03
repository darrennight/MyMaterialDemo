package com.meterial.demo.index.database;

import android.database.Observable;

public class DataObservable extends Observable<DataObserver> {
 
    /** 
     * Invokes {@link DataObserver#onInited()}  on each observer. 
     * Called when the data set is no longer valid and cannot be queried again, 
     * such as when the data set has been closed. 
     */ 
    public void notifyInited() { 
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) { 
                mObservers.get(i).onInited(); 
            } 
        } 
    } 
 
    /** 
     * Invokes {@link DataObserver#onChanged} on each observer. 
     * Called when the contents of the data set have changed.  The recipient 
     * will obtain the new contents the next time it queries the data set. 
     */ 
    public void notifyChanged() { 
        synchronized (mObservers) {
            // since onChanged() is implemented by the app, it could do anything, including 
            // removing itself from {@link mObservers} - and that could cause problems if 
            // an iterator is used on the ArrayList {@link mObservers}. 
            // to avoid such problems, just march thru the list in the reverse order. 
            for (int i = mObservers.size() - 1; i >= 0; i--) { 
                mObservers.get(i).onChanged(); 
            } 
        } 
    } 
 
    /** 
     * Invokes {@link DataObserver#onSetListener(int)} on each observer. 
     * Called when the data set is no longer valid and cannot be queried again, 
     * such as when the data set has been closed. 
     */ 
    public void notifySetListener(int type) {
        synchronized (mObservers) {
            for (int i = mObservers.size() - 1; i >= 0; i--) { 
                mObservers.get(i).onSetListener(type); 
            } 
        } 
    } 
} 