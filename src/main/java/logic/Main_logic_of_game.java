package logic;


import static input.Check_input.getIntNumber;
import static print.Sout.soutFieldOfTheGame;

public class Main_logic_of_game {
    // змінні для зберігання інфо про ігрове поле і " стан гри "
    public static final int ROW = 3;
    public static final int COLUMN = 3;

    // фіксовані змінні які відповідають за вміст комірки
    public static final String EMPTY = "   "; // порожня клітинка для поля
    public static final String CROSS = " X "; // хрестик
    public static final String ZERO = " O "; // нулик
    public static String[][] playField = new String[ROW][COLUMN]; // ігрове поле !!!

    public static String activePlayer; // активний гравець

    public static int gameStatus; // статус гравця
    public static final int status_Game_continues = 0;
    public static final int status_Draw = 1;
    public static final int status_Wins_X = 3;
    public static final int status_Wins_O = 4;


    public static void startGame() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                playField[i][j] = EMPTY; // малюємо наше порожнє поле гри
            }
        }
        activePlayer = CROSS; // вкузую що починає гру хрестик
        soutFieldOfTheGame(); // виводим поле гри
    }  // Метод для запуску гри створить порожнє ігрове поле і запамятає хто починає гру

    public static void getInputOfThePlayer() {// Просить гравця щоб він поставив свій елемент

        boolean inputFromKeyboard = false;

        do {
            System.out.println("Гравець " + activePlayer + " Введіть рядок від (1 до 3) після того нажміть клавішу enter щоб продовжити:");

            int inRow = getIntNumber() - 1; //вводим рядок!  -1 я написав для тому що користувачам я сказав вводити від 1 до 3  і індекси починаются з 0
            System.out.println("Введіть стовбчик від (1 до 3):");
            int inColumn = getIntNumber() - 1; //вводим стовбчик!  -1 я написав для тому що користувачам я сказав вводити від 1 до 3  і індекси починаются з 0

            if (inRow >= 0 && inRow < ROW && inColumn >= 0 && inColumn < COLUMN && playField[inRow][inColumn] == EMPTY) {
                playField[inRow][inColumn] = activePlayer; //записуємо введення користувача в масив
                inputFromKeyboard = true; // я перевірив що введення є дійсне  і тому змінну я міняю на ТРУ
            } else {
                System.out.println("Вибране розміщення не може бути використане. Спробуйте ще раз... ");
            }
        }
        while (!inputFromKeyboard);// поки введення буде не дійсне
    }

    public static void analyzeFieldOfTheGame() {
        String winner = findTheWinner();
        if (winner.equals(CROSS)) {
            gameStatus = status_Wins_X;

        } else if (winner.equals(ZERO)) {
            gameStatus = status_Wins_O;
        } else if (fieldIsFull()) {
            gameStatus = status_Draw;
        } else
            gameStatus = status_Game_continues;


    }  //Аналізує чи хтось з гравців переміг чи гра закінчилась нічєю

    public static boolean fieldIsFull() {

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                if (playField[i][j] == EMPTY) {
                    return false; // якщо знайдено хоч одну порожню клітинку повертає фолс і немає спислу дальше шукати
                }
            }
        }
        return true; // якщо немає порожніх

    }  // перевіряє чи всі клітинки на ігровому полі заповнені гравцями

    public static String findTheWinner() {

        int countSame;    // лічильник для кількості однакових елементів
        for (int i = 0; i < ROW; i++) { // це є перевірка на 3 співпадіння  в РЯДОК !!!
            countSame = 0;
            for (int j = 0; j < COLUMN; j++) {
                if (playField[i][0] != EMPTY && playField[i][0] == playField[i][j]) {
                    countSame++;
                }
            }
            if (countSame == 3) {
                return playField[i][0]; // повертаємо елемент який 3 рази я однаковий // тобто переможця
            }
        }


        for (int j = 0; j < COLUMN; j++) {// це є перевірка співпадінь в СТОВБЧИК !!!
            countSame = 0;
            for (int i = 0; i < ROW; i++) {
                if (playField[0][j] != EMPTY && playField[0][j] == playField[i][j]) {
                    countSame++;
                }
            }
            if (countSame == 3) {
                return playField[0][j]; // повертаємо елемент який 3 рази я однаковий // тобто переможця

            }

        }

// перевірка по діагоналі з ліва на право
        if (playField[0][0] != EMPTY && playField[0][0] == playField[1][1] && playField[0][0] == playField[2][2]) {
            return playField[0][0];
        }

// перевірка по діагоналі справа на ліво
        if (playField[0][2] != EMPTY && playField[1][1] == playField[0][2] && playField[2][0] == playField[0][2]) {
            return playField[0][2];
        }
        return EMPTY; // переможця не знайдено


    }  //після кожного введення гравця потрібно викликати цей метод він перевіряє чи є в нас переможець
}
