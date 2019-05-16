package ru.cft.aml.battlecoordinator.model;

import java.util.List;

public class InitialRequest {

    private List<CellModel> zeroList;

    private List<CellModel> firstList;


    public List<CellModel> getZeroList() {
        return zeroList;
    }

    public void setZeroList(List<CellModel> zeroList) {
        this.zeroList = zeroList;
    }

    public List<CellModel> getFirstList() {
        return firstList;
    }

    public void setFirstList(List<CellModel> firstList) {
        this.firstList = firstList;
    }
}
