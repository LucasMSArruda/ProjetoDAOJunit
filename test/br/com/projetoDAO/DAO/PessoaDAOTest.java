/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoDAO.DAO;

import br.com.projetoDAO.model.Pessoa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lucas.A
 */
public class PessoaDAOTest {
       
    Pessoa p;    
    Pessoa p2;
    Pessoa p3;
    
    public PessoaDAOTest() {
        p = new Pessoa("Sandra", "Teacher");  
        p2 = new Pessoa ("Teste", "Testes"); 
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Antes da classe");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Depois da classe");
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of consultar method, of class PessoaDAO.
     */
    @Test
    public void testConsultar() {
        System.out.println("consultar");
        PessoaDAO instance = new PessoaDAO();
        instance.consultar();
        
//        if(instance.consulta())
//            System.out.println("Teste ok");
//        else
//        fail("Erro no teste de consulta");

        assertTrue(instance.consultar());
        //assertEquals("Teste falhou", false, instance.consulta());
                
    }

    /**
     * Test of inserir method, of class PessoaDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        PessoaDAO pd = new PessoaDAO();
        assertTrue(pd.inserir(p));
    }

    /**
     * Test of consultaID method, of class PessoaDAO.
     */
    @Test
    public void testConsultaID() {
        System.out.println("consultaID");
        PessoaDAO pd = new PessoaDAO();
        p.setId(1);       
        assertTrue(pd.consultaID(p));        
    }

    /**
     * Test of atualizar method, of class PessoaDAO.
     */
    @Test
    public void testAtualizar() {
        System.out.println("atualizar");
        PessoaDAO pd = new PessoaDAO();
        p.setId(3);               
        p.setNome("Tester");
        p.setProfissao("Testador");
        pd.atualizar(p);
        //p3 = new Pessoa("TESTADOR", "TESTADO");
        assertTrue(pd.atualizar(p)); 
    }

    /**
     * Test of remover method, of class PessoaDAO.
     */
    @Test
    public void testRemover() {
        System.out.println("remover");
        PessoaDAO pd = new PessoaDAO();
        p.setId(5);
        assertTrue(pd.remover(p));
    }
    
}
