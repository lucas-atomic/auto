package main;

import org.junit.runner.RunWith;

import annotations.AfterSuite;
import annotations.BeforeSuite;
import annotations.ExtendedCucumberRunner;
import cucumber.api.CucumberOptions;
import driver.DriverWeb;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(features = "src/test/resources/features", 
				plugin = { "json:src/test/resources/cucumber-report/Resultado.json" }, 
				glue = { "classpath:steps" }, 
				tags = { "@Correios" }, monochrome = true, dryRun = false, strict = false)

public class ExecuteTest {

	@BeforeSuite
	public static void metodoInicial() {
		System.out.println("Iniciado Teste");
	}

	@AfterSuite
	public static void metodoFinal() {
		DriverWeb.killDriver();
		System.out.println("Finalizando teste");
	}
}