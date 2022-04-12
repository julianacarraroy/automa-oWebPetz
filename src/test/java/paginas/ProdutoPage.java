package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProdutoPage {
    private WebDriver navegador;

    public ProdutoPage(WebDriver navegador){
        this.navegador = navegador;
    }

    public CarrinhoPage adicionarIrParaCarrinho(){
        navegador.findElement(By.cssSelector(".exclusive>span")).click();
        navegador.findElement(By.cssSelector(".button-medium>span")).click();

        return new CarrinhoPage(navegador);
    }

    public PopUpProdutoPage clicarNoBotaoEnviarParaOAmigo(){
        navegador.findElement(By.id("send_friend_button")).click();

        return new PopUpProdutoPage(navegador);
    }

}
