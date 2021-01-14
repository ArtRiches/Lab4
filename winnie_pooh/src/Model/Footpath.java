package Model;

import java.util.Objects;

/**
 * Тропинка
 */
public class Footpath {
    private boolean narrow;

    /**
     * Состояние тропинки
     * @return узкая/широкая
     */
    public boolean isNarrow() {
        return narrow;
    }

    /**
     * Сделать тропнку уже
     * @return Тропинка стала уже
     */
    public String Narrow() {
        this.narrow = true;
        return "Тропинка стала уже";
    }

    /**
     * Вывод троинки
     * @return Тропинка: узкая/широкая
     */
    @Override
    public String toString() {
        return String.format(
                "Тропинка: %s",
                narrow ? "узкая" : "широкая"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footpath footpath = (Footpath) o;
        return narrow == footpath.narrow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(narrow);
    }
}
