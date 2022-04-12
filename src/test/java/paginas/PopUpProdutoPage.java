package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpProdutoPage {

    private WebDriver navegador;

    public PopUpProdutoPage (WebDriver navegador){
        this.navegador = navegador;
    }

    public PopUpProdutoPage preencherNomeDoAmigue (String nome){
        navegador.findElement(By.id("friend_name")).sendKeys(nome);

        return this;
    }

    public PopUpProdutoPage preencherEmailDoAmigue (String email){
        navegador.findElement(By.id("friend_email")).sendKeys(email);

        return this;
    }

    public PopUpProdutoPage enviarEmail (){
        navegador.findElement(By.cssSelector("#sendEmail > span")).click();

        return this;
    }

    public String capturarMensagemDeSucesso (){
        String texto = navegador.findElement(By.cssSelector(".fancybox-inner>p")).getText();

        return texto;
    }

    public String capturarMensagemDeErro (){
        String texto = navegador.findElement(By.cssSelector("#send_friend_form_content>div")).getText();

        return texto;
    }

}
