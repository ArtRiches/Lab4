package Model;

import java.util.Objects;

/**
 * ���
 */
public class Forest {
    private boolean quiet;

    /**
     * ����� ��������� ����
     * @return �����/������ �����
     */
    public boolean isQuiet() {
        return quiet;
    }

    /**
     * ������� ��� �����
     * @return � ���� ����� ����� ����
     */
    public String quiet() {
        quiet = true;
        return "� ���� ����� ����� ����";
    }

    /**
     * ����� ����
     * @return ���: �����/������ �����
     */
    @Override
    public String toString() {
        return String.format(
                "���: %s",
                quiet ? "�����" : "������ �����"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forest forest = (Forest) o;
        return quiet == forest.quiet;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quiet);
    }
}
