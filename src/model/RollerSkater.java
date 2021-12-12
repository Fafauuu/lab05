package model;

import exceptions.InvalidNameException;

public class RollerSkater {
    private final String name;
    private final int speed;
    private int lapsLeft;
    private int position;
    private int sessionsAccomplished;

    public RollerSkater(String name) {
        if (name.length() > 1) throw new InvalidNameException("Roller skater name: " + name + " is too long");
        this.name = name;
        this.speed = randomNumber(0,1000);
    }

    public void putOnTrack() {
        position = 0;
        Track.getInstance().getTrackPositions().get(position).OccupyPosition(this);
    }

    public void takeOffTrack() {
        Track.getInstance().getTrackPositions().get(position).ReleasePosition();
        sessionsAccomplished++;
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
        track.getTrackPositions().get(nextPosition).OccupyPosition(this);
        track.getTrackPositions().get(position).ReleasePosition();
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

    public int getLapsLeft() {
        return lapsLeft;
    }

    public void setLapsLeft(int lapsLeft) {
        this.lapsLeft = lapsLeft;
    }

    public int getSessionsAccomplished() {
        return sessionsAccomplished;
    }

    @Override
    public String toString() {
        return name;
    }
}
