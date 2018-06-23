# example-geometry-jts 

## Proposta da Atividade

Vocês deverão criar uma aplicação que use o JTS, e que contenha dois campos de texto nos quais serão inseridos geometrias na forma de texto bem formatado (WKT). Sua aplicação deverá ler os campos de texto e criar dois objetos do tipo Geometry. Por fim, deverá mostrar na tela todos os resultados dos predicados espaciais (Equals, Disjoint, Intersects, Touches, Crosses, Within, Contains, Overlaps, Covers e CoveredBy) entre esses objetos, além de calcular os predicados espaciais, desenhar as geometrias na tela utilizando SVG.

## Build

O projeto utiliza Maven para gerenciar dependencias e ferramenta de build, portanto para "construir o projeto" é preciso executar:
```sh
$ mvn clean install
```
## Run
```sh
$ mvn spring-boot:run
```



