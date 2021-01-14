package Model;

import java.util.Objects;

/**
 * Погода
 */
public class Weather {

    /**
     * Состояние погоды
     */
    private boolean bad;

    /**
     * Вывод состояиния погоды
     * @return плохая/хорошая
     */
    public boolean isBad() {
        return bad;
    }

    /**
     * Сделать погоду плохой
     * @return Погода стала непогодой
     */
    public String Bad() {
        this.bad = true;
        return "Погода стала непогодой";
    }

    /**
     * Вывод погоды
     * @return Погода: плохая/хорошая
     */
    @Override
    public String toString() {
        return String.format(
                "Погода: %s",
                bad ? "плохая" : "хорошая"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return bad == weather.bad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bad);
    }

}
