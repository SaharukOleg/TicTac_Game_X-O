package print;
import static logic.Main_logic_of_game.COLUMN;
import static logic.Main_logic_of_game.ROW;
import static logic.Main_logic_of_game.playField;

public class Sout {
    public static void soutFieldOfTheGame() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                System.out.print(playField[i][j]);
                if (j != COLUMN - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();
            if (i != ROW - 1) {
                System.out.println("-----------");
            }
        }
        System.out.println();
    }  // виводить поле гри ОНОВЛЕНЕ
}
