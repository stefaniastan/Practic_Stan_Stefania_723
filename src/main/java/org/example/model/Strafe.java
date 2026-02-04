package org.example.model;

import org.example.repository.InFileRepository;

public class Strafe implements InFileRepository.IdProvider {
    private int id;
    private int fahrerId;
    private StrafeGrund grund;
    private int seconds;
    private int lap;

    public Strafe(){}

    public Strafe(int fahrerId, StrafeGrund grund,  int seconds, int lap){
        this.fahrerId = fahrerId;
        this.grund = grund;
        this.seconds = seconds;
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

    public StrafeGrund getGrund() {
        return grund;
    }

    public void setGrund(StrafeGrund grund) {
        this.grund = grund;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getLap() {
        return lap;
    }

    public void setLap(int lap) {
        this.lap = lap;
    }

    @Override
    public String toString() {
        return "Strafe{" +
                "id=" + id +
                ", fahrerId=" + fahrerId +
                ", strafeGrund=" + grund +
                ", seconds=" + seconds +
                ", lap=" + lap +
                '}';
    }
}
