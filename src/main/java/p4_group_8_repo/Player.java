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

    /**
     * <h1>HandleOutOfBoundsEvent</h1>
     * <p>Sets boundaries for the stage as well as what happens when a player crosses a boundry</p>
     */
    public void HandleOutOfBoundsEvent() {
        if (getY()<0 || getY()>734) {
            restoreDefaults();
        }

        if (getX() < 0) {
            move( movement * 2, 0 );
        }

        else if (getX() > 800) {
            move( -movement * 2, 0 );
        }
    }

    /**
     * <h1>restoreDefaults</h1>
     * <p>Resets player to default position with default resting animation</p>
     */
    public void restoreDefaults(){

        stop = false;

        setImage(ActorImage);

        setX(startXPos);

        setY(startYPos);

        return;
    }
    public abstract EventHandler<KeyEvent> getKeyPressedHandler();

}
