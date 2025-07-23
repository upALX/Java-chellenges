package com.challenges.elevator;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ElevatorUsageRecord {

    @JsonProperty("andar")
    private int floor;

    @JsonProperty("elevador")
    private char elevator;

    @JsonProperty("turno")
    private String shift;

    public ElevatorUsageRecord() {
        // construtor padrão porque o Jackson precisa
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public char getElevator() {
        return elevator;
    }

    public void setElevator(char elevator) {
        this.elevator = elevator;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }
}


