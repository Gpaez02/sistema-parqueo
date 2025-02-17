# Proyecto: Control de Parqueo

## Descripción

Este proyecto es una simulación de un parqueadero que permite registrar vehículos (automóviles, motocicletas y camiones), calcular tarifas según el tiempo de parqueo, y generar reportes de los vehículos registrados. 

El sistema permite a los usuarios:
- Registrar vehículos con diferentes tipos (automóviles, motocicletas y camiones).
- Consultar el estado de los vehículos en el parqueadero.
- Registrar la salida de un vehículo y calcular el costo de parqueo.
- Ver las tarifas del parqueadero para cada tipo de vehículo.
- Generar reportes con información de los vehículos registrados.

## Funcionalidades

### 1. Ingresar un vehículo
El usuario puede registrar un vehículo en el parqueadero, proporcionando:
- Tipo de vehículo (1: Automóvil, 2: Motocicleta, 3: Camión).
- Placa, marca, y modelo del vehículo.
- Información adicional como tipo de combustible (para vehículos tipo automóvil), cilindraje (para motocicletas), o capacidad de carga (para camiones).

### 2. Registrar la salida de un vehículo
Cuando un vehículo sale del parqueadero, el usuario puede:
- Introducir la placa del vehículo.
- Calcular el costo de parqueo basado en el tiempo que estuvo estacionado.
- Eliminar el vehículo de la lista de vehículos registrados.

### 3. Consultar el estado del parqueadero
El usuario puede consultar los vehículos que están actualmente en el parqueadero.

### 4. Mostrar las tarifas
El sistema muestra las tarifas por hora de parqueo para cada tipo de vehículo.

### 5. Generar un reporte
El sistema genera un reporte con los vehículos registrados, mostrando detalles como la placa, marca, modelo y hora de entrada de cada vehículo.

## Instrucciones de uso

1. **Compilar el proyecto**:
   Si estás usando la terminal, navega hasta el directorio donde tienes el archivo `Main.java` y compílalo con el siguiente comando:
   ```bash
   java Main.java
