Algoritmo FacturacionEnergia
    
    totalKwh <- 0
    totalFacturado <- 0
    contadorAltoConsumo <- 0
    mayorConsumo <- 0
    medidorMayor <- 0
    
    // Validar que la cantidad de usuarios (n) sea mayor a 0
    Repetir
        Escribir "Ingrese la cantidad de usuarios a procesar:"
        Leer n
    Hasta Que n > 0
    
    // Ciclo para procesar cada medidor
    Para i <- 1 Hasta n Con Paso 1 Hacer
        
        Escribir "---------------------------------------------"
        Escribir "Procesando Usuario ", i, " de ", n
        Escribir "---------------------------------------------"
        
        Escribir "Ingrese el número de medidor:"
        Leer medidor
        
        // Validar que el estrato esté entre 1 y 6
        Repetir
            Escribir "Ingrese el estrato (1 al 6):"
            Leer estrato
        Hasta Que estrato >= 1 Y estrato <= 6
        
        // Validar que el consumo en kWh sea mayor a 0
        Repetir
            Escribir "Ingrese el consumo en kWh:"
            Leer kwh
        Hasta Que kwh > 0
        
        // Determinar la tarifa según el estrato seleccionado
        Segun estrato Hacer
            1: tarifa <- 0.05
            2: tarifa <- 0.07
            3: tarifa <- 0.09
            4: tarifa <- 0.11
            5: tarifa <- 0.13
            6: tarifa <- 0.15
        FinSegun
        
        // Cálculos parciales por usuario
        subtotal <- kwh * tarifa
        
        Si kwh > 300 Entonces
            recargo <- subtotal * 0.10
            contadorAltoConsumo <- contadorAltoConsumo + 1
        Sino
            recargo <- 0
        FinSi
        
        total <- subtotal + recargo
        
        // Acumular totales generales
        totalKwh <- totalKwh + kwh
        totalFacturado <- totalFacturado + total
        
        // Determinar el medidor con el mayor consumo registrado
        Si i = 1 O kwh > mayorConsumo Entonces
            mayorConsumo <- kwh
            medidorMayor <- medidor
        FinSi
        
        // Mostrar la factura individual de este usuario
        Escribir ""
        Escribir "--- FACTURA DEL USUARIO ---"
        Escribir "Medidor: ", medidor
        Escribir "Estrato: ", estrato
        Escribir "Consumo: ", kwh, " kWh"
        Escribir "Subtotal: $", subtotal
        Escribir "Recargo: $", recargo
        Escribir "Total a pagar: $", total
        Escribir "---------------------------"
        Escribir ""
        
    FinPara
    
    // Mostrar resultados consolidados finales
    Escribir "========================================="
    Escribir "TOTALES CONSOLIDADOS DE LA OPERACIÓN:"
    Escribir "========================================="
    Escribir "Total de kWh consumidos: ", totalKwh
    Escribir "Total facturado general: $", totalFacturado
    Escribir "Cantidad de usuarios con alto consumo: ", contadorAltoConsumo
    Escribir "Medidor con el mayor consumo registrado: ", medidorMayor, " (", mayorConsumo, " kWh)"
    Escribir "========================================="
	
FinAlgoritmo
