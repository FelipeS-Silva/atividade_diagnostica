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
            
            compra.exibeProdutos(produtos);

            querComprar = perguntaSeQuerComprar(scanner);

        }

        // TODO Implementar gorjeta
        
        metodoPagamento(scanner, compra, produtos);

        String agradecimento = """
                Muito obrigado por comprar no meu mercadinho. Até a próxima
                """;

        System.out.println(agradecimento);

        System.exit(0);

    }

    private static boolean perguntaSeQuerComprar(Scanner scanner){
        
        String desejo = """
                Caso deseje comprar mais algum produto, digite 1. Caso não, digite qualquer outra coisa
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

        if(produto != null) {
            produtos.add(produto);
            compra.adicionaProduto(indice);
            System.out.println("Você adicionou o produto " + produto.getNome());
        }
        
    }

    private static void metodoPagamento(Scanner scanner, Compra compra, List<EnumProdutos> produtos){
        
        // Apenas PIX

        compra.exibeProdutos(produtos);

        System.out.println("Qual o valor a ser pago?");

        double pagamento = scanner.nextDouble();

        compra.abatePagamento(pagamento);

        if(compra.getValorFinal() > 0){
            
            metodoPagamento(scanner, compra, produtos);

        }else if(compra.getValorFinal() == 0){

            System.out.println("Valor totalmente pago. Sem troco");

        }else{

            System.out.println(String.format("Seu troco é de %.2f", compra.getValorFinal()*-1));
        }

    }
    
}
