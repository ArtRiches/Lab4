package Model;

/**
 * ��������� ��������
 */
public enum ActionIntent {

    /**
     * ��������� �������� ��������
     */
    ACCIDENTALLY {
        @Override
        public String toString() {
            return "��������";
        }
    },

    /**
     * ��������� �������� ����������
     */
    ESPECIALLY {
        @Override
        public String toString() {
            return "����������";
        }
    };
}
