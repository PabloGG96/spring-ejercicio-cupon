package com.example.Helpers;

import java.util.ArrayList;
import java.util.List;

public class Knapsack {


    public List<Integer> getMaximizedItemsIDByTop(int capacity, int[] W, int[] V) {

        //Se regresará null dada una de las siguientes condiciones
        //Si nuestros vector de pesos (enviamos el mismo para ser utilizado como vector V y W)
        //Si la longitud de ambos vectores son distintos
        //Si la capacidad maxima (nuestro tope) es menor a 0
        if (W == null || V == null || W.length != V.length || capacity < 0)
           return null;

        final int N = W.length;

        //Creamos una tabla que indique:
        //Filas: cantidad de items presentes en la lista de favoritos del usuario
        //Columnas: utilizaremos el monto del cupon + 1 para representar la cantidad de columnas

        int[][] DP = new int[N + 1][capacity + 1];

        for (int i = 1; i <= N; i++) {

            // Obtenemos el valor y el peso para esta iteración
            int w = W[i - 1];
            int v = V[i - 1];

            //Inicializamos una variable para recorrer cada una de las columnas generadas
            for (int sz = 1; sz <= capacity; sz++) {

                DP[i][sz] = DP[i - 1][sz];

                //Verificamos si la columna actual es mayor al peso leído para esta fila (item actual) y ademas que el valor de la celda anterior (fila) en la columna resultante de restar el valor de la iteración con el peso mas la suma del valor del item, sea menor que el valor de la celda actual.
                //Y buscaremos agregar siempre el valor máximo entre ambos
                if (sz >= w && DP[i - 1][sz - w] + v > DP[i][sz])
                    DP[i][sz] = DP[i - 1][sz - w] + v;
            }
        }

        //Una vez recorridos todos los pesos (columnas) de nuestra matriz, buscaremos cuales fueron los items que conforman la suma maxima
        int sz = capacity;
        List<Integer> itemsSelected = new ArrayList<>();

        //Usamos la tabla generada para obtener los items que generaron la suma maxima. En esta tabla miramos si:
        //DP[i][sz] != DP[i-1][sz]

        //Comenzamos de la ultima posición de la tabla y consultamos si el item en la fila anterior y misma columna es un valor distinto, quiere decir que se utilizo para encontrar el valor maximo.
        //Entonces, marcamos el item actual como item participante, lo agregamos a una lista y para la variable "sz" restamos el valor del item agregado e iteramos nuevamente.

        for (int i = N; i > 0; i--) {
            if (DP[i][sz] != DP[i - 1][sz]) {
                int itemIndex = i - 1;
                itemsSelected.add(itemIndex);
                sz -= W[itemIndex];
            }
        }

        // Ordenamos los items de menor a mayor (orden por defecto) y los enviamos nuevamente a nuestro servicio.
        java.util.Collections.sort(itemsSelected);
        return itemsSelected;

        // Si quisieramos regresar cual fue la suma maxima mediante este metodo, tenemos que devolver la ultima posición de la tabla
        //return DP[N][capacity];
    }



}
