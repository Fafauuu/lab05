package model;

public class Gate {
    private RollerSkater gateOccupier;

    public Gate() {
        gateOccupier = null;
    }

    public synchronized void OccupyGate(RollerSkater rollerSkater) {
        while (gateOccupier != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gateOccupier = rollerSkater;
    }

    public synchronized void ReleaseGate() {
        gateOccupier = null;
        notifyAll();
    }

    public RollerSkater getGateOccupier() {
        return gateOccupier;
    }
}
