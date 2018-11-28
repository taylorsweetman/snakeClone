/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.awt.Graphics;

/**
 *
 * @author taylo
 */
public class Piece {

    private int x;
    private int y;

    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean runsInto(Piece piece) {
        return x == piece.getX() && y == piece.getY();
    }
    
    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Piece pObj = (Piece) obj;

        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else {
            return this.x == pObj.getX() && this.y == pObj.getY();
        }
    }

    @Override
    public int hashCode() {
        if (this == null) {
            return 7;
        } else {
            return 11 * this.x + 13 * this.y;
        }
    }

}
