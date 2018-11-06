package estruturadedadoslineares;

public class MergeSort {

    void merge(int arr[], int esquerdo, int meio, int direito){
        int subEsquerdo = meio - esquerdo + 1;
        int subDireito = direito - meio;

        // arrays demporários
        int auxEsquerdo[] = new int [subEsquerdo];
        int auxDireito[] = new int [subDireito];

        //copia para os arrays temporários
        for (int i = 0; i < subEsquerdo; ++i)
            auxEsquerdo[i] = arr[esquerdo + i];
        for (int j = 0; j < subDireito; ++j)
            auxDireito[j] = arr[meio + 1+ j];


        // junta os arrays
        int i = 0, j = 0;
        int k = esquerdo;

        while (i < subEsquerdo && j < subDireito){
            if (auxEsquerdo[i] <= auxDireito[j]){
                arr[k] = auxEsquerdo[i];
                i++;
            }
            else{
                arr[k] = auxDireito[j];
                j++;
            }
            k++;
        }

        while (i < subEsquerdo){
            arr[k] = auxEsquerdo[i];
            i++;
            k++;
        }

        while (j < subDireito){
            arr[k] = auxDireito[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int esquerda, int direita){
        if (esquerda < direita){
            int meio = (esquerda + direita) / 2;
            sort(arr, esquerda, meio);
            sort(arr , meio + 1, direita);
            merge(arr, esquerda, meio, direita);
        }
    }

    static void printArray(int arr[]){
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]){
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("\nArray para ser ordenado");
        printArray(arr);

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr, 0, arr.length-1);

        System.out.println("\nArray ordenado");
        printArray(arr);
    }
}
