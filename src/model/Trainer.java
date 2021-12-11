package model;

import java.util.List;

public class Trainer {
    private List<RollerSkater> rollerSkaters;
    private int lapsToTask;

    public Trainer(List<RollerSkater> rollerSkaters) {
        this.rollerSkaters = rollerSkaters;
    }

    public int getLapsToTask() {
        return lapsToTask;
    }

    public List<RollerSkater> getRollerSkaters() {
        return rollerSkaters;
    }
}
