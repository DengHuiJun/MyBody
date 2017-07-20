// ICallBack.aidl
package com.zero.mybody;

// Declare any non-default types here with import statements
import com.zero.mybody.jsonResult.Category;

interface ICallBack {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void setTitles(in List<Category> data);
}
