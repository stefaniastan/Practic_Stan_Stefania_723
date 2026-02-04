package org.example.model;

import org.example.repository.InFileRepository;

public class Fahrer implements InFileRepository.IdProvider {

    private int id;
    private String name;
    private String team;
    private FahrerStatus status;
    private int skillLevel;

    public Fahrer(){}

    public Fahrer(String name, String team, FahrerStatus status, int skillLevel){
        this.name = name;
        this.team = team;
        this.status = status;
        this.skillLevel = skillLevel;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public FahrerStatus getStatus() {
        return status;
    }

    public void setStatus(FahrerStatus status) {
        this.status = status;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }

    @Override
    public String toString() {
        return "Fahrer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", team='" + team + '\'' +
                ", status=" + status +
                ", skillLevel=" + skillLevel +
                '}';
    }
}
