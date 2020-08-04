/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2020-2020. All rights reserved.
 * Note: 提供的缺省代码仅供参考，可自行根据答题需要进行使用、修改或删除。
 */

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

/**
 * OJ考题代码：最佳升级时间窗
 *
 * @author 命题组
 * @since 2020-4-21
 */
public class Main {

    private static final int WEEK_HOURS = 7 * 24;

    /**
     * main入口由OJ平台调用
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
        int pvErrorTolerance = Integer.parseInt(cin.nextLine());
        int[] pvByHourWeekly = new int[7 * 24];
        for (int i = 0; i < pvByHourWeekly.length; i++) {
            pvByHourWeekly[i] = cin.nextInt();
        }
        cin.close();
        int[] results = getBestTimeWindow(pvByHourWeekly, pvErrorTolerance);
        String[] strResult = Arrays.stream(results).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", strResult));
    }

    private static int[] getBestTimeWindow(int[] pvByHourWeekly, int pvErrorTolerance) {
        int left = 0;
        int right = -1;
        int maxStart = -1;
        int maxEnd = -1;
        int maxGap = 0;
        int currentGap = 0;
        int currentPvCount = 0;
        while (left < pvByHourWeekly.length) {
            right = (right + 1) % WEEK_HOURS;
            currentGap++;
            currentPvCount = currentPvCount + pvByHourWeekly[right];
            if (currentPvCount <= pvErrorTolerance && currentGap > maxGap) {
                if (currentGap == WEEK_HOURS) {
                    break;
                }
                maxGap = currentGap;
                maxStart = left;
                maxEnd = right;
                continue;
            }
            if (currentPvCount > pvErrorTolerance) {
                currentPvCount = currentPvCount - pvByHourWeekly[left];
                left++;
                currentGap--;
            }
        }
        return new int[]{maxStart, maxEnd};
    }
}
