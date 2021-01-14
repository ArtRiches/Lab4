package Model;

/**
 * Намерение действия
 */
public enum ActionIntent {

    /**
     * Выполнить дейтсвие случайно
     */
    ACCIDENTALLY {
        @Override
        public String toString() {
            return "случайно";
        }
    },

    /**
     * Выполнить действие специально
     */
    ESPECIALLY {
        @Override
        public String toString() {
            return "специально";
        }
    };
}
