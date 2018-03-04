package homework13temp2;

public enum Lectures implements GetDescription{
    LECTURE1 {
        @Override
        public String getDescription() { return "Введение"; }
    },
    LECTURE2 {
        @Override
        public String getDescription() {
            return "Скаляры";
        }
    },
    LECTURE3 {
        @Override
        public String getDescription() {
            return "Массивы";
        }
    },
    LECTURE4 {
        @Override
        public String getDescription() {
            return "Углубленное изучение массивов";
        }
    }
}
