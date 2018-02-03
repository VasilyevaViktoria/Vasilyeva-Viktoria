package homework7temp2.Figure;

public abstract class Figure {

    private String name;

    public Figure(String name) {
        this.name = name;
    }

    public abstract double areaOfFigure();

    public String getName() {
        return name;
    }

    public boolean isAreasEquals(Figure figureNew) {
        return this.areaOfFigure() == figureNew.areaOfFigure();
    }
}
