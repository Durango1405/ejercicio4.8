import java.util.*;

// Clase abstracta FiguraGeometrica
abstract class FiguraGeometrica {
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
}

// Clase Círculo
class Circulo extends FiguraGeometrica {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
}

// Clase Rectángulo
class Rectangulo extends FiguraGeometrica {
    private double base;
    private double altura;

    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return base * altura;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
}

// Clase Cuadrado
class Cuadrado extends FiguraGeometrica {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    @Override
    public double calcularArea() {
        return lado * lado;
    }

    @Override
    public double calcularPerimetro() {
        return 4 * lado;
    }
}

// Clase TriánguloRectangulo (hereda de Rectangulo)
class TrianguloRectangulo extends Rectangulo {
    public TrianguloRectangulo(double base, double altura) {
        super(base, altura);
    }

    public double calcularHipotenusa() {
        return Math.sqrt(base * base + altura * altura);
    }

    public String determinarTipoTriangulo() {
        if (base == altura)
            return "Equilátero: todos sus lados son iguales.";
        else if (base == altura || base == calcularHipotenusa() || altura == calcularHipotenusa())
            return "Isósceles: tiene dos lados iguales.";
        else
            return "Escaleno: todos sus lados son diferentes.";
    }
}

public class PruebaFigurasGeometricas {
    public static void main(String[] args) {
        // Crear las cuatro figuras geométricas
        FiguraGeometrica circulo = new Circulo(5.0);
        FiguraGeometrica rectangulo = new Rectangulo(4.0, 6.0);
        FiguraGeometrica cuadrado = new Cuadrado(3.0);
        FiguraGeometrica trianguloRectangulo = new TrianguloRectangulo(5.0, 4.0);

        // Calcular y mostrar las áreas y perímetros
        System.out.println("Área del Círculo: " + circulo.calcularArea());
        System.out.println("Perímetro del Círculo: " + circulo.calcularPerimetro());

        System.out.println("Área del Rectángulo: " + rectangulo.calcularArea());
        System.out.println("Perímetro del Rectángulo: " + rectangulo.calcularPerimetro());

        System.out.println("Área del Cuadrado: " + cuadrado.calcularArea());
        System.out.println("Perímetro del Cuadrado: " + cuadrado.calcularPerimetro());

        System.out.println("Área del Triángulo Rectángulo: " + trianguloRectangulo.calcularArea());
        System.out.println("Perímetro del Triángulo Rectángulo: " + trianguloRectangulo.calcularPerimetro());

        // Calcular la hipotenusa y determinar el tipo de triángulo rectángulo
        if (trianguloRectangulo instanceof TrianguloRectangulo) {
            TrianguloRectangulo triangulo = (TrianguloRectangulo) trianguloRectangulo;
            System.out.println("Hipotenusa del Triángulo Rectángulo: " + triangulo.calcularHipotenusa());
            System.out.println("Tipo de Triángulo Rectángulo: " + triangulo.determinarTipoTriangulo());
        }
    }
}


