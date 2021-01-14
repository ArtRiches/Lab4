package Model;

import java.util.Objects;

/**
 * ���� �������� � ����������� ������ � ������� ����
 */
public class AnimalChildEat extends AnimalChild {

    /**
     * ������� ���������� �������
     */
    private boolean fed;

    /**
     * ���������� ������� ���� �������� ��������
     */
    private boolean tookFishOil;

    /**
     * ��������� ������� ����� ������ ��������� �������
     * @param name ��� ���������
     * @param tookFishOil ������/�������� ����� ���
     */
    public AnimalChildEat(String name, boolean tookFishOil) {
        super(name);
        this.tookFishOil = tookFishOil;
    }

    /**
     * ����� ��������� ������� ��������� �������
     * @return �����(��)/��������(��)
     */
    public boolean isFed() {
        return fed;
    }

    /**
     * �������� ��������� �������: ������
     * @return ��� ���������� ������� ����(�) � ������ �� ��������(��)
     */
    public String eat() {
        this.fed = true;
        return String.format("%s ����(�) � ������ �� ��������(��)", getName());
    }

    /**
     * �������� ��������� �������: �������������
     * @return ��� ���������� ������� ����� ����� ����
     */
    public String hungry() {
        this.fed = false;
        return String.format("%s ����� ����� ����", getName());
    }

    /**
     * ����� ��������� ���������� ������� ���� ��������� �������
     * @return ������(a) ����� ���/�� ������ ����� ���
     */
    public boolean isTookFishOil() {
        return tookFishOil;
    }

    /**
     * �������� ��������� �������: ��������� ����� ���
     * @return ��� ���������� ������� ������(�) ����� ���
     */
    public String takeFishOil() {
        this.tookFishOil = true;
        return String.format("%s ������(�) ����� ���", getName());
    }

    /**
     * ����� ���������� �������
     * @return �������� �������: ��� ���������� ������� ������/�� ������ ����� ��� �����(��)/��������(��)
     */
    @Override
    public String toString() {
        return String.format(
                "�������� �������: %s, %s, %s",
                getName(),
                tookFishOil ? "������(a) ����� ���" : "�� ������ ����� ���",
                fed ? "�����(��)" : "��������(��)"
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
