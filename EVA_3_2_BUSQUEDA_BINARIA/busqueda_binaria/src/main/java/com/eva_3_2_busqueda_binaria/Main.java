package com.eva_3_2_busqueda_binaria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = new int [10];
        fillArray(arreglo);
        System.out.println("------ Arreglo Original ------");
        imprimir(arreglo);
        selectionSort(arreglo);
        System.out.println("------ Arreglo Ordenado ------");
        imprimir(arreglo);
        
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que valor buscas");
        int valor = sc.nextInt();
        System.out.println("Valor en la posicion :" + busquedaBinaria(arreglo, valor ));     
    }
    //Fill arreglo
    public static void fillArray(int[] arreglo) {
        for (int i = 0; i < 10; i++) {
            arreglo[i] = (int) (Math.random() * 100);
        }
    }
    //Imprimir arreglo
    public static void imprimir(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(" [" + arreglo[i] + "] ");
        }
        System.out.println("");
    }
    //Sort
    public static void selectionSort(int [] arreglo){
        for(int i =0;i<arreglo.length;i++){//pasadas *runs
            int min = i; 
            for(int j=i+1; j<arreglo.length; j++){//busqueda
             if(arreglo[min]>arreglo[j]){
                min=j;//nuevo valor mas pequeño
            }
        }
        int temp =arreglo[min];
        arreglo[min]=arreglo[i];
        arreglo[i]=temp;
        }
    }
    //busqueda binaria
    public static int busquedaBinaria(int[] arreglo, int valor){
        return busquedaBinariaRecu(arreglo,  valor, 0, arreglo.length -1);
    }
        
    private static int busquedaBinariaRecu(int[] arreglo, int valor, int ini, int fin){
        int mitad = ini +((fin -ini ) /2);
        int posicion = -1; //indica que no se encontro
         if(ini <= fin){//detener recursividad 
            //busqueda binaria
            if (valor > arreglo[mitad]){ //NO LO ENCONTRAMOS, BUSCAMOS A LA DERECHA
                posicion = busquedaBinariaRecu(arreglo, valor, mitad + 1, fin);
            }else if(valor < arreglo[mitad]){//NO LO ENCONTRAMOS BUSCAMOS A LA IZQUIERDA
                posicion = busquedaBinariaRecu(arreglo, valor, mitad - 1, fin);
            }else // LO ENCONTRAMOS
                posicion = mitad;
        }
        return posicion;
    }
}