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
- Fecha de reporte
- Fecha posible de resolución
- Estado del incidente (Abierto, Resuelto)
- Colchón de horas estimadas
- Técnico asignado (relación a tabla de Técnicos)
- Cliente (relación a tabla de Clientes)

### Detalle de Incidente
- ID del detalle de incidente
- Descripción detallada del problema
- Tipo del problema (relación a tabla de Tipos de Problema)
- Incidente relacionado (relación a tabla de Incidentes)

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
- Incidente tiene Detalles de Incidente (relación uno a muchos)
- Incidente está relacionado con un Tipo de Problema (relación uno a uno)


## Correciones 
- controlar entidades se agrego `Detalle de Incidente`
- relacion incidente y tipo de problema

| posibles tablas |
|----------|
 | Área de RRHH |
 | Área Comercial |
 | Reporte |
 | Problema |
 | Estadísticas |

![DER](./uml.png)
