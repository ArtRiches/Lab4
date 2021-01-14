package Model;

import java.util.Objects;

/**
 * ���� �������� � ����������� ������� � ������
 */
public class AnimalChildEmotions extends AnimalChildEat{

    /**
     * ������ ��������� �������
     */
    private boolean happy;

    /**
     * ����� �� ��������� ������� �������
     */
    private boolean cold;

    /**
     * ���� ��������� �������
     * @param name ��� ���������� �������
     * @param happy ��������(�)/�� ��������(�)
     */
    public AnimalChildEmotions(String name, boolean happy) {
        super(name, false);
        this.happy = happy;
    }

    /**
     * ����� ������ ���������� �������
     * @return ��������(�)/�� ��������(�)
     */
    public boolean isHappy() {
        return happy;
    }

    /**
     * ������� ���������� ������� ����������
     * @return ��� ���������� ������� ����(�) ����������(��)
     */
    public String makeHappy() {
        this.happy = true;
        return String.format("%s ����(�) ����������(��)", getName());
    }

    /**
     * ������� ���������� ������� �� ����������
     * @return ��� ���������� ������� ���� �� ����������
     */
    public String makeUnHappy() {
        this.happy = true;
        return String.format("%s ���� �� ����������", getName());
    }

    /**
     * ����� �������� ������ �������� ��������
     * @return ��� ���������� �������(�) ����� �������
     */
    public boolean isCold() {return cold;}

    public String makeCold() {
        this.cold = true;
        return String.format("%s(�) ����� �������", getName());
    }

    /**
     * ����� ���������� ������� � ���������� �������
     * @return �������� �������: ��� ���������� ������� ��������(�)/�� ��������(�)
     */
    @Override
    public String toString() {
        return String.format(
                "�������� �������: %s, %s",
                getName(),
                happy ? "��������(�)" : "�� ��������(�)"

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
