package com.ztm.schedule.client;

public interface ZtmClient {

    public Object getStops(String busStopId, String busStopNumber, String line);

    public Object getLines(String busStopId, String busStopNumber);

    public Object getBusStopId(String name);
}
