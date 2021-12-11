package threads;

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
        while (true) {
            int lapsTasked = randomNumber(1, 1);
            trainer.setLapsToTask(lapsTasked);
            trainer.setSkaterToTask(null);
            sleepFor(2000);
            RollerSkater rollerSkater = pickSkater();
            sleepFor(2000);
            boolean taskCreated = createTask(lapsTasked, rollerSkater);
            if (taskCreated){
                trainer.setLapsToTask(-1);
            }
            sleepFor(500);
        }
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
        if (Bench.getInstance().getRollerSkaters().size() != 0){
            firstRollerSkaterOnBench = Bench.getInstance().getRollerSkaters().get(0);
        } else firstRollerSkaterOnBench = null;
        if (firstRollerSkaterOnBench != null) {
            trainer.setSkaterToTask(firstRollerSkaterOnBench);
            return firstRollerSkaterOnBench;
        }
        return null;
    }

    private boolean createTask(int lapsTasked, RollerSkater rollerSkater) {
        if (rollerSkater != null) {
            rollerSkater.setLapsLeft(lapsTasked);
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
