package Model;

/**
 * Животное родитель
 */
public class AnimalParent extends Animal {

    /**
     * Ввод животного родителя
     * @param name имя животного родителя
     */
    public AnimalParent(String name) {
        super(name);
    }

    /**
     * Вывод животного родителя
     * @return Животное Родитель: имя животного родителя
     */
    @Override
    public String toString() {
        return String.format(
                "Животное Родитель: %s",
                getName()
        );
    }
}
