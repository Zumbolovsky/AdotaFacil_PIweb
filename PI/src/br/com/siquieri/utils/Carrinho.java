package br.com.siquieri.utils;

import br.com.siquieri.entity.Produto;
import java.util.LinkedHashSet;
import java.util.Set;

public class Carrinho {
    private static Set<Produto> produtos;
    
    public Carrinho() {
        this.setProdutos(new LinkedHashSet<>());
    }

    public Set<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(LinkedHashSet<Produto> produtos) {
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
