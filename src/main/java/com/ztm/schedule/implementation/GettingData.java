package com.ztm.schedule.implementation;

import com.ztm.schedule.model.Result;
import com.ztm.schedule.model.Value;

import java.util.ArrayList;
import java.util.List;

public class GettingData {

    private List<String> busStopIdList = new ArrayList<>();
    private List<String> linesList = new ArrayList<>();
    private List<String> timesList = new ArrayList<>();
    private List<String> directionList = new ArrayList<>();
    private List<Value> valuesList = new ArrayList<>();

    private ZtmImpl ztm;
    private String line;
    private String busStopNumber;
    private String busStopId;
    private String station;
    private String direction;

    public GettingData(){}

    public ZtmImpl getZtm() {
        return ztm;
    }

    public void setZtm(ZtmImpl ztm) {
        this.ztm = ztm;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getBusStopNumber() {
        return busStopNumber;
    }

    public void setBusStopNumber(String busStopNumber) {
        this.busStopNumber = busStopNumber;
    }

    public String getBusStopId() {
        return busStopId;
    }

    public void setBusStopId(String busStopId) {
        this.busStopId = busStopId;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getBusStopIdList() {
        return busStopIdList;
    }

    public void setBusStopIdList(List<String> busStopIdList) {
        this.busStopIdList = busStopIdList;
    }

    public List<String> getLinesList() {
        return linesList;
    }

    public void setLinesList(List<String> linesList) {
        this.linesList = linesList;
    }

    public List<String> getTimesList() {
        return timesList;
    }

    public void setTimesList(List<String> timesList) {
        this.timesList = timesList;
    }

    public List<String> getDirectionList() {
        return directionList;
    }

    public void setDirectionList(List<String> directionList) {
        this.directionList = directionList;
    }

    public void createBusStopIdList() {
        for (Result result : ztm.getBusStopId(station).getResults()) {
            for (Value value : result.getValues()) {
                if (value.getKey().equals("zespol")) {
                    busStopIdList.add(value.getValue());
                }
            }
        }
    }

    public void createTimesList() {
        for (String busStopId : busStopIdList) {

            for(String line: linesList){

            for (Result result : ztm.getTimes(busStopId, busStopNumber, line).getResults()) {
                for (Value value : result.getValues()) {
                    if (value.getKey().equals("czas")) {
                        timesList.add(value.getValue());
                    }
                }
            }
        }
        }
    }
    public void createLinesList() {

        for (String busStopId : busStopIdList) {

            for (Result result : ztm.getLines(busStopId, busStopNumber).getResults()) {
                for (Value value : result.getValues()) {
                    if (value.getKey().equals("linia")) {
                        linesList.add(value.getValue());
                    }
                }
            }
        }
    }

    public void createDirectionList(){
        for(String busStopId: busStopIdList){

            for (Result result: ztm.getTimes(busStopId,busStopNumber,line).getResults()) {
                for (Value value : result.getValues()) {
                    if (value.getKey().equals("kierunek")) {
                        directionList.add(value.getValue());
                    }
                }
            }
        }
    }

}

