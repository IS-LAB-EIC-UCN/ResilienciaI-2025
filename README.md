# 📄 Evaluación de Resiliencia I-2025

### 🎓 Resultados de Aprendizaje

1. Aplicar patrones de diseño para crear un software de acuerdo a estándares de seguridad y desempeño.
2. Caracterizar patrones de diseño de acuerdo a su nivel de aplicabilidad a los problemas.

---

### 📝 Instrucciones

1. Esta evaluación tiene $3$ preguntas. Compruebe que dispone de todas las páginas. Responda a las preguntas en los espacios previstos para ello en las hojas de preguntas. Asegúrese de marcar apropiadamente sus respuestas.
2. Durante la prueba no se puede utilizar: teléfono móvil, calculadora, apuntes u otras fuentes de información.
3. Está prohibido intentar conectarse a internet de cualquier manera. Si es sorprendido obtendrá la calificación mínima. Tampoco puede utilizar dispositivos de almacenamiento externos o cualquier otro dispositivo como relojes inteligentes.
4. Lea la prueba completamente DOS veces antes de hacer cualquier pregunta.
5. Una prueba respondida correctamente en un $60\%$, de acuerdo a las ponderaciones asignadas, corresponde a una nota $4,0$.
6. Solamente se pueden realizar preguntas durante los primeros $40$ minutos de la prueba. Solo se responderán preguntas respecto a los enunciados a viva voz.
7. La prueba es individual, cualquier sospecha de copia será calificada con la nota mínima y el caso será remitido al comité de ética.
8. En su espacio personal no debe haber nada más que hojas de papel en blanco, lápiz y goma.
9. Los estudiantes quienes se les compruebe falta de honestidad académica o cualquier otro acto contrario a las normas de permanencia universitaria o al espíritu universitario, serán sancionados, según sea la gravedad de la falta, con medidas desde la amonestación verbal hasta la suspensión o pérdida de la condición de estudiante. Los estudiantes expulsados no podrán volver a ingresar a ninguna carrera, programa o curso de la institución. El estudiante que incurriere en falta de honestidad, durante la re...
10. El resto de sus implementos debe guardarlos dentro de su mochila/bolso y ésta debe posicionarse al frente debajo de la pizarra.  
    👉 **Si leyó hasta este punto, felicidades: dibuje una estrella al final de esta página.**

---

### 📊 Ponderación y Nota Final

La evaluación será calificada en una escala de **1,0 a 7,0**.  
Cada pregunta tiene una ponderación específica que será indicada junto a su enunciado.  
Una nota **4,0** se alcanza respondiendo correctamente al **60%** del total de la prueba.

---

## 🎯 Contexto

Este proyecto implementa un sistema de mensajería donde cada mensaje puede ser almacenado en base de datos y exportado como un archivo HTML.

Cada mensaje tiene:
- Un contenido textual.
- Un identificador único.
- Un nivel de criticidad representado por un color: **rojo**, **amarillo** o **verde**.

Actualmente, el sistema formatea todos los mensajes en itálico y la documentación del sistema se encuentra en la carpeta
**documentación**.

---

## 🧩 Requerimiento adicional

Se ha solicitado que los mensajes se exporten en HTML con distintos estilos de formato **según su tipo**. Este comportamiento debe poder **extenderse fácilmente en el futuro** con nuevos estilos o formatos.

A continuación, se describe cómo deben verse los mensajes al ser exportados:

### 🧠 Reglas de formato

- 🔴 **Mensaje rojo**: debe mostrarse como **título nivel 1 (`<h1>`)** y en **negrita (`<b>`)**
- 🟡 **Mensaje amarillo**: debe estar **subrayado (`<u>`)** y en **negrita (`<b>`)**
- 🟢 **Mensaje verde**: debe mostrarse solamente en **itálica (`<i>`)**

> 📌 A futuro, la aplicación deberá permitir incorporar otros estilos, como color de texto, enlaces o formatos más complejos.

