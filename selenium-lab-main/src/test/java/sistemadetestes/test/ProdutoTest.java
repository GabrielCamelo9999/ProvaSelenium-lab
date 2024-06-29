package sistemadetestes.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import sistemadetestes.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProdutoTest extends BaseTest{
	
	private static ProdutoPO ProdutoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		ProdutoPage = new ProdutoPO(driver);
	}
	
	@Test
	public void TC001_naoDeverCadastrarComTudosCamposVazios() {
		ProdutoPage.executarBotaoDeCriar();
		ProdutoPage.executarBotaoDeCriar();
		ProdutoPage.executarAcaoDeCadastrar("", "", "", "", "");
		
		String mensagem = ProdutoPage.obterMensagem();
		assertEquals(mensagem, "Todos os campos são obrigatórios para o cadastro!");
	}
	
	@Test
	public void TC002_deverSalvarAsInformçoesAoClicarNoBotaoSalvar() {
		ProdutoPage.executarBotaoDeCriar();
		ProdutoPage.executarBotaoDeCriar();
		ProdutoPage.executarAcaoDeCadastrar("002", "Hermes", "02", "10", "28/06;2024");
		
		ProdutoPage.buttonSalvar.click();
		
		assertTrue(ProdutoPage.executarAcaoDeVisualizacao("002", "Hermes", "02", "10", "2024-06-28"));
	}
	
	@Test
	public void TC003_deverFecharComBotaoX() {
		ProdutoPage.executarBotaoDeCriar();
		ProdutoPage.executarBotaoDeCriar();;

        ProdutoPage.executarBotaoX();

        String modalStyle = ProdutoPage.modalCadastroProduto.getAttribute("style");
        assertTrue(modalStyle.contains("display: none;"));
	}
	
}
