package Model;

/**
 * Шишка
 */
public class Cone {

    /**
     * Кинуть шишку
     * @param performer имя животоного тот кто кидает
     * @param target имя животоного в кого кидают
     * @return имя животоного кинул(а) шишку в имя животного
     */
    public String hurl(Animal performer, Animal target) {
        return String.format("%s кинул(а) шишку в %s", performer.getName(), target.getName());
    }

    /**
     * Вывод шишки
     * @return Шишка
     */
    @Override
    public String toString() {
        return "Шишка";
    }
}
