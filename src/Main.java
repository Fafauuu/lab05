import controller.Controller;
import database.Database;
import model.RollerSkater;
import model.Trainer;

public class Main {

    public static void main(String[] args) {
        Database database = new Database();
        initializeData(database);

        Controller controller = new Controller(database);
        controller.simulate();
    }

    private static void initializeData(Database database) {
        database.addRollerSkater(new RollerSkater("a"));
        database.addRollerSkater(new RollerSkater("b"));
        database.addRollerSkater(new RollerSkater("c"));
        database.addRollerSkater(new RollerSkater("d"));
        database.addRollerSkater(new RollerSkater("e"));
        for (RollerSkater rollerSkater : database.getRollerSkaters()) {
            System.out.println(rollerSkater.getName() + " speed: " + rollerSkater.getSpeed());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        database.setTrainer(new Trainer(database.getRollerSkaters()));
    }
}
