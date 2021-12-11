package model;

import java.util.List;

public class Bench {
    private static final Bench instance = new Bench();
    private List<RollerSkater> rollerSkaters;

    private Bench() {
    }

    public static Bench getInstance() {
        return instance;
    }

    public void addRollerSkater(RollerSkater rollerSkater) {
        rollerSkaters.add(rollerSkater);
    }

    public void removeRollerSkater(RollerSkater rollerSkater) {
        rollerSkaters.remove(rollerSkater);
    }

    public List<RollerSkater> getRollerSkaters() {
        return rollerSkaters;
    }

    public void setRollerSkaters(List<RollerSkater> rollerSkaters) {
        this.rollerSkaters = rollerSkaters;
    }
}
