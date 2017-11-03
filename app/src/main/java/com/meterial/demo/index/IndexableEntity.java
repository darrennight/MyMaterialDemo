package com.meterial.demo.index;

public interface IndexableEntity {
 
    String getFieldIndexBy();
 
    void setFieldIndexBy(String indexField);
 
    void setFieldPinyinIndexBy(String pinyin);
} 
