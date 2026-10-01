## Casos de Prueba

### Caso 1 – Normal (N = 3)
* **Entradas:**
  * Usuario 1: Medidor `M001`, Estrato `2`, kWh `150`
  * Usuario 2: Medidor `M002`, Estrato `4`, kWh `350`
  * Usuario 3: Medidor `M003`, Estrato `1`, kWh `80`
* **Desglose de Cálculos:**
  | Medidor | Estrato | kWh | Tarifa | Subtotal | Recargo (10% si > 300) | Total |
  | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
  | M001 | 2 | 150 | $0.07 | $10.50 | $0.00 | $10.50 |
  | M002 | 4 | 350 | $0.11 | $38.50 | $3.85 | $42.35 |
  | M003 | 1 | 80 | $0.05 | $4.00 | $0.00 | $4.00 |
* **Resultados Esperados:**
  * **kWh Total Consumido:** 580.00 kWh
  * **Total Facturado:** $56.85
  * **Usuarios con Recargo:** 1
  * **Medidor con Mayor Consumo:** M002 (350.00 kWh)

---

### Caso 2 – Límite (N = 1)
* **Entradas:**
  * Usuario 1: Medidor `M010`, Estrato `6`, kWh `300`
* **Desglose de Cálculos:**
  | Medidor | Estrato | kWh | Tarifa | Subtotal | Recargo | Total |
  | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
  | M010 | 6 | 300 | $0.15 | $45.00 | $0.00 (300 no es > 300) | $45.00 |
* **Resultados Esperados:**
  * **kWh Total Consumido:** 300.00 kWh
  * **Total Facturado:** $45.00
  * **Usuarios con Recargo:** 0
  * **Medidor con Mayor Consumo:** M010 (300.00 kWh)

---

### Caso 3 – Datos Inválidos
* **Pruebas de Validación:**
  | Entrada Ingresada | Mensaje de Error del Programa | Acción del Sistema |
  | :--- | :--- | :--- |
  | `N = 0` | Error: N debe ser mayor que 0. | Vuelve a solicitar la cantidad de usuarios (N) |
  | `Estrato = 7` | Error: El estrato debe estar entre 1 y 6. | Vuelve a solicitar el estrato socioeconómico |
  | `kWh = -20` | Error: El consumo debe ser mayor que 0. | Vuelve a solicitar el consumo en kWh |
