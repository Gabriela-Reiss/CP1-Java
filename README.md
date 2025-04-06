# CP1-Java

Catálogo de Carros - Web API

Esta é uma Web API desenvolvida em Java com Spring Boot para gerenciar um catálogo de carros, 
fornecendo endpoints para consultas e manutenção de veículos com diferentes características de desempenho, economia e tipo.

📋 Funcionalidades

- Consulta de carros por potência, economia e tipo
- CRUD completo de veículos
- Filtros específicos para veículos elétricos
- Tratamento de erros e validações


🚀 Endpoints

Consultas

- GET /carros/potencia - Top 10 carros mais potentes
- GET /carros/economia - Top 10 carros mais econômicos
- GET /carros/eletricos - Todos os carros elétricos
- GET /carros/{id} - Detalhes de um carro específico

Manutenção

- POST /carros - Adiciona novo carro
- PUT /carros/{id} - Atualiza carro existente
- DELETE /carros/{id} - Remove carro do catálogo


⚙️ Tecnologias

- Java 17
- Spring Boot 3.1.5
- Spring Data JPA
- H2 Database (para desenvolvimento)
- Maven
- JUnit 5 (para testes)
