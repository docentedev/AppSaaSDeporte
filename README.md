# SaaSDeporte - De AppInicial a app funcional

Este README documenta el proceso completo para transformar una app creada por defecto en Android Studio (AppInicial) en una base funcional llamada SaaSDeporte, lista para abrir, mostrarse en el launcher y renderizar su primera pantalla con Jetpack Compose.

## Objetivo técnico

Partimos con una plantilla inicial y llegamos a una app que cumple estos mínimos:

1. Tiene identidad de proyecto y paquete propia.
2. Compila con SDK moderno.
3. Tiene punto de entrada real (MainActivity + launcher en Manifest).
4. Renderiza UI con Compose.
5. Queda preparada para crecer con arquitectura basada en ViewModel.

## Paso 1: Renombrar identidad del proyecto

### Qué se cambió

1. Nombre de proyecto en `settings.gradle.kts`:
	- `rootProject.name = "SaaSDeporte"`
2. Identificadores del módulo app en `app/build.gradle.kts`:
	- `namespace = "com.duoc.saasdeporte"`
	- `applicationId = "com.duoc.saasdeporte"`
3. Paquetes Kotlin de `com.duoc.appinicial` a `com.duoc.saasdeporte` en:
	- `app/src/main/java`
	- `app/src/test/java`
	- `app/src/androidTest/java`
4. Nombre visible en `app/src/main/res/values/strings.xml`:
	- `app_name = "SaaSDeporte"`

### Por qué

1. Evita inconsistencias entre nombre mostrado, paquete y configuración Gradle.
2. Deja lista la app para instalación, distribución y versiones futuras sin arrastrar nombre de plantilla.
3. Asegura que tests, imports y rutas de código apunten al paquete correcto.

## Paso 2: Ajustar SDK de compilación y objetivo

### Qué se cambió

En `app/build.gradle.kts`:

1. `compileSdk = 37`
2. `targetSdk = 37`
3. Se mantiene `minSdk = 26`

### Por qué

1. `compileSdk` define con qué API compila tu código y qué APIs puedes usar.
2. `targetSdk` indica para qué comportamiento del sistema está optimizada la app.
3. Mantener `minSdk = 26` conserva compatibilidad con dispositivos no tan nuevos.

## Paso 3: Preparar Gradle para Kotlin y Compose

### Qué se cambió

1. En `gradle/libs.versions.toml`:
	- se agregó `kotlin = "2.0.0"`
	- se registró plugin `org.jetbrains.kotlin.android`
	- se registró plugin `org.jetbrains.kotlin.plugin.compose`
2. En `build.gradle.kts` (raíz):
	- `alias(libs.plugins.kotlin.android) apply false`
	- `alias(libs.plugins.kotlin.compose) apply false`
3. En `app/build.gradle.kts`:
	- se aplica `alias(libs.plugins.kotlin.compose)`

### Por qué

1. Compose necesita soporte del compilador Kotlin y su plugin correspondiente.
2. Declarar versiones en `libs.versions.toml` centraliza dependencias y evita desorden de versiones.
3. Registrar plugins en raíz permite que cada módulo los aplique solo cuando los necesita.

## Paso 4: Activar Compose en el módulo app

### Qué se cambió

En `app/build.gradle.kts`:

1. `buildFeatures { compose = true }`
2. Se agregó BOM:
	- `platform("androidx.compose:compose-bom:2024.04.01")`
3. Se agregaron librerías Compose base.

### Por qué

1. `compose = true` activa el pipeline de compilación para UI declarativa.
2. El BOM alinea versiones internas de Compose para evitar incompatibilidades.
3. Sin estas dependencias, `setContent {}` y componentes UI no compilan.

## Paso 5: Crear un punto de entrada funcional

### Qué se cambió

1. Se creó `MainActivity` en `app/src/main/java/com/duoc/saasdeporte/MainActivity.kt`.
2. La clase hereda de `ComponentActivity`.
3. En `onCreate`, se usa `setContent {}` para montar Compose.
4. Se muestra una UI mínima (texto centrado).

### Por qué

1. Una app Android necesita una Activity de entrada para iniciar interfaz.
2. `setContent {}` es el puente entre el ciclo de vida Android y Compose.
3. Una pantalla simple valida rápido que configuración, theme y render funcionan.

## Paso 6: Declarar launcher y Activity en el Manifest

### Qué se cambió

En `app/src/main/AndroidManifest.xml`:

1. Tema:
	- `android:theme="@style/Theme.SaaSDeporte"`
