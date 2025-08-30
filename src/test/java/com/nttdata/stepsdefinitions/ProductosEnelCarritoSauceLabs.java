package com.nttdata.stepsdefinitions;

import com.nttdata.screens.AplicacionAbiertoScreen;
import com.nttdata.steps.AplicacionAbiertoSteps;
import com.nttdata.steps.CarritoSteps;
import com.nttdata.steps.ProductoSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductosEnelCarritoSauceLabs {
    @Steps
    AplicacionAbiertoSteps aplicacionAbiertoSteps;
    @Steps
    ProductoSteps productoSteps;
    @Steps
    CarritoSteps carritoSteps;

    private static final Logger LOGGER = LoggerFactory.getLogger(AplicacionAbiertoScreen.class);

    @Given("estoy en la aplicación de SauceLabs")
    public void estoyEnLaAplicaciónDeSauceLabs() {
        aplicacionAbiertoSteps.estaPantallaVisible();
        LOGGER.info("PRIMER TEST PASADO");

    }

    @And("valido que carguen correctamente los productos en la galeria")
    public void validoQueCarguenCorrectamenteLosProductosEnLaGaleria() {
        aplicacionAbiertoSteps.TituloproductosVisible();
        aplicacionAbiertoSteps.seMuestranlosProductos();
        aplicacionAbiertoSteps.Productosenpantalla();
        aplicacionAbiertoSteps.validarProductosenPantallaPrimeralinea();

        aplicacionAbiertoSteps.DesplazamientodeProductosPrimero();
        aplicacionAbiertoSteps.Productosenpantalla();
        aplicacionAbiertoSteps.validarProductosenPantallaSegundalinea();

        aplicacionAbiertoSteps.DesplazamientodeProductosFinal();
        aplicacionAbiertoSteps.Productosenpantalla();
        aplicacionAbiertoSteps.validarProductosenPantallaUltimalinea();


        LOGGER.info("SEGUNDO TEST PASADO");
    }

    @When("agrego {string} del siguiente producto {string}")
    public void agregoDelSiguienteProducto(String UNIDADES, String PRODUCTO) {
        aplicacionAbiertoSteps.busquedaProductoDesplazando(PRODUCTO);
        aplicacionAbiertoSteps.seleccionandoProducto(PRODUCTO);
        productoSteps.BusquedaCantidad();
        productoSteps.ColocandoUnidades(UNIDADES);
        productoSteps.validandoCantidad(UNIDADES);
        productoSteps.ClicAnadirCarritodeCompra();


        LOGGER.info("TERCER TEST PASADO");

    }

    @Then("valido el carrito de compra actualice correctamente")
    public void validoElCarritoDeCompraActualiceCorrectamente() {
        carritoSteps.ClicCarritodeCompra();
        carritoSteps.validarNumeroGloboCarrito();
        carritoSteps.validarNumerodeItems();

        LOGGER.info("CUARTO TEST PASADO");

    }


}
