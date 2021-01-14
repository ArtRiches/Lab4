package Model;

import java.util.Objects;

/**
 * Лес
 */
public class Forest {
    private boolean quiet;

    /**
     * Вывод состояния леса
     * @return тихий/слышны звуки
     */
    public boolean isQuiet() {
        return quiet;
    }

    /**
     * Сделать лес тихим
     * @return В Лесу стало очень тихо
     */
    public String quiet() {
        quiet = true;
        return "В Лесу стало очень тихо";
    }

    /**
     * Вывод леса
     * @return Лес: тихий/слышны звуки
     */
    @Override
    public String toString() {
        return String.format(
                "Лес: %s",
                quiet ? "тихий" : "слышны звуки"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forest forest = (Forest) o;
        return quiet == forest.quiet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quiet);
    }
}
