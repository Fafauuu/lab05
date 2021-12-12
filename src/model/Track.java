package model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final Track instance = new Track();
    private final int size;
    private final List<TrackPosition> positions;
    private final Gate entranceGate;
    private final Gate exitGate;

    private Track() {
        this.size = 16;
        positions = initializeTrack();
        entranceGate = new Gate();
        exitGate = new Gate();
    }

    private List<TrackPosition> initializeTrack() {
        List<TrackPosition> positionsOccupiedList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            positionsOccupiedList.add(new TrackPosition());
        }
        return positionsOccupiedList;
    }

    public static Track getInstance(){
        return instance;
    }

    public int getSize() {
        return size;
    }

    public synchronized List<TrackPosition> getTrackPositions() {
        return positions;
    }

    public Gate getEntranceGate() {
        return entranceGate;
    }

    public Gate getExitGate() {
        return exitGate;
    }

    public String getNameOfPositionOccupier(int position){
        return positions.get(position).getPositionOccupier() == null
                ? "_"
                : positions.get(position).getPositionOccupier().toString();
    }
}
