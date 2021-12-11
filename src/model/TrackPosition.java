package model;

public class TrackPosition {
    private RollerSkater positionOccupier;

    public TrackPosition() {
        positionOccupier = null;
    }

    public synchronized void OccupyPosition(RollerSkater rollerSkater) {
        while (positionOccupier != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        positionOccupier = rollerSkater;
    }

    public synchronized void ReleasePosition() {
        positionOccupier = null;
        notifyAll();
    }

    public RollerSkater getPositionOccupier() {
        return positionOccupier;
    }
}
