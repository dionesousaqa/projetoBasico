package br.ce.wcaquino.testes;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.HomePage;

public class SaldoTest extends BaseTest {
	HomePage page = new HomePage();
	@Test
	public void testSaldoConta() {
		Assert.assertEquals("123.00",page.obterSaldoDaConta("Cont do Teste Alterada"));
	}

}
