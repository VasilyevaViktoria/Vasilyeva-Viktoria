package homework13temp2;

public enum Practice implements GetDescription{
    PRACTICE1 {
        @Override
        public String getDescription() {
            return "Упражнения";
        }
    },
    PRACTICE2 {
        @Override
        public String getDescription() {
            return "Решения";
        }
    }
}
