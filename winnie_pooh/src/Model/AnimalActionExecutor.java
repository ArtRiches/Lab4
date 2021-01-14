package Model;

/**
 * ���������� ��������� ��������
 */
public interface AnimalActionExecutor {

    /**
     * ������ �������� ���������
     * @param action ��������
     */
    void setAction(AnimalAction action);

    /**
     * ��������� �������� ��������
     */
    void makeAction();
}
