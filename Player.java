package p4_group_8_repo;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public abstract class Player  extends MovingActor{
    protected final double movement = 13.3333333*2;
    protected final double movementX = 10.666666*2;
    protected boolean stop = false;
    private double startXPos;
    private double startYPos;

    public Player(String imageLink, double size, double xPos, double yPos) {
        super(imageLink, size, xPos, yPos);
        this.startXPos = xPos;
        this.startYPos = yPos;

        setOnKeyPressed( getKeyPressedHandler() );
    }

    public void HandleOutOfBoundsEvent() {
        if (getY()<0 || getY()>734) {
            restoreDefaults();
        }

        if (getX() < 0) {
            move( movement * 2, 0 );
        }

        else if (getX() > 600) {
            move( -movement * 2, 0 );
        }
    }

    public void restoreDefaults(){

        stop = false;

        setImage(ActorImage);

        setX(startXPos);

        setY(startYPos);

        return;
    }
    public abstract EventHandler<KeyEvent> getKeyPressedHandler();

}
