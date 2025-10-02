---
config:
  layout: fixed
  theme: neutral
---
flowchart TD
subgraph subGraph0["1. Dimensiones (Maestros)"]
A["Cliente"]
B["Contrato"]
C["Producto / MP"]
D["Día"]
end
subgraph subGraph1["2. Planificacion (Inmutable)"]
E["Orden de Compra OC"]
F["OC Detalle Diario"]
G["OC Cancelación / Extra"]
end
subgraph subGraph2["3. Transacción (Entrega)"]
H["Nota de Venta NV"]
I["NV Detalle"]
J["NV Incumplimiento"]
end
subgraph subGraph3["4. Contabilidad (Cobro)"]
K["Factura"]
L["Control Factura"]
M["Contra Recibo Pago"]
end

    %% RELACIONES
    A -- "1:N" --> H
    B -- "1:N" --> E
    B -- "1:N" --> H
    B -- "1:N" --> K
    
    C -- "1:N" --> I %% Corregido a 1:N (Un Producto está en muchos detalles)
    D -- "1:N" --> F
    
    E -- "1:N" --> F
    E -- "1:N" --> G
    
    H -- "1:N" --> I
    H -- "1:N" --> J
    
    H -- "Consolida N Notas" --> K
    K -- "1:1 Estado" --> L
    L -- "1:N" --> M
    
    M -- "Actualiza Monto" --> B
    
    %% ESTILOS (Usando un color estándar y solo una clase)
    classDef important fill:#f9f,stroke:#333
    B:::important