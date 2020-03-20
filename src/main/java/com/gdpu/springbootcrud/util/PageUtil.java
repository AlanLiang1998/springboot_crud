package com.gdpu.springbootcrud.util;

import java.util.ArrayList;

/**
 * @Descriptin TODO
 * @Author AlanLiang
 * Date 2020/3/19 12:49
 * Version 1.0
 **/
public class PageUtil {
    /**
     * 获取当前连续页码
     *
     * @param current      当前页码
     * @param pages        总共页
     * @param navigatePage 连续页数量
     * @return 当前连续页码
     */
    public static ArrayList<Long> getNavigatePageNums(Long current, Long pages, Long navigatePage) {
        long begin, end;
        if (pages >= navigatePage) {
            long beforeOffset, afterOffset;
            if (navigatePage % 2 != 0) {
                beforeOffset = afterOffset = navigatePage / 2;
            } else {
                beforeOffset = navigatePage / 2 - 1;
                afterOffset = navigatePage / 2;
            }
            begin = current - beforeOffset;
            end = current + afterOffset;
            if (begin <= 0) {
                begin = 1;
                end = begin + navigatePage - 1;
            }
            if (end > pages) {
                end = pages;
                begin = end - (navigatePage - 1);
            }
        } else {
            begin = 1;
            end = pages;
        }
        ArrayList<Long> list = new ArrayList<>();
        for (long i = begin; i <= end; i++) {
            list.add(i);
        }
        return list;
    }
}
