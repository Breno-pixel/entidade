package com.exemplo1;

import com.exemplo.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
        EntityManager em = emf.createEntityManager();

        Produto produto = new Produto();
        produto.setNome("Notebook");
        produto.setPreco(3500.00);
        produto.setQuantidade(10);

        em.getTransaction().begin();
        em.persist(produto); // Salva o produto no banco de dados
        em.getTransaction().commit();

        System.out.println("Produto cadastrado com sucesso!");

        em.close();
        emf.close();
    }
}
