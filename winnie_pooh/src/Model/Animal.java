package Model;

import java.util.Objects;

/**
 * Абстрактный класс животных
 */
public abstract class Animal implements AnimalActionExecutor {

    /**
     * Имя животоного
     */
    private final String name;

    /**
     * Дествие животного
     */
    private AnimalAction action;

    /**
     * Имя животного
     * @param name имя животного
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * Задать животному действие
     * @param action действие животного
     */
    public void setAction(AnimalAction action) {
        this.action = action;
    }

    /**
     * Выполнить животному действие
     */
    public void makeAction() {
        action.make();
    }

    /**
     * Узнать имя животного
     * @return имя животного
     */
    public String getName() {
        return name;
    }

    /**
     * Вывод живтоного
     * @return Животное: имя животного
     */
    @Override
    public String toString() {
        return String.format("Животное: %s", name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(name, animal.name) &&
                Objects.equals(action, animal.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, action);
    }
}
