package threads;

import model.RollerSkater;
import model.Trainer;

public class TrainerThread extends Thread{
    private final Trainer trainer;

    public TrainerThread(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public void run(){
        while (true) {
            int lapsTasked = randomNumber(1, 9);
            createTask(lapsTasked);
            try {
                sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void createTask(int lapsTasked) {
        RollerSkater rollerSkater = pickSkater();
        if (rollerSkater != null) {
            rollerSkater.setLapsLeft(lapsTasked);
            RollerSkaterThread rollerSkaterThread = new RollerSkaterThread(rollerSkater);
            rollerSkaterThread.start();
        }
    }

    private RollerSkater pickSkater() {
        for (RollerSkater rollerSkater : trainer.getRollerSkaters()) {
            if (rollerSkater.getLapsLeft() == 0){
                return rollerSkater;
            }
        }
        return null;
    }

    private int randomNumber(int minimum, int maximum){
        return (minimum + (int)(Math.random() * maximum));
    }
}
