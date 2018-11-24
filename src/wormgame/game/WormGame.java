package wormgame.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.domain.Apple;
import wormgame.domain.Piece;
import wormgame.domain.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Worm worm;
    private Apple apple;
    private Random myRandom;

    public WormGame(int width, int height) {
        super(1000, null);

        this.myRandom = new Random();

        this.width = width;
        this.height = height;
        this.continues = true;
        this.worm = new Worm(this.width / 2, this.height / 2, Direction.DOWN);
        this.apple = createRandomApple();

        addActionListener(this);
        setInitialDelay(2000);

    }

    public final Apple createRandomApple() {
        Apple returnApple = new Apple(myRandom.nextInt(width), myRandom.nextInt(height));

        while (worm.runsInto(returnApple)) {
            returnApple = new Apple(myRandom.nextInt(width), myRandom.nextInt(height));
        }
        return returnApple;
    }

    public Worm getWorm() {
        return worm;
    }

    public void setWorm(Worm worm) {
        this.worm = worm;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public boolean continues() {
        return continues;
    }

    public void setUpdatable(Updatable updatable) {
        this.updatable = updatable;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        } else {
            worm.move();

            if (worm.runsInto(apple)) {
                worm.grow();
                Apple newApple = createRandomApple();
                setApple(newApple);
            }

            if (worm.runsIntoItself() || wormRunsIntoWall()) {
                continues = false;
            }

            updatable.update();

            setDelay(1000 / worm.getLength());
        }

    }

    public boolean wormRunsIntoWall() {
        Piece head = worm.getHeadPiece();
        Direction currentDir = worm.getDirection();

        switch (currentDir) {
            case UP:
                return head.getY() == 0;
            case DOWN:
                return head.getY() == height - 1;
            case RIGHT:
                return head.getX() == width - 1;
            case LEFT:
                return head.getX() == 0;
            default:
                return false;
        }
    }
}
