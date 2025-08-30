package com.nttdata.screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Assert;

import org.openqa.selenium.By;


public class ProductoScreen extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductoScreen.class);
    private String unidadesingresadas;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/plusIV")
    private WebElement botonañadirmas;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/noTV")
    private WebElement cantidadapp;

    @AndroidFindBy(id = "com.saucelabs.mydemoapp.android:id/cartBt")
    private WebElement botonanadiralcarrito;


    public void BusquedaCantidad(){
        getDriver().findElement(By.id("com.saucelabs.mydemoapp.android:id/container"));
        getDriver().findElement(
                MobileBy.AndroidUIAutomator(
                        "new UiScrollable(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/container\"))" +
                                ".scrollIntoView(new UiSelector().resourceId(\"com.saucelabs.mydemoapp.android:id/addToCartLL\"))"
                )
        );
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(
                By.id("com.saucelabs.mydemoapp.android:id/addToCartLL"))
        );

        LOGGER.info("Desplazamiento de pantalla realizado. Ingrese la cantidad.");

    }

    public void ColocandoUnidades(String UNIDADES){
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        wait.until(ExpectedConditions.elementToBeClickable(botonañadirmas));
        LOGGER.info("Esperando a que el boton + sea visible");
        int cantidad = Integer.parseInt(UNIDADES);

        for (int i = 1; i < cantidad; i++) {
            botonañadirmas.click();
        }

        LOGGER.info("Se hicieron " + (cantidad - 1) + " clics en el boton +");


    }

    public void validandoCantidad(String UNIDADES){
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(cantidadapp, UNIDADES));
        unidadesingresadas = cantidadapp.getText();
        Assert.assertEquals(UNIDADES, unidadesingresadas);
        LOGGER.info("Unidades verificadas correctamente. " +"Unidades Requeridas : "+ UNIDADES +". Unidades Ingresadas : "+ unidadesingresadas);

    }

    public void ClicAnadirCarritodeCompra(){
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        wait.until(ExpectedConditions.elementToBeClickable(botonanadiralcarrito));

        botonanadiralcarrito.click();
    }


}
