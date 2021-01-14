package Model;

import java.util.Objects;

/**
 * —тул
 */
public class Chair {
    /**
     * ѕараметр стула: стоит или перевернут
     */
    private boolean down;

    /**
     * ¬ывододит состо€ни€ стула
     * @return —тул: перевернут/стоит
     */
    public boolean isDown() {
        return down;
    }

    /**
     * ¬ыводит какое животоное и с каким намерением перевернул сутл
     * @param animal им€ животоного
     * @param actionIntent намерение действи€
     * @return »м€ животоного намерение действи€ перевернул стул
     */
    public String makeDown(Animal animal, ActionIntent actionIntent) {
        down = true;
        return String.format("%s %s перевернул стул", animal.getName(), actionIntent);
    }

    /**
     * ¬ывод стула: перевернут он или стоит
     * @return —тул: перевернут/стоит
     */
    @Override
    public String toString() {
        return String.format(
                "—тул: %s",
                down ? "перевернут" : "стоит"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return down == chair.down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(down);
    }
}
