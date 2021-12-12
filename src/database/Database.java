package database;

import model.RollerSkater;
import model.Trainer;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private static final Database instance = new Database();
    private final List<RollerSkater> rollerSkaters;
    private Trainer trainer;

    private Database() {
        rollerSkaters = new ArrayList<>();
    }

    public static Database getInstance() {
        return instance;
    }

    public List<RollerSkater> getRollerSkaters() {
        return rollerSkaters;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public void addRollerSkater(RollerSkater rollerSkater) {
        rollerSkaters.add(rollerSkater);
    }
}