2. Declaración de Activity:
	- `<activity android:name=".MainActivity" android:exported="true">`
3. Intent filter launcher:
	- `android.intent.action.MAIN`
	- `android.intent.category.LAUNCHER`

### Por qué

1. `MAIN + LAUNCHER` define qué pantalla abre al tocar el icono.
2. `android:exported="true"` es obligatorio en Activities con intent-filter en Android moderno.
3. Sin esto, la app puede compilar pero no aparecer ni abrir correctamente desde el launcher.

## Paso 7: Alinear tema y recursos

### Qué se cambió

1. En:
	- `app/src/main/res/values/themes.xml`
	- `app/src/main/res/values-night/themes.xml`
2. Renombre de estilo:
	- `Theme.AppInicial` -> `Theme.SaaSDeporte`

### Por qué

1. Evita referencias a estilos inexistentes tras el renombre del proyecto.
2. Mantiene consistencia entre `Manifest`, recursos y branding.

## Librerías agregadas y para qué sirve cada una

### Base Android

1. `androidx.core:core-ktx`
	- Extensiones Kotlin para Android (API más idiomática y limpia).
2. `androidx.appcompat:appcompat`
	- Compatibilidad de componentes en distintas versiones Android.
3. `com.google.android.material:material`
	- Componentes Material clásicos para vistas Android (útil en coexistencia con Compose o migraciones graduales).

### Compose

1. `androidx.compose:compose-bom:2024.04.01`
	- Administra versiones compatibles del ecosistema Compose.
2. `androidx.compose.ui:ui`
	- Núcleo de UI de Compose (layouts, modifiers, rendering).
3. `androidx.compose.material3:material3`
	- Componentes visuales Material 3 (Button, Text, Scaffold, etc.).
4. `androidx.compose.ui:ui-tooling-preview`
	- Soporte para previews en Android Studio.
5. `androidx.activity:activity-compose`
	- Integración Activity + Compose (`setContent`).
6. `androidx.lifecycle:lifecycle-viewmodel-compose`
	- Conexión natural entre ViewModel y Composables (`viewModel()`, estado de UI).

### Testing

1. `junit:junit`
	- Unit tests locales.
2. `androidx.test.ext:junit`
	- Integración JUnit para tests Android instrumentados.
3. `androidx.test.espresso:espresso-core`
	- UI tests instrumentados sobre vistas/interacciones.

## Validación final

Después de sincronizar Gradle y ejecutar la app, se validó que:

1. La app aparece en el launcher.
2. Al abrirla no se cae.
3. Se renderiza la pantalla inicial con Compose.

## Resultado

SaaSDeporte quedó como una base funcional y mantenible para seguir construyendo módulos de negocio, con stack moderno (Kotlin + Compose), configuración consistente y punto de entrada correctamente declarado.

## Version 2: Estructura base para escalar

Para la segunda version se agrego una estructura por capas dentro del paquete base `com.duoc.saasdeporte`, orientada a Clean Architecture y preparada para integrar API REST + base de datos local.

### Estructura creada

```text
com.duoc.saasdeporte
├── di
├── data
│   ├── local
│   ├── remote
│   └── repository
├── domain
│   ├── model
│   ├── repository
│   └── usecase
└── presentation
	 ├── login
	 └── home
```

### Que va en cada package y por que

1. `di/`
	- Que contiene: modulos de Hilt para proveer Retrofit, Room, interceptores y repositorios.
	- Por que existe: centraliza la construccion de dependencias y evita crear objetos manualmente en Activities/ViewModels.

2. `data/local/`
	- Que contiene: `@Entity`, `@Dao`, `RoomDatabase`.
	- Por que existe: concentra la persistencia local y separa reglas de almacenamiento del resto de la app.

3. `data/remote/`
	- Que contiene: interfaces de Retrofit, DTOs de request/response y `AuthInterceptor` para JWT.
	- Por que existe: encapsula toda la comunicacion HTTP y el mapeo de payloads externos.

4. `data/repository/`
	- Que contiene: implementaciones concretas de repositorios (por ejemplo, `AuthRepositoryImpl`).
	- Por que existe: une origen remoto/local y entrega datos listos para dominio.

5. `domain/model/`
	- Que contiene: modelos puros de negocio (sin anotaciones de red ni base de datos).
	- Por que existe: mantiene el nucleo de negocio independiente de frameworks.

