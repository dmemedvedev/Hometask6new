import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RobotWar {
    public static void main(String[] args) {
        List<String> robotPartsNeeded = Arrays.asList("leftArm", "rightArm", "leftLeg", "rightLeg", "body", "head");

        Factory factory = new Factory();
        new Thread(factory).start();

        Country country1 = new Country("Страна 1", new ArrayList<>(robotPartsNeeded), factory, 20);
        Country country2 = new Country("Страна 2", new ArrayList<>(robotPartsNeeded), factory, 20);
        new Thread(country1).start();
        new Thread(country2).start();
    }
}
