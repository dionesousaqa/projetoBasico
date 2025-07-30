package br.ce.wcaquino.core;

import static br.ce.wcaquino.core.DriverFactory.killDriver;


import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import br.ce.wcaquino.pages.LoginPage;
public class BaseTest {
	private LoginPage page = new LoginPage();
	@Rule
	public TestName testName = new TestName();
	
	@Before
	public void inicializa() {
		page.acessarTelaInicial();
		
		page.setEmail("dione@sousa");
		page.setSenha("123456");
		page.entrar();
		
		
	}
	@After
	public void finaliza() throws IOException {
//		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
//		File arquivo = ss.getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(arquivo, new File("target"+ File.separatorChar+"screenshot"
//		                    +File.separatorChar + testName.getMethodName() + ".jpg"));		
		 if(Propriedades.FECHAR_BROWSER) {
		      killDriver();
	}
}
}