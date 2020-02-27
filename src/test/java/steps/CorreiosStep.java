package steps;

import org.junit.Assert;

import basepages.CorreiosPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class CorreiosStep {
	
	CorreiosPage cor = new CorreiosPage();

	@Dado("^que estou na pagina Home dos Correios$")
	public void que_estou_na_pagina_Home_dos_Correios() throws Throwable {
		
		// Carregar pagina Correios
		cor.abrirPageCorreios();
		
		// Assert Pagina Correios
		Assert.assertTrue("Não foi possivel carregar a tela do Correios", cor.abrirPageCorreios());
	}

	@Quando("^informar o CEP \"([^\"]*)\" para realizar a pesquisa$")
	public void informar_o_CEP_para_realizar_a_pesquisa(String cep) throws Throwable {
		
		// Realizar Pesquisa pelo CEP
		cor.realizarPesquisa(cep);
	}

	@Entao("^valido o redirecionamento da pagina e gero um arquivo com as informacoes da tabela de resultados da busca pelo CEP$")
	public void valido_o_redirecionamento_da_pagina_e_gero_um_arquivo_com_as_informacoes_da_tabela_de_resultados() throws Throwable {
	  
		// Assert Pagina Resultado Busca CEP/Logradouro
		Assert.assertEquals("Busca CEP - Endereço", cor.validarPaginaResultadosBusca());
		
		// Armazenar os dados da pesquisa por CEP
		cor.armazenarDadosTabelaCep();
	}
	
	@Quando("^informar o logradouro \"([^\"]*)\" para realizar a pesquisa$")
	public void informar_o_logradouro_para_realizar_a_pesquisa(String logradouro) throws Throwable {
		
		// Realizar Pesquisa pelo Logradouro
		cor.realizarPesquisa(logradouro);
	}
	
	@Entao("^valido o redirecionamento da pagina e gero um arquivo com as informacoes da tabela de resultados da busca pelo logradouro$")
	public void valido_o_redirecionamento_da_pagina_e_gero_um_arquivo_com_as_informacoes_da_tabela_de_resultados_da_busca_pelo_logradouro() throws Throwable {
	  
		// Assert Pagina Resultado Busca CEP/Logradouro
		Assert.assertEquals("Busca CEP - Endereço", cor.validarPaginaResultadosBusca());
		
		// Armazenar os dados da pesquisa por Logradouro
		cor.armazenarDadosTabelaLogradouro();
	}
}
