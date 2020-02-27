package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverWeb {

	protected static WebDriver driver;
	private static String navegador = "CHROME";
	private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
	private static String browserSemInterface = System.getProperties().getProperty("headless");
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static String sistemaOperacional = System.getProperty("os.name").toLowerCase();
	private static String caminhoDriverChromeW = "src/test/resources/driver/chromedriver.exe";
	private static boolean maximizarJanela = true;
	private static boolean executarSemInterface = false;

	public static WebDriver getDriver() {
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		return driver;
	}

	public static WebDriver getDriver(boolean maximizarJanelaDoNavegador, boolean executarSemInterfaceGrafica) {
		maximizarJanela = maximizarJanelaDoNavegador;
		executarSemInterface = executarSemInterfaceGrafica;
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		return driver;
	}

	private static void setarConfiguracoesDoDriver() {
		if (browserSetadoViaPrompt != null) {
			navegador = browserSetadoViaPrompt;
			if (browserSetadoViaPrompt.contains("CHROME")) {
				configs();
			}
		} else {
			if (navegador.contains("CHROME")) {
				configs();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	private static void configs() {
		obterDriverEsetarNaPath();
		configHeadless();
		iniciarNavegador();
	}

	private static void obterDriverEsetarNaPath() {
		if (sistemaOperacional.contains("windows")) {
			if (navegador.contains("CHROME")) {
				System.setProperty("webdriver.chrome.driver", caminhoDriverChromeW);
			}
		}
	}

	private static void iniciarNavegador() {
		if (navegador.contains("CHROME")) {
			if (chromeOptions != null) {
				driver = new ChromeDriver(chromeOptions);
			} else {
				driver = new ChromeDriver();
			}
			if (maximizarJanela) {
				driver.manage().window().maximize();
			}
		}
	}

	private static void configHeadless() {
		if (executarSemInterface == true || browserSemInterface == "true") {
			if (navegador.contains("CHROME")) {
				chromeOptions.setHeadless(true);
			}
		}
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}