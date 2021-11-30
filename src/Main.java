import model.RollerSkater;
import threads.RollerSkaterThread;

public class Main {

    public static void main(String[] args) {
        RollerSkater rollerSkaterA = new RollerSkater("a");
        RollerSkater rollerSkaterB = new RollerSkater("b");
        RollerSkaterThread rollerSkaterThreadA = new RollerSkaterThread(rollerSkaterA);

        rollerSkaterThreadA.start();

        try {
            Thread.sleep(3300);
            RollerSkaterThread rollerSkaterThreadB = new RollerSkaterThread(rollerSkaterB);
            rollerSkaterThreadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
