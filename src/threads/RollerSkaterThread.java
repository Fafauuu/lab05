package threads;

import model.RollerSkater;
import view.TrackObserver;

public class RollerSkaterThread extends Thread{
    private TrackObserver trackObserver;
    private RollerSkater rollerSkater;

    public RollerSkaterThread(RollerSkater rollerSkater) {
        this.rollerSkater = rollerSkater;
    }

    @Override
    public void run(){
        rollerSkater.putOnTrack();

        while (!(rollerSkater.getLapsLeft() == 0 && rollerSkater.getPosition() == 3)){
            boolean moved = rollerSkater.move();
            if (moved && trackObserver != null) {
                trackObserver.trackChanged();
            }
            try {
                sleep(1500 - rollerSkater.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        rollerSkater.takeOffTrack();
    }

    public void setTrackObserver(TrackObserver trackObserver) {
        this.trackObserver = trackObserver;
    }
}
