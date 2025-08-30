Feature:Carrito de compras
  @TestCarrito
  Scenario Outline:Agregar productos al carrito y validarlo
    Given estoy en la aplicación de SauceLabs
    And valido que carguen correctamente los productos en la galeria
    When agrego "<UNIDADES>" del siguiente producto "<PRODUCTO>"
    Then valido el carrito de compra actualice correctamente

    Examples:
      | PRODUCTO          | UNIDADES |
      |Sauce Labs Backpack|1|
      |Sauce Labs Bolt T-Shirt|1|
      |Sauce Labs Bike Light|2|
 #NOTA : EL PRODUCTO Sauce Labs Bike Light ocasiona el cierre de la App.
  #Sauce Labs Bolt T-Shirt Estaba mal escrito, lo corregí.Pero al añadir 1 al carrito se agregan 10.
  #Sauce Labs Bike Light al presionarlo se cierra la app.