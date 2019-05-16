package ru.cft.aml.battlecoordinator.model;

public class DamageData {

    private Integer x;

    private Integer y;

    private Boolean shooted;

    private Boolean killed;

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

    public Boolean getShooted() {
        return shooted;
    }

    public void setShooted(Boolean shooted) {
        this.shooted = shooted;
    }

    public Boolean getKilled() {
        return killed;
    }

    public void setKilled(Boolean killed) {
        this.killed = killed;
    }
}