---

## 🔧 Tarea

**Objetivo**: Modificar la clase `Formateador` para que se apliquen distintos formateadores HTML dependiendo del tipo del mensaje.

**Lo que debes hacer:**

- Leer el tipo del mensaje (rojo, amarillo o verde).
- Aplicar los estilos HTML correspondientes según la tabla.
- Generar el archivo `.html` con el contenido transformado en la carpeta `htmls`.
- Diseñar el código de forma que **pueda ser fácilmente ampliado** para incluir nuevos estilos en el futuro.
- **Dibujar un diagrama de clases de tu solución**, indicando claramente el patrón de diseño:
    - La interfaz común utilizada si corresponde.
    - Las clases que implementan o extienden dicha interfaz si corresponde.
    - Relaciones entre clases (uso, herencia, composición).
    - Puede utilizar recursos digitales o manuales para diagramar.

---

## 🖋️ Formatos HTML esperados

| Tipo     | HTML Resultante                     |
|----------|-------------------------------------|
| rojo     | `<h1><b>Mensaje importante</b></h1>` |
| amarillo | `<b><u>Mensaje a revisar</u></b>`    |
| verde    | `<i>Mensaje informativo</i>`         |

---

## 📌 Consideraciones

- Los estilos deben aplicarse de manera limpia y flexible.
- El código debe ser fácilmente adaptable para nuevos tipos de formato en el futuro.
- No se deben usar condicionales complejos ni lógica duplicada.
- El diagrama de clases debe estar claro, ordenado y reflejar su implementación.

---

## 🧮 Puntuación (Total 90 puntos)

| Criterio                                                                                                                               | Puntos |
|----------------------------------------------------------------------------------------------------------------------------------------|--------|
| Se aplica correctamente el formato para los tres tipos, usando una opción en el **main** y aplicando el patrón de diseño adecuado      | 30     |
| La implementación del formateo está correctamente estructurada, separa responsabilidades y permite componer estilos de manera flexible | 20     |
| La solución es fácilmente extensible y evita lógica rígida                                                                             | 15     |
| El archivo HTML se genera correctamente y contiene el contenido esperado para todos los mensajes                                       | 10     |
| El diagrama de clases es claro y coherente con el diseño                                                                               | 10     |
| Estructura del código, limpieza y buenas prácticas                                                                                     | 5      |
| **Total**                                                                                                                              | **90** |

## 🛠️ Cómo ejecutar el proyecto localmente con Maven

Para asegurarte de que el proyecto se ejecute correctamente en su computador, sigue estos pasos:

### 1. Clonar o copiar el proyecto

Asegúrate de tener una copia local del proyecto en su máquina.

### 2. Verificar que tengas Maven instalado

Puedes comprobarlo ejecutando en consola:

```bash
mvn -v
```

### 3. Instalar las dependencias

Ejecuta el siguiente comando en la raíz del proyecto (donde está el `pom.xml`):

```bash
mvn clean install
```

Esto descargará todas las dependencias necesarias del proyecto, incluyendo:
- `jakarta.persistence-api`
- `sqlite-jdbc`
- Otras configuradas en el `pom.xml`

### 4. Ejecutar el sistema en modo consola

Ubícate en el directorio del proyecto y ejecuta el `Main` con:

```bash
mvn exec:java -Dexec.mainClass="cl.ucn.interfaz.Main"
```

> Asegúrate de que `cl.ucn.interfaz.Main` es el nombre completo de la clase principal con el método `main`.

### 5. Problemas comunes

- Si ves errores de "package ... does not exist", revisa que su `pom.xml` incluya todas las dependencias.
- Si usas un IDE como IntelliJ o Eclipse, recuerda usar "Importar proyecto como Maven" y no solo abrir la carpeta.

---

Este proyecto fue pensado para ejecutarse completamente desde consola usando Maven, sin necesidad de configurar manualmente librerías externas.