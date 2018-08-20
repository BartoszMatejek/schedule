package com.ztm.schedule.implementation;

import com.ztm.schedule.client.ZtmClient;

public class ZtmImpl implements ZtmClient{
    
    private static String apiKey = "&apikey=d6361ada-beac-4c41-909a-3f261817b25e";

    public String getStops(String busStopId, String busStopNumber, String line) {
        String url = "https://api.um.warszawa.pl/api/action/dbtimetable_get?id=e923fa0e-d96c-43f9-ae6e60518c9f3238&busstopId="+busStopId+"&busstopNr="+busStopNumber+
                "&line="+line;
        String finalUrl = url+apiKey;

        return finalUrl;
    }

    public String getLines(String busStopId, String busStopNumber) {
        String url = "https://api.um.warszawa.pl/api/action/dbtimetable_get?id=88cd555f-6f31-43ca-9de466c479ad5942&busstopId="+busStopId+"&busstopNr="+busStopNumber;
        String finalUrl = url+busStopId+busStopNumber+apiKey;

        return finalUrl;
    }

    public String getBusStopId(String name) {
        String url = "https://api.um.warszawa.pl/api/action/dbtimetable_get?id=b27f4c17-5c50-4a5b-89dd236b282bc499&name=";
        String finalUrl = url+name+apiKey;

        return finalUrl;
    }
}
