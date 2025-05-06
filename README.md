# 18-challenge-conversor-monedas-alura

<em> TEMATICA </em>

[Descripción proyecto](#descripción-proyecto) \
[Como usar el programa](#como-usar-el-programa) \
[Ayuda para usuarios](#ayuda-para-usuarios) \
[Autores del proyecto](#autores-del-proyecto)
<h2>Descripción proyecto</h2>
---------------------------- <br/>
Construir tu propio Conversor de Monedas. <br/> 
Aprenderás a realizar solicitudes a una API de tasas de cambio, a manipular datos JSON y,
finalmente, a filtrar y mostrar las monedas de interés.<br/>

Los pasos para completar este desafío se detallo:\
A) Configuración del Ambiente Java;\
B) Creación del Proyecto;\
C) Consumo de la API;\
D) Análisis de la Respuesta JSON;\
E) Filtro de Monedas;\
F) Exibición de Resultados a los usuarios

<h2>Como usar el programa</h2>
---------------------------- <br/>
**Conversor de monedas**   
1. Listado paises incluidos para conversión <br/>
2. Conversión de monedas <br/>
3. Listar paises con nombres similares <br/>
4. Listar movimientos diarios <br/>
9. Salir <br/>

Digite opción [1..4] o [9.Salir] 1
<h4>Explicación.</h4>
Aqui puede digitar la opcion, dentro del rango permitido, si hay error
de digitación se devuelve a leer opción.

<h3>Al seleccionar opcion 1. Sale un listado asi:</h3>

1-(AED)=United Arab Emirates *|* 2-(AFN)=Afghanistan *|* 3-(ALL)=Albania *|* 4-(AMD)=Armenia *|* 5-(ANG)=Netherlands Antilles *|* _
6-(AOA)=Angola *|* 7-(ARS)=Argentina *|* 8-(AUD)=Australia *|* 9-(AWG)=Aruba *|* 10-(AZN)=Azerbaijan *|* _
11-(BAM)=Bosnia and Herzegovina *|* 12-(BBD)=Barbados *|* 13-(BDT)=Bangladesh *|* 14-(BGN)=Bulgaria *|* 15-(BHD)=Bahrain *|* _
16-(BIF)=Burundi *|* 17-(BMD)=Bermuda *|* 18-(BND)=Brunei *|* 19-(BOB)=Bolivia *|* 20-(BRL)=Brazil *|* _
21-(BSD)=Bahamas *|* 22-(BTN)=Bhutan *|* 23-(BWP)=Botswana *|* 24-(BYN)=Belarus *|* 25-(BZD)=Belize *|* _
26-(CAD)=Canada *|* 27-(CDF)=Democratic Republic of the Congo *|* 28-(CHF)=Switzerland *|* 29-(CLP)=Chile *|* 30-(CNY)=China *|* _
31-(COP)=Colombia *|* 32-(CRC)=Costa Rica *|* 33-(CUP)=Cuba *|* 34-(CVE)=Cape Verde *|* 35-(CZK)=Czech Republic *|* _ <br/>
asi.. hasta completar los paises, que maneja la API.
[Exchangerate API](https://www.exchangerate-api.com/docs/overview)

<h3>opcion 2. Conversion de monedas</h3>
Digite opción [1..4] o [9.Salir] 2

Digite Pais Fuente :colombia \
Pais{codeCurrency='COP', currencyName='Colombian Peso', country='Colombia'} \
Codigo moneda :COP, pais :Colombia \
Digite Pais Destino :estados unidos \
Pais{codeCurrency='USD', currencyName='United States Dollar', country='Estados Unidos'} \
A Codigo moneda :USD, pais :Estados Unidos \
Valor a convertir, en COP :500000 

Resultado.\
Result :Currency[base_code=COP, target_code=USD, conversion_rate=2.3622E-4] \
Conversion 500000,00  COP   Colombian Peso son 118,11  USD United States Dollar
<h4>Explicación.</h4>
En la digitación o captura del pais, sea fuente o destino, se valida que el país, este el la tabla de conversiones.<br/> 
No puede colocar paises repetidos, o nombres de paises que no esten. <br/>
Ejemplo. Colombia, puede colocar colo, Colo, Colomb, col, Colombia, etc. <br/>
El programa le pasa todo el texto a minúscula y mayúscula a la primera letra.<br/>
Para el caso de Europa, donde hay 27 paises que utilizan el EURO, hay que digitar
"European Union" o "union", para que tome el EURO.

<h3>Opcion 3. Listar paises con nombres similares</h3> 

Dígite Pais con nombres similiares :pa

**Paises con nombres similares** \
->Panama PAB \
->Papua New Guinea PGK \
->Pakistan PKR \
->Paraguay PYG 

<h3>Opcion 4. Listar movimientos diarios</h3>
Digite opción [1..4] o [9.Salir] 4 <br/>
Moneda{base='COP', target='USD', factor =2.3618E-4, valor a convertir=100000.0, valor conversion=23.618000000000002, fecha='2025-05-04 16:37:27'} <br/> 
Moneda{base='COP', target='USD', factor =2.3502E-4, valor a convertir=10000.0, valor conversion=2.3502, fecha='2025-05-06 10:18:53'} <br/>
Moneda{base='EUR', target='USD', factor =1.1321, valor a convertir=10000.0, valor conversion=11321.000000000002, fecha='2025-05-06 10:40:16'} <br/>
Moneda{base='USD', target='AED', factor =3.6725, valor a convertir=10000.0, valor conversion=36725.0, fecha='2025-05-06 11:00:23'} <br/>
Lista todas las transacciones que se han realizado hasta el momento. <br/>

**En construccion**  <br/>
- listar transacciones por día. <br/>


<h3>Tecnologías utilizadas</h3>
- Java
- Manejo de API's
- Postman  (pruebas de la API)
- Editor IDE, Intellij IDEA
- git y github, terminal.
- LURI, IA de ALURA-ONE, Sao Pablo, Brazil.

<h3>Personas o entidades contribuyentes en el Proyecto</h3>


<h3>Personas desarrolladores del Proyecto</h3>


