algoritmo "Cadastro e Consulta"
var
   nome,email,telefone,endereco:vetor[1..3]de caractere
   lugar,cidade,estado:vetor[1..3]de caractere
   cadastro,consulta,ltela,i,j:inteiro
   bdados:caractere
inicio

   para i de 1 ate 3 faca
      escreval("----- CADASTRO ----")
      escreval("(1) - DESTINO ")
      escreval("(2) - CLIENTE ")
      leia(cadastro)
      se (cadastro = 1) entao
         para i de 1 ate 3 faca
            escreval("Digite o lugar:")
            leia(lugar[i])
            escreval("Cidade:")
            leia(cidade[i])
            escreval("estado: ")
            leia(pais[i])
            escreval("Deseja cadastrar outro destino?")
            escreval(" (1) - Sim")
            escreval(" (2) - Não")
            leia(j)
            se j = 2 entao
               escreval("---- FIM CADASTRO ----")
               interrompa
            fimse
         fimpara
      senao
         se (cadastro = 2) entao
            para i de 1 ate 3 faca
               escreval("Digite o nome:")
               leia(nome[i])
               escreval("email:")
               leia(email[i])
               escreval("telefone: ")
               leia(telefone[i])
               escreval("endereço: ")
               leia(endereco[i])
               escreval("Deseja cadastrar outro cliente?")
               escreval(" (1) - Sim")
               escreval(" (2) - Não")
               leia(j)
               se j = 2 entao
                  escreval("---- FIM CADASTRO ----")
                  interrompa
               fimse
            fimpara
         senao
            escreval ("---- ERRO ----")
         fimse
      fimse
      escreval("Deseja fazer outro cadastro de cliente ou destino?")
      escreval(" (1) - Sim")
      escreval(" (2) - Não")
      leia(j)
      se j = 2 entao
         escreval("---- FIM CADASTRO ----")
         interrompa
      fimse
   fimpara

   escreval("")
   escreval("gostaria de limpar a tela? (1) - sim (2) - nao")
   leia(ltela)
   se (ltela = 1) entao
      limpatela
   fimse

   para i de 1 ate 2 faca
      escreval("---- CONSULTA ----")
      escreval("(1) - DESTINO ")
      escreval("(2) - CLIENTE ")
      leia(consulta)
      se (consulta = 1)entao
         escreval("Escolha um destino para a consulta")
         leia(bdados)
         para i de 1 ate 3 faca
            se lugar[i] = bdados entao
               escreval("---- RESULTADO ----")
               escreva("Lugar: ")
               escreval(lugar[i])
               escreva("Cidade: ")
               escreval(cidade[i])
               escreva("estado: ")
               escreval(pais[i])
               escreval("---- FINAL RESULTADO ----")
            fimse
         fimpara
      senao
         se (consulta = 2) entao
            escreval("Escolha um cliente para a consulta")
            leia(bdados)
            para i de 1 ate 3 faca
               se nome[i] = bdados entao
                  escreval("---- RESULTADO ----")
                  escreva("Nome: ")
                  escreval(nome[i])
                  escreva("E-mail: ")
                  escreval(email[i])
                  escreva("Telefone: ")
                  escreval(telefone[i])
                  escreva("Endereço: ")
                  escreval(endereco[i])
                  escreval("---- FINAL RESULTADO ----")
               fimse
            fimpara
         fimse
      fimse
      escreval("Deseja fazer outra consulta?")
      escreval(" (1) - Sim")
      escreval(" (2) - Não")
      leia(j)
      se j = 2 entao
         escreval("---- FIM CONSULTA ----")
         interrompa
      fimse
   fimpara





fimalgoritmo