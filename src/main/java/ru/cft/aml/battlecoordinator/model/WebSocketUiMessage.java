package ru.cft.aml.battlecoordinator.model;

import java.util.ArrayList;

public class WebSocketUiMessage {

    private String type;

    private Integer playgroundID;

    private Integer value;

    private Integer x;

    private Integer y;

    private ArrayList<ArrayList<Integer>> cells;

    private String name;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPlaygroundID() {
        return playgroundID;
    }

    public void setPlaygroundID(Integer playgroundID) {
        this.playgroundID = playgroundID;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public ArrayList<ArrayList<Integer>> getCells() {
        return cells;
    }

    public void setCells(ArrayList<ArrayList<Integer>> cells) {
        this.cells = cells;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
