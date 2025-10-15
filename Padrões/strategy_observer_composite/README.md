# Padrões Strategy + Observer + Composite

Este exemplo demonstra como três padrões de design podem trabalhar juntos harmoniosamente em um sistema de processamento de pagamentos para funcionários organizados em equipes.

## Visão Geral dos Padrões

### 1. Strategy Pattern (Estratégia de Pagamento)
Permite alternar entre diferentes métodos de pagamento sem modificar o código cliente.

### 2. Observer Pattern (Sistema de Notificações)
Permite que múltiplos observadores sejam notificados quando um pagamento é processado.

### 3. Composite Pattern (Estrutura de Funcionários)
Permite tratar funcionários individuais e equipes de forma uniforme através de uma interface comum.

## Diagrama UML Completo

```mermaid
classDiagram
    %% Strategy Pattern
    class IPaymentStrategy {
        <<interface>>
        +pay(String recipient, double amount)
    }
    
    class CreditCardPayment {
        +pay(String recipient, double amount)
    }
    
    class PayPalPayment {
        +pay(String recipient, double amount)
    }
    
    class PaymentProcessor {
        -IPaymentStrategy paymentStrategy
        +setPaymentStrategy(IPaymentStrategy strategy)
        +processPayment(IEmployee employee, double baseAmount, PaymentNotificationSystem notifier)
    }
    
    %% Observer Pattern
    class IPaymentObserver {
        <<interface>>
        +update(String recipient, double amount, String paymentMethod)
    }
    
    class PaymentNotificationSystem {
        -List~IPaymentObserver~ observers
        -String recipient
        -double amount
        -String paymentMethod
        +registerObserver(IPaymentObserver o)
        +removeObserver(IPaymentObserver o)
        -notifyObservers()
        +setPayment(String recipient, double amount, String paymentMethod)
    }
    
    class PaymentDisplay {
        -String name
        +PaymentDisplay(String name)
        +update(String recipient, double amount, String paymentMethod)
    }
    
    %% Composite Pattern
    class IEmployee {
        <<interface>>
        +showDetails()
        +getName() String
        +calculateSalary(double baseAmount) double
    }
    
    class Developer {
        -String name
        -String level
        +Developer(String name, String level)
        +showDetails()
        +getName() String
        +calculateSalary(double baseAmount) double
    }
    
    class Manager {
        -String name
        -String position
        +Manager(String name, String position)
        +showDetails()
        +getName() String
        +calculateSalary(double baseAmount) double
    }
    
    class Team {
        -String name
        -List~IEmployee~ employees
        +Team(String name)
        +addEmployee(IEmployee employee)
        +removeEmployee(IEmployee employee)
        +showDetails()
        +getName() String
        +calculateSalary(double baseAmount) double
    }
    
    %% Strategy Pattern Relationships
    IPaymentStrategy <|.. CreditCardPayment
    IPaymentStrategy <|.. PayPalPayment
    PaymentProcessor --> IPaymentStrategy : usa
    
    %% Observer Pattern Relationships
    IPaymentObserver <|.. PaymentDisplay
    PaymentNotificationSystem --> IPaymentObserver : notifica
    PaymentProcessor --> PaymentNotificationSystem : aciona
    
    %% Composite Pattern Relationships
    IEmployee <|.. Developer
    IEmployee <|.. Manager
    IEmployee <|.. Team
    Team --> IEmployee : contém
    
    %% Integration Relationships
    PaymentProcessor --> IEmployee : processa pagamento para
    
    note for PaymentProcessor "Integra os 3 padrões:\n- Strategy: escolhe método pagamento\n- Observer: notifica observadores\n- Composite: processa funcionários/equipes"
```

## Arquitetura por Camadas

```mermaid
graph TB
    subgraph "View Layer"
        PD[PaymentDisplay]
    end
    
    subgraph "Controller Layer"
        PP[PaymentProcessor]
        PNS[PaymentNotificationSystem]
        CC[CreditCardPayment]
        PPL[PayPalPayment]
    end
    
    subgraph "Model Layer"
        DEV[Developer]
        MGR[Manager]
        TEAM[Team]
    end
    
    subgraph "Interfaces"
        IPS[IPaymentStrategy]
        IPO[IPaymentObserver]
        IE[IEmployee]
    end
    
    PP --> IPS
    PP --> IPO
    PP --> IE
    PNS --> IPO
    CC --> IPS
    PPL --> IPS
    PD --> IPO
    DEV --> IE
    MGR --> IE
    TEAM --> IE
    
    classDef interface fill:#e1f5fe
    classDef view fill:#f3e5f5
    classDef controller fill:#e8f5e8
    classDef model fill:#fff3e0
    
    class IPS,IPO,IE interface
    class PD view
    class PP,PNS,CC,PPL controller
    class DEV,MGR,TEAM model
```

## Fluxo de Execução

