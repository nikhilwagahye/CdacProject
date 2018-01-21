package com.cdac.projectdemo.pageindicator;
import android.support.v4.view.ViewPager;

/**
 * Created by ankit.thakur on 10-07-2017.
 */

public interface PageIndicator extends ViewPager.OnPageChangeListener{

    void setViewPager(ViewPager view);
    void setViewPager(ViewPager view, int initialPosition);
    void setCurrentItem(int item);
    void setOnPageChangeListener(ViewPager.OnPageChangeListener listener);
    void notifyDataSetChanged();
}
