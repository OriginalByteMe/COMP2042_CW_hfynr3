package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

public class ActorGroupToWindow {
    private double size = 0;
    private double speed = 0;
    private double startXPos;
    private double yPos = 0;
    private double shift = 0; // To space out sprites equally (on x axis)
    private int amount = 0;
    private String imageLink = "";
    private String ActorType =  "";
    private String ActorGroup;


    public void setSize(double size) {
        this.size = size;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setStartXPos(double startXPos) {
        this.startXPos = startXPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public void setShift(double shift) {
        this.shift = shift;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public void setActorType(String actorType) {
        ActorType = actorType;
    }

    public ActorGroupToWindow(String actorGroup) {
        ActorGroup = actorGroup;
    }

    /**
     * <h1>AddToWindow</h1>
     * <p>Adds Actors to the Stage and assigns them their <u>factory type</u></p>
     * @param area Current stage to add Actor to
     * @return List of actors added
     */
    public List<Actor> AddToWindow(MyStage area){
        List<Actor> added = new ArrayList<>();

        FactoryProducer factoryProducer = FactoryProducer.getActorFactoryProducer();

        AbstractFactory factory = factoryProducer.getFactory(ActorGroup);

        if(factory instanceof ObstacleFactory) {
            ((ObstacleFactory) factory).setSpeed(speed);
        }

        for(int i = 0; i < amount; i++) {

            final double actualXPos = startXPos + shift * i;

            Actor actor = factory.getActor(ActorType, imageLink, size,  actualXPos, yPos);

            added.add(actor);

            area.add(actor);

        }

        return added;
    }

}
