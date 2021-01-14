package Model;

/**
 * Дети животные
 */
public class AnimalChild extends Animal {
    /**
     * Ввод животного ребенка
     * @param name имя животного ребенка
     */
    public AnimalChild(String name) {
        super(name);
    }

    /**
     * Вывод живтоного ребенка
     * @return Животное Ребенок: имя животного
     */
    @Override
    public String toString() {
        return String.format(
                "Животное Ребенок: %s",
                getName()
        );
    }
}
