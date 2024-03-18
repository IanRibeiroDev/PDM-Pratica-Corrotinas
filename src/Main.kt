package br.ifpb.pdm.praticas

import kotlinx.coroutines.*

// Atividade Prática: Introdução às Corrotinas em Kotlin

// Etapa 1: Criar uma Corrotina Simples
// Crie uma função chamada simpleCoroutine que inicia uma corrotina simples que imprime "Olá, mundo!" após um atraso de 1 segundo.

// Etapa 2: Utilizar a Função runBlocking
// Modifique a função main para usar runBlocking para esperar a conclusão da corrotina.

// Etapa 3: Adicionar Mais uma Corrotina
// Adicione uma segunda corrotina à função simpleCoroutine que imprime "Segunda corrotina" após um atraso de 2 segundos.

// Etapa 4: Utilizar um Escopo de Corrotina
// Modifique a função simpleCoroutine para usar um escopo de corrotina em vez de GlobalScope.
// Dica: Utilize CoroutineScope(Dispatchers.Default).launch {}

// Etapa 5: Utilizar o Objeto Job
// Modifique a função simpleCoroutine para retornar um objeto Job que representa a corrotina.

// Agora utilize o método cancel() do objeto job para cancelar a corrotina.
// Execute o programa e observe que a corrotina é cancelada.

suspend fun simpleCoroutine(): Job {
    return CoroutineScope(Dispatchers.Default).launch {
        coroutineScope<Unit> {
            delay(1000)
            println("Olá, mundo!")
        }

        coroutineScope {
            delay(2000)
            println("Segunda corrotina")
        }
    }
}


fun main() {
    runBlocking {
        println("Corrotina iniciada.")
        val job = simpleCoroutine()
//        job.join()
        job.cancel()
    }
    println("Corrotina finalizada.")
}