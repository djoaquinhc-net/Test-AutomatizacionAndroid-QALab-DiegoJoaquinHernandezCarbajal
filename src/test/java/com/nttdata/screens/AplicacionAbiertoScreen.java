package com.nttdata.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;


import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class AplicacionAbiertoScreen extends PageObject {

    private static final Logger LOGGER = LoggerFactory.getLogger(AplicacionAbiertoScreen.class);


    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/action_bar_root")
    private WebElement pantallaprincipal;

    public void estaPantallaVisible() {
        LOGGER.info("Esperando a que la pantalla principal sea visible.");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(pantallaprincipal));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Pantalla principal ha sido visible");

    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productTV")
    private WebElement tituloproductos;

    public void TituloproductosVisible() {
        LOGGER.info("Esperando a que el título (Productos) sea visible.");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(tituloproductos));
        LOGGER.info("Título (Productos) visible");
    }

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/productRV")
    private WebElement displaydeproductos;

    public void seMuestranlosProductos() {
        LOGGER.info("Esperando a que se muestren los productos en el display.");
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOf(displaydeproductos));
        LOGGER.info("Productos visibles en el display ");

    }

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup")
    private List<WebElement> ProductosEnApp;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup//android.widget.TextView[not(contains(@text,'$'))]")
    private List<WebElement> NombredeProductosenApp;

    public void Productosenpantalla() {
        for (int i = 0; i < NombredeProductosenApp.size(); i++) {
            String nombreproducto = NombredeProductosenApp.get(i).getText();
            System.out.println("Producto [De izquierda a derecha] (" + (i+1) + "): " + nombreproducto);
        }
    }

    public void DesplazamientodeProductosPrimero() {
        LOGGER.info("Realizando desplazamiento de pantalla en la lista de productos.");

        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/scrollView\"))" +
                        ".scrollIntoView(new UiSelector().text(\"Sauce Labs Bolt T-Shirt\"))"
        );

        LOGGER.info("Desplazamiento de pantalla realizado");
    }
    public void DesplazamientodeProductosFinal() {
        LOGGER.info("Realizando desplazamiento de pantalla en la lista de productos.");

        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/scrollView\"))" +
                        ".scrollIntoView(new UiSelector().text(\"Test.sllTheThings() T-Shirt\"))"
        );

        LOGGER.info("Desplazamiento de pantalla realizado");
    }

    public void validarProductosenPantallaPrimeralinea() {
        List<String> listadeproductosesperados = Arrays
                .asList(
                "Sauce Labs Backpack",
                "Sauce Labs Bike Light"
                );
        LOGGER.info("Productos Esperados : " + listadeproductosesperados);
        List<String> listamostradaenpantalla = NombredeProductosenApp.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        LOGGER.info("Productos Mostrados : " + listamostradaenpantalla);
        Assert.assertEquals("Los productos han sido validados como los esperados :", listadeproductosesperados, listamostradaenpantalla);
        LOGGER.info("Productos Validado con Exito.");

    }

    public void validarProductosenPantallaSegundalinea() {
        List<String> listadeproductosesperados = Arrays
                .asList(
                        "Sauce Labs Bolt T-Shirt",
                        "Sauce Labs Fleece Jacket"
                );
        LOGGER.info("Productos Esperados : " + listadeproductosesperados);
        List<String> listamostradaenpantalla = NombredeProductosenApp.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        LOGGER.info("Productos Mostrados : " + listamostradaenpantalla);
        Assert.assertEquals("Los productos han sido validados como los esperados :", listadeproductosesperados, listamostradaenpantalla);
        LOGGER.info("Productos Validado con Exito.");

    }

    public void validarProductosenPantallaUltimalinea() {
        List<String> listadeproductosesperados = Arrays
                .asList(
                        "Sauce Labs Onesie",
                        "Test.sllTheThings() T-Shirt"
                );
        LOGGER.info("Productos Esperados : " + listadeproductosesperados);
        List<String> listamostradaenpantalla = NombredeProductosenApp.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        LOGGER.info("Productos Mostrados : " + listamostradaenpantalla);
        Assert.assertEquals("Los productos han sido validados como los esperados :", listadeproductosesperados, listamostradaenpantalla);
        LOGGER.info("Productos Validado con Exito.");

    }

    public void busquedaProductoDesplazando(String PRODUCTO) {
        LOGGER.info("Realizando desplazamiento de pantalla para buscar el producto: " + PRODUCTO);
        AndroidDriver driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();

        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/scrollView\"))" +
                        ".scrollIntoView(new UiSelector().text(\"" + PRODUCTO + "\"))"
        );

        LOGGER.info("Desplazamiento de pantalla realizado. Producto encontrado: " + PRODUCTO);
    }

    public void seleccionandoProducto(String PRODUCTO) {
        LOGGER.info("Buscando el producto: " + PRODUCTO);
        try {AndroidDriver driver = (AndroidDriver) ((WebDriverFacade) getDriver()).getProxiedDriver();
        WebElement seleccion = driver.findElementByXPath(
                "//android.widget.ImageView[@content-desc='" + PRODUCTO + "']"
        );

        seleccion.click();
        LOGGER.info("Se entro al producto :" + PRODUCTO);
        } catch (Exception e) {
        LOGGER.error("No se pudo entrar al producto: " + PRODUCTO + ". Presenta un fallo este producto.", e);
    }
    }
}



