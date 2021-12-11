package model;

import java.util.List;

public class Trainer {
    private List<RollerSkater> rollerSkaters;
    private int lapsToTask = -1;
    private RollerSkater skaterToTask;

    public Trainer(List<RollerSkater> rollerSkaters) {
        this.rollerSkaters = rollerSkaters;
    }

    public List<RollerSkater> getRollerSkaters() {
        return rollerSkaters;
    }

    public int getLapsToTask() {
        return lapsToTask;
    }

    public RollerSkater getSkaterToTask() {
        return skaterToTask;
    }

    public void setLapsToTask(int lapsToTask) {
        this.lapsToTask = lapsToTask;
    }

    public void setSkaterToTask(RollerSkater skaterToTask) {
        this.skaterToTask = skaterToTask;
    }

    @Override
    public String toString() {
        return "t";
    }
}
