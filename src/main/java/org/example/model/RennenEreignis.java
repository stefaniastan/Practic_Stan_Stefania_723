package org.example.model;

import org.example.repository.InFileRepository;

public class RennenEreignis implements InFileRepository.IdProvider {
    private int id;
    private int fahrerId;
    private EreignisTyp typ;
    private int basePoints;
    private int lap;

    public RennenEreignis() {}

    public RennenEreignis(int fahrerId, EreignisTyp typ, int basePoints, int lap) {
        this.id = id;
        this.fahrerId = fahrerId;
        this.typ = typ;
        this.basePoints = basePoints;
        this.lap = lap;
    }
    @Override
    public Integer getId() {
        return id;
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getFahrerId() {
        return fahrerId;
    }

    public void setFahrerId(int fahrerId) {
        this.fahrerId = fahrerId;
    }

    public EreignisTyp getTyp() {
        return typ;
    }

    public void setTyp(EreignisTyp typ) {
        this.typ = typ;
    }

    public int getBasePoints() {
        return basePoints;
    }

    public void setBasePoints(int basePoints) {
        this.basePoints = basePoints;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "RennenEreignis{" +
                "id=" + id +
                ", fahrerId=" + fahrerId +
                ", typ=" + typ +
                ", basePoints=" + basePoints +
                ", lap=" + lap +
                '}';
    }
}
