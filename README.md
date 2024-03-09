# Versão 1.0.0 (09/03/2024)

## Adições
- Implementação de um DAO (Data Access Object) genérico para aumentar a reutilização de código.  
- Estudo e implementação do uso de @Transactional com opção de leitura apenas (readOnly) configurável como verdadeiro ou falso.  
- Investigação sobre o carregamento de estágios (stage loaded) para otimização de consultas.  

## Modificações
- Ajustes na estrutura do DAO para suportar operações genéricas em diferentes entidades.  

## Correções
- Correção de bugs relacionados à transação em operações de leitura.  
- Resolução de problemas de desempenho identificados durante o estudo de carregamento de estágios.  

## Remoções
- Remoção de métodos duplicados ou desnecessários após a implementação do DAO genérico.  

## Outros
- Documentação atualizada para refletir as mudanças e adições realizadas.  
- Testes adicionais para garantir a robustez das novas funcionalidades e correções.

  ## Diagrama do projeto

  ![image](https://github.com/guigomes91/generic-dao/assets/44264050/34772f0d-77a2-4d38-9c48-605f1bb52b36)

