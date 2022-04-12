package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CarrinhoPage {
    private WebDriver navegador;

    public CarrinhoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CarrinhoPage adicionarUmaUnidadeDoProduto(){
        navegador.findElement(By.cssSelector(".icon-plus")).click();
        return this;
    }

    public String verificarSaldoTotalSemFrete(){
        // Encontrar uma maneira mais elegante de aguardar a mudanca do saldo em tela
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        String resultado = navegador.findElement(By.id("total_product")).getText();

        return resultado;
    }
}
