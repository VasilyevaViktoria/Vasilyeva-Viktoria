package homework7temp2.Figure;

public enum TypeOfTriangle implements DescriableFigures {
    RECTANGULAR {
        @Override
        public String getDescription() {
            return "прямоугольный";
        }
    },
    ACUTEANGLED {
        @Override
        public String getDescription() {
            return "остроугольный";
        }
    },
    OBTUSE {
        @Override
        public String getDescription() {
            return "тупоугольный";
        }
    },
    NOTEXIST {
        @Override
        public String getDescription() {
            return "Ошибка";
        }
    }
}
