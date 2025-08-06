package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.ContasPage;
import br.ce.wcaquino.pages.MenuPage;

public class RemoverMovimentacaoContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	 @Test
	   public void excluirContaComMovimentacao() {
		   menuPage.acessarTelaListarConta();
		   
		   contasPage.cliclarExcluirConta("Cont do Teste Alterada");

		   Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMesagemErro());
	   }
}
