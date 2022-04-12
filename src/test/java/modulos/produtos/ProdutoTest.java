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
        System.setProperty("webdriver.chrome.driver", "C:\\Driverbrowser\\chromedriver_win32 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");

        this.navegador = new ChromeDriver(options);

        // maximizar a tela
        this.navegador.manage().window().maximize();

        // Vou definir um tempo de espera padrao de 10 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navegar para a pagina da Loja
        this.navegador.get("http://automationpractice.com/index.php");

    }

    @Test
    @DisplayName("Validar cálculo total no carrinho acrescentando 2 quantidades do produto")
    public void testValidatorValorTotalDoCarino(){

        String valorSemFrete = new HomePage(navegador)
                .pesquisarProdutoEspecifico("Blouse")
                .adicionarIrParaCarrinho()
                .adicionarUmaUnidadeDoProduto()
                .verificarSaldoTotalSemFrete();

        Assertions.assertEquals("$54.00", valorSemFrete);


    }

    @Test
    @DisplayName("Validar exclusão do produto do carrinho")
    public void testValidatorExclusaoDoCarrinho() {
        String alerta = new HomePage(navegador)
            .pesquisarProdutoEspecifico("Faded Short Sleeve T-shirts")
            .adicionarIrParaCarrinho()
            .excluirProduto()
            .capturarMensagem();

        Assertions.assertEquals("Your shopping cart is empty.", alerta);
    }

    @Test
    @DisplayName("Enviar produto para um amigo por E-mail")
    public void testEnviarProdutoParaEmailDeAmigo(){
        String mensagem = new HomePage(navegador)
                .pesquisarProdutoEspecifico("Faded Short Sleeve T-shirts")
                .clicarNoBotaoEnviarParaOAmigo()
                .preencherNomeDoAmigue("João")
                .preencherEmailDoAmigue("joao@exemplo.com")
                .enviarEmail()
                .capturarMensagemDeSucesso();

        Assertions.assertEquals("Your e-mail has been sent successfully", mensagem);
    }

    @Test
    @DisplayName("Verificar que E-mail é um campo obrigatório")
    public void testValidarCamposObrigatoriosParaEnviarEmailParaAmigo(){
        String mensagem = new HomePage(navegador)
                .pesquisarProdutoEspecifico("Faded Short Sleeve T-shirts")
                .clicarNoBotaoEnviarParaOAmigo()
                .preencherNomeDoAmigue("João")
                .enviarEmail()
                .capturarMensagemDeErro();

        Assertions.assertEquals("You did not fill required fields", mensagem);
    }

    @AfterEach
    public void afterEach(){
        navegador.quit();
    }
}
