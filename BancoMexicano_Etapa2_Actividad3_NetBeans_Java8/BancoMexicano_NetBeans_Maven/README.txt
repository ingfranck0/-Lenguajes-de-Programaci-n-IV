BANCO MEXICANO - ACTIVIDAD 3 (ETAPA 2)
Proyecto Java 8 con interfaz gráfica Swing y paradigma orientado a objetos.

REQUISITOS
- Apache NetBeans
- JDK 8 o una versión compatible
- Maven (incluido en NetBeans)

ABRIR Y EJECUTAR
1. Extrae el archivo ZIP.
2. En NetBeans selecciona File > Open Project.
3. Abre la carpeta BancoMexicano_NetBeans_Maven.
4. En Source Packages > banco, ejecuta BancoMexicanoApp.java (Run File).
5. Si NetBeans solicita la clase principal, utiliza: banco.BancoMexicanoApp

FUNCIONES
1. Depósito: agrega una cantidad positiva y permite realizar otro depósito.
2. Retiro: descuenta una cantidad si es positiva y no supera el saldo disponible.
3. Saldo: muestra el monto actual de la cuenta y el botón Continuar regresa al menú.
4. Salir: muestra “Cerrando sesión, vuelva pronto...” y termina la aplicación.

CLASES
- BancoMexicanoApp: punto de entrada del programa.
- CuentaBancaria: administra el saldo y las operaciones de depósito y retiro.
- MenuPrincipal: presenta las cuatro opciones del menú.
- Deposito: interfaz y validación del depósito.
- Retiro: interfaz y validación del retiro.
- Saldo: consulta y muestra el saldo actual.

NOTA
El saldo se conserva mientras la aplicación está abierta. Esta versión no conecta
a un gestor de base de datos; el documento de la actividad no especifica motor,
esquema ni credenciales de conexión.
