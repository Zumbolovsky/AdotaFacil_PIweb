package br.com.siquieri.utils;

import br.com.siquieri.entity.Produto;
import java.util.ArrayList;

public class Carrinho {
    private static ArrayList<Produto> produtos;
    
    public Carrinho() {
        this.setProdutos(null);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        Carrinho.produtos = produtos;
    }   
            
}
