package threads;

import model.Bench;
import model.RollerSkater;
import model.Track;
import view.TrackObserver;

public class RollerSkaterThread extends Thread{
    private TrackObserver trackObserver;
    private final RollerSkater rollerSkater;

    public RollerSkaterThread(RollerSkater rollerSkater) {
        this.rollerSkater = rollerSkater;
    }

    @Override
    public void run(){
        goToEntranceGate();
        goOnTrack();
        driveOnTheTrack();
        goToExitGate();
        goOnBench();
    }

    private void driveOnTheTrack() {
        while (!(rollerSkater.getLapsLeft() == 0 && rollerSkater.getPosition() == 3)){
            sleepRelatedToSpeed();
            rollerSkater.move();
            trackObserver.trackChanged();
        }
    }

    private void goToEntranceGate() {
        Track.getInstance().getEntranceGate().OccupyGate(rollerSkater);
        trackObserver.gatesChanged();
        sleepRelatedToSpeed();
    }

    private void goOnTrack() {
        rollerSkater.putOnTrack();
        Track.getInstance().getEntranceGate().ReleaseGate();
        trackObserver.gatesChanged();
    }

    private void goToExitGate() {
        sleepRelatedToSpeed();
        Track.getInstance().getExitGate().OccupyGate(rollerSkater);
        trackObserver.gatesChanged();
        rollerSkater.takeOffTrack();
        trackObserver.trackChanged();
    }

    private void goOnBench() {
        sleepRelatedToSpeed();
        Track.getInstance().getExitGate().ReleaseGate();
        Bench.getInstance().addRollerSkater(rollerSkater);
        trackObserver.gatesChanged();
        trackObserver.trackChanged();
    }

    private void sleepRelatedToSpeed() {
        try {
            sleep(2000 - rollerSkater.getSpeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setTrackObserver(TrackObserver trackObserver) {
        this.trackObserver = trackObserver;
    }
}
