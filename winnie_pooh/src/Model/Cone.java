package Model;

/**
 * �����
 */
public class Cone {

    /**
     * ������ �����
     * @param performer ��� ���������� ��� ��� ������
     * @param target ��� ���������� � ���� ������
     * @return ��� ���������� �����(�) ����� � ��� ���������
     */
    public String hurl(Animal performer, Animal target) {
        return String.format("%s �����(�) ����� � %s", performer.getName(), target.getName());
    }

    /**
     * ����� �����
     * @return �����
     */
    @Override
    public String toString() {
        return "�����";
    }
}
