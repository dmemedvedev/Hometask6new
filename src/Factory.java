import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Factory implements Runnable {
    private Random random = new Random();
    private String[] parts = {"leftArm", "rightArm", "leftLeg", "rightLeg", "body", "head"};
    private List<RobotPartListener> listeners = new ArrayList<>();

    public void addRobotPartListener(RobotPartListener listener) {
        listeners.add(listener);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String part = parts[random.nextInt(parts.length)];
            for (RobotPartListener listener : listeners) {
                listener.onRobotPartProduced(part);
            }
        }
    }
}

interface RobotPartListener {
    void onRobotPartProduced(String part);
}