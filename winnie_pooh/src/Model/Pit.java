package Model;

import java.lang.reflect.Type;

/**
 * ���
 */
public class Pit {

    /**
     * ��� �����
     */
    static class GroundType {

        /**
         * ���
         */
        String type;

        /**
         * ���� ���� �����
         * @param type ���
         */
        public GroundType(String type) { this.type = type; }

        /**
         * ����� ���� �����
         * @return �����: ���
         */
        @Override
        public String toString() {
            return String.format("�����: %s", type);
        }
    }
    
    GroundType groundType = new GroundType("�����");

    /**
     * ����� ���
     * @return ���: ��� �����
     */
    @Override
    public String toString() {
        return (String.format("���: %s", groundType.toString()));
    }

}
