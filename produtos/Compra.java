package atividade_diagnostica.produtos;

import java.util.List;

public class Compra {

    private double valorFinal;

    public Compra(){
        this.valorFinal = 0f;
    }

    public double getValorFinal(){
        return valorFinal;
    }

    public void adicionaProduto(int idProduto){

        valorFinal += EnumProdutos.getById(idProduto).getPreco();

    }

    public void exibeProdutos(List<EnumProdutos> produtos){

        StringBuffer sb = new StringBuffer("Sua lista de compra possui os seguintes itens:\n");

        for (EnumProdutos produto : produtos) {
            sb.append(produto.getNome()).append(" - R$").append(produto.getPreco()).append("\n");
        }

        sb.append(String.format("O valor atual de sua compra é R$%.2f", valorFinal)).append("\n");

    }
    
}
