package stepsPO;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.Base;

import java.time.Duration;

public class Hooks {
    Base base;

    public Hooks(Base Base) {
        this.base = Base;
    }

    @Before// Execute antes de todos os blocos de passos --> usar do Cucumber
    public void before_all() {
        ChromeOptions options = new ChromeOptions(); // instancia o objeto de Opções do ChromeDriver
        options.addArguments("--remote-allow-origins=*"); // Permite qualquer origem remota
        WebDriverManager.chromedriver().setup(); // baixa a versão mais atual do ChromeDriver

        Base.driver = new ChromeDriver(options);      // instancia o objeto do Selenium como ChromeDriver

        // Estabelece uma espera implicita de 5 segundo para carregar qualquer elemento
        Base.driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        Base.driver.manage().window().maximize();               // Maximiza a janela do navegador
    }

    @After // Executa após todos os blocos de passos --> usar do cumcumber
    public void after_all()  {
        Base.driver.quit();                                     // Encerrar o objeto do Selenium WebDriver
    }

}
