import controller.Controller;
import database.Database;
import model.RollerSkater;
import model.Trainer;
import view.GraphicalInterface;
import view.GraphicalInterfaceImpl;

public class Main {

    public static void main(String[] args) {
        initializeData(Database.getInstance());

        GraphicalInterface graphicalInterface = new GraphicalInterfaceImpl();

        Controller controller = new Controller(graphicalInterface);
        controller.simulate();
    }

    private static void initializeData(Database database) {
        database.addRollerSkater(new RollerSkater("a"));
        database.addRollerSkater(new RollerSkater("b"));
        database.addRollerSkater(new RollerSkater("c"));
        database.addRollerSkater(new RollerSkater("d"));
        database.addRollerSkater(new RollerSkater("e"));
        database.setTrainer(new Trainer(database.getRollerSkaters()));
    }
}
