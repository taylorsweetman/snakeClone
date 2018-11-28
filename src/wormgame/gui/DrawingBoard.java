/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import wormgame.game.WormGame;
import wormgame.domain.*;

/**
 *
 * @author taylo
 */
public class DrawingBoard extends JPanel implements Updatable{

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        //paint the apple
        Apple appleObject = wormGame.getApple();
        g.setColor(Color.red);
        g.fillOval(appleObject.getX(), appleObject.getY(), pieceLength, pieceLength);
        //need to implement painting of the worm
    }

    @Override
    public void update() {
        super.repaint();
    }
    
    
    
    
    
    

}
