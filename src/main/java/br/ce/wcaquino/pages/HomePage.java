package br.ce.wcaquino.pages;

import br.ce.wcaquino.core.BasePage;

public class HomePage extends BasePage {

	public String obterSaldoDaConta(String conta) {
		
	    return obterCelula("Conta", conta,"Saldo", "tabelaSaldo").getText();
			
		}
	}

