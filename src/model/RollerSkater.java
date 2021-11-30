package model;

public class RollerSkater {
    private String name;
    private int lapsLeft;
    private boolean onTrack;
    private int position;

    public RollerSkater(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getLapsLeft() {
        return lapsLeft;
    }

    public void setLapsLeft(int lapsLeft) {
        this.lapsLeft = lapsLeft;
    }

    public boolean isOnTrack() {
        return onTrack;
    }

    public void putOnTrack() {
        onTrack = true;
        position = 0;
        Track.getInstance().getPositionsOccupied().set(position, name);
    }

    public void takeOffTrack() {
        onTrack = false;
        position = -1;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        Track track = Track.getInstance();
        int nextPosition = position + 1;
        if (nextPosition == track.getSize()){
            nextPosition = 0;
        }
        if (track.getPositionsOccupied().get(nextPosition) == "_"){
            track.releasePosition(position);
            track.occupyPosition(nextPosition, name);
            position = nextPosition;
        }
    }
}
