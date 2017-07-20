// ICatchNews.aidl
package com.zero.mybody;

// Declare any non-default types here with import statements
import com.zero.mybody.ICallBack;

interface ICatchNews {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void registerCallback(ICallBack c);

    void refreshData();
}