6. `domain/repository/`
	- Que contiene: interfaces de repositorio que consume el dominio.
	- Por que existe: permite invertir dependencias (dominio no depende de data).

7. `domain/usecase/`
	- Que contiene: casos de uso (ejemplo: `LoginUseCase`, `GetHomeDataUseCase`).
	- Por que existe: concentra reglas de negocio y orquesta repositorios con una intencion clara por accion.

8. `presentation/login/`
	- Que contiene: pantalla Compose de login, estado de UI y `LoginViewModel`.
	- Por que existe: separa el flujo de autenticacion del resto de pantallas.

9. `presentation/home/`
	- Que contiene: pantalla principal, estado de UI y `HomeViewModel`.
	- Por que existe: encapsula el flujo principal post-login y facilita evolucion modular.

### Beneficio inmediato de esta estructura

1. Facilita pruebas unitarias por capa.
2. Evita mezclar UI, red y base de datos en una sola clase.
3. Permite crecer por funcionalidades sin perder orden.
4. Prepara el proyecto para agregar autenticacion JWT, cache local y sincronizacion de datos.

### Estado actual de la V2

Se crearon los packages y archivos base de referencia para dejar la estructura trazada en el repositorio. El siguiente paso es implementar clases reales en cada capa (API service, entities/dao, repositorios, use cases y viewmodels).

### Paso nuevo V2: mover MainActivity y agregar Preview

Para ordenar mejor la capa de presentacion, se movio la activity de entrada y se separo la UI en un composable con preview.

1. `MainActivity` se movio desde la raiz del paquete a:
	- `app/src/main/java/com/duoc/saasdeporte/presentation/MainActivity.kt`
2. Se creo la pantalla `HomeScreen` en:
	- `app/src/main/java/com/duoc/saasdeporte/presentation/home/HomeScreen.kt`
3. Se agrego `@Preview(showBackground = true)` para visualizar la pantalla en Android Studio sin ejecutar la app.
4. Se actualizo el `AndroidManifest.xml` para usar la nueva ruta:
	- `android:name=".presentation.MainActivity"`

#### Por que este cambio mejora la estructura

1. `MainActivity` actua como host de UI y navegacion, por eso pertenece a `presentation/` y no al root del proyecto.
2. La UI queda desacoplada de la Activity, facilitando testeo, reutilizacion y evolucion.
3. El preview acelera desarrollo visual y reduce ciclos de compilar/instalar para cambios simples de interfaz.

### Paso nuevo V2: solucion de Render Problem en Compose Preview

Durante la configuracion de previews, Android Studio mostraba `Render Problem`. Se aplicaron ajustes de tooling para que el preview pudiera renderizar correctamente.

1. En `app/build.gradle.kts` se agrego dependencia de tooling solo para debug:
	- `debugImplementation(libs.androidx.ui.tooling)`
2. En `gradle/libs.versions.toml` se agrego el alias:
	- `androidx-ui-tooling = { module = "androidx.compose.ui:ui-tooling" }`
3. En el preview de `HomeScreen` se envolvio el contenido con `MaterialTheme`:
	- mejora el contexto visual del composable en el render de Android Studio.

#### Resultado

1. El preview de `HomeScreen` ahora se renderiza correctamente.
2. La app sigue compilando en debug sin errores (`:app:assembleDebug` exitoso).

## Troubleshooting (Compose Preview)

Si Android Studio muestra errores de preview, revisa estos casos comunes:

### 1) Render Problem

Sintoma:

1. El panel de Preview aparece en blanco o con mensaje `Render Problem`.

Solucion:

1. Verifica `debugImplementation(libs.androidx.ui.tooling)` en `app/build.gradle.kts`.
2. Verifica alias `androidx-ui-tooling` en `gradle/libs.versions.toml`.
3. Haz `Sync Project with Gradle Files` y vuelve a abrir el preview.

### 2) Preview sin tema o con estilos rotos

Sintoma:

1. Colores/fuentes incorrectos o error visual en componentes Material.

Solucion:

1. Envuelve el composable de preview con `MaterialTheme`.
2. Asegura que imports de Material 3 sean consistentes (`androidx.compose.material3.*`).

### 3) Compila, pero el preview no actualiza cambios

Sintoma:

1. El emulador funciona, pero el preview no refleja cambios recientes.

Solucion:

1. Usa `Build > Clean Project` y luego `Build > Rebuild Project`.
2. Reinicia el panel de preview (`Refresh` o cerrar/abrir pestaña).
3. Si persiste, `File > Invalidate Caches / Restart`.
