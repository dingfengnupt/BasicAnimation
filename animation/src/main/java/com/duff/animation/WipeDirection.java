package com.duff.animation;

/**
 * Created by dingfeng on 2017/6/15.
 */

public class WipeDirection {
    public final static int LEFT_TO_RIGHT = 0; // 从左向右
    public final static int RIGHT_TO_LEFT = 1; // 从右向左
    public final static int TOP_TO_BOTTOM = 2; // 从上到下
    public final static int BOTTOM_TO_TOP = 3; // 从下到上
    public final static int CLOCKWISE = 4; // 顺时针
    public final static int ANTI_CLOCKWISE = 5; // 逆时针
    public final static int UNKNOWN = -1;

    public final static int DEFAULT_DIRECTION = RIGHT_TO_LEFT;
}
