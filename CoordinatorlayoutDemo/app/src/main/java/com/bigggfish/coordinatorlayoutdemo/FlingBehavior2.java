package com.bigggfish.coordinatorlayoutdemo;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ScrollingView;
import android.util.AttributeSet;
import android.view.View;

/**
 * 对实现ScrollingView接口的View有效，但是对NestedScrollView无效。
 *
 */
public final class FlingBehavior2 extends AppBarLayout.Behavior {

    public FlingBehavior2() {
    }

    public FlingBehavior2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, AppBarLayout child, View target, float velocityX, float velocityY, boolean consumed) {
        if (target instanceof ScrollingView) {
            final ScrollingView scrollingView = (ScrollingView) target;
            consumed = velocityY > 0 || scrollingView.computeVerticalScrollOffset() > 0;
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }
}