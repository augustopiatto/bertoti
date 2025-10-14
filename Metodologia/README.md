# Augusto de Moraes Piatto

## Introdução

Olá! Sou estudante no curso de Banco de Dados da FATEC, da turma de 2024 - 1º semestre.

Sempre gostei da área de exatas, e durante minha infância participei de campeonatos de xadrez e matemática. Ao longo dos anos de fundamental e ensino médio quis ingressar em uma área relacionada e, por conta disso, em 2010 iniciei um curso técnico na ETEC, em paralelo com o ensino médio, me graduando no final de 2011 em Manutenção Automotiva. Em 2013 ingressei em Engenharia de Materiais na UNESP de Guaratinguetá, iniciando pesquisas científicas em 2014. Em 2015 realizei intercâmbio pelo Ciência sem Fronteiras para o Estados Unidos, com duração de 9 meses de curso em Ciência dos Materiais e 2 meses realizando pesquisa científica.

Mudei de área para a programação web em 2020, através do bootcamp oferecido pela empresa Buser Brasil. Fiz 3 meses de curso, onde aprendi tecnologias como Vue (Javascript) e Django (Python), com o uso de Postgres no banco. Desde então tenho trabalhado com foco em front-end, aprendendo novas tecnologias e ferramentas.

<p align="center">
  <img src="fotos/foto-perfil.png" alt="Minha Foto" width="200">
</p>

<div align = center>
 <a href="[https://www.linkedin.com/in/dsf21/](https://www.linkedin.com/in/augusto-piatto/)" target="_blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
 <a href="[https://github.com/DaviSFS21](https://github.com/augustopiatto)" target="_blank"><img src="https://img.shields.io/badge/github-000000?style=for-the-badge&logo=github" target="_blank"></a>
</div>

## Meus Principais Conhecimentos
* Desenvolvimento Web Front-end: Experiência sólida utilizando Vue, com conhecimento em React.
* Desenvolvimento Web Back-end: Experiência sólida utilizando Django, além de uso esporádico de SpringBoot.
* Banco de Dados: Conhecimento em banco relacionais, principalmente postgres.

## Meus Projetos

### Em 2025-1
Durante o primeiro semestre de 2025, desenvolvi junto da minha equipe um projeto desafiador focado na criação de um sistema de pontos que registra as movimentações dos funcionários, com dashboards de gráficos e geração de relatórios. O sistema registra a entrada e saída dos funcionários, bem como a quantidade de horas trabalhadas, e gera gráficos e relatórios com essas informações.

**Empresa Parceira**: Projeto acadêmico desenvolvido no âmbito da FATEC, com parceria com a empresa Altave.

**Problema**: A necessidade de uma ferramenta que verificasse atrasos em funcionários de uma empresa terceira contratada, a fim de evitar atrasos e, por consequência, prejuízos para o cliente.

**Solução Entregue pela Equipe**: Desenvolvemos um sistema web que consome as informações de um banco de dados terceiro para exibir dados de entrada e saída dos funcionários. Esta interface possibilita diversos filtros para o usuários, além de oferecer gráficos e extração de relatórios para melhor análise e tomada de decisões.

