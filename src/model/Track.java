package model;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final Track instance = new Track();
    private final int size;
    private final List<String> positionsOccupied;

    private Track() {
        this.size = 16;
        positionsOccupied = initialTrack();
    }

    private List<String> initialTrack() {
        List<String> positionsOccupiedList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            positionsOccupiedList.add("_");
        }
        return positionsOccupiedList;
    }

    public static Track getInstance(){
        return instance;
    }

    public int getSize() {
        return size;
    }

    public List<String> getPositionsOccupied() {
        return positionsOccupied;
    }

    public void releasePosition(int position){
        positionsOccupied.set(position, "_");
    }

    public void occupyPosition(int position, String skaterName){
        positionsOccupied.set(position, skaterName);
    }
}
