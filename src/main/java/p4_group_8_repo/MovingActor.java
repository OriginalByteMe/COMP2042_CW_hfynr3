package p4_group_8_repo;

public abstract class MovingActor extends Actor{
    public MovingActor(String imageLink, double size, double xPos, double yPos) {
        super(imageLink,size,xPos,yPos);
    }


    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
