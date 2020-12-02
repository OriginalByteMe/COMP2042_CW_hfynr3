package p4_group_8_repo;

public class Car extends obstacle{

    public Car(String imageLink, double size, double xPos, double yPos, double speed) {
        super(imageLink, size, xPos, yPos, speed);
    }

    @Override
    public String getActorClassName() {
        return "Car";
    }
}
