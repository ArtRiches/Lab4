package Model;

import java.util.Objects;

/**
 * �����
 */
public class Door {
    private boolean open;

    /**
     * ������� �����
     */
    class DoorHandle {

        /**
         * ����������� �� ����� ����� ������� �����
         * @return open
         */
        public boolean isTouched() {
            return open;
        }
    }

    /**
     * ����� ��������� �����
     * @return �������/�������
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * �������� ���������: ������� �����
     * @param animal ��� ����������
     * @return ��� ���������� ������ �����
     */
    public String makeOpen(Animal animal) {
        open = true;
        return String.format("%s ������ �����", animal.getName());
    }

    /**
     * ����� �����
     * @return �����: �������/�������
     */
    @Override
    public String toString() {
        return String.format(
                "�����: %s",
                open ? "�������" : "�������"
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        return open == door.open;
    }

    @Override
    public int hashCode() {
        return Objects.hash(open);
    }
}
