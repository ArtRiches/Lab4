package Model;

import java.util.Objects;

/**
 * Дом
 */
public class House {
    /**
     * Владелец дома
     */
    private final Animal houseOwner;

    /**
     * Ввод дома
     * @param houseOwner имя животоного владельца дома
     */
    public House(Animal houseOwner) { this.houseOwner = houseOwner;}

    /**
     * Вывод дома
     * @return Дом: владелец имя животоного владельца дома
     */
    @Override
    public String toString() {
        return String.format(
                "Дом: владелец %s",
                houseOwner.getName()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseOwner);
    }
}