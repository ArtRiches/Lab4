package Model;

import java.lang.reflect.Type;

/**
 * Яма
 */
public class Pit {

    /**
     * Тип земли
     */
    static class GroundType {

        /**
         * Тип
         */
        String type;

        /**
         * Ввод типа земли
         * @param type тип
         */
        public GroundType(String type) { this.type = type; }

        /**
         * Вывод типа земли
         * @return Почва: тип
         */
        @Override
        public String toString() {
            return String.format("Почва: %s", type);
        }
    }
    
    GroundType groundType = new GroundType("Песок");

    /**
     * Вывод ямы
     * @return Яма: тип земли
     */
    @Override
    public String toString() {
        return (String.format("Яма: %s", groundType.toString()));
    }

}
