package model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final Track instance = new Track();
    private final int size;
    private final List<TrackPosition> positions;

    private Track() {
        this.size = 16;
        positions = initialTrack();
    }

    private List<TrackPosition> initialTrack() {
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

    public List<TrackPosition> getTrackPositions() {
        return positions;
    }

    public String getNameOfPositionOccupier(int position){
        return positions.get(position).getPositionOccupier() == null
                ? "_"
                : positions.get(position).getPositionOccupier().toString();
    }

    public void releasePosition(int position){
        positions.get(position).ReleasePosition();
    }

    public void occupyPosition(int position, RollerSkater rollerSkater){
        positions.get(position).OccupyPosition(rollerSkater);
    }
}
