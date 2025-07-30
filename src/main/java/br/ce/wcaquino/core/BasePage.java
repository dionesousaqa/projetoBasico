package br.ce.wcaquino.core;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import static br.ce.wcaquino.core.DriverFactory.getDriver;
public class BasePage {
   
private WebDriver driver;
	
//	//Construtor gerado	
//	public BasePage(WebDriver driver) {
//		//super();
//		this.driver = driver;
//	}

	public void escreve(String id_campo, String texto) {
		getDriver().findElement(By.id(id_campo)).clear();
		getDriver().findElement(By.id(id_campo)).sendKeys(texto);
		
	}
	
	public String obterValorCampo(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getAttribute("value");		
	}
	
	public String obterValorCampoText(String id_campo) {
		return getDriver().findElement(By.id(id_campo)).getText();		
	}
	 
	 public String obterTexto(By by) {
			
	        return	getDriver().findElement(by).getText();
			
	 }
	public void clicarCadastrar(String id) {
		
		getDriver().findElement(By.id(id)).click();
	}
	
    public void clicarNoCampo(String id) {
		
    	getDriver().findElement(By.id(id)).click();
	}
    
    public void webCombo (String id_campo, String valor) {
    	
    	WebElement element = driver.findElement(By.id(id_campo));
		Select combo = new Select(element);
		combo.selectByVisibleText(valor);
    	
    }
    
    public void entrarNoFrame(String id) {
    	getDriver().switchTo().frame(id);
    }
    
    public void sairDoFrame() {
    	getDriver().switchTo().defaultContent();
    	
    }
    public void clicarNoBotao(By by) {
		
    	getDriver().findElement(by).click();
		
 }
    public void clicarBotao(String id) {
		
		clicarNoBotao(By.id(id));
		
 }
    public void clicarNoLink(By by) {
		
    	getDriver().findElement(by).click();
		
 }
   public void clicarLink(String text) {
		
		clicarNoLink(By.linkText(text));
		
 }
    public void trocarJanela(String id) {
    	getDriver().switchTo().window(id);
    }
    
    public String alertaObterTextoAceito() {
    	
    	Alert alerta = getDriver().switchTo().alert();
    	  	
		return alerta.getText();       	
    	
    }   
    
    public void aceiteAlerta(String id) {
    	
    	Alert alerta = driver.switchTo().alert();
		Assert.assertEquals( id, alerta.getText());
		alerta.accept();
    }
    
    /*********** JS ***************/
    
    public Object executarJS(String cmd, Object... param ) {
    	
    	WebDriverManager.firefoxdriver().setup();
    	WebDriver driver = new FirefoxDriver();
    	driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	WebElement element = driver.findElement(By.id("elementosForm:nome"));
        return js.executeScript(cmd , param);
    }
    public Object executarJS2(String cmd, Object... param ) {
    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	
    	WebElement element = driver.findElement(By.id("elementosForm:nome"));
        return js.executeScript(cmd , param);
    }
 
      /*********** Tabela ***************/
 
    public WebElement obterCelula(String colunaBusca, String valor , String colunaBotao, String idTabela) {
   	 //procurar coluna do registro
   	 
   	 WebElement tabela = getDriver().findElement(By.xpath("//*[@id='"+idTabela+"']"));
   	 int idColuna = obterIndiceColuna(colunaBusca, tabela);
   	 
   	 //encontrar a linha do registro
   	 
   	 int idLinhas = obterIndiceLinha(valor, tabela, idColuna);
   	  
   	  //procurar coluna do botao
   	  
   	  int idColunaBotao = obterIndiceColuna(colunaBotao, tabela);
   	  
   	  //Clicar no botão da celula encontrada
   	  
   	  WebElement celula = tabela.findElement(By.xpath(".//tr["+idLinhas+"]/td["+idColunaBotao+"]"));
   	  return celula;
    }
    
    
   public void clicarBotaoTabela(String colunaBusca, String valor , String colunaBotao, String idTabela) {
	 	  
	  WebElement celula = obterCelula(colunaBusca, valor, colunaBotao, idTabela);
			  celula.findElement(By.xpath(".//input")).click();
 }

	protected int obterIndiceLinha(String valor, WebElement tabela, int idCoulna) {
		List<WebElement> Linhas = tabela.findElements(By.xpath("./tbody/tr/td["+idCoulna+"]"));
		  int idLinhas = -1;
			 for(int i = 0; i < Linhas.size(); i ++) {
				  if(Linhas.get(i).getText().equals(valor)) {
					 
					 idLinhas = i+1;
				 		break;
				 		}
 }
			             return idLinhas;
	}

	protected int obterIndiceColuna(String coluna, WebElement tabela) {
		List<WebElement> colunas = tabela.findElements(By.xpath(".//th"));
		 int idColuna = -1;
		 for(int i = 0; i < colunas.size(); i ++) {
			 if(colunas.get(i).getText().equals(coluna)) {
				 
				 idColuna = i+1;
			 		break;}
			 
		 }
		      return idColuna;
	}
	
	/*********** Radio ***************/
	
	public void clicarRadio(By by) {
		getDriver().findElement(by).click();
		
	}
	public void clicarRadio(String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void clicarBotaoPorTexto(String texto) {
		clicarNoBotao(By.xpath("//button[.='"+texto+"']"));
	}
	
	public void selecionarComboPrime(String radical , String valor) {
		clicarRadio(By.xpath("(.//*[@id='"+radical+"_label']/../div)[2]"));
		clicarRadio(By.xpath(".//*[@id='"+radical+"_items']//li[.='"+valor+"']"));
	}
	public void selecionarCombo(String radical , String valor) {
		clicarRadio(By.xpath("(.//*[@id='"+radical+"'])"));
		clicarRadio(By.xpath(".//*[@id='"+radical+"']//option[.='"+valor+"']"));
	}
	
}