[Repositório do projeto](https://github.com/SQLutions-FATEC/API-3-Semestre)

#### Tecnologias Utilizadas
* **PostgreSQL**: Banco de dados relacional utilizado para armazenar de forma estruturada os dados coletados pelo crawler, como notícias, autores e metadados. Foram implementadas tabelas normalizadas, índices para otimização de consultas e triggers para garantir a consistência dos dados.
* **Docker**: Empregado para containerização da aplicação, permitindo a criação de ambientes isolados para o crawler, API e banco de dados. Utilizou-se docker-compose para orquestrar múltiplos serviços (PostgreSQL + backend Java), garantindo portabilidade e implantação reproduzível em diferentes sistemas.
* **Java 21**: Linguagem principal do backend, com ênfase em orientação a objetos.
* **Spring Boot**: Framework para desenvolvimento da API RESTful, responsável por expor endpoints. Utilizou-se Spring Data JPA para mapeamento objeto-relacional (ORM) com o PostgreSQL.
* **Maven**: Gerenciador de dependências para automatização do build, integração de bibliotecas (Jsoup, Spring Boot) e configuração de perfis de desenvolvimento/produção.
* **Vue.js**: Framework web utilizado para construir o frontend da aplicação.

### Contribuições Pessoais

Atuei como desenvolvedor full-stack com participação estratégica em todas as fases do projeto. Minhas contribuições iniciaram na concepção da interface e modelagem do banco de dados, evoluindo para o desenvolvimento das funcionalidades front-end e otimizações back-end. Esta visão completa do ecossistema técnico me permitiu entregar soluções coesas e alinhadas com os objetivos do negócio, sempre focando na qualidade do produto final e na eficiência do processo de desenvolvimento.

<details>
  <summary>Desenvolvimento de Wireframe para as sprints</summary>
  <br />

  **Liderança na definição da experiência do usuário e fluxos navegacionais**, criando wireframes no Figma que serviram como fonte única de verdade para todo o time. Esta documentação visual foi fundamental para **alinhar expectativas com o cliente**, validar requisitos de negócio e **acelerar o processo de desenvolvimento** através de um guia claro e consistente. Os protótipos evolutivos permitiram iterações rápidas baseadas em feedback, **reduzindo retrabalho em fases posteriores** do projeto.
  <br />
  <p align="center">
    <img src="fotos/wireframe.png" alt="Wireframe">
  </p>
  
  A partir do design, **estruturei e refinei as user-stories** que podem ser vistas [aqui no github](https://github.com/SQLutions-FATEC/API-3-Semestre?tab=readme-ov-file#-backlogs--user-stories), estabelecendo **critérios de aceitação claros** que orientaram todo o ciclo de desenvolvimento. Esta abordagem garantiu que cada sprint entregasse valor tangível, mantendo o foco nas necessidades reais do usuário final.
</details>

<details>
  <summary>Modelagem inicial do banco de dados</summary>
  <br />

  **Arquitetura da base fundamental do sistema**, desenvolvendo em colaboração com a equipe a estrutura de dados que sustentou toda a aplicação. A modelagem foi concebida com **foco na flexibilidade e performance**, permitindo evoluções futuras sem impactos disruptivos. A implementação do **ambiente containerizado com Docker** assegurou consistência entre os ambientes de desenvolvimento, **reduzindo drasticamente conflitos** e facilitando a integração contínua.
  <br />
  <p align="center">
    <img src="fotos/modelagem.png" alt="Modelagem">
  </p>
  
  Esta base sólida permitiu que o time **concentrasse esforços na implementação de funcionalidades** em vez de resolver problemas de infraestrutura, acelerando a entrega de valor nas sprints iniciais e garantindo a **escalabilidade da solução**.
</details>
  
<details>
  <summary>Desenvolvimento front-end utilizando Vue.js</summary>
  <br />

  **Liderança técnica no desenvolvimento da interface**, implementando soluções robustas e escaláveis com Vue.js. Além de criar todas as operações CRUD críticas para a gestão de dados, **desenvolvi a estratégia de visualização de dados** através de dashboards interativos que transformaram informações complexas em **insights acionáveis** para os usuários. Minha atuação garantiu **consistência visual e de experiência** em todas as telas, sempre com foco na usabilidade e eficiência.
  Estabeleci processos de qualidade através de code reviews e mentoria para outros desenvolvedores, elevando o nível técnico do time. A colaboração próxima com Product Owners permitiu traduzir necessidades de negócio em soluções técnicas eficazes, sempre com foco na entrega de valor.

<details>
  <summary>Definição de bibliotecas ao projeto</summary>
  <br />

  **Arquitetura da stack tecnológica front-end**, selecionando bibliotecas que otimizaram desenvolvimento e performance. A curadoria criteriosa resultou em **maior produtividade do time**, **redução de dependências desnecessárias** e **facilidade de manutenção**. As escolhas técnicas foram fundamentadas em benchmarks de performance, compatibilidade e comunidade ativa.
  <br />
  <p align="center">
    <img src="fotos/bibliotecas.png" alt="Bibliotecas">
  </p>
</details>

<details>
  <summary>Definição de padrão de estilos para identidade visual</summary>
  <br />

  **Criação de design system consistente** que unificou a identidade visual em toda a aplicação. Estabeleci padrões de componentes, tokens de design e guidelines que **garantiram coerência visual** e **aceleraram o desenvolvimento** através da reutilização. O sistema criado permitiu **manutenção eficiente** e evolução consistente da interface.
  <br />
  <p align="center">
    <img src="fotos/design-system.png" alt="Design-system">
  </p>
</details>

<details>
  <summary>Dashboard</summary>
  <br />

  **Desenvolvimento de ferramenta estratégica de business intelligence**, criando visualizações de dados que permitiram **análise rápida e tomada de decisão informada**. Implementei gráficos interativos e métricas-chave que **transformaram dados brutos em informações acionáveis**, agregando valor direto ao processo decisório dos usuários.
  <br />
  <p align="center">
    <img src="fotos/dashboard.png" alt="Dashboard">
  </p>
</details>

<details>
  <summary>CRUD</summary>
  <br />

  **Implementação de operações fundamentais para a gestão de dados**, desenvolvendo interfaces intuitivas para criação, edição, visualização e exclusão de registros. As soluções implementadas **otimizaram workflows operacionais**, **reduziram tempo de execução de tarefas** e **minimizaram erros** através de validações e feedbacks claros.
  <br />
  <p align="center">
    <img src="fotos/crud.png" alt="Crud">
  </p>
</details>
</details>
  
<details>
  <summary>Desenvolvimento back-end utilizando SpringBoot</summary>
  <br />

  **Atuação estratégica na camada de serviços**, garantindo a robustez e performance da API. Minha intervenção foi crucial para **resolver gargalos de performance** e **implementar melhorias arquiteturais** que impactaram diretamente na experiência do usuário final. Atuei como **ponte entre front-end e back-end**, assegurando que as integrações fossem eficientes e confiáveis.
  <br />

<details>
  <summary>Paginações</summary>
  <br />

  **Otimização de performance em grandes volumes de dados** através da implementação de paginação eficiente. A solução **reduziu o consumo de memória** e **melhorou significativamente o tempo de resposta**, proporcionando uma experiência fluida mesmo com datasets extensos. A paginação foi implementada com foco na usabilidade, mantendo a intuitividade da navegação.
  <br />
  <p align="center">
    <img src="fotos/paginacao.png" alt="Paginacao">
  </p>
</details>

<details>
  <summary>Endpoints de listagem</summary>
  <br />

  **Desenvolvimento de APIs RESTful eficientes** para recuperação e filtragem de dados. Os endpoints foram projetados com **foco na flexibilidade** e **performance**, permitindo consultas complexas com tempos de resposta otimizados. Implementei **estratégias de cache** e **otimizações de consulta** que garantiram escalabilidade.
  <br />
  <p align="center">
    <img src="fotos/listagem.png" alt="Listagem">
  </p>
</details>

<details>
  <summary>Estruturação de dados (DTO)</summary>
  <br />

  **Padronização do contrato de dados** entre front-end e back-end através de DTOs bem definidos. Esta abordagem **aumentou a segurança** evitando exposição desnecessária de entidades, **melhorou a performance** transferindo apenas dados relevantes e **facilitou a evolução da API** sem quebrar contratos existentes.
  <br />
  <p align="center">
    <img src="fotos/dto.png" alt="Dto">
  </p>
</details>

<details>
  <summary>Ajustes de queries</summary>
  <br />

  **Otimização de consultas críticas** que impactavam diretamente na performance do sistema. Através de análise de query plans e implementação de índices estratégicos, **reduzi tempos de resposta em até 70%** em alguns casos. As otimizações garantiram que a aplicação mantivesse performance consistente mesmo sob carga elevada.
  <br />
  <p align="center">
    <img src="fotos/query.png" alt="Query">
  </p>
</details>
  
<details>
  <summary>Padronização de código</summary>
  <br />

  **Estabelecimento de convenções e boas práticas** que elevaram a qualidade do código back-end. Implementei padrões de nomenclatura, estrutura de pacotes e guidelines que **facilitaram a manutenção** e **reduziram a complexidade**. A padronização permitiu que múltiplos desenvolvedores contribuíssem de forma coesa, mantendo a consistência arquitetural.
  <br />
  <p align="center">
    <img src="fotos/padronizacao.png" alt="Padronizacao">
  </p>
</details>
</details>

#### Hard Skills
* **Java e Orientação a Objetos**: Domínio intermediário em desenvolvimento Java, aplicando os princípios SOLID, e arquitetura limpa para criar soluções escaláveis e de fácil manutenção. Experiência no desenvolvimento de aplicações robustas utilizando coleções, streams, lambdas e tratamento de exceções, garantindo código eficiente e legível.
* **PostgreSQL**: Domínio intermediário em modelagem de bancos de dados relacionais, otimização de consultas SQL. Experiência em migração e administração de bancos PostgreSQL em ambientes de desenvolvimento e produção.
* **Vue**: Domínio avançado em arquitetura do projeto, criação de componentes para a divisão adequada de responsabilidades, compreensão de como é feita a comunicação entre sistemas via api.
* **CSS**: Domínio avançado em estilização de componentes visuais do projeto, com habilidade em implementar design systems consistentes, garantindo identidade visual coesa. Experiência em otimizar o desempenho de estilos, reduzindo redundâncias. Além disso, conhecimento em pré-processadores como SASS para modularização e reutilização de código.

#### Soft Skills
* **Trabalho em equipe**: Atuei com comunicação constante com o resto do time, principalmente com o meu par do back-end, devido ao meu foco no front-end. Em casos de discordância no time, expressei minha opinião e evitei o acúmulo de problemas. Trabalhei na integração das partes desenvolvidas por diferentes membros do time, garantindo que o sistema funcionasse de forma coesa.
* **Comunicação**: Participei ativamente de reuniões semanais com o time, garantindo alinhamento entre as entregas e as expectativas do cliente. Mantive uma comunicação clara e objetiva com o PO e o SM, detalhando minhas abordagens para as tarefas e antecipando possíveis desafios. Além disso, ofereci suporte aos membros com maior dificuldade no front-end, promovendo um ambiente colaborativo e reduzindo retrabalho por meio de alinhamentos frequentes.
* **Resolução de problemas**: Contribuí para o planejamento e estruturação inicial do banco de dados, propondo soluções práticas para desafios técnicos no back-end e garantindo a integração fluida com o front-end. No front-end, atuei na arquitetura geral, otimizando fluxos críticos e implementando melhorias que tornaram o sistema mais eficiente e escalável. Minha abordagem proativa ajudou a resolver gargalos técnicos e a manter o progresso do projeto dentro dos prazos estabelecidos.
