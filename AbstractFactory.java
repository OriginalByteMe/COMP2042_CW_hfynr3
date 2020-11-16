package p4_group_8_repo;

public abstract class AbstractFactory {
    abstract Actor getActor(String obstacleName, String imageLink, double size, double xPos, double yPos);
}
