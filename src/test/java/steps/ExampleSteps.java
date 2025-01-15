package steps;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ExampleSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;

    @Given("I open the browser")
    public void iOpenTheBrowser() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setSlowMo(500)
                        .setTimeout(60000)
                        .setArgs(List.of(
                                "--no-sandbox",
                                "--disable-setuid-sandbox",
                                "--disable-cloud-policy",
                                "--disable-background-networking",
                                "--disable-background-timer-throttling",
                                "--remote-debugging-pipe"
                        )) // Agregar argumentos comunes
        );
        System.out.println("Playwright iniciado: " + (playwright != null));
        System.out.println("Browser iniciado: " + (browser != null));
        page = browser.newPage(); // Crear una nueva página
        page.navigate("https://youtube.com"); // Navegar a la URL proporcionada
        System.out.println("Título de la página: " + page.title());
    }

}
