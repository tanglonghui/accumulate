package com.example.a11_calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.ChineseCalendar;
import android.icu.util.IndianCalendar;
import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.Locale;
/**
 * Diwali是印度最重要的节日之一，也被称为“光明节”。它在印度历中的日期是根据农历计算的，因此每年的具体日期都会有所不同。以下是2012年至2032年期间Diwali在印度历中的大致时间范围：
 *
 * 2012年：11月13日
 * 2013年：11月3日
 * 2014年：10月23日
 * 2015年：11月11日
 * 2016年：10月30日
 * 2017年：10月19日
 * 2018年：11月7日
 * 2019年：10月27日
 * 2020年：11月14日
 * 2021年：11月4日
 * 2022年：10月24日
 * 2023年：11月12日
 * 2024年：11月1日
 * 2025年：10月21日
 * 2026年：11月9日
 * 2027年：10月29日
 * 2028年：10月17日
 * 2029年：11月5日
 * 2030年：10月25日
 * 2031年：11月14日
 * 2032年：11月2日
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG ="Calendartest";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);

        // 计算排灯节的日期
        Calendar diwaliDate = Calendar.getInstance();
        diwaliDate.set(2024, 11, 1); // 设置为卡提克月的第一天
//        diwaliDate.add(Calendar.DATE, 14); // 加上14天，得到卡提克月的第15天

        // 显示排灯节的日期
        Log.d(TAG,"Diwali Date: " + diwaliDate.get(Calendar.DAY_OF_MONTH) + " " + getMonthName(diwaliDate.get(Calendar.MONTH)) + " " + diwaliDate.get(Calendar.YEAR));
        IndianCalendar indianCalendar = new IndianCalendar(new Locale("in"));
        indianCalendar.set(2024, 11, 1); // 设置为卡提克月的第一天
        indianCalendar.add(Calendar.DATE, 14); // 加上14天，得到卡提克月的第15天
        Log.e(TAG,"Diwali getType: "+indianCalendar.getType());
        Log.e(TAG,"Diwali getType: "+indianCalendar.getType());
        Log.e(TAG,"Diwali Date2: " + indianCalendar.get(Calendar.DAY_OF_MONTH) + " " + getMonthName(indianCalendar.get(Calendar.MONTH)) + " " + indianCalendar.get(Calendar.YEAR));

        ChineseCalendar chineseCalendar =new ChineseCalendar();
        Log.e(TAG,"chineseCalendar getType: "+chineseCalendar.getType());
//        Log.e(TAG,"chineseCalendar getType: "+chineseCalendar.);

        Calendar calendar1 = Calendar.getInstance();

        // 设置年份为当前年份
        int year1 = calendar.get(Calendar.YEAR);

        // 设置月份为农历正月
        calendar.set(year1, 0, 1);

        // 获取农历正月初一的日期
        int springFestivalDay = calendar.get(Calendar.DAY_OF_MONTH);

        // 输出结果
        Log.e(TAG,"每年春节的日期为：" + year + "年" + (calendar.get(Calendar.MONTH) + 1) + "月" + springFestivalDay + "日");
//        LunarToGregorian(null);
        test();
    }

    // 辅助函数，将月份转换为对应的名称
    private String getMonthName(int month) {
        String[] monthNames = {"January1", "February2", "March3", "April4", "May5", "June6", "July7", "August8", "September9", "October10", "November11", "December12"};
        return monthNames[month];
    }
    public void LunarToGregorian(Date date){
        Calendar cal;
        Calendar ccal;
        cal  = Calendar.getInstance();
        ccal  = new ChineseCalendar();

//        ccal.set(ChineseCalendar.EXTENDED_YEAR, Integer.parseInt("2024"));
//        ccal.set(ChineseCalendar.YEAR, Integer.parseInt("0"));
        ccal.set(ChineseCalendar.MONTH, Integer.parseInt("0"));
        ccal.set(ChineseCalendar.DAY_OF_MONTH, Integer.parseInt("1"));

        cal.setTimeInMillis(ccal.getTimeInMillis());
        Log.e(TAG,"cal.getTime()："+cal.getTime()+"-[]-"+cal.getTime().getYear()+","+cal.getTime().getMonth()+","+cal.getTime().getDay());

        Log.e(TAG,"cal.getTime()："+sdf.format(cal.getTime()));
        Log.e(TAG,"cal.getTime()："+sdf.format(ccal.getTime()));
    }

    public void test(){
        Calendar calendar =Calendar.getInstance();
        calendar.set(Calendar.MONTH,0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Log.e(TAG,"calendar："+sdf.format(calendar.getTime()));

        Calendar chineseCalendar =new ChineseCalendar();
//        chineseCalendar.set(ChineseCalendar.YEAR,2024-1984+2);
        chineseCalendar.set(ChineseCalendar.MONTH,0);
        chineseCalendar.set(ChineseCalendar.DAY_OF_MONTH, 1);
        Log.e(TAG,"chineseCalendar YEAR："+chineseCalendar.get(ChineseCalendar.YEAR));
        Log.e(TAG,"chineseCalendar EXTENDED_YEAR："+chineseCalendar.get(ChineseCalendar.EXTENDED_YEAR));
        Log.e(TAG,"chineseCalendar："+sdf.format(chineseCalendar.getTime()));

//        Date date=new Date(2024,11,1);
        Calendar indianCalendar =new IndianCalendar(new Locale("in"));
//        indianCalendar.set(IndianCalendar.YEAR,0);
//        indianCalendar.set(IndianCalendar.ERA,1);
        indianCalendar.set(IndianCalendar.MONTH,IndianCalendar.KARTIKA);
        indianCalendar.set(IndianCalendar.DAY_OF_MONTH, 10);
//        indianCalendar.setTime(date);
        Log.e(TAG,"indianCalendar ERA："+indianCalendar.get(IndianCalendar.ERA));
        Log.e(TAG,"indianCalendar YEAR："+indianCalendar.get(IndianCalendar.YEAR));
        Log.e(TAG,"indianCalendar EXTENDED_YEAR："+indianCalendar.get(IndianCalendar.EXTENDED_YEAR));
        Log.e(TAG,"indianCalendar："+sdf.format(indianCalendar.getTime()));
    }
}