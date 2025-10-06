# Composite Anti-Pattern

Este é um exemplo de como NÃO implementar o padrão Composite. O anti-pattern demonstra os problemas de não usar uma interface comum e ter métodos específicos para cada tipo.

```mermaid
classDiagram
    class Team {
        -List~Object~ members
        +addMember(Developer developer)
        +addMember(Team team)
        +showMembers()
    }
    class Developer {
        -String name
        +Developer(String name)
        +getName()
    }
    Team --> Developer : contains
```

## Problemas do Anti-Pattern
1. Métodos duplicados `addMember` para cada tipo
2. Uso de casting com `instanceof`
3. Lista de `Object` ao invés de uma interface comum
4. Difícil extensibilidade para novos tipos de membros
5. Violação do princípio Open/Closed
