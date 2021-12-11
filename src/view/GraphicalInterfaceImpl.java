package view;

import database.Database;
import model.RollerSkater;
import model.Track;
import model.Trainer;

public class GraphicalInterfaceImpl implements GraphicalInterface{
    @Override
    public void printTrack() {
        Track track = Track.getInstance();
        Trainer trainer = Database.getInstance().getTrainer();
        StringBuilder sb = new StringBuilder();
        sb.append(trainer);
        if (trainer.getLapsToTask() != -1){
            sb.append(trainer.getLapsToTask());
        } else sb.append("?");
        if (trainer.getSkaterToTask() != null){
            sb.append(trainer.getSkaterToTask());
        } else sb.append("#");
        sb.append("\n\n");

        for (RollerSkater rollerSkater : Database.getInstance().getRollerSkaters()) {
            sb.append(rollerSkater);
            sb.append(rollerSkater.getLapsLeft());
            sb.append(" ");
        }
        sb.append("\n\n");

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
