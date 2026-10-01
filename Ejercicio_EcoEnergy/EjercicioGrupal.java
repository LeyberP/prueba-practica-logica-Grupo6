import java.util.Scanner;

public class EcoEnergy {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n; // cantidad de usuarios
        String medidor;
        int estrato;
        double kwh, tarifa, subtotal, recargo, total;

        // Acumuladores
        double totalKwh = 0;
        double totalFacturado = 0;

        // Contador
        int contadorAltoConsumo = 0;

        // Máximo
        double mayorConsumo = 0;
        String medidorMayor = "";

        System.out.println("===== ECOENERGY - CONSUMO ELECTRICO =====");

        // Validar N
        do {
            System.out.print("Ingrese la cantidad de usuarios (N > 0): ");
            n = sc.nextInt();
            if (n <= 0) {
                System.out.println("Error: N debe ser mayor que 0.");
            }
        } while (n <= 0);

        // Ciclo principal
        for (int i = 1; i <= n; i++) {
            System.out.println("\n--- Usuario " + i + " ---");
            System.out.print("Numero de medidor: ");
            medidor = sc.next();

            // Validar estrato
            do {
                System.out.print("Estrato (1-6): ");
                estrato = sc.nextInt();
                if (estrato < 1 || estrato > 6) {
                    System.out.println("Error: el estrato debe estar entre 1 y 6.");
                }
            } while (estrato < 1 || estrato > 6);

            // Validar kWh
            do {
                System.out.print("Consumo en kWh (> 0): ");
                kwh = sc.nextDouble();
                if (kwh <= 0) {
                    System.out.println("Error: el consumo debe ser mayor que 0.");
                }
            } while (kwh <= 0);

            // Tarifa según estrato
            switch (estrato) {
                case 1:
                    tarifa = 0.05;
                    break;
                case 2:
                    tarifa = 0.07;
                    break;
                case 3:
                    tarifa = 0.09;
                    break;
                case 4:
                    tarifa = 0.11;
                    break;
                case 5:
                    tarifa = 0.13;
                    break;
                default:
                    tarifa = 0.15;
                    break; // estrato 6
            }

            subtotal = kwh * tarifa;

            // Recargo por alto consumo
            if (kwh > 300) {
                recargo = subtotal * 0.10;
                contadorAltoConsumo++;
            } else {
                recargo = 0;
            }

            total = subtotal + recargo;

            // Acumular
            totalKwh += kwh;
            totalFacturado += total;

            // Mayor consumo
            if (i == 1 || kwh > mayorConsumo) {
                mayorConsumo = kwh;
                medidorMayor = medidor;
            }

            System.out.printf(
                "Tarifa: $%.2f/kWh | Subtotal: $%.2f | Recargo: $%.2f | Total: $%.2f%n",
                tarifa,
                subtotal,
                recargo,
                total
            );
        }

        // Resultados
        System.out.println("\n========== RESUMEN ==========");
        System.out.println("Usuarios procesados: " + n);
        System.out.printf("kWh total consumido: %.2f kWh%n", totalKwh);
        System.out.printf("Total facturado: $%.2f%n", totalFacturado);
        System.out.println(
            "Usuarios con recargo (>300 kWh): " + contadorAltoConsumo
        );
        System.out.printf(
            "Medidor con mayor consumo: %s (%.2f kWh)%n",
            medidorMayor,
            mayorConsumo
        );
        sc.close();
    }
}
