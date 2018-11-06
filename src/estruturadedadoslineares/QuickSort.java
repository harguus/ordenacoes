package estruturadedadoslineares;

public class QuickSort {

    int particao(int arr[], int menor, int maior){
        int pivor = arr[maior];
        int iMenor = ( menor - 1 );
        for (int j = menor; j < maior; j++){
            // Se o elemento atual for menor que ou igual a pivor
            if ( arr[j] <= pivor ){
                iMenor++; // incremento o índice do elemento menor

                // troca o menor pelo elemento arr[j]
                int aux = arr[iMenor];
                arr[iMenor] = arr[j];
                arr[j] = aux;
            }
        }

        //troca o menor + 1
        int aux = arr[iMenor + 1];
        arr[iMenor + 1] = arr[maior];
        arr[maior] = aux;
        return iMenor + 1;
    }

    void sort(int arr[], int menor, int maior){
        if (menor < maior){
            int pivor = particao(arr, menor, maior);
            sort(arr, menor, pivor-1);
            sort(arr, pivor+1, maior);
        }
    }

    static void printArray(int arr[]){
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }


    public static void main(String args[]){
        int arr[] = {2, 17, 8, 5, 1, 5};
        int n = arr.length;

        System.out.println("\nArray para ser ordenado");
        printArray(arr);

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr, 0, n - 1);

        System.out.println("\nArray ordenado");
        printArray(arr);
    }
}
