package com.meterial.demo.index;

import java.util.Comparator;

class InitialComparator<T extends IndexableEntity> implements Comparator<EntityWrapper<T>> {
    @Override 
    public int compare(EntityWrapper<T> lhs, EntityWrapper<T> rhs) {
        return lhs.getIndex().compareTo(rhs.getIndex());
    } 
} 