package com.psbc.canteen.voucher.web.config;


import com.psbc.canteen.common.utils.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <pre>
 * 功       能: 定时任务
 * 涉及版本: V1.0.0
 * 创  建  者: zhangdd
 * 日       期: 2018年08月06日下午17:08:57
 * Q    Q: 540461328
 * </pre>
 */
//@Configuration
@EnableScheduling
public class PlanQuartzConfig {
    private final static Logger log = LoggerFactory.getLogger(PlanQuartzConfig.class);

    /**
     * 根据cron表达式格式触发定时任务
     *  cron表达式格式:
     *      1.Seconds Minutes Hours DayofMonth Month DayofWeek Year
     *      2.Seconds Minutes Hours DayofMonth Month DayofWeek
     *  顺序:
     *      秒（0~59）
     *      分钟（0~59）
     *      小时（0~23）
     *      天（月）（0~31，但是你需要考虑你月的天数）
     *      月（0~11）
     *      天（星期）（1~7 1=SUN 或 SUN，MON，TUE，WED，THU，FRI，SAT）
     *      年份（1970－2099）
     *
     *  注:其中每个元素可以是一个值(如6),一个连续区间(9-12),一个间隔时间(8-18/4)(/表示每隔4小时),一个列表(1,3,5),通配符。
     *  由于"月份中的日期"和"星期中的日期"这两个元素互斥的,必须要对其中一个设置?.
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled(){
        log.info("cron定时任务scheduled开始执行"+System.currentTimeMillis());


        log.info("cron定时任务scheduled结束执行"+System.currentTimeMillis());
    }


    @Scheduled(cron = "0/10 * * * * *")
    public void scheduled1(){
        log.info("cron定时任务scheduled1开始执行"+ DateUtils.getSysStringTime());


        log.info("cron定时任务scheduled1结束执行"+DateUtils.getSysStringTime());
    }

    /**
     * 每隔5秒执行一次
     */
   /* @Scheduled(fixedRate = 5000)
    public void scheduled1() {
        log.info("fixedRate定时任务开始执行"+System.currentTimeMillis());


        log.info("fixedRate定时任务结束执行"+System.currentTimeMillis());
    }*/

    /**
     * 每隔5秒执行一次
     */
    /*@Scheduled(fixedDelay = 5000)
    public void scheduled2() {
        log.info("fixedDelay定时任务开始执行"+System.currentTimeMillis());


        log.info("fixedDelay定时任务结束执行"+System.currentTimeMillis());
    }*/
}
