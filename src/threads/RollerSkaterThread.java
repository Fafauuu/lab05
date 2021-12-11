package threads;

import model.RollerSkater;
import view.GraphicalInterface;
import view.GraphicalInterfaceImpl;

public class RollerSkaterThread extends Thread{
    private RollerSkater rollerSkater;
    private boolean stopCondition;
    GraphicalInterface gui = new GraphicalInterfaceImpl();

    public RollerSkaterThread(RollerSkater rollerSkater) {
        this.rollerSkater = rollerSkater;
    }

    @Override
    public void run(){
        stopCondition = false;
        rollerSkater.putOnTrack();

        while (rollerSkater.getLapsLeft() > 0){
            boolean moved = rollerSkater.move();
            if (moved) gui.printTrack();
            try {
                sleep(rollerSkater.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        rollerSkater.takeOffTrack();
    }

    public void setStopCondition(){
        this.stopCondition = true;
    }

}
