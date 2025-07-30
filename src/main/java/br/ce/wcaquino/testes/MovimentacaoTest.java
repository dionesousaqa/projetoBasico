package br.ce.wcaquino.testes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.core.BaseTest;
import br.ce.wcaquino.pages.MenuPage;
import br.ce.wcaquino.pages.MovimentacaoPage;
import br.ce.wcaquino.utils.DataUtils;


public class MovimentacaoTest extends  BaseTest {
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
 @Test
 public void testInserirMovimentacao() {
	 	 menuPage.acessarTelaInserirMovimentacao();
	 	 
	 	 movPage.setDataMovimentacao(DataUtils.obterDataFormatada(new Date()));
	 	 movPage.setDataPagamento(DataUtils.obterDataFormatada(new Date()));
	 	 movPage.setDescricao("Movimentação do Teste");
	 	 movPage.setInteressado("Interessado QualQuer");
	 	 movPage.setValor("500");
	 	 movPage.setConta("Cont do Teste Alterada");
	 	 movPage.setStatusPago();
	 	 movPage.salvar();
	 	 
	 	 Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMesagemSucesso());
 
 }
 
  @Test
  public void testCamposObrigatorios() {
	  menuPage.acessarTelaInserirMovimentacao();
	  
	  movPage.salvar();
	  List<String> erros = movPage.obterErros();
	//Assert.assertEquals("Data da Movimentação é obrigatório", erros.get(0));
	//Assert.assertTrue(erros.contains("Data da Movimentação é obrigatório"));
	  Assert.assertTrue(erros.containsAll(Arrays.asList(
			        "Data da Movimentação é obrigatório","Data do pagamento é obrigatório",
			        "Descrição é obrigatório", "Interessado é obrigatório",
			        "Valor é obrigatório", "Valor deve ser um número")));
	           Assert.assertEquals(6, erros.size());
	  
	  
  }
  
  @Test
  public void testInserirMovimentacaoFutura() {
	  menuPage.acessarTelaInserirMovimentacao();
	  
	  Date datafutura = DataUtils.obterDataComDiferencaDias(5);
	  
	  movPage.setDataMovimentacao(DataUtils.obterDataFormatada(datafutura));
	 	 movPage.setDataPagamento(DataUtils.obterDataFormatada(datafutura));
	 	 movPage.setDescricao("Movimentação do Teste");
	 	 movPage.setInteressado("Interessado QualQuer");
	 	 movPage.setValor("500");
	 	 movPage.setConta("Cont do Teste Alterada");
	 	 movPage.setStatusPago();
	 	 movPage.salvar();
	 	 
	 	List<String> erros = movPage.obterErros();
			  Assert.assertTrue(erros.contains(
			  "Data da Movimentação deve ser menor ou igual à data atual"));
		      Assert.assertEquals(1, erros.size());
	  
  }
}
