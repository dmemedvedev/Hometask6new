import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Country implements RobotPartListener, Runnable {
    private String name;
    private List<Robot> robots = new ArrayList<>();
    private List<String> robotPartsNeeded = new ArrayList<>();
    private Factory factory;
    private int robotsToBuild;

    public Country(String name, List<String> robotPartsNeeded, Factory factory, int robotsToBuild) {
        this.name = name;
        this.robotPartsNeeded = robotPartsNeeded;
        this.factory = factory;
        this.robotsToBuild = robotsToBuild;
    }

    @Override
    public void onRobotPartProduced(String part) {
        if (robotPartsNeeded.contains(part)) {
            robotPartsNeeded.remove(part);
            System.out.println(name + " получила часть " + part + " от завода");
        }
        if (robotPartsNeeded.isEmpty()) {
            Robot robot = new Robot("leftArm", "rightArm", "leftLeg", "rightLeg", "body", "head");
            robots.add(robot);
            System.out.println(name + " собрала робота №" + robots.size());
            if (robots.size() == robotsToBuild) {
                System.out.println(name + " победила!");
                System.exit(0);
            }
            robotPartsNeeded.addAll(Arrays.asList("leftArm", "rightArm", "leftLeg", "rightLeg", "body", "head"));
        }
    }

    @Override
    public void run() {
        factory.addRobotPartListener(this);
    }
}









