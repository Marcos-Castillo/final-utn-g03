# final-utn-g03
# Sistema de reporte de incidentes

## Entidades:

### Cliente
- ID del cliente
- Razón social
- CUIT
- Contacto principal
- Teléfono
- Email

### Operador (Mesa de Ayuda)
- ID del operador
- Nombre
- Apellido
- Teléfono
- Email
- Usuario
- Contraseña

### Técnico
- ID del técnico
- Nombre
- Apellido
- Especialidades (relación a tabla de Especialidades)
- Medio de notificación preferido (Email, WhatsApp)
- Tiempo estimado de resolución por defecto

### Incidente
- ID del incidente
- Descripción del problema
- Tipo del problema (relación a tabla de Tipos de Problema)
- Fecha de reporte
- Fecha posible de resolución
- Estado del incidente (Abierto, Resuelto)
- Colchón de horas estimadas
- Técnico asignado (relación a tabla de Técnicos)
- Cliente (relación a tabla de Clientes)

### Servicio
- ID del servicio
- Nombre del servicio
- Descripción del servicio
- Especialidad

### Especialidad
- ID de la especialidad
- Nombre de la especialidad

### Tipo de Problema
- ID del tipo de problema
- Nombre del tipo de problema
- Tiempo máximo de resolución

### Notificación
- ID de la notificación
- Contenido de la notificación
- Técnico destinatario (relación a tabla de Técnicos)
- Fecha de envío

## Relaciones:

- Cliente tiene Servicios contratados (relación muchos a muchos)
- Técnico tiene Especialidades (relación muchos a muchos)
- Técnico tiene Notificaciones (relación uno a muchos)
- Incidente es asignado a un Técnico (relación uno a uno)
- Incidente está relacionado con un Tipo de Problema (relación uno a uno)

## Falta revision 
- controlar entidades 1 faltante 
- relacion incidente y tipo de problema


![DER](./uml.png)
