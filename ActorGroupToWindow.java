package p4_group_8_repo;

import java.util.ArrayList;
import java.util.List;

public class ActorGroupToWindow {
    private double size = 0;
    private double speed = 0;
    private double startXPos;
    private double yPos = 0;
    private double shift = 0;
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

    public void setyPos(double yPos) {
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

    public void setActorGroup(String actorGroup) {
        ActorGroup = actorGroup;
    }

    public List<Actor> AddToWindow(MyStage window){
        List<Actor> added = new ArrayList<>();

        FactoryProducer factoryProducer = FactoryProducer.getActorFactoryProducer();

        AbstractFactory factory = factoryProducer.getFactory(ActorGroup);

        if(factory instanceof ObstacleFactory) {
            ((ObstacleFactory) factory).setSpeed(speed);
        }

        for(int iterator = 0; iterator < amount; iterator++) {

            final double actualXPos = startXPos + shift * iterator;

            Actor actor = factory.getActor(ActorType, imageLink, size,  actualXPos, yPos);

            added.add(actor);

            window.add(actor);

        }

        return added;
    }
}