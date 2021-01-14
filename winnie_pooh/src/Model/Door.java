package Model;

import java.util.Objects;

/**
 * Дверь
 */
public class Door {
    private boolean open;

    /**
     * Дверная ручка
     */
    class DoorHandle {

        /**
         * Докоснуться до ручки чтобы открыть дверь
         * @return open
         */
        public boolean isTouched() {
            return open;
        }
    }

    /**
     * Вывод состояния двери
     * @return открыта/закрыта
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * Действие животного: окртыть дверь
     * @param animal имя животоного
     * @return имя животоного открыл дверь
     */
    public String makeOpen(Animal animal) {
        open = true;
        return String.format("%s открыл дверь", animal.getName());
    }

    /**
     * Вывод двери
     * @return Дверь: открыта/закрыта
     */
    @Override
    public String toString() {
        return String.format(
                "Дверь: %s",
                open ? "открыта" : "закрыта"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return open == door.open;
    }

    @Override
    public int hashCode() {
        return Objects.hash(open);
    }
}
