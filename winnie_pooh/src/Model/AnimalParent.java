package Model;

/**
 * �������� ��������
 */
public class AnimalParent extends Animal {

    /**
     * ���� ��������� ��������
     * @param name ��� ��������� ��������
     */
    public AnimalParent(String name) {
        super(name);
    }

    /**
     * ����� ��������� ��������
     * @return �������� ��������: ��� ��������� ��������
     */
    @Override
    public String toString() {
        return String.format(
                "�������� ��������: %s",
                getName()
        );
    }
}
