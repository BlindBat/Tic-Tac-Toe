package tictactoe.game;

import java.util.HashMap;
import java.util.Map;

public enum State {
    GAME_NOT_FINISHED,
    DRAW,
    X_WINS,
    O_WINS,
    IMPOSSIBLE;

    static final Map<State, String> STRINGS = new HashMap<>() {{
        put(GAME_NOT_FINISHED, "Game not finished");
        put(DRAW, "Draw");
        put(X_WINS, "X wins");
        put(O_WINS, "O wins");
        put(IMPOSSIBLE, "Impossible");
    }};
}
