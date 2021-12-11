package model;

public class RollerSkater {
    private String name;
    private int speed;
    private int lapsLeft;
    private boolean onTrack;
    private int position;

    public RollerSkater(String name) {
        this.name = name;
        this.speed = randomNumber(500,2000);
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
        Track.getInstance().getPositionsOccupied().set(position, this);
    }

    public void takeOffTrack() {
        onTrack = false;
        position = -1;
    }

    public int getPosition() {
        return position;
    }

    public boolean move() {
        Track track = Track.getInstance();
        int nextPosition = position + 1;
        if (nextPosition == track.getSize()){
            nextPosition = 0;
        }
        if (track.getPositionsOccupied().get(nextPosition) == null){
            track.releasePosition(position);
            track.occupyPosition(nextPosition, this);
            position = nextPosition;
            return true;
        } else {
            return false;
        }
    }

    private int randomNumber(int minimum, int maximum){
        return (minimum + (int)(Math.random() * maximum));
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return name;
    }
}
