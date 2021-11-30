package threads;

import model.RollerSkater;
import model.Track;
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

        while (!stopCondition){
            gui.printTrack();
            rollerSkater.move();
            try {
                sleep(2000);
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
