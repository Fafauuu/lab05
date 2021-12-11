package view;

import model.Track;

public class GraphicalInterfaceImpl implements GraphicalInterface{
    @Override
    public void printTrack() {
        Track track = Track.getInstance();
        String trainer = "t?#";
        StringBuilder sb = new StringBuilder();
        sb.append(trainer);
        sb.append("\n");
        sb.append(track.getNameOfPositionOccupier(15));
        sb.append(" ");
        for (int i = 0; i < 5; i++) {
            if (i == 0){
                sb.append(track.getNameOfPositionOccupier(i));
                sb.append(" ");
                continue;
            }
            sb.append(track.getNameOfPositionOccupier(i));
            sb.append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                sb.append(track.getNameOfPositionOccupier(14));
                sb.append(" ");
                continue;
            }
            if (i == 5){
                sb.append(track.getNameOfPositionOccupier(5));
                sb.append(" ");
                continue;
            }
            sb.append("  ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                sb.append(track.getNameOfPositionOccupier(13));
                sb.append(" ");
                continue;
            }
            if (i == 5){
                sb.append(track.getNameOfPositionOccupier(6));
                sb.append(" ");
                continue;
            }
            sb.append("  ");
        }
        sb.append("\n");
        for (int i = 12; i > 6; i--) {
            sb.append(track.getNameOfPositionOccupier(i));
            sb.append(" ");
        }
        sb.append("\n\n");
        System.out.println(sb);
    }
}
