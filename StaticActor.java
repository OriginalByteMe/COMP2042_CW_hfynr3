package p4_group_8_repo;

public abstract class StaticActor extends Actor{
    public StaticActor(String ImageLink, double size, double xPos, double yPos) {
        super(ImageLink, size, xPos, yPos);
    }

    @Override
    public String getActorClassName() {
        return "StaticActor";
    }

    @Override
    public void act() {
        // Do nothing
    }
}
