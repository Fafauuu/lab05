package model;

public class RollerSkater {
    private String name;
    private int speed;
    private boolean onTrack;
    private int lapsLeft;
    private int position;

    public RollerSkater(String name) {
        this.name = name;
        this.speed = randomNumber(0,1000);
    }

    public void putOnTrack() {
        onTrack = true;
        position = 0;
        Track.getInstance().getTrackPositions().get(position).OccupyPosition(this);
        Bench.getInstance().removeRollerSkater(this);
    }

    public void takeOffTrack() {
        onTrack = false;
        Track.getInstance().getTrackPositions().get(position).ReleasePosition();
        position = -1;
        Bench.getInstance().addRollerSkater(this);
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
        track.occupyPosition(nextPosition, this);
        track.releasePosition(position);
        position = nextPosition;
        if (position == 0){
            lapsLeft--;
        }
    }

    private int randomNumber(int min, int max){
        return (min + (int)(Math.random() * ((max - min) + 1)));
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOnTrack() {
        return onTrack;
    }

    public int getLapsLeft() {
        return lapsLeft;
    }

    public void setLapsLeft(int lapsLeft) {
        this.lapsLeft = lapsLeft;
    }

    @Override
    public String toString() {
        return name;
    }
}
