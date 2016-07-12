package com.xu.hasee.livewhere.home.hotel_detile.hotel_info;

/**
 * Created by hasee on 2016/5/17.
 */
public class MyEntity_traffic {
    private String distance_km;
    private String time_minute;
    private String dayPrice_yuan;
    private String traffic_name;

    public MyEntity_traffic() {
    }

    public MyEntity_traffic(String distance_km, String time_minute, String dayPrice_yuan, String traffic_name) {
        this.distance_km = distance_km;
        this.time_minute = time_minute;
        this.dayPrice_yuan = dayPrice_yuan;
        this.traffic_name = traffic_name;
    }

    public String getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(String distance_km) {
        this.distance_km = distance_km;
    }

    public String getTime_minute() {
        return time_minute;
    }

    public void setTime_minute(String time_minute) {
        this.time_minute = time_minute;
    }

    public String getDayPrice_yuan() {
        return dayPrice_yuan;
    }

    public void setDayPrice_yuan(String dayPrice_yuan) {
        this.dayPrice_yuan = dayPrice_yuan;
    }

    public String getTraffic_name() {
        return traffic_name;
    }

    public void setTraffic_name(String traffic_name) {
        this.traffic_name = traffic_name;
    }
}
