package Snake;

import java.util.Random;

public class SnakeModel {
    
    private Random random = new Random();
    private int numCols = 20;
    private int numRows = numCols;
    private int unitSize = 30;
    private int boardWidth = numCols*unitSize;
    private int boardHeight = numRows*unitSize;
    private int bodyLength = 5;
    private int appleX;
    private int appleY;
    // private int numUnits = (boardHeight*boardWidth)/unitSize;
    private int xCoordinates[] = new int[numCols * numRows];
    private int yCoordinates[] = new int[numCols * numRows];
    private char movementDirection = 'R';
    // private boolean gameRunning = false;

    public int getBoardWidth() {
        return boardWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getNumCols() {
        return numCols;
    }

    public int getNumRows() {
        return numRows;
    }

    public int getUnitSize() {
        return unitSize;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public int getAppleX() {
        return appleX;
    }

    public int getAppleY() {
        return appleY;
    }

    public int[] getXCoordinates() {
        return xCoordinates;
    }

    public int[] getYCoordinates() {
        return yCoordinates;
    }

    public char getMovementDirection() {
        return movementDirection;
    }

    /* public void startGame() {
        generateApple();
        gameRunning = true;
    } */

    public void setMovementDirection(char c) {
        movementDirection = c;
    }

    public void generateApple() {
        appleX = random.nextInt(numCols)  * unitSize;
        appleY = random.nextInt(numRows) * unitSize;
    }

    public void detectCollisions() {
        
        if (appleX == xCoordinates[0] && appleY == yCoordinates[0]) {
            bodyLength++;
            generateApple();
        }

        for (int i=bodyLength; i>0; i--) {
            if (xCoordinates[0] == xCoordinates[i] && yCoordinates[0] == yCoordinates[i]) {
                // gameRunning = false;
                bodyLength = 5;
                generateApple();
            }
        }

        if (yCoordinates[0] < 0 ) {
            yCoordinates[0] = boardHeight;
        }

        if (xCoordinates[0] > boardWidth) {
            xCoordinates[0] = 0;
        }

        if (yCoordinates[0] > boardHeight) {
            yCoordinates[0] = 0;
        }

        if (xCoordinates[0] < 0) {
            xCoordinates[0] = boardWidth;
        }
    }

    public void moveSnake() {
        
        for (int i=bodyLength; i>0; i--) {
            xCoordinates[i] = xCoordinates[i - 1];
            yCoordinates[i] = yCoordinates[i - 1];
        }

        switch(movementDirection) {
            case 'U':
                yCoordinates[0] = yCoordinates[0] - unitSize;
                break;
            case 'R':
                xCoordinates[0] = xCoordinates[0] + unitSize;
                break;
            case 'D':
                yCoordinates[0] = yCoordinates[0] + unitSize;
                break;
            case 'L':
                xCoordinates[0] = xCoordinates[0] - unitSize;
                break;
        }
    }
}
