package estruturadedadoslineares;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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

    public static void main(String args[]) throws FileNotFoundException {
        String[] files = new String[9];
        files[0] = "teste_1000_1.dat";
        files[1] = "teste_1000_2.dat";
        files[2] = "teste_1000_3.dat";
        files[3] = "teste_10000_1.dat";
        files[4] = "teste_10000_2.dat";
        files[5] = "teste_10000_3.dat";
        files[6] = "teste_100000_1.dat";
        files[7] = "teste_100000_2.dat";
        files[8] = "teste_100000_3.dat";

        int[] tamanho = new int[9];
        tamanho[0] = 1001;
        tamanho[1] = 1001;
        tamanho[2] = 1001;
        tamanho[3] = 10001;
        tamanho[4] = 10001;
        tamanho[5] = 10001;
        tamanho[6] = 100001;
        tamanho[7] = 100001;
        tamanho[8] = 100001;

        //laço para gerar os vetores
        for (int i=0;i<9;i++){

            int arr[] = new int[tamanho[i]];
            int count = 0;
            Scanner scanner = new Scanner(new FileReader("/home/rodrigo/Projects/algoritmos-de-ordenacao/input/" + files[i]));

            while (scanner.hasNext()) {

                int valor = scanner.nextInt();
                arr[count] = valor;
                count++;
                //System.out.println(valor);
            }

            //System.out.println("\nArray para ser ordenado");

            MergeSort mergeSort = new MergeSort();
            long start = System.currentTimeMillis();
            mergeSort.sort(arr, 0, arr.length-1);
            long tempo = System.currentTimeMillis() - start;

            System.out.println(files[i]+ " : " + tempo);

            //System.out.println("\nArray ordenado");
            //printArray(arr);
        }

    }
}
