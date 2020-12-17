package p4_group_8_repo;

/**
 * <h1>Abstract Factory</h1>
 * <p>Used as interface for all other factories in <b>Abstract Factory design model</b></p>
 */
public abstract class AbstractFactory {
    abstract Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos);
}
