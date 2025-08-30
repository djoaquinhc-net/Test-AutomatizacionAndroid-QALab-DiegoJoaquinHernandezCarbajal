package com.nttdata.steps;

import com.nttdata.screens.CarritoScreen;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class CarritoSteps {
    @Steps
    CarritoScreen carritoScreen;

    @Step("valido el carrito de compra actualice correctamente")
    public void ClicCarritodeCompra(){
        carritoScreen.ClicCarritodeCompra();
    }
    public void validarNumeroGloboCarrito(){
        carritoScreen.validarNumeroGloboCarrito();
    }
    public void validarNumerodeItems(){
        carritoScreen.validarNumerodeItems();
    }

}
