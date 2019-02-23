package wormgame.gameLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;
import wormgame.Direction;
import wormgame.models.Apple;
import wormgame.models.Worm;
import wormgame.gui.Updatable;

public class WormGame extends Timer implements ActionListener {

    private int width;
    private int height;
    private boolean continues;
    private Updatable updatable;
    private Random random = new Random();
    private Worm wormy;
    private Apple obuolys;

    private int points;

    public WormGame(int width, int height) {
        super(1000, null);

        this.width = width;
        this.height = height;
        this.continues = true;
        this.points = 10;

        addActionListener(this);
        setInitialDelay(2000);

        this.wormy = new Worm(width / 2, height / 2, Direction.DOWN);
        int randomInteger = random.nextInt(width);
        int randomInteger2 = random.nextInt(height);

        this.obuolys = new Apple(randomInteger, randomInteger2);
        while (wormy.runsInto(obuolys)) {
            this.points++;
            this.obuolys = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
        }

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

    public Worm getWorm() {
        return wormy;
    }

    public void setWorm(Worm worm) {
        this.wormy = worm;

    }

    public Apple getApple() {
        return obuolys;
    }

    public void setApple(Apple apple) {
        this.obuolys = apple;
    }

    public int getPoints(){
        return this.points;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!continues) {
            return;
        }
        wormy.move();

        if (wormy.runsInto(obuolys)) {
            wormy.grow();
            while (wormy.runsInto(obuolys)) {
                this.obuolys = new Apple(new Random().nextInt(this.width), new Random().nextInt(this.height));
            }
        } else if (wormy.runsIntoItself()) {
            continues = false;
        } else if (wormy.wormHead().getX() == this.width || wormy.wormHead().getX() < 0) {
            continues = false;
        } else if (wormy.wormHead().getY() == this.height || wormy.wormHead().getY() < 0) {
            continues = false;
        }

        updatable.update();
        setDelay(1000 / wormy.getLength());

    }

}