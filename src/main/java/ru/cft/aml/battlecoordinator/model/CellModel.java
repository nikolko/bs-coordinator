package ru.cft.aml.battlecoordinator.model;

public class CellModel {

    private Integer x;

    private Integer y;

    public CellModel(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public CellModel() {
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
}
