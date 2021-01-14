package Model;

/**
 * Выполнение животными действий
 */
public interface AnimalActionExecutor {

    /**
     * Задать действие животному
     * @param action действие
     */
    void setAction(AnimalAction action);

    /**
     * Выполнить действие животным
     */
    void makeAction();
}
