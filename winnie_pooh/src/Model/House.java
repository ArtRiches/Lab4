package Model;

import java.util.Objects;

/**
 * ���
 */
public class House {
    /**
     * �������� ����
     */
    private final Animal houseOwner;

    /**
     * ���� ����
     * @param houseOwner ��� ���������� ��������� ����
     */
    public House(Animal houseOwner) { this.houseOwner = houseOwner;}

    /**
     * ����� ����
     * @return ���: �������� ��� ���������� ��������� ����
     */
    @Override
    public String toString() {
        return String.format(
                "���: �������� %s",
                houseOwner.getName()
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseOwner);
    }
}