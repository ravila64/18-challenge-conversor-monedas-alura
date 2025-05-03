# 18-challenge-conversor-monedas-alura

<em> # TEMATICA </em>

1. Descripción proyecto
2. Funcionalidad
3. Como pueden usarlo los usurios
4. Donde pueden encontrar ayuda los usuarios
5. Autor(s) del proyecto

<h2>DESCRIPCION DEL PROYECTO </h2>

Construir tu propio Conversor de Monedas.
Aprenderás a realizar solicitudes a una API de tasas de cambio, a manipular datos JSON y,
finalmente, a filtrar y mostrar las monedas de interés.

Los pasos para completar este desafío se detallo:
A) Configuración del Ambiente Java;
B) Creación del Proyecto;
C) Consumo de la API;
D) Análisis de la Respuesta JSON;
E) Filtro de Monedas;
F) Exibición de Resultados a los usuarios;

<h2>FUNCIONALIDAD</h2>
----------------------------
****Conversor de monedas****
1. Listado paises incluidos para conversión
2. Conversión de monedas
3. Listar paises con nombres similares
9. Salir

Digite opción [1..3] o [9.Salir]

<h3>Al seleccionar opcion 1. Sale un listado asi:</h3>

1-(AED)=United Arab Emirates *|* 2-(AFN)=Afghanistan *|* 3-(ALL)=Albania *|* 4-(AMD)=Armenia *|* 5-(ANG)=Netherlands Antilles *|* _
6-(AOA)=Angola *|* 7-(ARS)=Argentina *|* 8-(AUD)=Australia *|* 9-(AWG)=Aruba *|* 10-(AZN)=Azerbaijan *|* _
11-(BAM)=Bosnia and Herzegovina *|* 12-(BBD)=Barbados *|* 13-(BDT)=Bangladesh *|* 14-(BGN)=Bulgaria *|* 15-(BHD)=Bahrain *|* _
16-(BIF)=Burundi *|* 17-(BMD)=Bermuda *|* 18-(BND)=Brunei *|* 19-(BOB)=Bolivia *|* 20-(BRL)=Brazil *|* _
21-(BSD)=Bahamas *|* 22-(BTN)=Bhutan *|* 23-(BWP)=Botswana *|* 24-(BYN)=Belarus *|* 25-(BZD)=Belize *|* _
26-(CAD)=Canada *|* 27-(CDF)=Democratic Republic of the Congo *|* 28-(CHF)=Switzerland *|* 29-(CLP)=Chile *|* 30-(CNY)=China *|* _
31-(COP)=Colombia *|* 32-(CRC)=Costa Rica *|* 33-(CUP)=Cuba *|* 34-(CVE)=Cape Verde *|* 35-(CZK)=Czech Republic *|* _
asi.. hasta completar los paises, que maneja la API.

<h3>opcion #2. Conversion de monedas</h3>

Digite Pais Fuente :colombia

Pais{codeCurrency='COP', currencyName='Colombian Peso', country='Colombia'}

Codigo moneda :COP, pais :Colombia

Digite Pais Destino :estados unidos

Pais{codeCurrency='USD', currencyName='United States Dollar', country='Estados Unidos'}

A Codigo moneda :USD, pais :Estados Unidos

Valor a convertir, en COP :500000

API Key: Verified
Result :Currency[base_code=COP, target_code=USD, conversion_rate=2.3622E-4]

Conversion 500000,00  COP   Colombian Peso son 118,11  USD United States Dollar  

<h3>opcion #3. Listar paises con nombres similares</h3>

igite Pais con nombres similiares :pa

**Paises con nombres similares**

->Panama PAB
->Papua New Guinea PGK
->Pakistan PKR
->Paraguay PYG

