package Model;

import java.util.Objects;

/**
 * Дети животные с параметрами сытости и эмоций
 */
public class AnimalChildEmotions extends AnimalChildEat{

    /**
     * Эмоции животного ребенка
     */
    private boolean happy;

    /**
     * Стало ли животному ребенку холодно
     */
    private boolean cold;

    /**
     * Ввод животного ребенка
     * @param name имя животоного ребенка
     * @param happy счастлив(а)/не счастлив(а)
     */
    public AnimalChildEmotions(String name, boolean happy) {
        super(name, false);
        this.happy = happy;
    }

    /**
     * Вывод эмоций животоного ребенка
     * @return счастлив(а)/не счастлив(а)
     */
    public boolean isHappy() {
        return happy;
    }

    /**
     * Сделать животоного ребенка счастливым
     * @return имя животоного ребенка стал(а) счастливым(ой)
     */
    public String makeHappy() {
        this.happy = true;
        return String.format("%s стал(а) счастливым(ой)", getName());
    }

    /**
     * Сделать животоного ребенка не счастливым
     * @return имя животоного ребенка стал не счастливым
     */
    public String makeUnHappy() {
        this.happy = true;
        return String.format("%s стал не счастливым", getName());
    }

    /**
     * Вывод ощущений холода животным ребенком
     * @return имя животоного ребенка(у) стало холодно
     */
    public boolean isCold() {return cold;}

    public String makeCold() {
        this.cold = true;
        return String.format("%s(у) стало холодно", getName());
    }

    /**
     * Вывод животоного ребенка с параметром счастья
     * @return Животное Ребенок: имя животоного ребенка счастлив(а)/не счастлив(а)
     */
    @Override
    public String toString() {
        return String.format(
                "Животное Ребенок: %s, %s",
                getName(),
                happy ? "счастлив(а)" : "не счастлив(а)"

        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalChildEmotions that = (AnimalChildEmotions) o;
        return happy == that.happy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), happy);
    }
}
