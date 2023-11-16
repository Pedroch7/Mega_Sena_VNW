import java.util.Scanner;

public class Mega_Sena_VNW {

    static int NUMERO_SORTEADOS = 7;

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] resultado = sorteaSena();
        int[] aposta = new int[NUMERO_SORTEADOS];

       
        System.out.println("Escolha o seu número entre 0 e 100: ");
        for (int i = 0; i < NUMERO_SORTEADOS; i++) {
            int nroAposta;
            boolean repetido = false;

            do {
		System.out.print("Informe o número "+(i+1)+": ");
                nroAposta = teclado.nextInt();
                if (nroAposta <=0) {
                    System.out.println("Número inválido, aposta cancelada!");
                    return;
                }
                repetido = existeNumero(aposta, nroAposta);
                if (repetido) {
                    System.out.println("Esse número já foi!");
                }
            } while(repetido);

            aposta[i] = nroAposta;
        }

	System.out.println("\nConfira sua aposta: ");
        for (int i = 0; i < aposta.length; i++) {
             System.out.print(aposta[i] + " ");
        }

        System.out.println("\nResultado do sorteio: ");
        for (int i = 0; i < resultado.length; i++) {
             System.out.print(resultado[i] + " ");
        }

        int nroAcertos = contaAcertos(resultado, aposta);
        System.out.println("\nNúmero de acertos: "+nroAcertos);

        switch (nroAcertos) {
            case 5: System.out.println("Parabéns. Você ganhou 10 mil Reais!"); break;
            case 6: System.out.println("Parabéns. Você ganhou ci ci ci 50 mil Reais"); break;
            case 7: System.out.println("Parabéns campeão, você ganhou 200 200 mil reais!"); break;
            default: System.out.println("PARABÉNS, mas você só ganhou experiência!"); break;
        }
    }

   
    static int[] sorteaSena() {
        int[] resultado = new int[NUMERO_SORTEADOS];
        
        for (int i = 0; i < NUMERO_SORTEADOS; i++) {
            int sorteado;
            boolean repetido = false;

            do {
                sorteado = (int) (Math.random()*100)+0; 
                repetido = existeNumero(resultado, sorteado);
            } while(repetido);

            resultado[i] = sorteado;
        }
        return resultado;
    }

     static int contaAcertos(int[] sorteio, int[] aposta) {
        int acertos = 0;
          for (int i = 0; i < NUMERO_SORTEADOS; i++) {
             int nroAposta = aposta[i];

         
            if (existeNumero(sorteio, nroAposta)) {
                acertos++;
            }
        }
        return acertos;
    }

   
    static boolean existeNumero(int[] numeros, int n) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == n) {
                return true;
            }
        }
        return false;
    }

}