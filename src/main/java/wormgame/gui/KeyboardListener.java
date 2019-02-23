package wormgame.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import wormgame.Direction;
import wormgame.models.Worm;

public class KeyboardListener implements KeyListener{
    private Worm wormy;

    public KeyboardListener(Worm worm){
        this.wormy = worm;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            wormy.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            wormy.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            wormy.setDirection(Direction.UP);
        } else {
            wormy.setDirection(Direction.DOWN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}