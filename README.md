# Bem vindo ao BookSystem:

O BookSystem é um sistema de gerenciamento de biblioteca com o objetivo de agilizar o processo de empréstimos de livros. O usuário pode realizar o cadastro de livros, bem como o gerenciamento de empréstimos e devoluções.

## Tecnologias:

- React
- CSS
- Java
- Spring
- MongoDB

## Principais funcionalidades:

- Login;
- Cadastro, edição consulta e exclusão de livros;
- Gerenciamento de empréstimos de livros.

## Integração com IOT
Durante as entrevistas realizadas para identificar as dores dos nossos clientes e levantar requisitos, surgiu uma preocupação recorrente: a segurança dos livros na biblioteca.

Para atender a essa necessidade, o projeto propõe uma integração com dispositivos IoT, utilizando sensores RFID. A ideia é fixar etiquetas RFID nos livros e instalar sensores nas saídas da biblioteca. Dessa forma, apenas livros devidamente registrados como emprestados poderão sair do local, ajudando a prevenir perdas e furtos.

Conseguimos prototipar e criar um MVP funcional utilizando alguns componentes eletrônicos. O código-fonte está disponível no repositório, no diretório `/ESP32`

### Materiais:

- Placa Esp32
- Sensor RFID RC522
- TAGs RFID
- Buzzer ativo 3v

## BookSystem Web 💻

### Como usar

(Acesse uma demonstração)

[BookSystem Demo](https://book-system.vercel.app/)

(Se deseja rodar o projeto na sua máquina)

1. Clone o repositório

   ```bash
   git clone https://github.com/JV-projects/chromodoro-app.git
   ```

2. Entre no repositório

   ```bash
   cd BookSystemFront
   ```

3. Instale as dependências

   ```bash
   npm install
   ```
4. Inicie o projeto

   ```bash
   npm run dev
   ```
   
5. Acesse o frontend no seguinte endereço
   
(Você conseguirá ter uma demonstração estática do funcionamento do projeto)
   ```bash
     localhost:5173
   ```

## BookSystem API 💻

### Como usar
(Se deseja rodar o projeto na sua máquina)

1. Clone o repositório

   ```bash
   git clone https://github.com/JV-projects/BookSystem.git
   ```

2. Entre no repositório

   ```bash
   cd BookSystemAPI
   cd booksystem
   ```

3. Execute a aplicação

   ```bash
   mvn spring-boot:run
   ```
   
4. Acesse o swagger com os endpoints no endereço a seguir:
   ```bash
     localhost:8080/swagger
   ```


## BookSystem Mobile 📱

O projeto também inclui um aplicativo Android voltado para os leitores, que permite acompanhar o status dos empréstimos e buscar livros com filtros.

### Funcionalidades principais

- Login de usuário;
- Cadastro de leitor;
- Visualização do histórico de empréstimos;
- Busca de livros com filtros personalizados;
- Visualização de status do livro (se está disponível para empréstimo ou não).

O código-fonte está disponível no repositório, no diretório `/BookSystemApp`.