```mermaid
sequenceDiagram
    participant Client as Cliente
    participant PP as PaymentProcessor
    participant Strategy as IPaymentStrategy
    participant Employee as IEmployee
    participant Notifier as PaymentNotificationSystem
    participant Observer as PaymentDisplay
    
    Client->>PP: setPaymentStrategy(creditCard)
    Client->>PP: processPayment(employee, 5000, notifier)
    
    PP->>Employee: calculateSalary(5000)
    Employee-->>PP: calculatedAmount
    
    PP->>Strategy: pay(employee.getName(), calculatedAmount)
    Strategy-->>PP: payment processed
    
    PP->>Notifier: setPayment(name, amount, method)
    Notifier->>Observer: update(name, amount, method)
    Observer-->>Notifier: notification displayed
```

## Estrutura de Diretórios

```
strategy_observer_composite/
├── controller/
│   ├── IPaymentStrategy.java          # Interface Strategy
│   ├── CreditCardPayment.java         # Concrete Strategy 1
│   ├── PayPalPayment.java            # Concrete Strategy 2
│   ├── PaymentProcessor.java          # Context (Strategy)
│   ├── IPaymentObserver.java         # Observer Interface
│   └── PaymentNotificationSystem.java # Subject (Observer)
├── model/
│   ├── IEmployee.java                 # Component (Composite)
│   ├── Developer.java                 # Leaf (Composite)
│   ├── Manager.java                   # Leaf (Composite)
│   └── Team.java                      # Composite (Composite)
├── view/
│   └── PaymentDisplay.java            # Concrete Observer
└── StrategyObserverCompositeDemo.java # Demonstration
```

## Benefícios da Integração

### ✅ **Flexibilidade Máxima**
- **Strategy**: Troca algoritmos de pagamento dinamicamente
- **Observer**: Adiciona/remove notificadores sem modificar código
- **Composite**: Trata indivíduos e grupos uniformemente

### ✅ **Baixo Acoplamento**
- Cada padrão opera independentemente
- Interfaces bem definidas entre componentes
- Fácil manutenção e evolução

### ✅ **Alta Coesão**
- Responsabilidades bem separadas
- Cada classe tem um propósito específico
- Código organizado e legível

### ✅ **Extensibilidade**
- Novos métodos de pagamento (Strategy)
- Novos tipos de notificação (Observer)
- Novos tipos de funcionário (Composite)

## Casos de Uso

1. **Pagamento Individual**: Developer ou Manager recebe salário via método escolhido
2. **Pagamento de Equipe**: Team inteira recebe pagamento calculado recursivamente
3. **Múltiplas Notificações**: Diferentes sistemas são notificados simultaneamente
4. **Troca de Método**: Alternar entre CartãoCredito e PayPal dinamicamente

## Padrões em Ação

### Strategy Pattern
```java
processor.setPaymentStrategy(new CreditCardPayment());
processor.processPayment(employee, 5000, notifier);
```

### Observer Pattern
```java
notifier.registerObserver(new PaymentDisplay("Sistema Principal"));
notifier.registerObserver(new PaymentDisplay("Auditoria"));
```

### Composite Pattern
```java
Team team = new Team("Desenvolvimento");
team.addEmployee(new Developer("João", "Senior"));
team.addEmployee(new Manager("Maria", "Tech Lead"));
double totalSalary = team.calculateSalary(5000); // Calcula para todos
```

## Como Executar

```bash
# Compilar todos os arquivos
javac **/*.java

# Executar a demonstração
java StrategyObserverCompositeDemo
```

## Saída Esperada

```
=== DEMONSTRAÇÃO DOS PADRÕES INTEGRADOS ===

Configurando equipe de desenvolvimento...
Team: Desenvolvimento
Developer: João Silva (Senior)
Manager: Maria Santos (Tech Lead)

Processando pagamentos com CartãoCredito:
💳 Pagamento de R$ 7500.0 para João Silva via Cartão de Crédito
🔔 Sistema Principal: Pagamento processado - João Silva recebeu R$ 7500.0 via CreditCardPayment
🔔 Auditoria: Pagamento processado - João Silva recebeu R$ 7500.0 via CreditCardPayment

💳 Pagamento de R$ 10000.0 para Maria Santos via Cartão de Crédito
🔔 Sistema Principal: Pagamento processado - Maria Santos recebeu R$ 10000.0 via CreditCardPayment
🔔 Auditoria: Pagamento processado - Maria Santos recebeu R$ 10000.0 via CreditCardPayment

Trocando para PayPal:
📧 Pagamento de R$ 17500.0 para Desenvolvimento via PayPal
🔔 Sistema Principal: Pagamento processado - Desenvolvimento recebeu R$ 17500.0 via PayPalPayment
🔔 Auditoria: Pagamento processado - Desenvolvimento recebeu R$ 17500.0 via PayPalPayment
```

## Vantagens desta Abordagem

- **Código Limpo**: Separação clara de responsabilidades
- **Facilidade de Teste**: Cada componente pode ser testado isoladamente
- **Manutenibilidade**: Mudanças são localizadas e controladas
- **Reutilização**: Componentes podem ser reutilizados em outros contextos
- **Escalabilidade**: Sistema cresce de forma organizada

Esta implementação demonstra como padrões de design diferentes podem trabalhar juntos para criar uma solução robusta, flexível e maintível.