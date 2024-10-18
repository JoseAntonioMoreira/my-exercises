import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler {
    public static final int RECT_SIZE = 50;
    private Rectangle[][] rectGrid;
    private boolean[][] paintedGrid;
    private int[] brush;

    private boolean isPainting;

    private Keyboard keyboard;

    public Grid(int rows, int columns) {
        isPainting = false;
        createGrid(rows, columns);
        createBrush();
        initKeyboard();
    }

    private void createGrid(int rows, int columns) {
        rectGrid = new Rectangle[rows][columns];
        paintedGrid = new boolean[rows][columns];
        int x = 10;
        int y = 10;
        for (int i = 0; i < rectGrid.length; i++) {
            for (int j = 0; j < rectGrid[i].length; j++) {
                rectGrid[i][j] = new Rectangle(x, y, RECT_SIZE, RECT_SIZE);
                rectGrid[i][j].draw();
                paintedGrid[i][j] = false;
                x += RECT_SIZE;
            }
            y += RECT_SIZE;
            x = 10;
        }
    }

    private void createBrush() {
        brush = new int[]{0, 0};
        rectGrid[brush[0]][brush[1]].setColor(Color.GREEN);
        rectGrid[brush[0]][brush[1]].fill();
    }

    private void updateBrushOldPosition() {
        rectGrid[brush[0]][brush[1]].setColor(Color.BLACK);

        if (isPainting) {
            if (!paintedGrid[brush[0]][brush[1]]) {
                rectGrid[brush[0]][brush[1]].fill();
                paintedGrid[brush[0]][brush[1]] = true;
                return;
            }
            rectGrid[brush[0]][brush[1]].draw();
            paintedGrid[brush[0]][brush[1]] = false;
            return;
        }

        if (!paintedGrid[brush[0]][brush[1]]) {
            rectGrid[brush[0]][brush[1]].draw();
        }
    }

    private void updateBrushPosition() {
        rectGrid[brush[0]][brush[1]].setColor(Color.GREEN);
        rectGrid[brush[0]][brush[1]].fill();
    }

    private void ClearScreen() {
        for (int i = 0; i < rectGrid.length; i++) {
            for (int j = 0; j < rectGrid[i].length; j++) {
                rectGrid[i][j].setColor(Color.BLACK);
                rectGrid[i][j].draw();
                paintedGrid[i][j] = false;
            }
        }
    }

    private void initKeyboard() {
        keyboard = new Keyboard(this);

        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_W, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_S, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_D, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_C, KeyboardEventType.KEY_PRESSED));
        keyboard.addEventListener(setKeyboardKey(KeyboardEvent.KEY_SPACE, KeyboardEventType.KEY_RELEASED));
    }

    private KeyboardEvent setKeyboardKey(int key, KeyboardEventType typeOfPress) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(key);
        event.setKeyboardEventType(typeOfPress);
        return event;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_A:
                if (brush[1] != 0) {
                    updateBrushOldPosition();
                    brush[1]--;
                    updateBrushPosition();
                }
                break;
            case KeyboardEvent.KEY_W:
                if (brush[0] != 0) {
                    updateBrushOldPosition();
                    brush[0]--;
                    updateBrushPosition();
                }
                break;
            case KeyboardEvent.KEY_S:
                if (brush[0] != rectGrid.length - 1) {
                    updateBrushOldPosition();
                    brush[0]++;
                    updateBrushPosition();
                }
                break;
            case KeyboardEvent.KEY_D:
                if (brush[1] != rectGrid[brush[0]].length - 1) {
                    updateBrushOldPosition();
                    brush[1]++;
                    updateBrushPosition();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                isPainting = true;
                break;
            case KeyboardEvent.KEY_C:
                ClearScreen();
                updateBrushPosition();
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_SPACE:
                isPainting = false;
                break;
        }

    }
}
