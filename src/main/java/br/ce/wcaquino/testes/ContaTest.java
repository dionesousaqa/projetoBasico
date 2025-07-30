package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class ContaTest extends BaseTest {
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	@Test
	public void testeInserirConta(){
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Test");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMesagemSucesso());
	}
	
   @Test
   public void testAlterarConta() {
	   menuPage.acessarTelaListarConta();
	   
	   contasPage.cliclarAlterarConta("Conta do Test");
	   contasPage.setNome("Cont do Teste Alterada");
	   contasPage.salvar();
	   
	   Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMesagemSucesso());
   }
   
   @Test
   public void testInserirContaMesmoNome() {
	   menuPage.acessarTelaInserirConta();
	   
	   contasPage.setNome("Cont do Teste Alterada");
	   contasPage.salvar();
	   
	   Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMesagemErro());
   }
   
   @Test
   public void excluirContaComMovimentacao() {
	   menuPage.acessarTelaListarConta();
	   
	   contasPage.cliclarExcluirConta("Cont do Teste Alterada");

	   Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMesagemErro());
   }
}
