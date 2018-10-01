import static logic.Main_logic_of_game.*;
import static print.Sout.soutFieldOfTheGame;

public class Main_TicTacGame {

    public static void main(String[] args) {
        startGame(); // заповнить поле порожніми елементами, вкажить на активного нравця і виведить поле гри
        do {
            getInputOfThePlayer(); // отримуєм введення від гравця
            analyzeFieldOfTheGame(); // аналізуємо поле гри, можливо гра вже закінчилась
            soutFieldOfTheGame(); // виводимо поле гри
            if (gameStatus == status_Wins_X) {
                System.out.println("'X' переміг! Вітаю !!!");
            } else if (gameStatus == status_Wins_O) {
                System.out.println("'O' переміг! Вітаю !!!");
            } else if (gameStatus == status_Draw) {
                System.out.println(" Гра закінчилась внічию !");
            }
            activePlayer = (activePlayer == CROSS ? ZERO : CROSS); // якщо активний гравець є Х то змінити його на О і навпаки, і це все записуєм в змінну activePlayer
        }
        while (gameStatus == status_Game_continues); // поки гра триває ми будем гравців просити знову і знову вводити дані
    }
}
