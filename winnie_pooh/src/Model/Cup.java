package Model;

import java.util.Objects;

/**
 * Чашка
 */
public class Cup {

    /**
     * Владелец чашки
     */
    private final Animal owner;

    /**
     * Полнота чашки
     */
    private boolean full;

    /**
     * Ввод чашки
     * @param owner имя животоного владельца чашки
     */
    public Cup(Animal owner) {
        this.owner = owner;
    }

    /**
     * Наплнить чашку
     * @param animal имя животоного кто наполняет чашку
     * @return имя животнго наполнил(а) чашку имя животного владельца чашки
     */
    public String fill(Animal animal) {
        full = true;
        return String.format("%s наполнил(а) чашку %s", animal.getName(), owner.getName());
    }

    /**
     * Выпить из кружки
     * @return имя животного владельца чашки выпил(a) содержимое чашки
     */
    public String use() {
        full = false;
        return String.format("%s выпил(a) содержимое чашки", owner.getName());
    }

    /**
     * Вывод состояния чашки
     * @return full
     */
    public boolean isFull() {
        return full;
    }

    /**
     * Вывод чашки
     * @return Чашка: владелец имя животного владельца чашки
     */
    @Override
    public String toString() {
        return String.format(
                "Чашка: владелец %s",
                owner.getName()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cup cup = (Cup) o;
        return full == cup.full &&
                Objects.equals(owner, cup.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, full);
    }
}
