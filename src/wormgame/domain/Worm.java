/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wormgame.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import wormgame.Direction;

/**
 *
 * @author taylo
 */
public class Worm {

    private Direction direction;
    private List<Piece> bodyPieceList;
    private boolean forceGrowth;

    public Worm(int originalX, int originalY, Direction originalDirection) {
        this.direction = originalDirection;
        bodyPieceList = new ArrayList<Piece>();
        Piece firstBodyPiece = new Piece(originalX, originalY);
        bodyPieceList.add(firstBodyPiece);
        forceGrowth = false;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction dir) {
        this.direction = dir;
    }

    public int getLength() {
        return bodyPieceList.size();
    }

    public List<Piece> getPieces() {
        return bodyPieceList;
    }

    public Piece getHeadPiece() {
        return bodyPieceList.get(getLength() - 1);
    }

    public void move() {
        int headX = getHeadPiece().getX();
        int headY = getHeadPiece().getY();
        Piece additionalBodyPiece;

        switch (direction) {
            case UP:
                additionalBodyPiece = new Piece(headX, headY - 1);
                break;
            case DOWN:
                additionalBodyPiece = new Piece(headX, headY + 1);
                break;
            case RIGHT:
                additionalBodyPiece = new Piece(headX + 1, headY);
                break;
            default: //case LEFT:
                additionalBodyPiece = new Piece(headX - 1, headY);
                break;
        }
        bodyPieceList.add(additionalBodyPiece);

        if (getLength() > 3 && forceGrowth == false) {
            bodyPieceList.remove(0);
        }

        forceGrowth = false;
    }

    public void grow() {
        forceGrowth = true;
    }

    public boolean runsInto(Piece piece) {
        for (Piece pieceInBody : bodyPieceList) {
            if (pieceInBody.runsInto(piece)) {
                return true;
            }
        }
        return false;
    }

    public boolean runsIntoItself() {
        Set<Piece> testSet = new HashSet<Piece>();
        testSet.addAll(bodyPieceList);
        return !(testSet.size() == bodyPieceList.size());
    }
}
