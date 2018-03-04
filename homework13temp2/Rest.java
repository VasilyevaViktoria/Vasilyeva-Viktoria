package homework13temp2;

public enum Rest implements GetDescription{
    REST1 {
        @Override
        public String getDescription() {
            return "Перерыв";
        }
    },
    REST2 {
        @Override
        public String getDescription() {
            return "Обеденный перерыв";
        }
    },
    REST3 {
        @Override
        public String getDescription() {
            return "Разминка";
        }
    }
}
