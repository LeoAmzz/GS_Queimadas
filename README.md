Leonardo A. RM: 553372
Gustavo F. RM: 554242
Gustavo B. RM: 553493


# Wildfire Monitoring System

Sistema de monitoramento e alerta para focos de queimadas, com API construída em Java e Spring Boot.

## Problema Abordado

As queimadas representam um problema ambiental crítico no Brasil, afetando a biodiversidade, o clima, a saúde pública e a economia. Esta aplicação busca apoiar agentes ambientais e autoridades no combate, prevenção e monitoramento de incêndios florestais.

## Objetivo da Solução

Fornecer uma API que permita:
- Registrar focos de calor com localização e intensidade

## Arquitetura e Padrões Utilizados

A aplicação foi desenvolvida com Java  e Spring Boot:

## Modelo de Domínio

A modelagem do sistema representa conceitos do domínio de queimadas:

- PontoDeFoco: representa um foco detectado com intensidade e localização
- Regiao: área geográfica monitorada
- Sensor: dispositivo responsável por captar sinais
- Alerta: notificação gerada com base em um foco
- AgenteAmbiental: pessoa responsável pelas ações no campo
- Ocorrencia: registro de intervenção ou finalização de foco

## (Spring Security)
- Senha (`username=admin`, `password=admin123`)

## Tecnologias Utilizadas

- Java 
- Spring Boot 
- Spring Web
- Spring Data JPA
- H2 Database
- Spring Security

