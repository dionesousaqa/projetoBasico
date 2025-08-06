package br.ce.wcaquino.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.wcaquino.core.DriverFactory;
import br.ce.wcaquino.pages.LoginPage;
import br.ce.wcaquino.testes.ContaTest;
import br.ce.wcaquino.testes.MovimentacaoTest;
import br.ce.wcaquino.testes.RemoverMovimentacaoContaTest;
import br.ce.wcaquino.testes.ResumoTest;
import br.ce.wcaquino.testes.SaldoTest;

@RunWith(Suite.class)
@SuiteClasses({
	ContaTest.class,
	MovimentacaoTest.class,
	RemoverMovimentacaoContaTest.class,
	SaldoTest.class,
	ResumoTest.class
})

public class SuiteGeral {
	
	private static LoginPage page = new LoginPage();
	
	@BeforeClass
	public static void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("dione@sousa");
		page.setSenha("123456");
		page.entrar();
		
		

}
	@AfterClass
	public static void finaliza() {
		DriverFactory.killDriver();
	}
}
