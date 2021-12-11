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

    public synchronized void addRollerSkater(RollerSkater rollerSkater) {
        rollerSkaters.add(rollerSkater);
        notifyAll();
        System.out.println("notifying trainer");
    }

    public void removeRollerSkater(RollerSkater rollerSkater) {
        rollerSkaters.remove(rollerSkater);
    }

    public synchronized RollerSkater getFirstSkaterOnBench() {
        while (rollerSkaters.size() == 0){
            try {
                System.out.println("no one left on bench");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("someone is on bench");
        return rollerSkaters.get(0);
    }

    public void setRollerSkaters(List<RollerSkater> rollerSkaters) {
        this.rollerSkaters = rollerSkaters;
    }
}
