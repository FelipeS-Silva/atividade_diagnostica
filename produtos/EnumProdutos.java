package atividade_diagnostica.produtos;

public enum EnumProdutos {

    ARROZ(1, "Arroz", 5.99),
    FEIJAO(2, "Feijão", 7.49),
    MACARRAO(3, "Macarrão", 3.89),
    OLEO(4, "Óleo de Soja", 6.29),
    ACUCAR(5, "Açúcar", 4.59),
    SAL(6, "Sal", 2.19),
    CAFE(7, "Café", 9.99),
    LEITE(8, "Leite", 4.79),
    BISCOITO(9, "Biscoito", 3.49),
    FARINHA(10, "Farinha de Trigo", 4.39);

    private final int id;
    private final String nome;
    private final double preco;

    EnumProdutos(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public static EnumProdutos getById(int id) {
        for (EnumProdutos produto : EnumProdutos.values()) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public static void exibirProdutos(){

        EnumProdutos[] produtos = EnumProdutos.values();
        
        StringBuffer sb = new StringBuffer("Escolha seu produto: \n");

        for (EnumProdutos produto : produtos) {
            sb.append(produto.id).append(") ").append(produto.nome).append(" - R$").append(produto.preco).append("\n");
        }

        System.out.println(sb.toString());

    }
    
}
