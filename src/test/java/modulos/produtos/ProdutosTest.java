package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

@DisplayName("Teste web do modulo de frete")
public class ProdutosTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Driverbrowser\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        this.navegador = new ChromeDriver(options);

        // maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 30 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Navegar para a pagina da Petz
        this.navegador.get("https://www.petz.com.br/");

    }

    @Test
    @DisplayName("Validar Sul, Sudeste e Centro-Oeste: frete grátis nos pedidos acima de R$ 119")
    public void testeValidarFreteSSCOcomValor119(){
        navegador.findElement(By.cssSelector("div.log-in")).click();
        navegador.findElement(By.cssSelector("a[class=button-login]")).click();
        //navegador.findElement(By.cssSelector("input[id='loginEmail']")).click();
        //navegador.findElement(By.cssSelector("input[id='loginEmail']")).sendKeys("julianacarraroy@gmail.com");
        navegador.findElement(By.cssSelector("input[id='loginEntrar']")).isDisplayed();
        navegador.findElement(By.cssSelector("input[id='loginEntrar']")).click();
        JavascriptExecutor executor = (JavascriptExecutor)navegador;
        executor.executeScript("arguments[0].click();",  navegador.findElement(By.cssSelector("input[id='loginEntrar']")));

    }


    @AfterEach
    public void afterEach(){
        // Vou fechar o navegador
        // navegador.quit();
    }
}
