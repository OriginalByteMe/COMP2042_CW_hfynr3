package p4_group_8_repo;

public abstract class MovingActor extends Actor{
    public MovingActor(String imageLink, int size, int xPos, int yPos) {
        super(imageLink,size,xPos,yPos);
    }

    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }
}
