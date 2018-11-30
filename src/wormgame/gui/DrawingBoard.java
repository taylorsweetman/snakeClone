/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import wormgame.game.WormGame;
import wormgame.domain.*;

/**
 *
 * @author taylo
 */
public class DrawingBoard extends JPanel implements Updatable {

    private WormGame wormGame;
    private int pieceLength;

    public DrawingBoard(WormGame wormGame, int pieceLength) {
        this.wormGame = wormGame;
        this.pieceLength = pieceLength;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Apple appleObject = wormGame.getApple();
        g.setColor(Color.red);
        g.fillOval(appleObject.getX() * pieceLength, appleObject.getY() * pieceLength, pieceLength, pieceLength);
        g.setColor(Color.black);

        for (Piece wormPiece : wormGame.getWorm().getPieces()) {
            g.fill3DRect(wormPiece.getX() * pieceLength, wormPiece.getY() * pieceLength, pieceLength, pieceLength, true);
        }
    }

    @Override
    public void update() {
        super.repaint();
    }

}
