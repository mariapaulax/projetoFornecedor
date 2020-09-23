/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.model.dao;

import br.ulbra.connection.ConnectionFactory;
import br.ulbra.model.bean.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class FornecedorDAO {
    
    public void save(Fornecedor fornecedor){
        EntityManager em = new ConnectionFactory().getConnection();
        
        try {
           em.getTransaction().begin();
           
           if(fornecedor.getId()== null){
               
           em.persist(fornecedor);//insert no banco
           }else{
               em.merge(fornecedor);
           }
           em.getTransaction().commit();
           
        } catch (Exception e) {
           System.err.print(e.getMessage());
           em.getTransaction().rollback();
            
            
        }finally{
           em.close();
            
        }
         
        }
    
    public void remove(Integer id){
          EntityManager em = new ConnectionFactory().getConnection();
          Fornecedor fornecedor = null;
        try {
           fornecedor = em.find(Fornecedor.class, id);
            em.getTransaction().begin();
            em.remove(fornecedor);
            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "removido com sucesso");
        } catch (Exception e) {
            System.err.println(e);
            em.getTransaction().rollback();
        }finally{
            em.close();
        }
        
    }

    
    public Fornecedor findById(Integer id){
        EntityManager em = new ConnectionFactory().getConnection();
        Fornecedor fornecedor  = null;
        try {
            fornecedor = em.find(Fornecedor.class, id);
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }finally{
            em.close();
        }
        
        return fornecedor;
    }
    
    
    public List<Fornecedor> findAll(){
          EntityManager em = new ConnectionFactory().getConnection();
          List<Fornecedor> fornecedores = null;
          try {
            fornecedores = em.createQuery("from Fornecedor f").getResultList();
            
        } catch (Exception e) {
             System.err.println(e);
           
        }finally{
            em.close();
          }
          return fornecedores;
    }


}


