package modulos.produtos;

import org.junit.jupiter.api.*;
import org.junit.platform.commons.function.Try;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import paginas.HomePage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@DisplayName("Teste web do modulo de adicionar ao carrinho")
public class ProdutoTest {

    private WebDriver navegador;

    @BeforeEach
    public void beforeEach(){
        // abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver100\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");

        this.navegador = new ChromeDriver(options);

        // maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 15 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //this.navegador.manage().window().maximize();

        // Navegar para a pagina da Petz
        this.navegador.get("http://automationpractice.com/index.php");

    }

    @Test
    @DisplayName("Validar calculo total no carrinho acrescentando 2 quantidades do produto")
    public void testValidatorValorTotalDoCarino(){

        String valorSemFrete = new HomePage(navegador)
                .pesquisarProdutoEspecifico("Blouse")
                .adicionarIrParaCarrinho()
                .adicionarUmaUnidadeDoProduto()
                .verificarSaldoTotalSemFrete();

        Assertions.assertEquals("$54.00", valorSemFrete);

        /*
        navegador.findElement(By.id("search_query_top")).click();
        navegador.findElement(By.id("search_query_top")).sendKeys("Blouse");
        navegador.findElement(By.cssSelector(".ac_even>strong")).click();

        navegador.findElement(By.cssSelector(".exclusive>span")).click();
        navegador.findElement(By.cssSelector(".button-medium>span")).click();

        navegador.findElement(By.cssSelector(".icon-plus")).click();
        navegador.findElement(By.cssSelector(".icon-plus")).click();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        String resultado = navegador.findElement(By.id("total_product")).getText();

        System.out.println(resultado);

        */
    }
    @Test
    @DisplayName("Enviar produto para um amigo por E-mail")
    public void testEnviarProdutoParaEmailDeAmigo(){
        navegador.findElement(By.id("search_query_top")).click();
        navegador.findElement(By.id("search_query_top")).sendKeys("Faded Short Sleeve T-shirts");
        navegador.findElement(By.cssSelector(".ac_even>strong")).click();
        navegador.findElement(By.id("send_friend_button")).click();
        navegador.findElement(By.id("friend_name")).sendKeys("Joao");
        navegador.findElement(By.id("friend_email")).sendKeys("joao@teste.com");
        navegador.findElement(By.cssSelector("#sendEmail > span")).click();

        String texto = navegador.findElement(By.cssSelector(".fancybox-inner>p")).getText();
        System.out.println(texto);
    }

    @Test
    @DisplayName("Mudar nome do teste")
    public void testValidarCamposObrigatoriosParaEnviarEmailParaAmigo(){
        navegador.findElement(By.id("search_query_top")).click();
        navegador.findElement(By.id("search_query_top")).sendKeys("Faded Short Sleeve T-shirts");
        navegador.findElement(By.cssSelector(".ac_even>strong")).click();
        navegador.findElement(By.id("send_friend_button")).click();
        navegador.findElement(By.cssSelector("#sendEmail > span")).click();

        String texto = navegador.findElement(By.cssSelector("#send_friend_form_content>div")).getText();
        System.out.println(texto);
    }

    @AfterEach
    public void afterEach(){
        //navegador.quit();
    }
}
