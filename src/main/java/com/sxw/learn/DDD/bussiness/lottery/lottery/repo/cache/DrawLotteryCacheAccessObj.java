
package com.sxw.learn.DDD.bussiness.lottery.lottery.repo.cache;

import com.sxw.learn.DDD.bussiness.lottery.lottery.domain.aggregate.DrawLottery;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>描述：抽奖缓存对象</b> <br/>
 *
 */
public class DrawLotteryCacheAccessObj {

    private static final Map<Integer, DrawLottery> DRAW_LOTTERY_CACHE = new HashMap<>();

    public DrawLottery get(Integer lotteryId) {
        return DRAW_LOTTERY_CACHE.get(lotteryId);
    }

    public void add(Integer lotteryId, DrawLottery drawLottery) {
        DRAW_LOTTERY_CACHE.put(lotteryId, drawLottery);
    }
}