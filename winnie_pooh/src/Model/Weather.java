package Model;

import java.util.Objects;

/**
 * ������
 */
public class Weather {

    /**
     * ��������� ������
     */
    private boolean bad;

    /**
     * ����� ���������� ������
     * @return ������/�������
     */
    public boolean isBad() {
        return bad;
    }

    /**
     * ������� ������ ������
     * @return ������ ����� ���������
     */
    public String Bad() {
        this.bad = true;
        return "������ ����� ���������";
    }

    /**
     * ����� ������
     * @return ������: ������/�������
     */
    @Override
    public String toString() {
        return String.format(
                "������: %s",
                bad ? "������" : "�������"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return bad == weather.bad;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bad);
    }

}
