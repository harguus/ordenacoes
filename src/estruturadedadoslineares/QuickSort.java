package estruturadedadoslineares;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
            Scanner scanner = new Scanner(new FileReader("/home/hargus/ifrn/lineares/ordenacoes/inputs/" + files[i]));

            while (scanner.hasNext()) {

                int valor = scanner.nextInt();
                arr[count] = valor;
                count++;
            }


            QuickSort quickSort = new QuickSort();
            long start = System.currentTimeMillis();
            quickSort.sort(arr, 0, arr.length - 1);
            long tempo = System.currentTimeMillis() - start;

            System.out.println(files[i]+ " : " + tempo);

        }

    }
}
