package br.ce.wcaquino.pages;

import org.openqa.selenium.By;

import br.ce.wcaquino.core.BasePage;

public class ContasPage extends BasePage {
 
	public void setNome( String nome) {
		escreve("nome", nome);
	}
	public void salvar() {
		clicarBotaoPorTexto("Salvar");		
		
	}
	public String obterMesagemSucesso() {
        return obterTexto(By.xpath("//div[@class='alert alert-success']")); 	
	
	}
	
	public String obterMesagemErro() {
        return obterTexto(By.xpath("//div[@class='alert alert-danger']")); 	
	
	}

	public void cliclarAlterarConta(String string) {
		obterCelula("Conta", string,"Ações", "tabelaContas")
		 .findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();
		
	}
	public void cliclarExcluirConta(String string) {
		obterCelula("Conta", string,"Ações", "tabelaContas")
		 .findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();
		
	}
}
