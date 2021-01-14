package Model;

import java.util.Objects;

/**
 * ƒети животные с параметрами голода и рыбьего жиры
 */
public class AnimalChildEat extends AnimalChild {

    /**
     * —ытость животоного ребенка
     */
    private boolean fed;

    /**
     * ѕрин€тость рыбьего жира животным ребенком
     */
    private boolean tookFishOil;

    /**
     * ѕараметры которые нужно задать животному ребенку
     * @param name им€ животного
     * @param tookFishOil прин€л/неприн€л рыбий жир
     */
    public AnimalChildEat(String name, boolean tookFishOil) {
        super(name);
        this.tookFishOil = tookFishOil;
    }

    /**
     * ¬ывод состо€ни€ сытости животонго ребенка
     * @return сытый(а€)/голодный(а€)
     */
    public boolean isFed() {
        return fed;
    }

    /**
     * ƒействие животного ребенка: поесть
     * @return им€ животоного ребенка поел(а) и теперь не голодный(а€)
     */
    public String eat() {
        this.fed = true;
        return String.format("%s поел(а) и теперь не голодный(а€)", getName());
    }

    /**
     * ƒействие животного ребенка: проголодатьс€
     * @return им€ животоного ребенка снова хочет есть
     */
    public String hungry() {
        this.fed = false;
        return String.format("%s снова хочет есть", getName());
    }

    /**
     * ¬ывод сто€т€ние прин€тости рыбьего жира животоное ребенок
     * @return прин€л(a) рыбий жир/не прин€л рыбий жир
     */
    public boolean isTookFishOil() {
        return tookFishOil;
    }

    /**
     * ƒействие животного ребенка: принимать рыбий жир
     * @return им€ животоного ребенка прин€л(а) рыбий жир
     */
    public String takeFishOil() {
        this.tookFishOil = true;
        return String.format("%s прин€л(а) рыбий жир", getName());
    }

    /**
     * ¬ывод животоного ребенка
     * @return ∆ивотное –ебенок: им€ животоного ребенка прин€л/не прин€л рыбий жир сытый(а€)/голодный(а€)
     */
    @Override
    public String toString() {
        return String.format(
                "∆ивотное –ебенок: %s, %s, %s",
                getName(),
                tookFishOil ? "прин€л(a) рыбий жир" : "не прин€л рыбий жир",
                fed ? "сытый(а€)" : "голодный(а€)"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AnimalChildEat that = (AnimalChildEat) o;
        return fed == that.fed &&
                tookFishOil == that.tookFishOil;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fed, tookFishOil);
    }
}
