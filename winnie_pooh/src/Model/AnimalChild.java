package Model;

/**
 * ���� ��������
 */
public class AnimalChild extends Animal {
    /**
     * ���� ��������� �������
     * @param name ��� ��������� �������
     */
    public AnimalChild(String name) {
        super(name);
    }

    /**
     * ����� ��������� �������
     * @return �������� �������: ��� ���������
     */
    @Override
    public String toString() {
        return String.format(
                "�������� �������: %s",
                getName()
        );
    }
}
