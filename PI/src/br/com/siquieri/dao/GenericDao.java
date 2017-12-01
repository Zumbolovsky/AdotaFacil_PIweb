/*
Andrew Siquieri - RA: 20872955 
Hadil Karim - RA: 20745273
Guilherme Lins - RA: 20699690
José Netto - RA: 20163147
Selma Masuzawa - RA: 20680327
 */
package br.com.siquieri.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.siquieri.entity.Contato;
import br.com.siquieri.entity.Doacao;
import br.com.siquieri.entity.Usuario;
import br.com.siquieri.utils.JpaUtil;
import br.com.siquieri.utils.Seguranca;

//Dao para adicionar, listar, buscar e remover entidades no Banco de Dados
public class GenericDao<T extends Serializable> implements Dao<T> {

    private final Class<T> classe;
    protected EntityManager em;

    public GenericDao(Class<T> classe) {
        this.classe = classe;
    }

    @Override
    public void adicionar(T entidade) {
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(entidade);
        em.getTransaction().commit();
        em.close();
    }

    public void adicionarDoacao(int idUsuario, Doacao doacao) throws Exception {
        em = JpaUtil.getEntityManager();
        Usuario u = em.find(Usuario.class, idUsuario);
        if (u != null) {
            doacao.setUsuario(u);
            u.getDoacoes().add(doacao);

            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }
        em.close();
    }

    public void adicionarContato(int idUsuario, Contato contato) throws Exception {
        em = JpaUtil.getEntityManager();
        Usuario u = em.find(Usuario.class, idUsuario);
        if (u != null) {
            contato.setUsuario(u);
            u.getContatos().add(contato);

            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
        }
        em.close();
    }

    @Override
    public List<T> listar() {

        em = JpaUtil.getEntityManager();

        TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName(), classe);
        List<T> lista = query.getResultList();

        //em.close();
        return lista;
    }

    public List<T> listar(String email) {

        em = JpaUtil.getEntityManager();

        TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName() + " Where email = :email", classe);
        query.setParameter("email", email);
        List<T> lista = query.getResultList();

        //em.close();
        return lista;
    }

    @Override
    public T buscar(int id) {
        em = JpaUtil.getEntityManager();

        em.getTransaction().begin();
        T entidade = em.find(classe, id);
        em.getTransaction().commit();

        //em.close();
        return entidade;
    }

    public T buscarUsuario(String email) throws Exception {
        T entidade = null;

        try {
            em = JpaUtil.getEntityManager();

            TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName() + " Where email = :email", classe);
            query.setParameter("email", email);
            List<T> lista = query.getResultList();
            if (lista.size() != 0) {
                entidade = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return entidade;
    }

    public T buscarUsuario(String email, String senha) throws Exception {
        T entidade = null;
        senha = Seguranca.gerarMD5(senha);
        try {
            em = JpaUtil.getEntityManager();

            TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName() + " Where email = :email and senha = :senha", classe);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            List<T> lista = query.getResultList();
            if (lista.size() != 0) {
                entidade = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return entidade;
    }

    public T buscarProduto(String nome) throws Exception {
        T entidade = null;
        try {
            em = JpaUtil.getEntityManager();

            TypedQuery<T> query = em.createQuery("From " + classe.getSimpleName() + " Where nome = :nome", classe);
            query.setParameter("nome", nome);
            List<T> lista = query.getResultList();
            if (lista.size() != 0) {
                entidade = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return entidade;
    }

    public void remover(T entidade) {
        em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(entidade);
        em.getTransaction().commit();
        em.close();
    }
}
