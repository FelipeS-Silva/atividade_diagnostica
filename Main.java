package atividade_diagnostica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atividade_diagnostica.produtos.EnumProdutos;

public class Main {

    public static void main(String[] args) {

        String inicio = """
                BEM VINDO AO MEU MERCADO
                """;

        System.out.println(inicio);

        List<EnumProdutos> produtos = new ArrayList<>();

        boolean querComprar = perguntaSeQuerComprar();

        while (querComprar) {
            
            querComprar = perguntaSeQuerComprar();

        }


    }

    // private static float calculaSoma(List<Produto> produtos){

    //     float valorFinal = 0;

    //     for (Produto produto : produtos) {
    //         valorFinal += produto.getValor();
    //     }

    //     return valorFinal;

    // }

    private static boolean perguntaSeQuerComprar(){

        Scanner scanner = new Scanner(System.in);
        
        String desejo = """
                Caso deseje comprar mais algum produto, digite 1. Caso não, digite qualquer outra
                """;

        System.out.println(desejo);

        return scanner.nextLine().equals("1");

    }

    private static void adicionarProduto(){

    }
    
}
