package model;

public class Trainer {
    private int lapsToTask = -1;
    private RollerSkater skaterToTask;

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
