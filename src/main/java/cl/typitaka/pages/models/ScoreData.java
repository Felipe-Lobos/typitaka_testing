package cl.typitaka.pages.models;

/**
 * Objeto que representa los datos del score
 * (Data Transfer Object / Value Object)
 */
public class ScoreData {
    private final int wpm;
    private final int wordsCorrect;
    private final int wordsIncorrect;
    private final int wordsMissed;
    private final int lettersCorrect;
    private final int lettersIncorrect;
    private final int lettersMissed;
    private final int lpm;
    private final int time;
    private final double accuracy;

    // Constructor
    public ScoreData(int wpm, int wordsCorrect, int wordsIncorrect, int wordsMissed,
            int lettersCorrect, int lettersIncorrect, int lettersMissed,
            int lpm, int time, double accuracy) {
        this.wpm = wpm;
        this.wordsCorrect = wordsCorrect;
        this.wordsIncorrect = wordsIncorrect;
        this.wordsMissed = wordsMissed;
        this.lettersCorrect = lettersCorrect;
        this.lettersIncorrect = lettersIncorrect;
        this.lettersMissed = lettersMissed;
        this.lpm = lpm;
        this.time = time;
        this.accuracy = accuracy;
    }

    // Getters
    public int getWpm() {
        return wpm;
    }

    public int getWordsCorrect() {
        return wordsCorrect;
    }

    public int getWordsIncorrect() {
        return wordsIncorrect;
    }

    public int getWordsMissed() {
        return wordsMissed;
    }

    public int getLettersCorrect() {
        return lettersCorrect;
    }

    public int getLettersIncorrect() {
        return lettersIncorrect;
    }

    public int getLettersMissed() {
        return lettersMissed;
    }

    public int getLpm() {
        return lpm;
    }

    public int getTime() {
        return time;
    }

    public double getAccuracy() {
        return accuracy;
    }

    // Método útil
    public int getTotalWords() {
        return wordsCorrect + wordsIncorrect + wordsMissed;
    }

    public int getTotalLetters() {
        return lettersCorrect + lettersIncorrect + lettersMissed;
    }
}
