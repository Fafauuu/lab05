package threads;

import database.Database;
import model.Bench;
import model.RollerSkater;
import model.Trainer;
import view.TrackObserver;

public class TrainerThread extends Thread{
    private TrackObserver trackObserver;
    private final Trainer trainer;

    public TrainerThread(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void run(){
        while (!stopCondition()) {
            int lapsTasked = randomNumber(1, 9);
            trainer.setLapsToTask(lapsTasked);
            trackObserver.trainerLabelChanged();
            sleepFor(2000);
            RollerSkater rollerSkater = pickSkater();
            sleepFor(2000);
            boolean taskCreated = createTask(lapsTasked, rollerSkater);
            if (taskCreated){
                trainer.setLapsToTask(-1);
                trainer.setSkaterToTask(null);
            }
            sleepFor(500);
        }
    }

    private boolean stopCondition() {
        for (RollerSkater rollerSkater : Database.getInstance().getRollerSkaters()) {
            if (rollerSkater.getSessionsAccomplished() < 3){
                return false;
            }
        }
        return true;
    }

    private void sleepFor(int i) {
        try {
            sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private RollerSkater pickSkater() {
        RollerSkater firstRollerSkaterOnBench;
        firstRollerSkaterOnBench = Bench.getInstance().getFirstSkaterOnBench();
        if (firstRollerSkaterOnBench != null) {
            trainer.setSkaterToTask(firstRollerSkaterOnBench);
            trackObserver.trainerLabelChanged();
            return firstRollerSkaterOnBench;
        }
        return null;
    }

    private boolean createTask(int lapsTasked, RollerSkater rollerSkater) {
        if (rollerSkater != null) {
            rollerSkater.setLapsLeft(lapsTasked);
            Bench.getInstance().removeRollerSkater(rollerSkater);
            RollerSkaterThread rollerSkaterThread = new RollerSkaterThread(rollerSkater);
            rollerSkaterThread.setTrackObserver(trackObserver);
            rollerSkaterThread.start();
            return true;
        }
        else return false;
    }

    private int randomNumber(int min, int max){
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }

    public void setTrackObserver(TrackObserver trackObserver) {
        this.trackObserver = trackObserver;
    }
}
