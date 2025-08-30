package com.nttdata.screens;

import com.nttdata.stepsdefinitions.ProductosEnelCarritoSauceLabs;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.bs.A;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CarritoScreen extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarritoScreen.class);



    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartTV")
    private WebElement numerocarritobarrasup;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartIV")
    private WebElement botoncarrito;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/itemsTV")
    private WebElement items;


    public void ClicCarritodeCompra(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(botoncarrito));

        botoncarrito.click();
    }

    public String validarNumeroGloboCarrito() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(numerocarritobarrasup));
        String unidadesEnGlobo = numerocarritobarrasup.getText();
        String unidadespuras = unidadesEnGlobo.replaceAll("[^0-9]", "");
        LOGGER.info("Numero en el globo del carrito: " + unidadespuras);
        String unidadesperada = "1";
        LOGGER.info("Numero ESPERADO: " + unidadesperada);


        Assert.assertEquals("El numero en el globo del carrito no coincide", unidadesperada, unidadesEnGlobo);

        LOGGER.info("SE VALIDO EL GLOBO DEL CARRITO");
        return unidadesEnGlobo;
    }

    public String validarNumerodeItems(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 15);
        wait.until(ExpectedConditions.visibilityOf(items));

        String unidadesenItems = items.getText();
        String unidadespuras = unidadesenItems.replaceAll("[^0-9]", "");
        LOGGER.info("Numero de items en el carrito: " + unidadespuras);
        String unidadesperada = "1";
        LOGGER.info("Numero ESPERADO: " + unidadesperada);

        LOGGER.info("SE VALIDO EL NUMERO DE ITEMS EN EL CARRITO.");
        Assert.assertEquals("El numero de items en el carrito no coincide", unidadesperada, unidadespuras);
        return unidadesenItems;
    }
}







