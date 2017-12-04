package br.com.siquieri.utils;

import br.com.siquieri.entity.Produto;
import java.util.ArrayList;

public class Carrinho {
    private static ArrayList<Produto> produtos;
    
    public Carrinho() {
        this.setProdutos(new ArrayList<>());
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        Carrinho.produtos = produtos;
    }   
    
    public double calcularTotal(Carrinho carrinho) {
        double total = 0.0;
        for (Produto prod : carrinho.getProdutos()) {
            total = total + (prod.getPreco() * prod.getQuantidade());
        }
        return total;
    }
            
}
