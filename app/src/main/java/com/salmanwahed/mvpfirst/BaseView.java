package com.salmanwahed.mvpfirst;

/**
 * Created by salman on 1/8/18.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
}
