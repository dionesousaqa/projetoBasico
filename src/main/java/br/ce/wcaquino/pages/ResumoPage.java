package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ResumoPage extends BasePage {
	
	public void excluirMovimentacao() {
	clicarNoBotao(By.xpath("//span[@class='glyphicon glyphicon-remove-circle']"));
	}
	
	public String obterMesagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']")); 	
	
	}
}
