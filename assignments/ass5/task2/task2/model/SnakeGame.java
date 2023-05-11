package task2.model;

import java.lang.Math;

public class SnakeGame implements GameInterface {

    private static final int width  = 15;
    private static final int height = 10;
    private static final int maxLength = 20;

    private SnakeSegment[] snake;
    
    private int foodX;
    private int foodY;

    private enum GameState {
        RUNNING,
        WON,
        LOST
    };

    private GameState state;

    public SnakeGame() {
        snake = new SnakeSegment[3];
        snake[0] = new SnakeSegment(width / 2, height / 2);
        snake[1] = new SnakeSegment((width / 2) + 1, height / 2);
        snake[2] = new SnakeSegment((width / 2) + 2, height / 2);
        spawnFood();
        state = GameState.RUNNING;
    }

    private boolean isSnakeSelfColiding() {
        for (SnakeSegment segment1 : snake) {
            for (SnakeSegment segment2 : snake) {
                if (segment1 != segment2 && segment1.getX() == segment2.getX() && segment1.getY() == segment2.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

    private void spawnFood() {
        foodX = (int) (Math.random() * width);
        foodY = (int) (Math.random() * height);
        for (SnakeSegment segment : snake) {
            if (segment.getX() == foodX && segment.getY() == foodY) {
                spawnFood();
            }
        }
    }

    private boolean isSnakeColiding() {
        if (isSnakeSelfColiding()) {
            return true;
        }
        SnakeSegment head = snake[0];
        if (head.getX() < 0 || head.getX() >= width || head.getY() < 0 || head.getY() >= height) {
            return true;
        }
        return false;
    }

    private void moveSnakeNoFood(Direction dir) {
        SnakeSegment newHead = snake[0].getMoved(dir);
        for (int i = snake.length - 1; i > 0; i--) {
            snake[i] = snake[i - 1];
        }
        snake[0] = newHead;
    }
    private void moveSnakeWithFood(Direction dir) {
        SnakeSegment[] newSnake = new SnakeSegment[snake.length + 1];
        newSnake[0] = snake[0].getMoved(dir);
        for (int i = 0; i < snake.length; i++) {
            newSnake[i + 1] = snake[i];
        }
        snake = newSnake;
        spawnFood();
    }

    private boolean facingFood(Direction dir) {
        SnakeSegment head = snake[0];
        return (head.getX() + dir.getXDiff()) == foodX && (head.getY() + dir.getYDiff()) == foodY;
    }

    private void moveSnake(Direction dir) {
        if (facingFood(dir)) {
            moveSnakeWithFood(dir);
        } else {
           moveSnakeNoFood(dir);
        }
    }

    private boolean isGameWon() {
        return snake.length > maxLength;
    }

    @Override
    public void pressUpButton() {
        moveSnake(Direction.UP);
        if (isSnakeColiding()) {
            state = GameState.LOST;
        } else if (isGameWon()) {
            state = GameState.WON;
        }
    }

    @Override
    public void pressDownButton() {
        moveSnake(Direction.DOWN);
        if (isSnakeColiding()) {
            state = GameState.LOST;
        } else if (isGameWon()) {
            state = GameState.WON;
        }
    }

    @Override
    public void pressLeftButton() {
        moveSnake(Direction.LEFT);
        if (isSnakeColiding()) {
            state = GameState.LOST;
        } else if (isGameWon()) {
            state = GameState.WON;
        }
    }

    @Override
    public void pressRightButton() {
        moveSnake(Direction.RIGHT);
        if (isSnakeColiding()) {
            state = GameState.LOST;
        } else if (isGameWon()) {
            state = GameState.WON;
        }
    }

    @Override
    public void pressAButton() {
        return;
    }

    @Override
    public void pressBButton() {
        return;
    }

    @Override
    public String getGameState() {
        if (isRunning()) {
            char[][] grid = new char[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = ' ';
                }
            }
            for (SnakeSegment segment : snake) {
                grid[segment.getY()][segment.getX()] = 'O';
            }
            grid[foodY][foodX] = '*';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < width + 2; i++) {
                sb.append("#");
            }
            sb.append("\n");
            for (int i = 0; i < height; i++) {
                sb.append("#");
                for (int j = 0; j < width; j++) {
                    sb.append(grid[i][j]);
                }
                sb.append("#\n");
            }
            for (int i = 0; i < width + 2; i++) {
                sb.append("#");
            }
            return sb.toString();
        } else if (state == GameState.WON) {
            return "You won!";
        } else {
            return "You lost!";
        }
    }

    @Override
    public String getUpLabel() {
        return "Up";
    }

    @Override
    public String getDownLabel() {
        return "Down";
    }

    @Override
    public String getLeftLabel() {
        return "Left";
    }

    @Override
    public String getRightLabel() {
        return "Right";
    }

    @Override
    public String getALabel() {
        return "A (not used)";
    }

    @Override
    public String getBLabel() {
        return "B (not used)";
    }

    @Override
    public boolean isRunning() {
        return state == GameState.RUNNING;
    }
}
