package Model;

import java.util.Objects;

/**
 * �����
 */
public class Fog {
    private boolean thick;

    /**
     * ����� ��������� ������
     * @return ������/������
     */
    public boolean isThick() {
        return thick;
    }

    /**
     * ������� ����� ����
     * @return ����� ���� ����
     */
    public String thick() {
        thick = true;
        return "����� ���� ����";
    }

    /**
     * ����� ������
     * @return �����: ������/������
     */
    @Override
    public String toString() {
        return String.format(
                "�����: %s",
                thick ? "������" : "������"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fog fog = (Fog) o;
        return thick == fog.thick;
    }

    @Override
    public int hashCode() {
        return Objects.hash(thick);
    }
}
