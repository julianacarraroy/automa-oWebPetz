package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver navegador;

    public HomePage(WebDriver navegador){
        this.navegador = navegador;
    }

    public ProdutoPage pesquisarProdutoEspecifico(String nomeProduto){
        navegador.findElement(By.id("search_query_top")).click();
        navegador.findElement(By.id("search_query_top")).sendKeys(nomeProduto);
        navegador.findElement(By.cssSelector(".ac_even>strong")).click();

        return new ProdutoPage(navegador);
    }

}
