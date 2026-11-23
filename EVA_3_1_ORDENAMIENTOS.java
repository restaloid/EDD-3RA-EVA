public class EVA_3_1_ORDENAMIENTOS {
    public static void main(String[] args) {
            int[] original, selection, insertion, bubble, quicksortt;
            original = new int[10];
            llenar(original);
            ///Arreglo original
            System.out.println("++++++++++++++ Original Array ++++++++++++++");
            imprimir(original);
            //sorters
            //Slection sort
            System.out.println("..................Selection sort..................");
            selection = copiar(original);
            long ini = System.nanoTime();
            selectionSort(selection);
            long fin = System.nanoTime();
            imprimir(selection);
            long tiempo = fin-ini;
            System.out.println("Selection Sort = "+tiempo);
            System.out.println("..................Insertion sort..................");
            insertion = copiar(original);
            ini = System.nanoTime();
            insertionSort(insertion);
            fin = System.nanoTime();
            imprimir(insertion);
            tiempo = fin-ini;
            System.out.println("Insertion Sort = "+tiempo);            
            //Bubble sort
            System.out.println("..................Bubble sort..................");
            bubble= copiar(original);
            ini = System.nanoTime();
            bubbleSort(bubble);
            fin = System.nanoTime();
            imprimir(bubble);
            tiempo = fin-ini;
            System.out.println("Bubble Sort = "+tiempo);
            System.out.println("..................Quick Sort..................");
            quicksortt= copiar(original);
            ini = System.nanoTime();
            quickSor(quicksortt);
            fin = System.nanoTime();
            imprimir(quicksortt);
            tiempo = fin-ini;
            System.out.println("Quick Sort = "+tiempo);


        }


        public static void llenar(int[] arreglo){
            for(int i=0; i<arreglo.length;i++){
                arreglo[i]=((int) (Math.random()*100)) ;
            }
        }
        public static void imprimir(int[] arreglo){
            for(int i=0; i<arreglo.length;i++){
                System.out.print("["+ arreglo[i]+"]");
            }
            System.out.println("");
        }
        public static int[] copiar(int[] arreglo){
            int[] copiar = new int[arreglo.length];        
            for(int i=0; i<arreglo.length; i++){
                copiar[i]=arreglo[i];       
            }
            return copiar;
        }
        //o(N^2)
        public static void selectionSort(int [] arreglo){
            for(int i =0;i<arreglo.length;i++){//pasadas *runs
                int min = i;
                for(int j=i+1; j<arreglo.length; j++){//busqueda
                    //Busqueda del minimo mas little
                    if(arreglo[min]>arreglo[j]){
                        min=j;//nuevo valor mas pequeño
                    }
                }
                //swap
                int temp =arreglo[min];
                arreglo[min]=arreglo[i];
                arreglo[i]=temp;
            }
        }
        //Bubble
        public static void bubbleSort(int []arreglo){
            for(int i = 0; i<arreglo.length; i++){
                for(int j =0; j<arreglo.length-1; j++){
                    if(arreglo[j]>arreglo[j+1]){//o(n^2 comparaciones)
                        int temp = arreglo[j]; //O(n^2)intercambios
                        arreglo[j]= arreglo[j+1];
                        arreglo[j+1]= temp;
                    }
                }
            }
        }

        //Insertion
        public static void insertionSort(int [] arreglo){
            for(int i=1; i<arreglo.length; i++){
                int insP = arreglo[i];
                int j = i-1;
                while (j>=0 && arreglo[j]>insP) {
                    arreglo[j+1]=arreglo[j];
                    j--;
                }
                arreglo[j+1]=insP;
            }    
        }

        public static void quickSor(int[] arreglo) {
            quickSortRec(arreglo, 0, arreglo.length - 1);
        }

        private static void quickSortRec(int[] arreglo, int ini, int fin) {
            if (ini < fin) { 
                int pivote = ini;
                int tooBig = ini + 1;
                int tooSmall = fin;

                while (tooBig <= tooSmall) {
                
                    while (tooBig <= fin && arreglo[tooBig] <= arreglo[pivote]) {
                        tooBig++;
                    }
               
                    while (tooSmall > ini && arreglo[tooSmall] >= arreglo[pivote]) {
                        tooSmall--;
                    }
                
                    if (tooBig < tooSmall) {
                        int temp = arreglo[tooBig];
                        arreglo[tooBig] = arreglo[tooSmall];
                        arreglo[tooSmall] = temp;
                    }
                }
                int temp = arreglo[pivote];
                arreglo[pivote] = arreglo[tooSmall];
                arreglo[tooSmall] = temp;
                quickSortRec(arreglo, ini, tooSmall - 1);
                quickSortRec(arreglo, tooSmall + 1, fin);
        }
    }
}
