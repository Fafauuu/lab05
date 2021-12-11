package controller;

import database.Database;
import threads.TrainerThread;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public void simulate() {
        TrainerThread trainerThread = new TrainerThread(database.getTrainer());
        trainerThread.run();
    }
}
