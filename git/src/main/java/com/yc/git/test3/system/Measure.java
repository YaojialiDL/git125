package com.yc.git.test3.system;

/**
 * 测量接口
 */
public interface Measure {
    /**
     *
     * @param obj：待测量的对象
     * @return ：测量的值
     */
    public double doMeasure(Object obj);
}
