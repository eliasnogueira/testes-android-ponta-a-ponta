package com.eliasnogueira.trianguloapp.models;

import com.eliasnogueira.trianguloapp.interfaces.ITriangulo;


public class CalculaTriangulo {

    public static String calculaTipoTriangulo(String lado1, String lado2, String lado3) {
        String resultado = null;
        double lado1d = Double.parseDouble(lado1);
        double lado2d = Double.parseDouble(lado2);
        double lado3d = Double.parseDouble(lado3);

        if (lado1.isEmpty() || lado2.isEmpty() || lado3.isEmpty()) {
            resultado = ITriangulo.LADO_NAO_PREENCHIDO;

        } else if (lado1d <= 0 || lado2d <= 0 || lado3d <= 0) {
            resultado = ITriangulo.NAO_E_TRIANGULO;
        } else {
            if (lado1.equals(lado2) && lado2.equals(lado3)) {
                resultado = ITriangulo.TRIANGULO_EQUILATERO;

            } else if (lado1.equals(lado2) || (lado2.equals(lado3)) || lado1.equals(lado3) )  {
                resultado = ITriangulo.TRIANGULO_ISOSCELES;

            } else {
                resultado = ITriangulo.TRIANGULO_ESCALENO;
            }
        }
        return resultado;
    }
}
