enum class Nivel {
    BASICO,
    INTERMEDIARIO,
    AVANCADO
}

data class Aluno(
    val nome: String,
    val documento: String,
    val email: String,

) {
    val formacoesMatriculadas = mutableListOf<Formacao>()
}

data class ConteudoEducacional(
    val nome: String,
    val duracao: Int
)

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudosEducacionais: List<ConteudoEducacional>
) {

    private val alunosMatriculados = mutableSetOf<Aluno>()


    fun matricular(aluno: Aluno) {
        alunosMatriculados.add(aluno)
        aluno.formacoesMatriculadas.add(this)

    }

    fun listarAlunos(): Set<Aluno> = alunosMatriculados
}

fun main() {

    val kotlinBasico = ConteudoEducacional("Kotlin Básico", 2)
    val kotlinIntermediario = ConteudoEducacional("Kotlin Intermediário", 8)
    val kotlinAvancado = ConteudoEducacional("Kotlin Avançado", 20)

    val formacaoKotlin1 = Formacao(
        "Formacao Kotlin basic",
        nivel = Nivel.BASICO,
        conteudosEducacionais = listOf(kotlinBasico)
    )

    val formacaoKotlin2 = Formacao(
        nome = "Formacao Kotlin intermed",
        nivel = Nivel.INTERMEDIARIO,
        conteudosEducacionais = listOf(kotlinBasico, kotlinIntermediario)
    )

    val formacaoKotlin3 = Formacao(
        nome = "Formacao Kotlin Developer",
        nivel = Nivel.AVANCADO,
        conteudosEducacionais = listOf(kotlinBasico, kotlinIntermediario, kotlinAvancado)
    )


    val aluno1 = Aluno(
        nome = "Lucrécio",
        documento = "123456789901",
        email = "lucrecio@gmail.com",

    )

    val aluno2 = Aluno(
        nome = "Madá",
        documento = "12545689712",
        email = "mada@outlook.com"

    )

    val aluno3 = Aluno(
        nome = "Josevan",
        documento = "89565423515",
        email = "jovan@hot.com"

    )

    formacaoKotlin1.matricular(aluno1)
    println("\nAluno matriculado:")
    println(formacaoKotlin1.listarAlunos())
    println("Formação do aluno:")
    aluno1.formacoesMatriculadas.forEach {
    println("-${it.nome}")
    }

    formacaoKotlin2.matricular(aluno2)
    println("\nAluno matriculádo:")
    println(formacaoKotlin2.listarAlunos())
    println("Formação do aluno:")
    aluno2.formacoesMatriculadas.forEach {
        println("-${it.nome}")
    }

    formacaoKotlin3.matricular(aluno3)
    println("\nAluno matriculádo:")
    println(formacaoKotlin3.listarAlunos())
    println("Formação do aluno:")
    aluno3.formacoesMatriculadas.forEach {
        println("-${it.nome}")
    }


    println("\nResumo da formação:")
    println("Nome: ${formacaoKotlin1.nome}")
    println("Nível: ${formacaoKotlin1.nivel}")
    println("Conteúdos:")
    formacaoKotlin1.conteudosEducacionais.forEach {
        println("- ${it.nome} (${it.duracao}h)")
    }

    println("\nResumo da formação:")
    println("Nome: ${formacaoKotlin2.nome}")
    println("Nível: ${formacaoKotlin2.nivel}")
    println("Conteúdos:")
    formacaoKotlin2.conteudosEducacionais.forEach {
        println("- ${it.nome} (${it.duracao}h)")
    }

    println("\nResumo da formação:")
    println("Nome: ${formacaoKotlin3.nome}")
    println("Nível: ${formacaoKotlin3.nivel}")
    println("Conteúdos:")
    formacaoKotlin3.conteudosEducacionais.forEach {
        println("- ${it.nome} (${it.duracao}h)")
    }

}