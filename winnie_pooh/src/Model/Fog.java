package Model;

import java.util.Objects;

/**
 * Туман
 */
public class Fog {
    private boolean thick;

    /**
     * Вывод состояния тумана
     * @return густой/слабый
     */
    public boolean isThick() {
        return thick;
    }

    /**
     * Сделать туман гуше
     * @return Туман стал гуше
     */
    public String thick() {
        thick = true;
        return "Туман стал гуше";
    }

    /**
     * Вывод тумана
     * @return Туман: густой/слабый
     */
    @Override
    public String toString() {
        return String.format(
                "Туман: %s",
                thick ? "густой" : "слабый"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fog fog = (Fog) o;
        return thick == fog.thick;
    }

    @Override
    public int hashCode() {
        return Objects.hash(thick);
    }
}
