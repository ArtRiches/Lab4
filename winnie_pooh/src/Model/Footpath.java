package Model;

import java.util.Objects;

/**
 * ��������
 */
public class Footpath {
    private boolean narrow;

    /**
     * ��������� ��������
     * @return �����/�������
     */
    public boolean isNarrow() {
        return narrow;
    }

    /**
     * ������� ������� ���
     * @return �������� ����� ���
     */
    public String Narrow() {
        this.narrow = true;
        return "�������� ����� ���";
    }

    /**
     * ����� �������
     * @return ��������: �����/�������
     */
    @Override
    public String toString() {
        return String.format(
                "��������: %s",
                narrow ? "�����" : "�������"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footpath footpath = (Footpath) o;
        return narrow == footpath.narrow;
    }

    @Override
    public int hashCode() {
        return Objects.hash(narrow);
    }
}
