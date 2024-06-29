package sistemadetestes.pageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
	
	@FindBy(id = "btn-adicionar")
	public WebElement buttonCriar;
	
	@FindBy(id = "codigo")
	public WebElement inputCodigo;
	
	@FindBy(id = "nome")
	public WebElement inputNome;
	
	@FindBy(id = "quantidade")
	public WebElement inputQuantidade;
	
	@FindBy(id = "valor")
	public WebElement inputValor;
	
	@FindBy(id = "data")
	public WebElement inputData;
	
	@FindBy(id = "btn-salvar")
	public WebElement buttonSalvar;
	
	@FindBy(id = "btn-sair")
	public WebElement buttonSair;
	
	@FindBy(css = "table tbody")
	public WebElement tabelaProdutosCriados;
	
	@FindBy(css = "form.form-produto>div.alert>span")
	public WebElement spanMensagem;
	
	@FindBy(css = "#cadastro-produto button.close")
    public WebElement closeButton;
	
	@FindBy(id = "cadastro-produto")
	public WebElement modalCadastroProduto;
	
	public ProdutoPO(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void escrever(WebElement input, String texto) {
		input.clear();
		input.sendKeys(texto + Keys.TAB);
	}
	
	public String obterMensagem() {
		return this.spanMensagem.getText();
	}
	
	public void executarBotaoDeCriar() {
		buttonCriar.click();
	}
	
	public void executarBotaoX() {
        closeButton.click();
	}
	
	public void executarAcaoDeCadastrar(String codigo, String nome, String quantidade, String valor, String data) {
		escrever(inputCodigo, codigo);
		escrever(inputNome, nome);
		escrever(inputQuantidade, quantidade);
		escrever(inputValor, valor);
		escrever(inputData, data);
		buttonSalvar.click();
		buttonSair.click();
	}
	
	public boolean executarAcaoDeVisualizacao(String codigo, String nome, String quantidade, String valor, String data) {
		boolean bool;
		boolean bool2;
		boolean bool3;
		boolean bool4;
		boolean bool5;
		bool = tabelaProdutosCriados.getText().contains(codigo);
		bool2 = tabelaProdutosCriados.getText().contains(nome);
		bool3 = tabelaProdutosCriados.getText().contains(quantidade);
		bool4 = tabelaProdutosCriados.getText().contains(valor);
		bool5 = tabelaProdutosCriados.getText().contains(data);
		if(bool && bool2 && bool3 && bool4 && bool5) {
			return true;
		} else {			
			return false;
		}
    }
	
	public String obterTituloDaTabela() {
		return driver.getTitle();
	}
	
	public String obterTituloPagina() {
		return driver.getTitle();
	}
	
}
