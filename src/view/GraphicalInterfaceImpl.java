package view;

import model.Track;

public class GraphicalInterfaceImpl implements GraphicalInterface{
    @Override
    public void printTrack() {
        Track track = Track.getInstance();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            if (i == 0){
                sb.append(track.getPositionsOccupied().get(i));
                sb.append(" ");
                continue;
            }
            sb.append(track.getPositionsOccupied().get(track.getSize() - i));
            sb.append(" ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                sb.append(track.getPositionsOccupied().get(1));
                sb.append(" ");
                continue;
            }
            if (i == 5){
                sb.append(track.getPositionsOccupied().get(10));
                sb.append(" ");
                continue;
            }
            sb.append("  ");
        }
        sb.append("\n");
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                sb.append(track.getPositionsOccupied().get(2));
                sb.append(" ");
                continue;
            }
            if (i == 5){
                sb.append(track.getPositionsOccupied().get(9));
                sb.append(" ");
                continue;
            }
            sb.append("  ");
        }
        sb.append("\n");
        for (int i = 3; i < 9; i++) {
            sb.append(track.getPositionsOccupied().get(i));
            sb.append(" ");
        }
        sb.append("\n\n");
        System.out.println(sb);
    }
}
