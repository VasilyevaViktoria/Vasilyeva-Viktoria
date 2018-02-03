package homework7temp2.Figure;

public enum TypeOfRectangle implements DescriableFigures {
    RECTANGLE {
        @Override
        public String getDescription() {
            return "Данная фигура - прямоугольник";
        }
    },
    SQUARE {
        @Override
        public String getDescription() {
            return "Данная фигура - квадрат";
        }
    },
    NOTQUADRANGLE {
        @Override
        public String getDescription() {
            return "Данная фигура - ни прямоугольник, ни квадрат";
        }
    }
}
