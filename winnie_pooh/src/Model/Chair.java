package Model;

import java.util.Objects;

/**
 * ����
 */
public class Chair {
    /**
     * �������� �����: ����� ��� ����������
     */
    private boolean down;

    /**
     * ��������� ��������� �����
     * @return ����: ����������/�����
     */
    public boolean isDown() {
        return down;
    }

    /**
     * ������� ����� ��������� � � ����� ���������� ���������� ����
     * @param animal ��� ����������
     * @param actionIntent ��������� ��������
     * @return ��� ���������� ��������� �������� ���������� ����
     */
    public String makeDown(Animal animal, ActionIntent actionIntent) {
        down = true;
        return String.format("%s %s ���������� ����", animal.getName(), actionIntent);
    }

    /**
     * ����� �����: ���������� �� ��� �����
     * @return ����: ����������/�����
     */
    @Override
    public String toString() {
        return String.format(
                "����: %s",
                down ? "����������" : "�����"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chair chair = (Chair) o;
        return down == chair.down;
    }

    @Override
    public int hashCode() {
        return Objects.hash(down);
    }
}
