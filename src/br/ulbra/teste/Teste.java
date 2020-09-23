/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ulbra.teste;

import br.ulbra.model.bean.Fornecedor;
import br.ulbra.model.dao.FornecedorDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class Teste {
    
    public static void main(String[] args) {
        
        
       
       /* f.setId(1);
        f.setRazaoSocial("Fassini Company pt-br");*/
      
        FornecedorDAO dao = new FornecedorDAO();
        Fornecedor fat = new Fornecedor();
        fat.setGerente("Maria Fassini");
        dao.save(fat);
        
        /*Fornecedor f = dao.findById(2);
       
       
        dao.save(f);
        
        JOptionPane.showMessageDialog(null, "Item inserido\nCodigo:"+f.getId()+"\nRazão Social:"+f.getRazaoSocial()+
                "\nNome Fantasia:"+f.getNomeFantasia()+"\nTelefone:"+f.getTelefone()+
                "\nEmail:"+f.getEmail()+"\nGerente:"+f.getGerente());*/
       
       
       String resultado = "Consulta por Descrição\n "
                + "--------------------------------\n"
               + "  Código    |  Razão Social    |    Nome Fantasia    |    Telefone    |    Email    |    Gerente   \n";
        for (Fornecedor f: dao.findAll()){
            resultado += "  "
                    + " " +f.getId()+"     "
                    + "         |    "+f.getRazaoSocial()+"\n"
                    + "         |    "+f.getNomeFantasia()+"\n"
                    + "         |    "+f.getTelefone()+"\n"
                    + "         |    "+f.getEmail()+"\n"
                    + "         |    "+f.getGerente()+"\n";
                                       
        }
        JOptionPane.showMessageDialog(null, resultado);
        int cod = Integer.parseInt(JOptionPane.showInputDialog("Qual código deseja excluir?"));
        dao.remove(cod);

    }

}

        

       
    
    

