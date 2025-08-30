package com.nttdata.steps;

import com.nttdata.screens.ProductoScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class ProductoSteps {
    @Steps
    ProductoScreen productoScreen;

    @Step("agrego {string} del siguiente producto {string}")
    public void BusquedaCantidad(){
        productoScreen.BusquedaCantidad();
    }
    public void ColocandoUnidades(String UNIDADES){
        productoScreen.ColocandoUnidades(UNIDADES);
    }
    public void validandoCantidad(String UNIDADES){
        productoScreen.validandoCantidad(UNIDADES);
    }
    public void ClicAnadirCarritodeCompra(){
        productoScreen.ClicAnadirCarritodeCompra();
    }



}
