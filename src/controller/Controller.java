package controller;

import database.Database;
import model.Bench;
import model.RollerSkater;
import threads.TrainerThread;
import view.GraphicalInterface;
import view.TrackObserver;

import java.util.ArrayList;
import java.util.List;

public class Controller implements TrackObserver {
    private final Database database;
    private final GraphicalInterface graphicalInterface;

    public Controller(GraphicalInterface graphicalInterface) {
        database = Database.getInstance();
        this.graphicalInterface = graphicalInterface;
    }

    public void simulate() {
        for (RollerSkater rollerSkater : database.getRollerSkaters()) {
            System.out.println(rollerSkater.getName() + " speed: " + rollerSkater.getSpeed());
        }
        List<RollerSkater> rollerSkaters = new ArrayList<>(Database.getInstance().getRollerSkaters());
        Bench.getInstance().setRollerSkaters(rollerSkaters);
        trackChanged();
        createTrainerThread();
    }

    private void createTrainerThread() {
        TrainerThread trainerThread = new TrainerThread(database.getTrainer());
        trainerThread.setTrackObserver(this);
        trainerThread.start();
    }

    @Override
    public void trackChanged() {
        try {
            graphicalInterface.updateTrack();
        } catch (NullPointerException e){}
    }

    @Override
    public void gatesChanged() {
        graphicalInterface.updateGates();
    }

    @Override
    public void trainerLabelChanged() {
        graphicalInterface.updateTrainer();
    }
}
