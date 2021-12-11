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
        trackObserver.trackChanged();

        while (!(rollerSkater.getLapsLeft() == 0 && rollerSkater.getPosition() == 3)){
            try {
                sleep(1500 - rollerSkater.getSpeed());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            boolean moved = rollerSkater.move();
//            if (moved && trackObserver != null) {
//                trackObserver.trackChanged();
//            }
            rollerSkater.move();
            trackObserver.trackChanged();
        }

        rollerSkater.takeOffTrack();
    }

    public void setTrackObserver(TrackObserver trackObserver) {
        this.trackObserver = trackObserver;
    }
}
