package atividade_diagnostica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import atividade_diagnostica.produtos.Compra;
import atividade_diagnostica.produtos.EnumProdutos;

public class Main {

    public static void main(String[] args) {

        String inicio = """
                BEM VINDO AO MEU MERCADO
                Caso queira comprar algum produto, digite 1. Caso não, digite outro valor
                """;

        System.out.println(inicio);

        Scanner scanner = new Scanner(System.in);
        boolean querComprar = scanner.nextLine().equals("1");

        List<EnumProdutos> produtos = new ArrayList<>();
        Compra compra = new Compra();

        while (querComprar) {

            adicionarProduto(scanner, produtos, compra);
            
            querComprar = perguntaSeQuerComprar(scanner);

        }

        String agradecimento = """
                Muito obrigado por comprar no meu mercadinho. Até a próxima
                """;

        System.out.println(agradecimento);

        System.exit(0);

    }

    private static boolean perguntaSeQuerComprar(Scanner scanner){
        
        String desejo = """
                Caso deseje comprar mais algum produto, digite 1. Caso não, digite qualquer outra
                """;

        System.out.println(desejo);
        String linha = scanner.next();
        
        return linha.equals("1");

    }

    private static void adicionarProduto(Scanner scanner, List<EnumProdutos> produtos, Compra compra){

        EnumProdutos.exibirProdutos();
        System.out.println("O que deseja comprar?");
        int indice = scanner.nextInt();

        EnumProdutos produto = EnumProdutos.getById(indice);

        if(produto != null) produtos.add(produto);

        compra.adicionaProduto(indice);
        
        // scanner.close();

    }
    
}
