package Model;

import java.util.Objects;

/**
 * ����������� ����� ��������
 */
public abstract class Animal implements AnimalActionExecutor {

    /**
     * ��� ����������
     */
    private final String name;

    /**
     * ������� ���������
     */
    private AnimalAction action;

    /**
     * ��� ���������
     * @param name ��� ���������
     */
    public Animal(String name) {
        this.name = name;
    }

    /**
     * ������ ��������� ��������
     * @param action �������� ���������
     */
    public void setAction(AnimalAction action) {
        this.action = action;
    }

    /**
     * ��������� ��������� ��������
     */
    public void makeAction() {
        action.make();
    }

    /**
     * ������ ��� ���������
     * @return ��� ���������
     */
    public String getName() {
        return name;
    }

    /**
     * ����� ���������
     * @return ��������: ��� ���������
     */
    @Override
    public String toString() {
        return String.format("��������: %s", name);
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
