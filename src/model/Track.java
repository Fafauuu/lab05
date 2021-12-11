package model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final Track instance = new Track();
    private final int size;
    private final List<RollerSkater> positionsOccupied;

    private Track() {
        this.size = 16;
        positionsOccupied = initialTrack();
    }

    private List<RollerSkater> initialTrack() {
        List<RollerSkater> positionsOccupiedList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            positionsOccupiedList.add(null);
        }
        return positionsOccupiedList;
    }

    public static Track getInstance(){
        return instance;
    }

    public int getSize() {
        return size;
    }

    public List<RollerSkater> getPositionsOccupied() {
        return positionsOccupied;
    }

    public String getNameOfPositionOccupier(int position){
        return positionsOccupied.get(position) == null ? "_" : positionsOccupied.get(position).toString();
    }

    public void releasePosition(int position){
        positionsOccupied.set(position, null);
    }

    public void occupyPosition(int position, RollerSkater skaterName){
        positionsOccupied.set(position, skaterName);
    }
}
