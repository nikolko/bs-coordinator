package ru.cft.aml.battlecoordinator.data;


import javax.persistence.*;

@Entity
@Table(name = "players")
public class PlayerEntity {

    @Id
    @GeneratedValue
    @Column(name = "Id", nullable = false)
    private Long id;

    private Integer penaltyCount;

    private Integer uiId;

    private String addr;


    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPenaltyCount() {
        return penaltyCount;
    }

    public void setPenaltyCount(Integer penaltyCount) {
        this.penaltyCount = penaltyCount;
    }

    public Integer getUiId() {
        return uiId;
    }

    public void setUiId(Integer uiId) {
        this.uiId = uiId;
    }
}
