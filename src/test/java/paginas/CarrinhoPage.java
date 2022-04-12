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
        //Tempo de espera explícito para aguardar o componente aparecer na tela
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        String resultado = navegador.findElement(By.id("total_product")).getText();

        return resultado;
    }
    public CarrinhoPage excluirProduto(){
        navegador.findElement(By.className("icon-trash")).click();

        return this;
    }

    public String capturarMensagem(){
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        String alerta = navegador.findElement(By.cssSelector(".alert-warning")).getText();

        return alerta;
    }

}

