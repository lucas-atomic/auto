package basepages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverWeb;
import util.WriteExcelFile;

public class CorreiosPage extends DriverWeb{

	public static String url;
	public static String logoHome;
	public static String txtBusca;
	public static String btnBusca;
	public static String tabelaColuna;
	public static String tabelaLinha;
	public static String lblResultBusca;
	
	public CorreiosPage() {
		url = "https://www.correios.com.br/";
		logoHome = "//a[contains(@class, 'logo-correios')]";
		txtBusca = "acesso-busca";
		btnBusca = "//input[contains(@id, 'acesso-busca')]/following-sibling::button";
		tabelaColuna = "//table[contains(@class, 'tmptabela')]/tbody/tr/th";
		tabelaLinha = "//table[contains(@class, 'tmptabela')]/tbody/tr/following-sibling::tr/td";
		lblResultBusca = "//div[contains(@class, 'tituloimagem')]/h3";
	}
	
	public boolean abrirPageCorreios() throws InterruptedException {
		
		// Carregar Pagina Correios
		DriverWeb.getDriver().get(url);
		return driver.findElement(By.xpath(logoHome)).isEnabled();
	}
	
	public void realizarPesquisa(String cepLogradouro) throws InterruptedException {
		
		// Preencher campo de busca CEP/Logadouro
		driver.findElement(By.id(txtBusca)).sendKeys(cepLogradouro);
		
		// Clicar botao busca
		driver.findElement(By.xpath(btnBusca)).click();
		
		// Trocar controle para a nova aba 
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(windowHandles.get(1));
	}
	
	public String validarPaginaResultadosBusca() {
		return driver.findElement(By.xpath(lblResultBusca)).getText();
	}
	
	public void armazenarDadosTabelaCep() {
		
		// Criar uma lista com os elementos da tabela de resultados somente colunas
		List<WebElement> elementsColuna = driver.findElements(By.xpath(tabelaColuna));
		ArrayList<String> listColuna = new ArrayList<String>();
		int i= 0;
		
		// Popular lista Colunas
		for(WebElement coluna : elementsColuna) {
			listColuna.add(i, coluna.getText());
			i++;
		}
		
		// Criar uma lista com os elementos da tabela de resultados somente linhas
		List<WebElement> elementsLinha = driver.findElements(By.xpath(tabelaLinha));
		ArrayList<String> listLinha = new ArrayList<String>();
		int j = 0;
		
		// Popular lista Linhas
		for(WebElement linha : elementsLinha) {
			listLinha.add(j, linha.getText());
			j++;
		}
		
		// Criar arquivo em excel com os valores da tabela
		WriteExcelFile w = new WriteExcelFile();
		w.criarArquivoCep(listColuna, listLinha);
		
		// Encerrar o driver
		DriverWeb.killDriver();
	}
	
	public void armazenarDadosTabelaLogradouro() {
		
		// Criar uma lista com os elementos da tabela de resultados somente colunas
		List<WebElement> elementsColuna = driver.findElements(By.xpath(tabelaColuna));
		ArrayList<String> listColuna = new ArrayList<String>();
		int i= 0;
		
		// Popular lista Colunas
		for(WebElement coluna : elementsColuna) {
			listColuna.add(i, coluna.getText());
			i++;
		}
		
		// Criar uma lista com os elementos da tabela de resultados somente linhas
		List<WebElement> elementsLinha = driver.findElements(By.xpath(tabelaLinha));
		ArrayList<String> listLinha = new ArrayList<String>();
		int j = 0;
		
		// Popular lista Linhas
		for(WebElement linha : elementsLinha) {
			listLinha.add(j, linha.getText());
			j++;
		}
		
		// Criar arquivo em excel com os valores da tabela
		WriteExcelFile w = new WriteExcelFile();
		w.criarArquivoLogradouro(listColuna, listLinha);
		
		// Encerrar o driver
		DriverWeb.killDriver();
	}
	
}
