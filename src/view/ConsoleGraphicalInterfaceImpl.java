package view;

import database.Database;
import model.RollerSkater;
import model.Track;
import model.Trainer;

public class ConsoleGraphicalInterfaceImpl implements GraphicalInterface{
    @Override
    public void updateTrack() {
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
        sb.append("\n");

        for (RollerSkater rollerSkater : Database.getInstance().getRollerSkaters()) {
            sb.append(rollerSkater);
            sb.append(rollerSkater.getLapsLeft());
            sb.append(" ");
        }
        sb.append("\n");

        sb.append(" v");
        if (Track.getInstance().getEntranceGate().getGateOccupier() == null){
            sb.append("_");
        } else sb.append(Track.getInstance().getEntranceGate().getGateOccupier());
        sb.append("    ^");
        if (Track.getInstance().getExitGate().getGateOccupier() == null){
            sb.append("_");
        } else sb.append(Track.getInstance().getExitGate().getGateOccupier());
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

    @Override
    public void updateGates() {
        updateTrack();
    }

    @Override
    public void updateTrainer() {
        updateTrack();
    }
}
