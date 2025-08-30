package com.nttdata.steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import com.nttdata.screens.AplicacionAbiertoScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WhenPageOpens;

public class AplicacionAbiertoSteps {
    @Steps
    AplicacionAbiertoScreen aplicacionAbiertoScreen;

    @Step("estoy en la aplicación de SauceLabs")
    @WhenPageOpens
    public void estaPantallaVisible(){
        aplicacionAbiertoScreen.estaPantallaVisible();
    }

    @Step("valido que carguen correctamente los productos en la galeria")
    public void TituloproductosVisible(){
        aplicacionAbiertoScreen.TituloproductosVisible();
    }

    public void seMuestranlosProductos(){
        aplicacionAbiertoScreen.seMuestranlosProductos();
    }

    public void DesplazamientodeProductosPrimero(){
        aplicacionAbiertoScreen.DesplazamientodeProductosPrimero();
    }

    public void DesplazamientodeProductosFinal(){
        aplicacionAbiertoScreen.DesplazamientodeProductosFinal();
    }

    public void Productosenpantalla(){
        aplicacionAbiertoScreen.Productosenpantalla();
    }

    public void validarProductosenPantallaPrimeralinea(){
        aplicacionAbiertoScreen.validarProductosenPantallaPrimeralinea();
    }

    public void validarProductosenPantallaSegundalinea(){
        aplicacionAbiertoScreen.validarProductosenPantallaSegundalinea();
    }

    public void validarProductosenPantallaUltimalinea(){
        aplicacionAbiertoScreen.validarProductosenPantallaUltimalinea();
    }

    @Step("agrego {string} del siguiente producto {string}")
    public void busquedaProductoDesplazando(String PRODUCTO){
        aplicacionAbiertoScreen.busquedaProductoDesplazando(PRODUCTO);
    }

    public void seleccionandoProducto(String PRODUCTO){
        aplicacionAbiertoScreen.seleccionandoProducto(PRODUCTO);
    }



}


